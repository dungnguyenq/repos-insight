package com.githubtools.demo.controller;


import com.githubtools.demo.entity.dto.CommitReturnDTO;
import com.githubtools.demo.enumeration.APIDefinition;
import com.githubtools.demo.enumeration.Constant;
import com.githubtools.demo.service.CommitService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/commit")
public class CommitController {

    @Autowired
    private CommitService commitService;

    final static Logger logger = LogManager.getLogger(CommitController.class);

    @GetMapping(value = APIDefinition.COMMIT_ALL)
    public List<CommitReturnDTO> getCommits(@RequestParam(value = "startDate", defaultValue = "null")String startDate, @RequestParam(value = "endDate", defaultValue = "null")String endDate) {
        List<CommitReturnDTO> data = new ArrayList<>();
        try{
            data = commitService.findAllByStartEndDate(startDate, endDate);
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return data;
    }

    @PostMapping(value = APIDefinition.COMMITS_SYNC_DATA)
    public void sync() {
        try{
            logger.info("Start Sync data from Github Repos");
            commitService.saveAll(Constant.RunType.MANUALLY);
            logger.info("End Sync data from Github Repos");
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }

}
