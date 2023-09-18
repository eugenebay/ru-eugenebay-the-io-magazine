package ru.eugenebay.the.io.magazine.view;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.common.InjectByType;
import ru.eugenebay.the.io.magazine.common.Singleton;
import ru.eugenebay.the.io.magazine.controller.LabelController;
import ru.eugenebay.the.io.magazine.model.Label;
import ru.eugenebay.the.io.magazine.model.Status;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Singleton
@Getter
public class LabelView implements Viewer, Settler {
    @InjectByType
    private LabelController controller;
    private final List<String> settlerNamesList = List.of("Sun", "Earth");

    @Override
    @PostConstruct
    public void settle() {
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
