import { Injectable } from '@angular/core';
import { urlBaseAPI } from '../common/urlRoute';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BuyProductsFromSupplier } from '../model/buyProductsFromSupplier';
import {
  BuyProductsFromSupplierResponse,
  PurchaseStatus,
} from '../model/buyProductsFromSupplierResponse';
import { PurchaseSupplier } from '../model/purchaseSupplier';
import { ChangeStatusSupplierPurchase } from '../model/changeStatusSupplierPurchase';

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

  changeStatusSupplier(
    changeStatusSupplierPurchase: ChangeStatusSupplierPurchase
  ): Observable<PurchaseStatus> {
    return this.httpClient.post<PurchaseStatus>(
      this.urlPurchase + '/change-status',
      changeStatusSupplierPurchase,
      { ...this.httpOptions, responseType: 'text' as 'json' }
    );
  }
}
