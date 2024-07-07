import { Component } from '@angular/core';
import { SupplierService } from '../services/supplier.service';
import { Supplier } from '../model/supplier';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Product } from '../model/product';
import { ProductsService } from '../services/products.service';
import { StockProductsService } from '../services/stock-products.service';
import { StockProduct } from '../model/stockProduct';
import { firstValueFrom } from 'rxjs';
import { BuyProductsFromSupplier } from '../model/buyProductsFromSupplier';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-purchasing',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './purchasing.component.html',
  styleUrl: './purchasing.component.css',
})
export class PurchasingComponent {
  supplierList: Supplier[] = [];
  productStockList: StockProduct[] = [];
  columnsTable: string[] = ['Item Name', 'Price ($)', 'Quantity (KG)'];
  buyProductsFromSupplier: BuyProductsFromSupplier = {
    idSupplier: 0,
    purchases: [],
  };
  totalOrder = 0;

  constructor(
    private supplierService: SupplierService,
    private stockProductsService: StockProductsService
  ) {}

  ngOnInit() {
    this.getInicialData();
  }

  private async getInicialData() {
    const supplierListPromise = firstValueFrom(
      this.supplierService.getSupplierList()
    );
    const productStockListPromise = firstValueFrom(
      this.stockProductsService.getAllStockProducts()
    );

    const [suppliers, productStocks] = await Promise.all([
      supplierListPromise,
      productStockListPromise,
    ]);

    this.supplierList = suppliers;
    this.productStockList = productStocks;

    productStocks.forEach((productStock) => {
      if (this.buyProductsFromSupplier.purchases !== undefined)
        this.buyProductsFromSupplier.purchases.push({
          productId: productStock.id,
          quantity: 0,
        });
    });
  }

  onSupplierChange(event: any) {
    const selectedSupplierId = +event.target.value;
    this.buyProductsFromSupplier.idSupplier = selectedSupplierId;
  }

  onChangeInput(event: any, productId: number | undefined) {
    const quantity = event.target.value;

    if (this.buyProductsFromSupplier.purchases !== undefined) {
      const productPurchase = this.buyProductsFromSupplier.purchases.find(
        (productPurchase) => productPurchase.productId === productId
      );

      if (productPurchase !== undefined) {
        productPurchase.quantity = quantity;
      }
      this.totalOrder = this.buyProductsFromSupplier.purchases.reduce(
        (total, productPurchase) => {
          const productStock = this.productStockList.find(
            (productStock) => productStock.id === productPurchase.productId
          );

          if (productPurchase && productStock) {
            return (
              total +
              (productPurchase.quantity || 0) * (productStock?.cost || 0)
            );
          } else {
            return total;
          }
        },
        0
      );
    }
  }

  async submitOrder() {
    console.log(this.buyProductsFromSupplier);
  }
}
