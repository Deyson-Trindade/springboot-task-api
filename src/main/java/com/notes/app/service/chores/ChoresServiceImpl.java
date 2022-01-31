package com.notes.app.service.chores;

import com.notes.app.model.Chore;
import com.notes.app.repository.ChoreReposity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ChoresServiceImpl implements ChoresService {

    final ChoreReposity choreReposity;


    @Override
    public List<Chore> listAll() {
        return choreReposity.findAll();
    }

    @Override
    public void delete(final UUID id) {
        Optional<Chore> optionalChore = choreReposity.findById(id);
        choreReposity.delete(optionalChore);
    }

    @Override
    public Chore create(final Chore chore) {
       return choreReposity.save(chore);
    }
}
