package ru.eugenebay.the.io.magazine.controller;

import ru.eugenebay.the.io.magazine.common.InjectByType;
import ru.eugenebay.the.io.magazine.common.Singleton;
import ru.eugenebay.the.io.magazine.model.Label;
import ru.eugenebay.the.io.magazine.repository.LabelRepository;

import java.util.List;

@Singleton
public class LabelController {
    @InjectByType
    private LabelRepository repository;

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
