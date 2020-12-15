package com.githubtools.demo.service;

import com.githubtools.demo.entity.dto.CommitReturnDTO;
import java.util.List;

public interface CommitService {
    public void saveAll(int runType);
    public List<CommitReturnDTO> findAllByStartEndDate(String startDate, String endDate);
}
