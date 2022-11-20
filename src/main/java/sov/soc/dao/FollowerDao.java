package sov.soc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sov.soc.entity.Follower;
import sov.soc.mapper.FollowerMapping;
import java.util.ArrayList;
import java.util.List;


@Component
public class FollowerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FollowerDao(@Qualifier("jdbcTemplatePostgres") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Follower> getUsers(Long id) {
        try {
            List<Follower> followers = jdbcTemplate.queryForObject(
                    "select \n" +
                            "\tut.id, ut.full_name, ut.status, (fo.id_user is not null) as follower \n" +
                            "from user_table ut\n" +
                            "left join follower fo\n" +
                            "\ton ut.id = fo.id_follower  \n" +
                            "where ut.id <> " + id + " order by ut.id", new FollowerMapping());
            return followers;
        } catch (EmptyResultDataAccessException e){
            return new ArrayList<>();
        }


    }



}
