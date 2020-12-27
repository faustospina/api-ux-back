package com.apiux.test.service;

import com.apiux.test.entity.ActivityEntity;
import com.apiux.test.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private final ActivityRepository activityRepository;

    @Override
    public List<ActivityEntity> getActivities() throws Exception {
        return  (List<ActivityEntity>) Optional
                .ofNullable(activityRepository.findAll())
                .orElseThrow(() -> new Exception("not elements in table activities"));
    }

    @Override
    public ActivityEntity addActivity(ActivityEntity activity) throws Exception {
        ActivityEntity activityToRegister = Optional.ofNullable(activity)
                .orElseThrow(() -> new Exception("object null"));
        activityToRegister.setCreation_date(new Date());
        activityRepository.save(activityToRegister);
        return activityToRegister;
    }

    @Override
    public ActivityEntity editActivity(ActivityEntity activityIn) throws Exception {
        ActivityEntity activitiesOut = activityRepository.findById(activityIn.getId())
                .orElseThrow(() -> new Exception("element not found"));
        activitiesOut.setDescription(activityIn.getDescription());
        activitiesOut.setCreation_date(new Date());
        activitiesOut.setIs_active(activityIn.getIs_active());
        activityRepository.save(activitiesOut);
        return activitiesOut;
    }

    @Override
    public ActivityEntity getActivityFindById(int id) throws Exception {
        return  activityRepository.findById(id)
                .orElseThrow(() -> new Exception("element not found"));
    }

    @Override
    public void deleteActivity(int id) {
        try {
            activityRepository.deleteById(id);
        }catch (Exception e){
        }
    }
}
