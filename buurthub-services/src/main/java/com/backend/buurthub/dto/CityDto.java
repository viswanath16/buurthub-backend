package com.backend.buurthub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "City", description = "Schema to hold City information")
public class CityDto {

  @Schema(description = "Name of the city", example = "Amsterdam")
  @NotEmpty(message = "City name cannot be null or empty")
  @Size(min = 2, max = 50, message = "The length of the city name should be between 2 and 50")
  private String cityName;
}
