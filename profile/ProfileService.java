package com.example.geekText.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional(readOnly = true)
    public List<Profiles> getProfiles() {
        return profileRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Profiles getProfileByUsername(String username) {
        return profileRepository.findProfileByUsername(username)
                .orElse(null);
    }

    @Transactional
    public void addNewProfile(Profiles profile) {
        profileRepository.save(profile);
    }

    @Transactional
    public void deleteProfile(String profileUsername) {
        Profiles profile = profileRepository.findProfileByUsername(profileUsername)
                .orElseThrow(() -> new IllegalStateException(
                        "Profile with username " + profileUsername + " does not exist"));
        profileRepository.delete(profile);
    }

    @Transactional
    public void updateProfile(String profileUsername, String newUsername, String newPassword) {
        Profiles profile = profileRepository.findProfileByUsername(profileUsername)
                .orElseThrow(() -> new IllegalStateException(
                        "Profile with username " + profileUsername + " does not exist"));
        if (newUsername != null && !newUsername.isEmpty()) {
            profile.setUsername(newUsername);
        }
        if (newPassword != null && !newPassword.isEmpty()) {
            profile.setPassword(newPassword);
        }
    }
}