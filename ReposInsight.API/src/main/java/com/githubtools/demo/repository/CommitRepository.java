package com.githubtools.demo.repository;

import com.githubtools.demo.entity.Commit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CommitRepository extends JpaRepository<Commit, Long> {

    @Query("SELECT c FROM Commit c WHERE c.commitDate >= ?1 AND c.commitDate <=?2 Order By commitDate Desc")
    public List<Commit> findAllByStartEndDate(Timestamp startDateTime, Timestamp endDateTime);
}
