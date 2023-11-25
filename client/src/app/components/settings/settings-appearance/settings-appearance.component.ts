import { Component } from '@angular/core';
import { ThemeService } from 'src/app/services/theme.service';

@Component({
  selector: 'app-settings-appearance',
  templateUrl: './settings-appearance.component.html',
  styleUrls: ['./settings-appearance.component.css']
})
export class SettingsAppearanceComponent {

  // Arrays to hold image data for the 1960s and 1970s with selection state
  images60s: { src: string; isSelected: boolean }[] = [
    { src: '/assets/images/12498931_4965007.jpeg', isSelected: false },
    { src: '/assets/images/12277065_4945415.jpeg', isSelected: false },
    { src: '/assets/images/12498935_5012660.jpeg', isSelected: false }
  ];

  images70s: { src: string; isSelected: boolean }[] = [
    { src: '/assets/images/vecteezy_abstract-spiral-starburst-or-sunburst-background-colorful_15261673.jpg', isSelected: false },
    { src: '/assets/images/vecteezy_retro-background-groovy-background_6797719.jpg', isSelected: false },
    { src: '/assets/images/35237771_8287145.jpeg', isSelected: false }
  ];

  // Variables to keep track of the selected image indices for each era
  selectedIndex60s: number | null = 0;
  selectedIndex70s: number | null = null;

  constructor(private themeService: ThemeService){}

  // Function to handle image selection
  selectImage(index: number, imageArray: any[], era: string) {

    // Depending on the era, select or deselect images and update the selected index
    if (era === '60s') {
      this.selectedIndex70s = null; // Deselect the image in the 70s era
      this.selectedIndex60s = index; // Select the image in the 60s era
    } else if (era === '70s') {
      this.selectedIndex60s = null; // Deselect the image in the 60s era
      this.selectedIndex70s = index; // Select the image in the 70s era
    }

    // Update the isSelected property of each image for styling
    imageArray.forEach((image, i) => {
      image.isSelected = i === index;
    });

    this.updateMainColor();
    this.themeService.updateSelectedImageSrc(era, index);
  }

  updateMainColor() {
    let newMainColor = '#fc9631'; // Default main color
    let newSecondaryColor = '#f8a95a'; // Default secondary color
    let newTertiaryColor = '#ffcd9a'; // Default tertiary color
    let newBackgroundColor = '#f8e4d0'; // Default background color


    if (this.selectedIndex60s !== null) {
      switch(this.selectedIndex60s){
        case 0:{
          newMainColor = '#fc9631';
          newSecondaryColor = '#f8a95a';
          newTertiaryColor = '#ffcd9a';
          newBackgroundColor = '#f8e4d0';
          break;
        }
        case 1:{
          newMainColor = '#3dabab';
          newSecondaryColor = '#63C3C3';
          newTertiaryColor = '#94DCDC';
          newBackgroundColor = '#C5EAEA';
          break;
        }
        case 2:{
          newMainColor = '#14D899';
          newSecondaryColor = '#4CE6B4';
          newTertiaryColor = '#8EEACC';
          newBackgroundColor = '#D0FBED';
          break;
        }
      }

    } else if (this.selectedIndex70s !== null) {
      switch(this.selectedIndex70s){
        case 0:{
          newMainColor = '#3DBDFF';
          newSecondaryColor = '#64C6F9';
          newTertiaryColor = '#A5DFFD';
          newBackgroundColor = '#D2F0FF';
          break;
        }
        case 1:{
          newMainColor = '#FF5886';
          newSecondaryColor = '#FF86A8';
          newTertiaryColor = '#FBAAC1';
          newBackgroundColor = '#FBD9E3';
          break;
        }
        case 2:{
          newMainColor = '#FF5A23';
          newSecondaryColor = '#FD8259';
          newTertiaryColor = '#FBAD93';
          newBackgroundColor = '#F9DBD0';
          break;
        }
      }
    }

    // Update colors
    document.documentElement.style.setProperty('--main-color', newMainColor);
    document.documentElement.style.setProperty('--secondary-color', newSecondaryColor);
    document.documentElement.style.setProperty('--tertiary-color', newTertiaryColor);
    document.documentElement.style.setProperty('--background-color', newBackgroundColor);

  }

}
