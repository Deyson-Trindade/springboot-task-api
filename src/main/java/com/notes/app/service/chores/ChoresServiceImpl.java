package com.notes.app.service.chores;

import com.notes.app.model.Chore;
import com.notes.app.repository.ChoreReposity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChoresServiceImpl implements ChoresService {

    final ChoreReposity choreReposity;


    @Override
    public List<Chore> listAll() {
        return choreReposity.findAll();
    }

    @Override
    public void delete(final Chore chore) {
        choreReposity.delete(chore);
    }

    @Override
    public Chore create(final Chore chore) {
       return choreReposity.save(chore);
    }
}
