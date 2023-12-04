package fr.mightycode.cpoo.server.controller;

import fr.mightycode.cpoo.server.dto.UserDTO;
import fr.mightycode.cpoo.server.dto.UserSettingsDTO;
//import fr.mightycode.cpoo.server.dto.NewPasswordDTO;
import fr.mightycode.cpoo.server.dto.ChangePasswordDTO;
import fr.mightycode.cpoo.server.dto.NotificationsDTO;
//import fr.mightycode.cpoo.server.dto.NotificationsDTO;
import fr.mightycode.cpoo.server.service.UserService;
import fr.mightycode.cpoo.server.service.UserSettingsService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserSettingsController {

    private final UserSettingsService userSettingsService;

    @Autowired
    public UserSettingsController(UserSettingsService userSettingsService) {
        this.userSettingsService = userSettingsService;
    }

    @GetMapping("/settings")
    public ResponseEntity<UserSettingsDTO> getUserSettings(final Principal user) {
        UserSettingsDTO userSettingsDTO = userSettingsService.getUserSettingsByUsername(user.getName());
        return new ResponseEntity<>(userSettingsDTO, HttpStatus.OK);
    }

    @PatchMapping("/account/chgusername")
    public void changeUsername(@RequestBody String newUsername) {
        // Implement change username logic
    }

    @PatchMapping("/account/changepp")
    public void changeProfilePicture(@RequestBody String imageUrl) {
        // Implement change profile picture logic
    }

    @PatchMapping("/changepwd")
    public void changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        // Implement change password logic
    }

    @PatchMapping("/notifications")
    public ResponseEntity<Object> updateNotifications(final Principal user, @RequestBody NotificationsDTO notificationsDTO) {
        // Implement update notifications logic
        userSettingsService.changeNotificationsSettings(user.getName(), notificationsDTO.sounds(), notificationsDTO.badges());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/change-theme")
    public ResponseEntity<Object> changeTheme(final Principal user, @RequestBody String themeId) {
        userSettingsService.changeUserTheme(user.getName(), Integer.parseInt(themeId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/language")
    public void changeLanguage(@RequestBody String language) {
        // Implement change language logic
    }
}
