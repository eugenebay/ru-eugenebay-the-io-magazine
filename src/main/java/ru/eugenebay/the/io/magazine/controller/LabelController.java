package ru.eugenebay.the.io.magazine.controller;

import ru.eugenebay.the.io.magazine.common.ApplicationObjectFactory;
import ru.eugenebay.the.io.magazine.model.Label;
import ru.eugenebay.the.io.magazine.repository.LabelRepository;

import java.util.List;

public class LabelController {
    private final LabelRepository repository = ApplicationObjectFactory.getInstance().createObject(LabelRepository.class);

    public Label getById(Long labelId) {
        return repository.getById(labelId);
    }

    public List<Label> getAll() {
        return repository.getAll();
    }

    public Label save(Label label) {
        return repository.save(label);
    }

    public Label update(Label label) {
        return repository.update(label);
    }

    public void deleteById(Long labelId) {
        repository.deleteById(labelId);
    }
}
