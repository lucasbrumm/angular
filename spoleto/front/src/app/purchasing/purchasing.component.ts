import { Component } from '@angular/core';
import { SupplierService } from '../services/supplier.service';
import { StatusSupplier, Supplier } from '../model/supplier';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Product } from '../model/product';
import { ProductsService } from '../services/products.service';
import { StockProductsService } from '../services/stock-products.service';
import { StockProduct } from '../model/stockProduct';
import { firstValueFrom } from 'rxjs';
import { BuyProductsFromSupplier } from '../model/buyProductsFromSupplier';
import { FormsModule } from '@angular/forms';
import { PurchasingService } from './purchasing.service';
import { PurchaseSupplier } from '../model/purchaseSupplier';
import { ChangeStatusSupplierPurchase } from '../model/changeStatusSupplierPurchase';

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
  purchaseSupplierList: PurchaseSupplier[] = [];
  buyProductsFromSupplier: BuyProductsFromSupplier = {
    idSupplier: 0,
    purchases: [],
  };
  columnsTableGetOrder: string[] = ['Item Name', 'Price ($)', 'Quantity (KG)'];
  columnsTableOrderList: string[] = [
    'Id',
    'Supplier',
    'Date',
    'Total Value',
    'Status',
  ];
  optionPuchaseStatus: string[] = ['PENDING', 'COMPLETED', 'CANCELLED'];
  totalOrder = 0;

  constructor(
    private supplierService: SupplierService,
    private stockProductsService: StockProductsService,
    private pushasingService: PurchasingService
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

    const purchaseSupplierListPromise = firstValueFrom(
      this.pushasingService.getAllOrdersFromSupplier()
    );

    const [suppliers, productStocks, purchaseSupplier] = await Promise.all([
      supplierListPromise,
      productStockListPromise,
      purchaseSupplierListPromise,
    ]);

    this.supplierList = suppliers.filter(
      (supplier) => supplier.status === StatusSupplier.ENABLED
    );
    this.productStockList = productStocks;
    this.purchaseSupplierList = purchaseSupplier;

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

  getSupplierName(supplierId: number | undefined) {
    const supplier = this.supplierList.find(
      (supplier) => supplier.id === supplierId
    );
    return supplier?.name;
  }

  async submitOrder() {
    this.pushasingService
      .buyNewProducts(this.buyProductsFromSupplier)
      .subscribe((res) => {
        this.buyProductsFromSupplier?.purchases?.map((productStock) => {
          productStock.quantity = 0;
        });
        const newOrder = {
          id: res.purchaseId,
          supplier: this.supplierList.find(
            (supplier) =>
              supplier.id === this.buyProductsFromSupplier.idSupplier
          ),
          purchaseDate: res.purchaseDate,
          totalValue: res.totalValue,
          status: res.purchaseStatus,
        };
        this.purchaseSupplierList.push(newOrder);
        this.totalOrder = 0;
      });
  }

  onChangeStatus(event: any, purchaseId?: number) {
    const status = event.target.value;
    const changeStatusSupplierPurchase: ChangeStatusSupplierPurchase = {
      idSupplierPurchase: purchaseId,
      statusPurchase: status,
    };
    this.pushasingService
      .changeStatusSupplier(changeStatusSupplierPurchase)
      .subscribe((res) => {
        const purchase = this.purchaseSupplierList.find(
          (purchase) => purchase.id === purchaseId
        );
        if (purchase) {
          purchase.status = res;
        }
      });
  }
}
