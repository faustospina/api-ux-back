package com.apiux.test.controller;

import com.apiux.test.entity.ActivityEntity;
import com.apiux.test.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("")
    public List<ActivityEntity> activities() throws Exception {
        return activityService.getActivities();
    }

    @GetMapping("/{id}")
    public ActivityEntity getActivity(@PathVariable int id) throws Exception {
        return activityService.getActivityFindById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActivity(@PathVariable int id) {
        activityService.deleteActivity(id);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ActivityEntity addActivity(@RequestBody ActivityEntity activity) throws Exception {
        return activityService.addActivity(activity);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ActivityEntity editActivity(@RequestBody ActivityEntity activity) throws Exception {
        return activityService.editActivity(activity);
    }



}
