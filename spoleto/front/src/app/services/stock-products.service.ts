import { Injectable } from '@angular/core';
import { urlBaseAPI } from '../common/urlRoute';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockProduct } from '../model/stockProduct';

@Injectable({
  providedIn: 'root',
})
export class StockProductsService {
  urlProduct = urlBaseAPI + '/stock';
  constructor(private httpClient: HttpClient) {}
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  getAllStockProducts(): Observable<StockProduct[]> {
    return this.httpClient.get<StockProduct[]>(
      this.urlProduct + '/get-all',
      this.httpOptions
    );
  }
}
