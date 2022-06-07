package com.prac.pracblog.service;

import com.prac.pracblog.domain.Comment;
import com.prac.pracblog.domain.Post;
import com.prac.pracblog.dto.CommentRequestDto;
import com.prac.pracblog.repository.CommentRepository;
import com.prac.pracblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public Comment save(Long id, CommentRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다")
        );
        Comment comment = new Comment(requestDto, post);
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        return commentList;
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다")
        );
    }

    @Transactional
    public void update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다")
        );
        comment.update(requestDto);
    }
}
