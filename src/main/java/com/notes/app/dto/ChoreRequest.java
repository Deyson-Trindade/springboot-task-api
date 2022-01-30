package com.notes.app.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ChoreRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private boolean finished;

}
