package boardcamp.boardcamp.exceptions.RentalExceptions;

public class GameNotFoundException extends RuntimeException{
  public GameNotFoundException(String message){
    super(message);
  }
}
