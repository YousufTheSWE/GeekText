package com.example.geekText.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/geektext/profiles") //This controls path in URL
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profiles> getProfiles(){
        return profileService.getProfiles();
    }

    @PostMapping
    public void registerNewProfile(@RequestBody Profiles profile){
        profileService.addNewProfile(profile);
    }

    @DeleteMapping(path = "{profileId}")
    public void deleteProfile(
            @PathVariable("profileId") Long profileId){
        profileService.deleteProfile(profileId);
    }

    @PutMapping(path = "{profileId}")
    public void updateProfile(
            @PathVariable("profileId") Long profileId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email){
        profileService.updateProfile(profileId, username, email);
    }
}
