package com.kanban.board.repository;
import com.kanban.board.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByOwnerId(String ownerId);
}

// Crée aussi ColumnRepository et TaskRepository si besoin de requêtes spécifiques