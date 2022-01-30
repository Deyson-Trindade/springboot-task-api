package com.notes.app.repository;

import com.notes.app.model.Chore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChoreReposity extends JpaRepository<Chore, UUID> {
}
