import { Component } from '@angular/core';
import { UserSettingsService } from 'src/app/services/user-settings.service';

@Component({
  selector: 'app-settings-notifications',
  templateUrl: './settings-notifications.component.html',
  styleUrls: ['./settings-notifications.component.css']
})
export class SettingsNotificationsComponent {

  soundIsChecked: boolean;

  constructor(private userSettingsService: UserSettingsService){
    this.soundIsChecked = userSettingsService.soundParameter;
  }

  onCheckboxChange(){
    this.userSettingsService.updateNotificationsSettings(!this.soundIsChecked);
  }
}
