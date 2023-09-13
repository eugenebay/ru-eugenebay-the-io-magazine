package ru.eugenebay.the.io.magazine.common;

import lombok.Getter;
import ru.eugenebay.the.io.magazine.view.LabelView;

@Getter
public class ApplicationContext {
    private final LabelView labelView = new LabelView();
}
