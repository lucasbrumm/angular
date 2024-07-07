import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { OptionsMenu } from './optionsMenu';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    FontAwesomeModule,
    NgbAlertModule,
    CommonModule,
    FormsModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  optionsMenu: OptionsMenu[] = [];
  error = '';

  ngOnInit() {
    this.addOptions(['Manage sales system', 'Manage purchasing system']);
  }

  addOptions(labels: string[]) {
    labels.forEach((label) => {
      let newOption = new OptionsMenu();
      newOption.label = label;
      this.optionsMenu.push(newOption);
    });
  }
}
