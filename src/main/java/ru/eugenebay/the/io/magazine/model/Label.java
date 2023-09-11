package ru.eugenebay.the.io.magazine.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Label {
    private final Long labelId;
    @NonNull
    private String labelName;
    private Status status;

    @Override
    public String toString() {
        return labelName;
    }
}
