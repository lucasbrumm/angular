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

enum StatusSupplier {
  ENABLED,
  DISABLED,
  IN_REVIEW,
}
