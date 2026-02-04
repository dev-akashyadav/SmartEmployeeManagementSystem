package com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        String errorMsg,
        LocalDateTime timestamp,
        int statusCode,
        String errorType
) {

    public ErrorResponseDTO(String msg, int statusCode, String errorType) {
        this(msg, LocalDateTime.now(), statusCode, errorType);
    }
}
