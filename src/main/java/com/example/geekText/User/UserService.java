package com.example.geekText.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService implements UserRepository{
    public UserService(){

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user){
        jdbcTemplate.update("INSERT INTO users (userID, address, fullname, password, username) VALUES (?,?,?,?,?)",
                user.getId());
    }

    @Override
    public User findUserById(long userId) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users",(rs, rosNum) ->
                new User(rs.getInt("userID")));
    }

}
