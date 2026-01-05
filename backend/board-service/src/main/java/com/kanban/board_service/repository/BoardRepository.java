package com.kanban.board_service.repository;
import com.kanban.board_service.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByOwnerId(String ownerId);
}

// Crée aussi ColumnRepository et TaskRepository si besoin de requêtes spécifiques