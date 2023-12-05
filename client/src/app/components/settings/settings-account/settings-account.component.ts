import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { SigninServiceService } from 'src/app/services/signin-service.service';
import{SignOutService} from 'src/app/services/signout.service';

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


  actual_user : UserNameDTO={ // Object which contains the current user 
    user_name: ''
  };

  actual_username = "Pierre";
  isEditing = false;


  constructor(private router:Router, private signinService: SigninServiceService, private signoutService : SignOutService){
    this.signinService.getActualUser().subscribe(actual_user => {
      if (actual_user.user_name !== '') {
        const username = actual_user.user_name;
        const regex = /^([^@]+)/;
        const match = username.match(regex);    
        if (match && match[1]) {
          this.actual_username = match[1];
        } else {
          // Gérer le cas où la correspondance n'est pas trouvée
          console.error("Aucune correspondance trouvée pour le nom d'utilisateur.");
        }
      }
    });
  }
  
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
