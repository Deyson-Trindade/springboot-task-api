package com.notes.app.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class Chore {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "finished", nullable = false)
    private boolean finished;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updated_at;

}
