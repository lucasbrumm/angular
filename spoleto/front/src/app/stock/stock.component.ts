import { Component } from '@angular/core';
import { StockProductsService } from '../services/stock-products.service';
import { firstValueFrom } from 'rxjs';
import { StockProduct } from '../model/stockProduct';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-stock',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './stock.component.html',
  styleUrl: './stock.component.css',
})
export class StockComponent {
  columnsTableStock = ['Id', 'Product', 'Cost($)', 'Quantity(KG)'];
  productStockList: StockProduct[] = [];
  constructor(private stockProductsService: StockProductsService) {}

  ngOnInit() {
    this.getInicialData();
  }

  private async getInicialData() {
    const productStockListPromise = firstValueFrom(
      this.stockProductsService.getAllStockProducts()
    );

    const [productStocks] = await Promise.all([productStockListPromise]);

    this.productStockList = productStocks;
  }
}
