package ru.eugenebay.the.io.magazine.console;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsoleMessage {
    private String header;
    private String text;
}
