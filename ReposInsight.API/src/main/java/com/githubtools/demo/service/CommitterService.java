package com.githubtools.demo.service;

import com.githubtools.demo.entity.Committer;
import com.githubtools.demo.entity.dto.CommitterReturnDTO;

import java.util.List;

public interface CommitterService {
    public Committer findCommitterByGithubUsername(String githubUsername);
    public List<CommitterReturnDTO> findTopTenCommitters();
    public void save(Committer committer);
    public void saveAll(List<Committer> committers);
}
