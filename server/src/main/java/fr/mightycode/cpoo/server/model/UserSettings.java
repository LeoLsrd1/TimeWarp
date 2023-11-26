package fr.mightycode.cpoo.server.model;

import lombok.Data;

import fr.mightycode.cpoo.server.dto.UserSettingsDTO;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "user_settings")
public class UserSettings {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "theme")
    private int theme;
    
    @Column(name = "language")
    private String language;

    @Column(name = "unreadBadges")
    private boolean unreadBadges;

    @Column(name = "notificationSound")
    private boolean notificationSound;

    @Column(name = "profileImage")
    private String profileImage;
    
    public UserSettings(){
    }
    
    public UserSettings(String username){
        this.username = username;
    }
    public UserSettingsDTO toDTO() {
        return new UserSettingsDTO(theme, language, unreadBadges, notificationSound, profileImage);
    }
}