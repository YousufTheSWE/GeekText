package com.example.geekText.profile;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public void addNewProfile(Profile profile) {
        Optional<Profile> profileByEmail = profileRepository.
                findProfileByEmail(profile.getEmail());
        if (profileByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        profileRepository.save(profile);
        System.out.println(profile);
    }

    public void deleteProfile(Long profileId) {
        boolean exists = profileRepository.existsById(profileId);
        if (!exists) {
            throw new IllegalStateException(
                    "profile with id " + profileId + " does not exists");
        }
        profileRepository.deleteById(profileId);
    }

    @Transactional
    public void updateProfile(Long profileId,
                              String username,
                              String email) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new IllegalStateException(
                        "profile with id " + profileId + " does not exist"));
        if (username != null &&
                username.length() > 0 &&
                !Objects.equals(profile.getUsername(), username)) {
            profile.setUsername(username);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(profile.getEmail(), email)) {
            Optional<Profile> profileOptional = profileRepository
                    .findProfileByEmail(email);
            if (profileOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            profile.setEmail(email);
        }

    }
}
