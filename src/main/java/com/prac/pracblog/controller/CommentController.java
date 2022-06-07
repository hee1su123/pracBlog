package com.prac.pracblog.controller;

import com.prac.pracblog.domain.Comment;
import com.prac.pracblog.dto.CommentRequestDto;
import com.prac.pracblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @ResponseBody
    @PostMapping("/api/comments/{id}")
    public Comment createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.save(id, requestDto);
    }

    @ResponseBody
    @GetMapping("/api/comments")
    public List<Comment> getComment() {
        List<Comment> commentList = commentService.findAll();
        return commentList;
    }

    @GetMapping("/api/comments/editpage/{id}")
    public String getCommentEditPage(@PathVariable Long id, Model model) {
        Comment comment = commentService.findById(id);
        model.addAttribute("comment", comment);
        return "editComment";
    }

    @ResponseBody
    @PutMapping("/api/comments/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
    }

    @ResponseBody
    @DeleteMapping("/api/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteById(id);
    }
}
