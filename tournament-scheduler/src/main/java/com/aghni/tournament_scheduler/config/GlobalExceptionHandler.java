package com.aghni.tournament_scheduler.config;

import com.aghni.tournament_scheduler.common.ErrorResponse;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

         @ExceptionHandler(TournamentNameAlreadyExistsException.class)
         public ResponseEntity<ErrorResponse> handleTournamentNameAlreadyExistsException(TournamentNameAlreadyExistsException e) {
             ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),409);
             return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
         }
}
