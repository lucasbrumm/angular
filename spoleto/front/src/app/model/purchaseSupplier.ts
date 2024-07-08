import { PurchaseStatus } from './buyProductsFromSupplierResponse';
import { Supplier } from './supplier';

export class PurchaseSupplier {
  id?: number;
  supplier?: Supplier;
  purchaseDate?: string;
  totalValue?: number;
  status?: PurchaseStatus;
}
