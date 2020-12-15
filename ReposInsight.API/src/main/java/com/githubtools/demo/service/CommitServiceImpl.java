package com.githubtools.demo.service;

import com.githubtools.demo.entity.*;
import com.githubtools.demo.entity.dto.Author1DTO;
import com.githubtools.demo.entity.dto.CommitDTO;
import com.githubtools.demo.entity.dto.CommitReturnDTO;
import com.githubtools.demo.entity.dto.DataDTO;
import com.githubtools.demo.enumeration.Constant;
import com.githubtools.demo.helper.GithubAPIHelper;
import com.githubtools.demo.helper.DateTimeHelper;
import com.githubtools.demo.repository.CommitRepository;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommitServiceImpl implements CommitService {

    @Autowired
    private CommitRepository commitRepository;

    @Autowired
    private CommitterService committerService;

    @Autowired
    private ScheduleService scheduleService;

    final static Logger logger = LogManager.getLogger(CommitServiceImpl.class);

    public void saveAll(int runType){

        //add new record to schedule table
        String startDateTime;
        Schedule schedule = scheduleService.getLatestSchedule();
        if (schedule != null){
            startDateTime = DateTimeHelper.dateToISO8601Format(schedule.getEndRunTime());
            schedule.setLatest(false);
            scheduleService.save(schedule);
        } else {
            startDateTime = DateTimeHelper.dateToISO8601Format(Timestamp.valueOf(LocalDateTime.now().minusMonths(3)));
        }
        String endDateTime = DateTimeHelper.dateToISO8601Format(Timestamp.valueOf(LocalDateTime.now()));

        Schedule newSchedule = new Schedule();
        newSchedule.setLatest(true);
        newSchedule.setStartRunTime(Timestamp.valueOf(LocalDateTime.now()));
        newSchedule.setRunType(runType);

        try{
            int pageNumber = 1;
            int resultLength = Constant.GithubPara.PER_PAGE;
            while (resultLength == Constant.GithubPara.PER_PAGE){
                String apiURL = String.format(Constant.GithubAPI.LIST_COMMITS_WITH_TIME, startDateTime, endDateTime, Constant.GithubPara.PER_PAGE, pageNumber);
                String json = GithubAPIHelper.get(apiURL);
                Gson gson = new Gson();
                DataDTO[] dataDTOS = gson.fromJson(json, DataDTO[].class);

                resultLength = dataDTOS.length;
                pageNumber++;

                //save data into database
                List<Commit> commits = new ArrayList<>();
                List<Committer> newCommitters = new ArrayList<>();
                for (DataDTO dataDTO : dataDTOS){
                    CommitDTO commitDTO = dataDTO.getCommit();
                    Commit commit = new Commit();
                    commit.setCommitUrl(dataDTO.getHtml_url());

                    String message = commitDTO.getMessage();
                    int indexOfNewline = message.indexOf("\n");
                    if (indexOfNewline>=0){
                        String title = message.substring( 0, message.indexOf("\n"));
                        commit.setTitle(title);
                    } else {
                        commit.setTitle(message);
                    }

                    Author1DTO authorDTO = dataDTO.getAuthor();
                    commit.setCommitDate(commitDTO.getAuthor().getDate());
                    commit.setGithubUsername(authorDTO.getLogin());

                    Committer oldCommitter = committerService.findCommitterByGithubUsername(authorDTO.getLogin());
                    if (oldCommitter != null){
                        oldCommitter.setCommitCount(oldCommitter.getCommitCount() + 1);
                        committerService.save(oldCommitter);
                    } else {
                        Committer committer = newCommitters.stream().filter(c -> c.getGithubUsername().equals(authorDTO.getLogin())).findFirst().orElse(null);
                        if (committer!=null){
                            committer.setCommitCount(committer.getCommitCount() + 1);
                        } else {
                            Committer newCommitter = new Committer();
                            newCommitter.setCommitter(commitDTO.getAuthor().getName(), authorDTO.getLogin(),
                                    commitDTO.getAuthor().getEmail(), authorDTO.getAvatar_url(), authorDTO.getHtml_url(), 1);
                            newCommitters.add(newCommitter);
                        }

                    }

                    commits.add(commit);
                }

                commitRepository.saveAll(commits);
                committerService.saveAll(newCommitters.stream().distinct().collect(Collectors.toList()));
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
        } finally {
            newSchedule.setEndRunTime(Timestamp.valueOf(LocalDateTime.now()));
            scheduleService.save(newSchedule);
        }
    }

    public List<CommitReturnDTO> findAllByStartEndDate(String startDate, String endDate){

        LocalDateTime startLocalDateTime = DateTimeHelper.stringToLocalDateTime(startDate).atStartOfDay();
        LocalDateTime endLocalDateTime = DateTimeHelper.stringToLocalDateTime(endDate).atTime(LocalTime.MAX);
        List<Commit> commits = commitRepository.findAllByStartEndDate(Timestamp.valueOf(startLocalDateTime), Timestamp.valueOf(endLocalDateTime));

        List<CommitReturnDTO> results = new ArrayList<>();
        for (Commit commit : commits){
            Committer committer = committerService.findCommitterByGithubUsername(commit.getGithubUsername());
            CommitReturnDTO commitReturnDTO = new CommitReturnDTO(commit.getTitle(), commit.getCommitUrl(), commit.getcommitDate(),
                    committer.getGithubUsername(), committer.getGithubAvaUrl(), committer.getGithubProfileUrl());
            results.add(commitReturnDTO);
        }

        return Collections.unmodifiableList(results);

    }
}
