import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { SigninServiceService } from 'src/app/services/signin-service.service';



interface UserNameDTO {
  user_name: string;
}

interface UserDTO {
  username: string;
  email: string;
  password: string;
}


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  already_an_user : UserNameDTO={ // Object which contains the current user 
    user_name: ''
  };
  Futur_user : UserNameDTO ={   // Object which contains the information of the futur current user, if signin is successful
    user_name: ''
  };
  
  userDTO : UserDTO = {         // Object which contains the information that will be sent to the server
    username : '',
    email :'',
    password:''
  }  
  
  constructor(private router:Router, private signinService: SigninServiceService){
    //Get the current user, if it exist we skip login
    this.already_an_user = this.signinService.actual_user;
    if(!(this.already_an_user.user_name==='')){
      console.log("User Already Connect");
      this.loginToHome();
    }
  }

  /* ----------------------------------------------------------------------------------------------------------------------------------------- */


  loginToHome() : void{
    this.router.navigate(['/home']);
  }

  navigateToForgotPassword() {
    this.router.navigate(['/forgot-password']);
  }

  navigateToCreateAccount(){
    this.router.navigate(['/create-account'])
  }

  /* ----------------------------------------------------------------------------------------------------------------------------------------- */



  username : string = "";
  password : string = "";

  

  /* Message that will display the corresponding field in case of error */
  userErrorMessage : string ="";
  pwdErrorMessage : string ="";

  /* Will be true if the corresponding field contain an error, else false */
  userError : boolean = false;
  pwdError : boolean = false;
  
 /* Checks if the different fields are empty */
  username_empty (): boolean{
    if(this.username==="") {this.userErrorMessage = "Field Empty";return true; }
    else{return false;}
  }
  pwd_empty (): boolean{
    if(this.password==="") {this.pwdErrorMessage = "Field Empty";return true; }
    else{return false;}
  }

   /* If the password or username invalid */
   invalid_login_pwd() : void {
    this.username = ''; 
    this.password = '';
    this.userError = true;
    this.pwdError = true;
    this.userErrorMessage = "Invalid login or password";
    this.pwdErrorMessage = "Invalid login or password"; 
  }

  /* If the user already connect */
  already_connect() : void {
   this.username = ''; 
   this.password = '';
   this.userError = true;
   this.pwdError = true;
   this.userErrorMessage = "Already signed in";
   this.pwdErrorMessage = "Already signed in"; 
 }

  signIn(user: UserDTO): void {
    this.signinService.signIn(user).subscribe(
      /* Classic Response */ 
      (response) => {
        /* Post returns a success (code 200) */
        if (response.status === 200) {
          console.log('Successful Login');
          this.Futur_user.user_name = this.userDTO.username;
          this.signinService.setActualUser(this.Futur_user);
          this.loginToHome();
        }
        /* Post returns an error (code 409) */
        else if (response.status === 409) {
          this.already_connect();
        }
        /* Post returns an error (code 401) */
        else if (response.status === 401){
          this.invalid_login_pwd();
        }
      },
      /* Errors */ 
      (error) => {        
        /* Post returns an error (code 409) */
        if (error.status === 409) {
          this.already_connect();
        }
        /* Post returns an error (code 401) */
        if (error.status === 401){
          this.invalid_login_pwd();
        }
      }
    );
  }


  login() : void{
    if (this.username_empty()) this.userError = true; else this.userError = false;
    if (this.pwd_empty()) this.pwdError = true; else this.pwdError = false;

    if(this.userError)
      this.username = '';  
    if(this.pwdError)
      this.password = '';  
    
    if (!this.userError&&!this.pwdError){
      this.userDTO.username = this.username;
      this.userDTO.email = '';
      this.userDTO.password = this.password       
      console.log(this.userDTO);
      this.signIn(this.userDTO);      
    }

  }


}
