import { Component } from '@angular/core';
import { SupplierService } from '../services/supplier.service';
import { Supplier } from '../model/supplier';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Product } from '../model/product';
import { ProductsService } from '../services/products.service';
import { StockProductsService } from '../services/stock-products.service';
import { StockProduct } from '../model/stockProduct';

@Component({
  selector: 'app-purchasing',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './purchasing.component.html',
  styleUrl: './purchasing.component.css',
})
export class PurchasingComponent {
  supplierList: Supplier[] = [];
  productStockList: StockProduct[] = [];
  columnsTable: string[] = ['Item Name', 'Price ($)', 'Quantity (KG)'];

  constructor(
    private supplierService: SupplierService,
    private productService: ProductsService,
    private stockProductsService: StockProductsService
  ) {}

  ngOnInit() {
    this.getInicialDate();
  }

  private getInicialDate() {
    this.supplierService.getSupplierList().subscribe((data) => {
      this.supplierList = data;
    });
    this.stockProductsService.getAllStockProducts().subscribe((data) => {
      this.productStockList = data;
    });
    // this.productService.getAllProducts().subscribe((data) => {
    //   this.productList = data;
    // });
  }
}
