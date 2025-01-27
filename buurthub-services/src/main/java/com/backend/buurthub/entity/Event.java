package com.backend.buurthub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_id")
  private Long eventId;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private Date date;

  @Column(nullable = false)
  private String address;

  private String locationUrl;

  @Embedded private Location location;

  @Column(nullable = false)
  private String image;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String organiser;

  private String city;

  private String time;

  @Enumerated(EnumType.STRING)
  private Price price;

  @Enumerated(EnumType.STRING)
  private Category category;

  @ElementCollection private List<String> participants;

  @Embeddable
  @Getter
  @Setter
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Location {
    @Column(nullable = false)
    private String type = "Point";

    @Embedded private Coordinates coordinates;
  }

  @Embeddable
  @Getter
  @Setter
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Coordinates {
    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;
  }

  public enum Price {
    Paid,
    Free
  }

  public enum Category {
    Art_and_Culture,
    Health_and_Wellness,
    Entertainment,
    Sports,
    Technology,
    Education,
    Community_and_Environment,
    Career
  }
}
