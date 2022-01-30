package com.notes.app.repository;

import com.notes.app.model.Chore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ChoreReposity extends JpaRepository<Chore, id> {
}
