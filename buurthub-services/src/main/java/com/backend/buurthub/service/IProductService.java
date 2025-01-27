package com.backend.buurthub.service;

import com.backend.buurthub.dto.ProductDto;

public interface IProductService {
  void createProduct(ProductDto productDto);

  ProductDto fetchProduct(Long productId);

  boolean updateProduct(ProductDto productDto);

  boolean deleteProduct(Long productId);
}
