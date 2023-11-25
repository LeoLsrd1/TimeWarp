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
        UserSettings userSettings = userSettingsRepository.findByUser(username);
        return (userSettings != null) ? userSettings.toDTO() : null;
    }

    @Transactional
    public void changeUserTheme(String username, int themeId) {
        userSettingsRepository.changeTheme(username, themeId);
    }
}
