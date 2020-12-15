package com.githubtools.demo.service;

import com.githubtools.demo.entity.*;

public interface ScheduleService {

    public Schedule getLatestSchedule();
    public void save(Schedule schedule);
}
