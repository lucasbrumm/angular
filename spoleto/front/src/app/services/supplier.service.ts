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
  constructor(private httpClient: HttpClient) {}
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };
  getSupplierList(): Observable<Supplier[]> {
    return this.httpClient.get<Supplier[]>(
      this.url + '/get-all',
      this.httpOptions
    );
  }
}
