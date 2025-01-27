package com.backend.buurthub.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
  private Long postId;
  private String city;
  private String title;
  private String content;
  private String postAuthor;
  private String image;
  private String contactInfo;
  private LocalDateTime createdAt;
}
