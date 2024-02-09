package boardcamp.boardcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import boardcamp.boardcamp.exceptions.RentalExceptions.GameNotFoundException;
import boardcamp.boardcamp.exceptions.RentalExceptions.RentalBadRequestException;
import boardcamp.boardcamp.exceptions.RentalExceptions.RentalUnprocessableEntityException;

@ControllerAdvice
public class RentalExceptionHandler {
  
  @ExceptionHandler({RentalBadRequestException.class})
  public ResponseEntity<String> handleRentalBadRequest(RentalBadRequestException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }

  @ExceptionHandler({GameNotFoundException.class})
  public ResponseEntity<String> handleGameNotFound(GameNotFoundException e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler({RentalUnprocessableEntityException.class})
  public ResponseEntity<String> handleUnprocessableEntity(RentalUnprocessableEntityException e){
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
  }
}
