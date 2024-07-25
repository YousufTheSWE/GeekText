package com.example.geekText.Cart;

import com.example.geekText.profile.Profiles;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepositoryImplementation<Cart, Long> {
    List<Cart> findCartItemsByUserId(long userId);

}
