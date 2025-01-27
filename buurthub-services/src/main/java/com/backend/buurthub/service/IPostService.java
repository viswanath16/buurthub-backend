package com.backend.buurthub.service;

import com.backend.buurthub.dto.PostDto;
import java.util.List;

public interface IPostService {
  PostDto createPost(PostDto postDto);

  PostDto fetchPost(Long postId);

  List<PostDto> fetchAllPosts();

  PostDto updatePost(Long postId, PostDto postDto);

  boolean deletePost(Long postId);
}
