package sov.soc.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sov.soc.dao.FollowerDao;
import sov.soc.entity.Follower;

import java.util.List;

@Component
public class FollowerService {

    private FollowerDao followerDao;

    @Autowired
    public FollowerService(FollowerDao followerDao) {
        this.followerDao = followerDao;
    }

    public List<Follower> getUsers(String id){
        return followerDao.getUsers(Long.valueOf(id));
    }
}
