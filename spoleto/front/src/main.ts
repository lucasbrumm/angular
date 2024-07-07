/// <reference types="@angular/localize" />

import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import routeConfig from './app/routes';
import { InjectionToken } from '@angular/core';
import { provideHttpClient, withFetch } from '@angular/common/http';

const APP_CONFIG_TOKEN = new InjectionToken('APP_CONFIG');

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(withFetch()),
    provideRouter(routeConfig),
    { provide: APP_CONFIG_TOKEN, useValue: appConfig },
  ],
}).catch((err) => console.error(err));
