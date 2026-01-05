package com.kanban.board_service.service;

import com.kanban.board_service.model.Board;
import com.kanban.board_service.model.ColumnEntity;
import com.kanban.board_service.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(String name, String ownerId) {
        Board board = new Board();
        board.setName(name);
        board.setOwnerId(ownerId);
        
        // Initialisation par défaut
        List<ColumnEntity> defaultCols = List.of(
            new ColumnEntity(null, "À faire", 0, board, new ArrayList<>()),
            new ColumnEntity(null, "En cours", 1, board, new ArrayList<>()),
            new ColumnEntity(null, "Terminé", 2, board, new ArrayList<>())
        );
        board.setColumns(defaultCols);
        return boardRepository.save(board);
    }

    public List<Board> getBoardsByOwner(String ownerId) {
        return boardRepository.findByOwnerId(ownerId);
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }
}