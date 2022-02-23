package com.notes.app.service.chores;

import com.notes.app.model.ChoreModel;

import java.util.List;
import java.util.UUID;

public interface ChoresService {

    List<ChoreModel> listAll();

    void delete(UUID id);

    ChoreModel create(ChoreModel choreModel);

    ChoreModel update(ChoreModel choreModel);
}
