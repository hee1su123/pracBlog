package com.prac.pracblog.controller;

import com.prac.pracblog.domain.Post;
import com.prac.pracblog.dto.PostRequestDto;
import com.prac.pracblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @ResponseBody
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @ResponseBody
    @GetMapping("/api/posts")
    public List<Post> getAllPost() {
        List<Post> postList = postService.findAll();
        return postList;
    }

    @ResponseBody
    @GetMapping("/api/posts/id/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/api/posts/{id}")
    public String getPostPage(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/api/posts/editpage/{id}")
    public String getEditPage(@PathVariable Long id, Model model) {
        System.out.println("1");
        Post post = postService.findById(id);
        System.out.println("3");
        model.addAttribute("post", post);
        System.out.println("4");
        return "edit";
    }

    @ResponseBody
    @PutMapping("/api/posts/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
    }

    @ResponseBody
    @DeleteMapping("/api/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }
}
