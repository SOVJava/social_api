package sov.soc.mapper;

import org.springframework.jdbc.core.RowMapper;
import sov.soc.entity.Follower;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowerMapping implements RowMapper<List<Follower>> {

    @Override
    public List<Follower> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<Follower> result = new ArrayList<>();
        do{
            Follower model = new Follower();
            model.setId(rs.getLong("id"));
            model.setFullName(rs.getString("full_name"));
            model.setStatus(rs.getString("status"));
            model.setFollowed(rs.getBoolean("follower"));
            result.add(model);
        } while(rs.next());
        return result;
    }
}

