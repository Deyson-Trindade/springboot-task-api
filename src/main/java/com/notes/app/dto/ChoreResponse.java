package com.notes.app.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChoreResponse {

    private UUID id;

    private String title;

    private String description;

    private boolean finished;

}
