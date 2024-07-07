import { Component } from '@angular/core';
import { OptionsMenu } from '../optionsMenu';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

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

  ngOnInit() {
    this.addOptions([
      {
        label: 'Manage sales system',
        route: '/sales',
      },
      {
        label: 'Manage purchasing system',
        route: '/purchase',
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
