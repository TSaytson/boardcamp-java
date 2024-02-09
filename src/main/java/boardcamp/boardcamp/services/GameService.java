package boardcamp.boardcamp.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import boardcamp.boardcamp.dto.GameDTO;
import boardcamp.boardcamp.exceptions.GameExceptions.GameConflictException;
import boardcamp.boardcamp.models.GameModel;
import boardcamp.boardcamp.repositories.GameRepository;
import jakarta.validation.Valid;

@Service
public class GameService {
  final GameRepository gameRepository;

  GameService(GameRepository gameRepository){
    this.gameRepository = gameRepository;
  }

  @GetMapping
  public List<GameModel> getGames(){
    return gameRepository.findAll();
  }

  @PostMapping
  public GameModel createGame(GameDTO body){
    if (gameRepository.existsByName(body.getName()))
      throw new GameConflictException("Game already exists");
    
    GameModel game = new GameModel(body);
    return gameRepository.save(game);
  }
}
