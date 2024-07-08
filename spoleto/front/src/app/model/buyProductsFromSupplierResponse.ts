import { BuyProductsFromSupplier } from './buyProductsFromSupplier';

export class BuyProductsFromSupplierResponse {
  purchaseId?: number;
  purchaseDate?: string;
  purchaseStatus?: PurchaseStatus;
  totalValue?: number;
  listProducts?: BuyProductsFromSupplier;
}

enum PurchaseStatus {
  PENDING = 'PENDING',
  COMPLETED = 'COMPLETED',
  CANCELED = 'CANCELED',
}
