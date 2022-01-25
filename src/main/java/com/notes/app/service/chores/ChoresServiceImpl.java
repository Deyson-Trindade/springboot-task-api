package com.notes.app.service.chores;

import com.notes.app.model.Chore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChoresServiceImpl implements ChoresService {

    List<Chore> chores;

    public ChoresServiceImpl() {
        chores = new ArrayList<>();
        chores.add(new Chore(true, "Take the trash out"));
        chores.add(new Chore(true, "Take the trash out"));
        chores.add(new Chore(true, "Take the trash out"));
    }

    @Override
    public List<Chore> listAll() {
        return chores;
    }

    @Override
    public void delete(Chore chore) {
        chores.remove(chore);
    }
}
