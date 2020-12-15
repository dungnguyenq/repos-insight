package com.githubtools.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_run_time")
    private Date startRunTime;

    @Column(name = "end_run_time")
    private Date endRunTime;

    @Column(name = "run_type")
    private int runType;

    @Column(name = "is_latest")
    private boolean isLatest;

    public int getId() {
        return id;
    }

    public Date getStartRunTime() {
        return startRunTime;
    }

    public void setStartRunTime(Date startRunTime) {
        this.startRunTime = startRunTime;
    }

    public Date getEndRunTime() {
        return endRunTime;
    }

    public void setEndRunTime(Date endRunTime) {
        this.endRunTime = endRunTime;
    }

    public int getRunType() {
        return runType;
    }

    public void setRunType(int runType) {
        this.runType = runType;
    }

    public boolean getIsLatest() {
        return isLatest;
    }

    public void setLatest(boolean latest) {
        isLatest = latest;
    }
}
