package com.notes.app.controller;

import com.notes.app.dto.ChoreRequest;
import com.notes.app.dto.ChoreResponse;
import com.notes.app.model.Chore;
import com.notes.app.service.chores.ChoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chore")
public class ChoreController {

    @Autowired
    ChoresService choresService;

    @GetMapping
    public List<Chore> getAllChores() {
        return choresService.listAll();
    }

    @PostMapping
    public ResponseEntity<ChoreResponse> create(
            @RequestBody @Valid ChoreRequest choreRequest) {

        Chore chore = new Chore();

        chore.setTitle(choreRequest.getTitle());
        chore.setDescription(choreRequest.getDescription());
        chore.setFinished(choreRequest.isFinished());

        choresService.create(chore);

        ChoreResponse choreResponse = new ChoreResponse();
        choreResponse.setTitle(choreRequest.getTitle());
        choreResponse.setDescription(choreRequest.getDescription());
        choreResponse.setFinished(choreResponse.isFinished());
        return new ResponseEntity<>(choreResponse, HttpStatus.CREATED);
    }

    @DeleteMapping
    public void delete() {

    }
}
