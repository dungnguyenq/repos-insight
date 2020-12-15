package com.githubtools.demo.service;

import com.githubtools.demo.entity.dto.TimePeriodReturnDTO;

import java.util.List;

public interface MasterService {
    public List<TimePeriodReturnDTO> getWeeks();
    public List<TimePeriodReturnDTO> getMonths();
}
