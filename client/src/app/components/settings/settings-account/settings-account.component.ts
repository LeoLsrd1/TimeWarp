import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { SigninServiceService } from 'src/app/services/signin-service.service';
import{SignOutService} from 'src/app/services/signout.service';
import { UserService } from 'src/app/services/user.service';

interface UserNameDTO {
  user_name: string;
}

@Component({
  selector: 'app-settings-account',
  templateUrl: './settings-account.component.html',
  styleUrls: ['./settings-account.component.css']
})
export class SettingsAccountComponent {
  account_picture : string = "/assets/icons/pp_contact1.jpg";

  textContent = "TempUser";
  isEditing = false;


  none_actual_user : UserNameDTO = {  //Object to put to default the current user
    user_name:''
  };

  constructor(private router:Router, private signinService: SigninServiceService, private signoutService : SignOutService, private userService: UserService){ }
  
  @Output() go_chg_pwd = new EventEmitter<void>();

  navigateToChgPwd() : void{
    this.go_chg_pwd.emit();
  }

  navigateToLogin() : void{
    this.router.navigate(['/login']);
  }


  /* Disconnect the current user */
  disconnect() : void{
    this.signoutService.signOut().subscribe();
    this.signinService.setActualUserToDefault();          //Set the current user to default beacause there is no user
    this.navigateToLogin(); 
  }


}
