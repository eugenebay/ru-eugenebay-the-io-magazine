package ru.eugenebay.the.io.magazine.repository.gson;

import ru.eugenebay.the.io.magazine.model.Writer;
import ru.eugenebay.the.io.magazine.annotations.WriterRepository;

import java.util.ArrayList;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    @Override
    public List<Writer> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Writer getById(Long aLong) {
        return null;
    }

    @Override
    public Writer save(Writer writer) {
        return null;
    }

    @Override
    public Writer update(Writer writer) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Long calculate(List<Writer> list) {
        return null;
    }

    @Override
    public void archive(List<Writer> list) {

    }
}
