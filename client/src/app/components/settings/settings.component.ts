import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { UserSettingsService } from 'src/app/services/user-settings.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit{

  constructor(private router:Router, public userSettingsService: UserSettingsService, private userService: UserService){}

  ngOnInit(): void {
    this.userSettingsService.getUserSettings();
  }

  settingsToHome() : void{
    this.router.navigate(['/home']);
  }

  settingsToLogin() : void{  
    this.router.navigate(['/login'])  
  }

  /* ----------------------------------------------------------------------------------------------------------------------------------------- */
account : boolean = false;
notifications : boolean = false;
appearance : boolean = false;
language : boolean = false;
acknowlodgements : boolean = false;
chg_pwd : boolean = false;

display_account_settings() {
  this.account = true;
  this.notifications = false;
  this.appearance = false;
  this.language = false;
  this.acknowlodgements = false;
  this.chg_pwd = false;
}

display_notifications_settings(){
  this.account = false;
  this.notifications = true;
  this.appearance = false;
  this.language = false;
  this.acknowlodgements = false;
  this.chg_pwd = false;
}

display_appearance_settings(){
  this.account = false;
  this.notifications = false;
  this.appearance = true;
  this.language = false;
  this.acknowlodgements = false;
  this.chg_pwd = false;
}

display_language_settings(){
  this.account = false;
  this.notifications = false;
  this.appearance = false;
  this.language = true;
  this.acknowlodgements = false;
  this.chg_pwd = false;
}

display_acknowlodgements_settings(){
  this.account = false;
  this.notifications = false;
  this.appearance = false;
  this.language = false;
  this.acknowlodgements = true;
  this.chg_pwd = false;
}

display_chgpwd_settings(){
  this.account = false;
  this.notifications = false;
  this.appearance = false;
  this.language = false;
  this.acknowlodgements = false;
  this.chg_pwd = true;
}

}
