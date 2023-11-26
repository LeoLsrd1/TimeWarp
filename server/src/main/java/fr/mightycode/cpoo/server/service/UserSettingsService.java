package fr.mightycode.cpoo.server.service;

import fr.mightycode.cpoo.server.dto.UserSettingsDTO;
import fr.mightycode.cpoo.server.model.UserSettings;
import fr.mightycode.cpoo.server.repository.UserSettingsRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsService {

    private final UserSettingsRepository userSettingsRepository;

    @Autowired
    public UserSettingsService(UserSettingsRepository userSettingsRepository) {
        this.userSettingsRepository = userSettingsRepository;
    }

    public UserSettingsDTO getUserSettingsByUsername(String username) {
        UserSettings userSettings = userSettingsRepository.findByUsername(username);
        if(userSettings == null) {
            userSettings = new UserSettings(username);
            userSettingsRepository.save(userSettings);
        }
        System.out.println(userSettings);
        return userSettings.toDTO();
    }

    @Transactional
    public void changeUserTheme(String username, int themeId) {
        userSettingsRepository.changeTheme(username, themeId);
    }
}
