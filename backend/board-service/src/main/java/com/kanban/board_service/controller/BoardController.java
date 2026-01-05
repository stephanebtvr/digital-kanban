package com.kanban.board.controller;

import com.kanban.board.model.Board;
import com.kanban.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Board> create(@RequestBody Board board) {
        return ResponseEntity.ok(boardService.createBoard(board.getName(), board.getOwnerId()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Board>> getByUser(@PathVariable String userId) {
        return ResponseEntity.ok(boardService.getBoardsByOwner(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }
}