export class BuyProductsFromSupplier {
  idSupplier?: number;
  purchases?: ProductPurchase[];
}

class ProductPurchase {
  productId?: number;
  quantity?: number;
}
