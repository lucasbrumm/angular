export class Supplier {
  id?: number;
  name?: string;
  address?: string;
  contactNumber?: string;
  email?: string;
  cnpj?: string;
  description?: string;
  status?: StatusSupplier;
}

export enum StatusSupplier {
  ENABLED = 'ENABLED',
  DISABLED = 'DISABLED',
  IN_REVIEW = 'IN_REVIEW',
}
