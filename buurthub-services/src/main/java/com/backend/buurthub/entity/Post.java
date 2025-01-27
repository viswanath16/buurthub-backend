package com.backend.buurthub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private Long postId;

  private String city;
  private String title;
  private String content;
  private String postAuthor;
  private String image;
  private String contactInfo;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;
}
