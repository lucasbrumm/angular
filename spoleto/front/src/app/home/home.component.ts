import { Component } from '@angular/core';
import { OptionsMenu } from '../optionsMenu';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  optionsMenu: OptionsMenu[] = [];
  error = '';
  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.addOptions([]);
    this.authService.fistScreenOn();
  }

  addOptions(optionsMenu: OptionsMenu[]) {
    optionsMenu.forEach((option) => {
      let newOption = new OptionsMenu();
      newOption.label = option.label;
      newOption.route = option.route;
      this.optionsMenu.push(newOption);
    });
  }

  setFirstScreen() {
    this.authService.fistScreenOff();
    console.log('asdasd');
  }
}
