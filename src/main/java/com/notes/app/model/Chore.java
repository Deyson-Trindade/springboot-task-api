package com.notes.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chore {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    private boolean finished;
    private String description;

    public boolean equals(@NotNull Object other) {

        Chore chore = (Chore) other;

        return this.description.equals(chore.description);
    }
}
