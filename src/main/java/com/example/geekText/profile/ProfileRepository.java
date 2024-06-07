package com.example.geekText.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository
        extends JpaRepository<Profile, Long> {

    @Query("SELECT s FROM Profile s WHERE s.email = ?1")
    Optional<Profile> findProfileByEmail(String email);
}
