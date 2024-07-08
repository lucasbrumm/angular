import { Injectable } from '@angular/core';
import { urlBaseAPI } from '../common/urlRoute';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BuyProductsFromSupplier } from '../model/buyProductsFromSupplier';
import { BuyProductsFromSupplierResponse } from '../model/buyProductsFromSupplierResponse';
import { PurchaseSupplier } from '../model/purchaseSupplier';

@Injectable({
  providedIn: 'root',
})
export class PurchasingService {
  urlPurchase = urlBaseAPI + '/purchase-supplier';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(private httpClient: HttpClient) {}

  buyNewProducts(
    buyProducts: BuyProductsFromSupplier
  ): Observable<BuyProductsFromSupplierResponse> {
    return this.httpClient
      .post<BuyProductsFromSupplierResponse>(
        this.urlPurchase + '/buy',
        JSON.stringify(buyProducts),
        this.httpOptions
      )
      .pipe((data) => data);
  }

  getAllOrdersFromSupplier(): Observable<PurchaseSupplier[]> {
    return this.httpClient.get<PurchaseSupplier[]>(
      this.urlPurchase + '/get-all',
      this.httpOptions
    );
  }
}
