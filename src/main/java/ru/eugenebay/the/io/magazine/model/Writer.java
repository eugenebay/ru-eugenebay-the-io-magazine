package ru.eugenebay.the.io.magazine.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Writer {
    private Long writerId;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Status status;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
