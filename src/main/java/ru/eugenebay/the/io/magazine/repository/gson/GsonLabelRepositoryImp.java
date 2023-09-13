package ru.eugenebay.the.io.magazine.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.model.Label;
import ru.eugenebay.the.io.magazine.repository.LabelRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class GsonLabelRepositoryImp implements LabelRepository {
    private final String path = "storage/labels.json";
    private final Gson gson = new Gson();

    @Override
    public Label getById(Long inputLabelId) {
        var labels = getAll();
        return labels.stream()
                .filter(lab -> lab.getLabelId().equals(inputLabelId))
                .findAny()
                .orElseThrow(() -> {
                    var ex = new IllegalArgumentException("There is no Label with labelId: " + inputLabelId);
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(path))))) {
            Type labelType = new TypeToken<ArrayList<Label>>() {
            }.getType();
            labels = gson.fromJson(reader, labelType);
        } catch (IOException ex) {
            log.error(ex.getLocalizedMessage());
        }
        return Objects.nonNull(labels) ? labels : new ArrayList<>();
    }

    @Override
    public Label save(Label label) {
        var labels = getAll();
        Long nextId = calculate(labels);
        label.setLabelId(nextId);
        labels.add(label);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Path.of(path))))) {
            gson.toJson(labels, writer);
        } catch (IOException ex) {
            log.error(ex.getLocalizedMessage());
        }
        return label;
    }

    @Override
    public Label update(Label label) {
        var labels = getAll();
        var storageLabel = labels.stream()
                .filter(l -> l.getLabelId().equals(label.getLabelId()))
                .findAny()
                .orElse(save(label));
        if (!storageLabel.equals(label)) {
            storageLabel.setLabelName(label.getLabelName());
            storageLabel.setLabelStatus(label.getLabelStatus());
        }
        labels.add(storageLabel);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Path.of(path))))) {
            gson.toJson(labels, writer);
        } catch (IOException ex) {
            log.error(ex.getLocalizedMessage());
        }
        return storageLabel;
    }

    @Override
    public void deleteById(Long inputLabelId) {
        var labels = getAll();
        Optional<Label> optionalLabel = labels.stream()
                .filter(l -> l.getLabelId().equals(inputLabelId))
                .findAny();
        optionalLabel.ifPresent(labels::remove);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Path.of(path))))) {
            gson.toJson(labels, writer);
        } catch (IOException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    //TODO mb transfer to View or Controller?
    @Override
    public Long calculate(List<Label> list) {
        return list.stream()
                .mapToLong(Label::getLabelId)
                .max()
                .orElse(0) + 1;
    }
}
