// theme.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  private selectedImageSrc: string = '/assets/images/blur-background-60s-0.jpg';

  getSelectedImageSrc(): string {
    return this.selectedImageSrc;
  }

  updateSelectedImageSrc(era: string, index: number): void {
    if (era === '60s') {
      switch(index){
        case 0:{
          this.selectedImageSrc = '/assets/images/blur-background-60s-0.jpg';
          break;
        }
        case 1:{
          this.selectedImageSrc = '/assets/images/blur-background-60s-1.jpg';
          break;
        }
        case 2:{
          this.selectedImageSrc = '/assets/images/blur-background-60s-2.jpg';
          break;
        }
      }
    } else if (era === '70s') {
        switch(index){
          case 0:{
            this.selectedImageSrc = '/assets/images/blur-background-70s-0.jpg';
            break;
          }
          case 1:{
            this.selectedImageSrc = '/assets/images/blur-background-70s-1.jpg';
            break;
          }
          case 2:{
            this.selectedImageSrc = '/assets/images/blur-background-70s-2.jpg';
            break;
          }
        }
    } else {
      this.selectedImageSrc = '/assets/images/blur-background-60s-0.jpg';
    }
  }
}
