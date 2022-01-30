package com.notes.app.service.chores;

import com.notes.app.model.Chore;

import java.util.List;

public interface ChoresService {

    List<Chore> listAll();

    void delete(Chore chore);

    Chore create(Chore chore);
}
