package com.notes.app.controller;

import com.notes.app.model.Chore;
import com.notes.app.repository.ChoreReposity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chore")
public class ChoreController {

    ChoreReposity choreReposity;

    @GetMapping
    public List<Chore> getAllChores() {
        //TODO change the return and implemen method
        return null;
    }
}
