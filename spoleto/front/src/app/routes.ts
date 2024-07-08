import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PurchasingComponent } from './purchasing/purchasing.component';
import { SalesComponent } from './sales/sales.component';
import { ReportsComponent } from './reports/reports.component';
import { StockComponent } from './stock/stock.component';

const routeConfig: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home page',
  },
  {
    path: 'purchase',
    component: PurchasingComponent,
    title: 'Purchasing',
  },
  {
    path: 'sales',
    component: SalesComponent,
    title: 'Sales',
  },
  {
    path: 'reports',
    component: ReportsComponent,
    title: 'Reports',
  },
  {
    path: 'stock',
    component: StockComponent,
    title: 'Stock',
  },
];

export default routeConfig;
