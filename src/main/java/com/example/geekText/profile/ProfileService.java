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

    public List<Profiles> getProfiles(){
        return profileRepository.findAll();
    }

    public Optional<Profiles> getProfileByUsername(String username) {
        return profileRepository.findProfileByUsername(username);
    }

    public void addNewProfile(Profiles profile) {
        Optional<Profiles> profileByUsername = profileRepository.findProfileByUsername(profile.getUsername());
        if (profileByUsername.isPresent()){
            throw new IllegalStateException("username taken");
        }
        profileRepository.save(profile);
        System.out.println(profile);
    }

    public void deleteProfile(String profileUsername) {
        Optional<Profiles> profile = profileRepository.findProfileByUsername(profileUsername);
        if (!profile.isPresent()) {
            throw new IllegalStateException(
                    "profile with username " + profileUsername + " does not exist");
        }
        profileRepository.delete(profile.get());
    }

    @Transactional
    public void updateProfile(String profileUsername,
                              String newUsername,
                              String newPassword) {
        Profiles profile = profileRepository.findProfileByUsername(profileUsername)
                .orElseThrow(() -> new IllegalStateException(
                        "profile with username " + profileUsername + " does not exist"));
        if (newUsername != null &&
                newUsername.length() > 0 &&
                !Objects.equals(profile.getUsername(), newUsername)) {
            profile.setUsername(newUsername);
        }
        if (newPassword != null &&
                newPassword.length() > 0 &&
                !Objects.equals(profile.getPassword(), newPassword)) {
            profile.setPassword(newPassword);
        }
    }
}