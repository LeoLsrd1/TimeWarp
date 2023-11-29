import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { UserSettings } from '../models/user-settings';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserSettingsService {

  private baseUrl = 'http://localhost:4200/serverapi/user';

  // Default image source
  private selectedImageSrc: string = '/assets/images/blur-background-60s-0.jpg';

  // Default theme ID
  themeId: number = 0;

  constructor(private http: HttpClient) { }

  /**
   * Fetches user settings from the server.
   */
  getUserSettings(): void{
    this.http.get<UserSettings>(`${this.baseUrl}/settings`).subscribe({
      next: (settings) => {
        if(settings.theme!=null){
          this.themeId = settings.theme;
          this.updateColorsAndImage(settings.theme);
        }
      }
    });
  }

  /*----------------------------------------------Theme----------------------------------------------*/

  /**
   * Updates the user's selected theme.
   * @param themeId - The ID of the selected theme.
   */
  updateTheme(themeId: number): void{
    // Update theme on the server
    this.http.patch(`${this.baseUrl}/change-theme`, themeId).subscribe();
    // Update theme locally
    this.themeId = themeId;
    // Update selected image and colors based on the new theme
    this.updateColorsAndImage(themeId);
  }

  /**
   * Gets the selected image source.
   * @returns The URL of the selected image.
   */
  getSelectedImageSrc(): string {
    return this.selectedImageSrc;
  }

  /**
   * Updates the selected image source and colors based on the theme ID.
   * @param id - The ID of the selected theme.
   */
  updateColorsAndImage(id: number): void {
    let newMainColor = '#fc9631'; // Default main color
    let newSecondaryColor = '#f8a95a'; // Default secondary color
    let newTertiaryColor = '#ffcd9a'; // Default tertiary color
    let newBackgroundColor = '#f8e4d0'; // Default background color

    switch(id){
      //60s orange
      case 0:{
        this.selectedImageSrc = '/assets/images/blur-background-60s-0.jpg';
        newMainColor = '#fc9631';
        newSecondaryColor = '#f8a95a';
        newTertiaryColor = '#ffcd9a';
        newBackgroundColor = '#f8e4d0';
        break;
      }
      //60s blue
      case 1:{
        this.selectedImageSrc = '/assets/images/blur-background-60s-1.jpg';
        newMainColor = '#3dabab';
        newSecondaryColor = '#63C3C3';
        newTertiaryColor = '#94DCDC';
        newBackgroundColor = '#C5EAEA';
        break;
      }
      //60s green
      case 2:{
        this.selectedImageSrc = '/assets/images/blur-background-60s-2.jpg';
        newMainColor = '#14D899';
        newSecondaryColor = '#4CE6B4';
        newTertiaryColor = '#8EEACC';
        newBackgroundColor = '#D0FBED';
        break;
      }
      //70s blue
      case 3:{
        this.selectedImageSrc = '/assets/images/blur-background-70s-0.jpg';
        newMainColor = '#3DBDFF';
        newSecondaryColor = '#64C6F9';
        newTertiaryColor = '#A5DFFD';
        newBackgroundColor = '#D2F0FF';
        break;
      }
      //70s pink
      case 4:{
        this.selectedImageSrc = '/assets/images/blur-background-70s-1.jpg';
        newMainColor = '#FF5886';
        newSecondaryColor = '#FF86A8';
        newTertiaryColor = '#FBAAC1';
        newBackgroundColor = '#FBD9E3';
        break;
      }
      //70s orange/red
      case 5:{
        this.selectedImageSrc = '/assets/images/blur-background-70s-2.jpg';
        newMainColor = '#FF5A23';
        newSecondaryColor = '#FD8259';
        newTertiaryColor = '#FBAD93';
        newBackgroundColor = '#F9DBD0';
        break;
      }
      default:{
        this.selectedImageSrc = '/assets/images/blur-background-60s-0.jpg';
        break;
      }
    }
    // Update colors
    document.documentElement.style.setProperty('--main-color', newMainColor);
    document.documentElement.style.setProperty('--secondary-color', newSecondaryColor);
    document.documentElement.style.setProperty('--tertiary-color', newTertiaryColor);
    document.documentElement.style.setProperty('--background-color', newBackgroundColor);
  }
}
