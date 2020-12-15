package com.githubtools.demo.controller;


import com.githubtools.demo.entity.dto.CommitterReturnDTO;
import com.githubtools.demo.enumeration.APIDefinition;
import com.githubtools.demo.service.CommitterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/committer")
public class CommitterController {

    @Autowired
    private CommitterService committerService;

    final static Logger logger = LogManager.getLogger(CommitterController.class);

    @GetMapping(value = APIDefinition.COMMIT_TOP_TEN_COMMITTERS)
    public List<CommitterReturnDTO> findTopTenCommitters(){
        List<CommitterReturnDTO> data = new ArrayList<>();
        try{
            data = committerService.findTopTenCommitters();
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return data;
    }

}
