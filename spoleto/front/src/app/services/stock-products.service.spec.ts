import { TestBed } from '@angular/core/testing';

import { StockProductsService } from './stock-products.service';

describe('StockProductsService', () => {
  let service: StockProductsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockProductsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
