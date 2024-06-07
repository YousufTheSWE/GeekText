package com.example.geekText.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository
        extends JpaRepository<Profiles, Long> {

    @Query("SELECT s FROM Profiles s WHERE s.email = ?1")
    Optional<Profiles> findProfileByEmail(String email);
}
