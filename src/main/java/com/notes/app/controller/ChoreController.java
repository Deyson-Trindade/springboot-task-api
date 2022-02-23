package com.notes.app.controller;

import com.notes.app.dto.ChoreRequest;
import com.notes.app.dto.ChoreResponse;
import com.notes.app.model.ChoreModel;
import com.notes.app.service.chores.ChoresService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/chore")
public class ChoreController {

    @Lazy
    @Autowired
    private ChoresService choresService;

    @Lazy
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ChoreModel> getAllChores() {
        return choresService.listAll();
    }

    @PostMapping
    public ResponseEntity<ChoreResponse> create(
            @RequestBody @Valid ChoreRequest choreRequest) {

        ChoreModel convertedChoreModel = modelMapper.map(choreRequest, ChoreModel.class);

        ChoreModel persistedChoreModel = choresService.create(convertedChoreModel);

        return new ResponseEntity<>(modelMapper.map(persistedChoreModel, ChoreResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {

        choresService.delete(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ChoreResponse> update(@PathVariable @Valid UUID id,
                                                @RequestBody @Valid ChoreRequest choreRequest) {

        ChoreModel convertedChoreModel = modelMapper.map(choreRequest, ChoreModel.class);

        ChoreModel persistedChoreModel = choresService.update(convertedChoreModel);

        return new ResponseEntity<>(modelMapper.map(persistedChoreModel, ChoreResponse.class), HttpStatus.OK);

    }

}
