package com.JPM.java.packet.manager.errors;

import com.JPM.java.packet.manager.dto.ErrorDTO;
import com.JPM.java.packet.manager.errors.FIles.FileError;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileError.class)
    public ResponseEntity<ErrorDTO> hedlerFileError(FileError err) {
        ErrorDTO errro = new ErrorDTO(
            Instant.now(),
            "File Error",
            err.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errro);
    }
}
