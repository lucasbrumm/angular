import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private isAuthenticatedSubject = new BehaviorSubject<boolean>(false);
  private isFirstScreenSubject = new BehaviorSubject<boolean>(true);
  isAuthenticated = this.isAuthenticatedSubject.asObservable();
  isFirstScreen = this.isFirstScreenSubject.asObservable();

  constructor() {}

  login() {
    this.isAuthenticatedSubject.next(true);
  }

  logout() {
    this.isAuthenticatedSubject.next(false);
  }

  fistScreenOn() {
    this.isFirstScreenSubject.next(true);
  }

  fistScreenOff() {
    this.isFirstScreenSubject.next(false);
  }
}
