package com.example.geekText.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "geektext/profiles") // This controls the path in the URL
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profiles> getProfiles() {
        return profileService.getProfiles();
    }

    @GetMapping("/{username}")
    public Profiles getProfileByUsername(@PathVariable("username") String username) {
        return profileService.getProfileByUsername(username)
                .orElseThrow(() -> new IllegalStateException("Profile with username " + username + " does not exist"));
    }

    @PostMapping
    public void registerNewProfile(@RequestBody Profiles profile) {
        profileService.addNewProfile(profile);
    }

    @DeleteMapping(path = "{profileUsername}")
    public void deleteProfile(@PathVariable("profileUsername") String profileUsername) {
        profileService.deleteProfile(profileUsername);
    }

    @PutMapping(path = "{profileUsername}")
    public void updateProfile(
            @PathVariable("profileUsername") String profileUsername,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {
        profileService.updateProfile(profileUsername, username, password);
    }
}
