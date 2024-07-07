import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { AuthService } from './auth.service';
import { faBars } from '@fortawesome/free-solid-svg-icons';
import { OptionsMenu } from './optionsMenu';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    FontAwesomeModule,
    NgbAlertModule,
    CommonModule,
    FormsModule,
    RouterModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  constructor() {}
  optionsMenu: OptionsMenu[] = [];

  ngOnInit() {
    this.addOptions([
      {
        label: 'Home',
        route: '/',
      },
      {
        label: 'Manage sales system',
        route: '/sales',
      },
      {
        label: 'Manage purchasing system',
        route: '/purchase',
      },
      {
        label: 'View reports',
        route: '/reports',
      },
    ]);
  }

  addOptions(optionsMenu: OptionsMenu[]) {
    optionsMenu.forEach((option) => {
      let newOption = new OptionsMenu();
      newOption.label = option.label;
      newOption.route = option.route;
      this.optionsMenu.push(newOption);
    });
  }
}
