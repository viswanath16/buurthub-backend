package com.backend.buurthub.controller;

import com.backend.buurthub.dto.ErrorResponseDto;
import com.backend.buurthub.dto.EventDto;
import com.backend.buurthub.dto.ResponseDto;
import com.backend.buurthub.service.IEventService;
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
    name = "CRUD REST APIs for Event in Buurthub",
    description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE event details")
@RestController
@RequestMapping(
    path = "/api/events",
    produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class EventController {

  private final IEventService iEventService;

  public EventController(IEventService iEventService) {
    this.iEventService = iEventService;
  }

  @Operation(summary = "Create Event REST API", description = "REST API to create a new Event")
  @ApiResponses({
    @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PostMapping("/create")
  public ResponseEntity<ResponseDto> createEvent(@Valid @RequestBody EventDto eventDto) {
    iEventService.createEvent(eventDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto("201", "Event created successfully"));
  }

  @Operation(
      summary = "Fetch Event Details REST API",
      description = "REST API to fetch Event details based on event title")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @GetMapping("/fetch")
  public ResponseEntity<EventDto> fetchEventDetails(@RequestParam String title) {
    EventDto eventDto = iEventService.fetchEvent(title);
    return ResponseEntity.status(HttpStatus.OK).body(eventDto);
  }

  @Operation(
      summary = "Update Event Details REST API",
      description = "REST API to update Event details based on event title")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(responseCode = "417", description = "Expectation Failed"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PutMapping("/update")
  public ResponseEntity<ResponseDto> updateEventDetails(@Valid @RequestBody EventDto eventDto) {
    boolean isUpdated = iEventService.updateEvent(eventDto);
    if (isUpdated) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseDto("200", "Event updated successfully"));
    } else {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .body(new ResponseDto("417", "Event update failed"));
    }
  }

  @Operation(
      summary = "Delete Event Details REST API",
      description = "REST API to delete Event details based on event title")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(responseCode = "417", description = "Expectation Failed"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> deleteEventDetails(@RequestParam String title) {
    boolean isDeleted = iEventService.deleteEvent(title);
    if (isDeleted) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseDto("200", "Event deleted successfully"));
    } else {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .body(new ResponseDto("417", "Event deletion failed"));
    }
  }
}
