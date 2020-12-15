package com.githubtools.demo.service;

import com.githubtools.demo.entity.*;
import com.githubtools.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule getLatestSchedule(){
        return scheduleRepository.getLatestSchedule();
    }

    @Override
    public void save(Schedule schedule) {
        scheduleRepository.save(schedule);
    }
}
