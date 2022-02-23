package com.notes.app.repository;

import com.notes.app.entity.ChoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChoreRepository extends JpaRepository<ChoreEntity, UUID> {

    void deleteById(UUID id);
}
