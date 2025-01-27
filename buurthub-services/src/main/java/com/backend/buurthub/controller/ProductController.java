package com.backend.buurthub.controller;

import com.backend.buurthub.dto.ErrorResponseDto;
import com.backend.buurthub.dto.ProductDto;
import com.backend.buurthub.dto.ResponseDto;
import com.backend.buurthub.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "CRUD REST APIs for Product in Buurthub",
    description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE product details")
@RestController
@RequestMapping(
    path = "/api/products",
    produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ProductController {

  private final IProductService productService;

  public ProductController(IProductService productService) {
    this.productService = productService;
  }

  @Operation(summary = "Create Product REST API", description = "REST API to create a new Product")
  @ApiResponses({
    @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PostMapping
  public ResponseEntity<ResponseDto> createProduct(@Valid @RequestBody ProductDto productDto) {
    productService.createProduct(productDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto("201", "Product created successfully"));
  }

  @Operation(
      summary = "Fetch Product Details REST API",
      description = "REST API to fetch Product details based on product ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> fetchProductDetails(@PathVariable Long id) {
    ProductDto productDto = productService.fetchProduct(id);
    return ResponseEntity.status(HttpStatus.OK).body(productDto);
  }

  @Operation(
      summary = "Update Product Details REST API",
      description = "REST API to update Product details based on product ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(responseCode = "417", description = "Expectation Failed"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto> updateProductDetails(
      @PathVariable Long id, @Valid @RequestBody ProductDto productDto) {
    productDto.setProductId(id);
    boolean isUpdated = productService.updateProduct(productDto);
    if (isUpdated) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseDto("200", "Product updated successfully"));
    } else {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .body(new ResponseDto("417", "Product update failed"));
    }
  }

  @Operation(
      summary = "Delete Product Details REST API",
      description = "REST API to delete Product details based on product ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(responseCode = "417", description = "Expectation Failed"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDto> deleteProductDetails(@PathVariable Long id) {
    boolean isDeleted = productService.deleteProduct(id);
    if (isDeleted) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseDto("200", "Product deleted successfully"));
    } else {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .body(new ResponseDto("417", "Product deletion failed"));
    }
  }
}
