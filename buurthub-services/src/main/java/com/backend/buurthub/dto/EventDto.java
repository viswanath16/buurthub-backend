package com.backend.buurthub.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class EventDto {
  private Long eventId;
  private String title;
  private Date date;
  private String address;
  private String locationUrl;
  private LocationDto location;
  private String image;
  private String description;
  private String organiser;
  private String city;
  private String time;
  private String price;
  private String category;
  private List<String> participants;

  @Data
  public static class LocationDto {
    private String type;
    private CoordinatesDto coordinates;
  }

  @Data
  public static class CoordinatesDto {
    private Double latitude;
    private Double longitude;
  }
}
