package com.githubtools.demo.service;

import com.githubtools.demo.entity.*;
import com.githubtools.demo.entity.dto.CommitReturnDTO;
import com.githubtools.demo.entity.dto.CommitterReturnDTO;
import com.githubtools.demo.repository.CommitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommitterServiceImpl implements CommitterService {

    @Autowired
    private CommitterRepository committerRepository;

    @Autowired
    private CommitService commitService;

    @Override
    public Committer findCommitterByGithubUsername(String githubUsername) {
        return committerRepository.findCommitterByGithubUsername(githubUsername);
    }

    @Override
    public List<CommitterReturnDTO> findTopTenCommitters() {
        List<CommitReturnDTO> commitsInThreeMonth = commitService.findAllByStartEndDate(LocalDate.now().minusMonths(3).toString(), LocalDate.now().toString());

        List<Map.Entry<String, Long>> topCommitters = commitsInThreeMonth.stream().collect(Collectors.groupingBy(CommitReturnDTO::getGithubUsername, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).collect(Collectors.toList());

        List<CommitterReturnDTO> results = new ArrayList<>();
        for (Map.Entry committer : topCommitters){
            Committer committerData = committerRepository.findCommitterByGithubUsername(committer.getKey().toString());
            CommitterReturnDTO committerReturnDTO = new CommitterReturnDTO(committerData.getGithubDisplayName(), committerData.getGithubUsername(),
                    committerData.getGithubUsername(), committerData.getGithubAvaUrl(), committerData.getGithubProfileUrl(), (Long) committer.getValue() );
            results.add(committerReturnDTO);
        }

        return Collections.unmodifiableList(results);
    }

    @Override
    public void save(Committer committer) {
        committerRepository.save(committer);
    }

    @Override
    public void saveAll(List<Committer> committers) {
        committerRepository.saveAll(committers);
    }

}
