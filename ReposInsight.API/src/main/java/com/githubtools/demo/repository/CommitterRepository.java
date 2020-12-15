package com.githubtools.demo.repository;

import com.githubtools.demo.entity.Committer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CommitterRepository extends JpaRepository<Committer, Long> {

    @Query("SELECT c FROM Committer c WHERE c.githubUsername = ?1")
    public Committer findCommitterByGithubUsername(String githubUsername);

}
