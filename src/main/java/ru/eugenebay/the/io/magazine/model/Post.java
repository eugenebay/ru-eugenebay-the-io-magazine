package ru.eugenebay.the.io.magazine.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class Post {
    private Long postId;
    private String content;
    private LocalDateTime postCreated;
    private LocalDateTime postUpdated;
    private Set<Label> labels;
    private PostStatus postStatus;

    @Override
    public String toString() {
        return content;
    }
}
