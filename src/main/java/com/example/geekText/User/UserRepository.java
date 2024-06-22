package com.example.geekText.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository {

    void insertUser(User user);

    User findUserById(long userId);

    List<User> selectAllUsers();

    //void saveAll(List<User> users);
}