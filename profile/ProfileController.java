package com.example.geekText.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geektext/profiles")
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
    public ResponseEntity<Profiles> getProfileByUsername(@PathVariable("username") String username) {
        Profiles profile = profileService.getProfileByUsername(username);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> registerNewProfile(@RequestBody Profiles profile) {
        profileService.addNewProfile(profile);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{profileUsername}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("profileUsername") String profileUsername) {
        profileService.deleteProfile(profileUsername);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{profileUsername}")
    public ResponseEntity<Void> updateProfile(
            @PathVariable("profileUsername") String profileUsername,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {
        profileService.updateProfile(profileUsername, username, password);
        return ResponseEntity.ok().build();
    }
}