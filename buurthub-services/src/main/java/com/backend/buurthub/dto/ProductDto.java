package com.backend.buurthub.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private Long productId;
  private String city;
  private String productName;
  private Double price;
  private String image;
  private String description;
  private String condition;
  private String productOwner;
  private String category;
  private String reservedById;
  private String favouriteById;
}
