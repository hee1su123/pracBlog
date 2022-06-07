package com.prac.pracblog.service;

import com.prac.pracblog.domain.Comment;
import com.prac.pracblog.domain.Post;
import com.prac.pracblog.dto.PostRequestDto;
import com.prac.pracblog.repository.CommentRepository;
import com.prac.pracblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Post save(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        return postList;
    }

    public void deleteById(Long id) {
        List<Comment> comments = commentRepository.findAllByPostId(id);
        for (Comment comment : comments) {
            commentRepository.delete(comment);
        }
        postRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, PostRequestDto requestDto) {
        System.out.println("update");
        System.out.println(id);
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다")
        );
        post.update(requestDto);
    }

    public Post findById(Long id) {
        System.out.println("2");
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다")
        );
    }
}
