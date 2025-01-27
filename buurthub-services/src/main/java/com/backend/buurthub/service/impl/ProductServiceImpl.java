package com.backend.buurthub.service.impl;

import com.backend.buurthub.dto.ProductDto;
import com.backend.buurthub.entity.Product;
import com.backend.buurthub.mapper.ProductMapper;
import com.backend.buurthub.repository.ProductRepository;
import com.backend.buurthub.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void createProduct(ProductDto productDto) {
    Product product = ProductMapper.mapToProduct(productDto, new Product());
    productRepository.save(product);
  }

  @Override
  public ProductDto fetchProduct(Long productId) {
    Optional<Product> productOptional = productRepository.findById(productId);
    if (productOptional.isPresent()) {
      return ProductMapper.mapToProductDto(productOptional.get(), new ProductDto());
    }
    return null;
  }

  @Override
  public boolean updateProduct(ProductDto productDto) {
    Optional<Product> productOptional = productRepository.findById(productDto.getProductId());
    if (productOptional.isPresent()) {
      Product product = ProductMapper.mapToProduct(productDto, productOptional.get());
      productRepository.save(product);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteProduct(Long productId) {
    Optional<Product> productOptional = productRepository.findById(productId);
    if (productOptional.isPresent()) {
      productRepository.deleteById(productId);
      return true;
    }
    return false;
  }
}
