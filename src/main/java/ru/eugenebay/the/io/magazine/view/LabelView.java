package ru.eugenebay.the.io.magazine.view;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.controller.LabelController;
import ru.eugenebay.the.io.magazine.model.Label;
import ru.eugenebay.the.io.magazine.model.Status;

import java.util.List;

@Slf4j
@Getter
public class LabelView implements View, Settler {
    private final LabelController controller;

    public LabelView() {
        this.controller = new LabelController();
    }

    @Override
    public void settle(List<String> settlerNamesList) {
        var labels = getController().getAll();
        if (labels.isEmpty()) {
            settlerNamesList.forEach(nameFromList -> {
                var lab = Label.builder()
                        .labelName(nameFromList)
                        .labelStatus(Status.ACTIVE)
                        .build();
                log.info("{}", getController().save(lab));
            });
        }
    }
}
