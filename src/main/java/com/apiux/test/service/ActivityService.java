package com.apiux.test.service;

import com.apiux.test.entity.ActivityEntity;

import java.util.List;

public interface ActivityService {

    List<ActivityEntity> getActivities() throws Exception;

    ActivityEntity addActivity(ActivityEntity activity) throws Exception;

    ActivityEntity editActivity(ActivityEntity entity) throws Exception;

    ActivityEntity getActivityFindById(int id) throws Exception;

    void deleteActivity(int id);


}
