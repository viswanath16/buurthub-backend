package com.backend.buurthub.controller;

import com.backend.buurthub.dto.ErrorResponseDto;
import com.backend.buurthub.dto.PostDto;
import com.backend.buurthub.service.IPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "CRUD REST APIs for Post in Buurthub",
    description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE post details")
@RestController
@RequestMapping("/api/posts")
public class PostController {

  private final IPostService postService;

  @Autowired
  public PostController(IPostService postService) {
    this.postService = postService;
  }

  @Operation(summary = "Create Post REST API", description = "REST API to create a new Post")
  @ApiResponses({
    @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PostMapping
  public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
    PostDto createdPost = postService.createPost(postDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
  }

  @Operation(
      summary = "Fetch Post Details REST API",
      description = "REST API to fetch Post details based on post ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(
        responseCode = "404",
        description = "Post not found",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @GetMapping("/{postId}")
  public ResponseEntity<PostDto> fetchPost(@PathVariable Long postId) {
    PostDto postDto = postService.fetchPost(postId);
    return ResponseEntity.status(HttpStatus.OK).body(postDto);
  }

  @Operation(summary = "Fetch All Posts REST API", description = "REST API to fetch all Posts")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @GetMapping
  public ResponseEntity<List<PostDto>> fetchAllPosts() {
    List<PostDto> posts = postService.fetchAllPosts();
    return ResponseEntity.status(HttpStatus.OK).body(posts);
  }

  @Operation(
      summary = "Update Post REST API",
      description = "REST API to update Post details based on post ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    @ApiResponse(
        responseCode = "404",
        description = "Post not found",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PutMapping("/{postId}")
  public ResponseEntity<PostDto> updatePost(
      @PathVariable Long postId, @Valid @RequestBody PostDto postDto) {
    PostDto updatedPost = postService.updatePost(postId, postDto);
    return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
  }

  @Operation(
      summary = "Delete Post REST API",
      description = "REST API to delete Post details based on post ID")
  @ApiResponses({
    @ApiResponse(responseCode = "204", description = "HTTP Status NO CONTENT"),
    @ApiResponse(
        responseCode = "404",
        description = "Post not found",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @DeleteMapping("/{postId}")
  public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
    boolean isDeleted = postService.deletePost(postId);
    if (isDeleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
