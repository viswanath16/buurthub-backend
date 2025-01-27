package com.backend.buurthub.controller;

import com.backend.buurthub.dto.CityDto;
import com.backend.buurthub.dto.ErrorResponseDto;
import com.backend.buurthub.dto.ResponseDto;
import com.backend.buurthub.service.ICityService;
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
        name = "CRUD REST APIs for City in Buurthub",
        description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE city details"
)
@RestController
@RequestMapping(path="/api/cities", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CityController {

    private final ICityService iCityService;

    public CityController(ICityService iCityService) {
        this.iCityService = iCityService;
    }

    @Operation(
            summary = "Create City REST API",
            description = "REST API to create a new City"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCity(@Valid @RequestBody CityDto cityDto) {
        iCityService.createCity(cityDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "City created successfully"));
    }

    @Operation(
            summary = "Fetch City Details REST API",
            description = "REST API to fetch City details based on city name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<CityDto> fetchCityDetails(@RequestParam String cityName) {
        CityDto cityDto = iCityService.fetchCity(cityName);
        return ResponseEntity.status(HttpStatus.OK).body(cityDto);
    }

    @Operation(
            summary = "Update City Details REST API",
            description = "REST API to update City details based on city name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCityDetails(@Valid @RequestBody CityDto cityDto) {
        boolean isUpdated = iCityService.updateCity(cityDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "City updated successfully"));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto("417", "City update failed"));
        }
    }

    @Operation(
            summary = "Delete City Details REST API",
            description = "REST API to delete City details based on city name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCityDetails(@RequestParam String cityName) {
        boolean isDeleted = iCityService.deleteCity(cityName);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "City deleted successfully"));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto("417", "City deletion failed"));
        }
    }
}