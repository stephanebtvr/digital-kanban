package com.kanban.board_service.controller;

import com.kanban.board_service.model.Board;
import com.kanban.board_service.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
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