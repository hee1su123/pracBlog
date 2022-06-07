package com.prac.pracblog.domain;

import com.prac.pracblog.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
public class Post extends TimeStamped {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String text;

    public Post(PostRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.text = requestDto.getText();
    }

    public void update(PostRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.text = requestDto.getText();
    }
}
