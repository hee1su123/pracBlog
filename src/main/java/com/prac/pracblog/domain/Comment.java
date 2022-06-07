package com.prac.pracblog.domain;

import com.prac.pracblog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends TimeStamped {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "Post_ID", nullable = false)
    private Post post;

    public Comment(CommentRequestDto requestDto, Post post) {
        this.text = requestDto.getText();
        this.post = post;
    }

    public void update(CommentRequestDto requestDto) {
        this.text = requestDto.getText();
    }
}
