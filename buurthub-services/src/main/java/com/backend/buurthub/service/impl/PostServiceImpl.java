package com.backend.buurthub.service.impl;

import com.backend.buurthub.dto.PostDto;
import com.backend.buurthub.entity.Post;
import com.backend.buurthub.mapper.PostMapper;
import com.backend.buurthub.repository.PostRepository;
import com.backend.buurthub.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

  private final PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public PostDto createPost(PostDto postDto) {
    Post post = PostMapper.mapToPost(postDto);
    Post savedPost = postRepository.save(post);
    return PostMapper.mapToPostDto(savedPost);
  }

  @Override
  public PostDto fetchPost(Long postId) {
    Post post =
        postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
    return PostMapper.mapToPostDto(post);
  }

  @Override
  public List<PostDto> fetchAllPosts() {
    return postRepository.findAll().stream()
        .map(PostMapper::mapToPostDto)
        .collect(Collectors.toList());
  }

  @Override
  public PostDto updatePost(Long postId, PostDto postDto) {
    Post post =
        postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
    post.setCity(postDto.getCity());
    post.setTitle(postDto.getTitle());
    post.setContent(postDto.getContent());
    post.setPostAuthor(postDto.getPostAuthor());
    post.setImage(postDto.getImage());
    post.setContactInfo(postDto.getContactInfo());
    Post updatedPost = postRepository.save(post);
    return PostMapper.mapToPostDto(updatedPost);
  }

  @Override
  public boolean deletePost(Long postId) {
    if (postRepository.existsById(postId)) {
      postRepository.deleteById(postId);
      return true;
    }
    return false;
  }
}
