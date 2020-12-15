package com.githubtools.demo.controller;


import com.githubtools.demo.entity.dto.TimePeriodReturnDTO;
import com.githubtools.demo.enumeration.APIDefinition;
import com.githubtools.demo.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping(value = APIDefinition.MASTER_WEEKS)
    public List<TimePeriodReturnDTO> weeks() {
        return masterService.getWeeks();
    }

    @GetMapping(value = APIDefinition.MASTER_MONTHS)
    public List<TimePeriodReturnDTO> months() {
        return masterService.getMonths();
    }
}
