package ru.eugenebay.the.io.magazine.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Label {
    private Long labelId;
    private String labelName;
    private Status labelStatus;

    @Override
    public String toString() {
        return labelName;
    }
}
