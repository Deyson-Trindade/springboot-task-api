package com.notes.app.service.chores;

import com.notes.app.entity.ChoreEntity;
import com.notes.app.model.ChoreModel;
import com.notes.app.repository.ChoreRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChoresServiceImpl implements ChoresService {

    final ChoreRepository choreRepository;

    final ModelMapper modelMapper;


    @Override
    public List<ChoreModel> listAll() {

        return choreRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ChoreModel.class)).collect(Collectors.toList());

    }

    @Override
    public void delete(final UUID choreId) {

        choreRepository.deleteById(choreId);
    }

    @Override
    public ChoreModel create(final ChoreModel choreModel) {

        final ChoreEntity choreEntity = modelMapper.map(choreModel, ChoreEntity.class);

        choreRepository.save(choreEntity);

        return modelMapper.map(choreEntity, ChoreModel.class);
    }

    @Override
    public ChoreModel update(final ChoreModel choreModel) {

        final ChoreEntity choreEntity = modelMapper.map(choreModel, ChoreEntity.class);

        choreRepository.save(choreEntity);

        return modelMapper.map(choreEntity, ChoreModel.class);
    }


}
