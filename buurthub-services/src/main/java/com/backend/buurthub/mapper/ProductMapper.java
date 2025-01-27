package com.backend.buurthub.mapper;

import com.backend.buurthub.dto.ProductDto;
import com.backend.buurthub.entity.Product;

public class ProductMapper {

  public static ProductDto mapToProductDto(Product product, ProductDto productDto) {
    productDto.setProductId(product.getProductId());
    productDto.setCity(product.getCity());
    productDto.setProductName(product.getProductName());
    productDto.setPrice(product.getPrice());
    productDto.setImage(product.getImage());
    productDto.setDescription(product.getDescription());
    productDto.setCondition(product.getCondition());
    productDto.setProductOwner(product.getProductOwner());
    productDto.setCategory(product.getCategory());
    productDto.setReservedById(product.getReservedById());
    productDto.setFavouriteById(product.getFavouriteById());
    return productDto;
  }

  public static Product mapToProduct(ProductDto productDto, Product product) {
    product.setCity(productDto.getCity());
    product.setProductName(productDto.getProductName());
    product.setPrice(productDto.getPrice());
    product.setImage(productDto.getImage());
    product.setDescription(productDto.getDescription());
    product.setCondition(productDto.getCondition());
    product.setProductOwner(productDto.getProductOwner());
    product.setCategory(productDto.getCategory());
    product.setReservedById(productDto.getReservedById());
    product.setFavouriteById(productDto.getFavouriteById());
    return product;
  }
}
