package com.githubtools.demo.helper;

import com.githubtools.demo.enumeration.Constant;
import com.githubtools.demo.service.CommitService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduleHelper {

    @Autowired
    private CommitService commitService;

    final static Logger logger = LogManager.getLogger(TaskScheduleHelper.class);

    @Scheduled(cron = "0 0 0/6 * * *" )
    public void crawlDataFromGithub() {
        logger.info("Start automatically crawl data from Github Repos");
        commitService.saveAll(Constant.RunType.AUTOMATICALLY);
        logger.info("End automatically crawl data from Github Repos");
    }
}
