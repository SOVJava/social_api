package sov.soc.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sov.soc.entity.Follower;
import sov.soc.service.FollowerService;

import java.util.List;


@RestController
@RequestMapping("/service")
public class ServiceController {

    private FollowerService followerService;

    @Autowired
    public ServiceController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping ("/add_follower")
    public String addFollower(@RequestBody Follower request) {

        /**/


        return "OK";
    }

    @GetMapping("/users/get")
    public List<Follower> getUsers() {
        return followerService.getUsers("1");
    }



}
