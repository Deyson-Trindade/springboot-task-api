package com.notes.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chore {

    private boolean finished;
    private String description;

    public boolean equals(@NotNull Object other) {

        Chore chore = (Chore) other;

        return this.description.equals(chore.description);
    }
}
