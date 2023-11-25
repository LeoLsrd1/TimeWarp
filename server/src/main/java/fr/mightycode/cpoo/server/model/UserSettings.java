package fr.mightycode.cpoo.server.model;

import lombok.Data;

import java.util.UUID;

import fr.mightycode.cpoo.server.dto.UserSettingsDTO;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "userSettings")
public class UserSettings {

    @Id
    private String user;

    @Column(name = "theme", nullable = true)
    private int theme;
    
    @Column(name = "language", nullable = true)
    private String language;

    @Column(name = "unreadBadges", nullable = true)
    private boolean unreadBadges;

    @Column(name = "notificationSound", nullable = true)
    private boolean notificationSound;

    @Column(name = "profileImage", nullable = true)
    private String profileImage;
    
    public UserSettingsDTO toDTO() {
        return new UserSettingsDTO(theme, language, unreadBadges, notificationSound, profileImage);
    }
}