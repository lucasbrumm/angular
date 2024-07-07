import { Injectable } from '@angular/core';
import { urlBaseAPI } from '../common/urlRoute';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class PurchasingService {
  urlPurchace = urlBaseAPI + '/purchase-supplier';

  constructor(private http: HttpClient) {}
}
