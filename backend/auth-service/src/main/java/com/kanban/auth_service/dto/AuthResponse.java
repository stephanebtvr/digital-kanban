package com.kanban.auth_service.dto;

public record AuthResponse(String token, String username, String email) {}
