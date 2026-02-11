package com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        String errorMsg,
        LocalDateTime timestamp,
        int statusCode,
        String errorType,
        String requestURI
) {

    public ErrorResponseDTO(String msg, int statusCode, String errorType, String requestURI) {
        this(msg, LocalDateTime.now(), statusCode, errorType, requestURI);
    }


}
