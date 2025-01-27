package com.backend.buurthub.mapper;

import com.backend.buurthub.dto.PostDto;
import com.backend.buurthub.entity.Post;

public class PostMapper {

  public static PostDto mapToPostDto(Post post) {
    PostDto postDto = new PostDto();
    postDto.setPostId(post.getPostId());
    postDto.setCity(post.getCity());
    postDto.setTitle(post.getTitle());
    postDto.setContent(post.getContent());
    postDto.setPostAuthor(post.getPostAuthor());
    postDto.setImage(post.getImage());
    postDto.setContactInfo(post.getContactInfo());
    postDto.setCreatedAt(post.getCreatedAt());
    return postDto;
  }

  public static Post mapToPost(PostDto postDto) {
    Post post = new Post();
    post.setCity(postDto.getCity());
    post.setTitle(postDto.getTitle());
    post.setContent(postDto.getContent());
    post.setPostAuthor(postDto.getPostAuthor());
    post.setImage(postDto.getImage());
    post.setContactInfo(postDto.getContactInfo());
    post.setCreatedAt(postDto.getCreatedAt());
    return post;
  }
}
