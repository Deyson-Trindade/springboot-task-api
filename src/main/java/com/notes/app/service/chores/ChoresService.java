package com.notes.app.service.chores;

import com.notes.app.model.Chore;

import java.util.List;
import java.util.UUID;

public interface ChoresService {

    List<Chore> listAll();

    void delete(UUID chore);

    Chore create(Chore chore);
}
