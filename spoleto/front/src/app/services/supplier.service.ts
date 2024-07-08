import { Injectable } from '@angular/core';
import { urlBaseAPI } from '../common/urlRoute';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Supplier } from '../model/supplier';

@Injectable({
  providedIn: 'root',
})
export class SupplierService {
  url = urlBaseAPI + '/supplier';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(private httpClient: HttpClient) {}

  getSupplierList(): Observable<Supplier[]> {
    return this.httpClient.get<Supplier[]>(
      this.url + '/get-all',
      this.httpOptions
    );
  }
}
