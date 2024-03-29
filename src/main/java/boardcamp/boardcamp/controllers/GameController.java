package boardcamp.boardcamp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boardcamp.boardcamp.dto.GameDTO;
import boardcamp.boardcamp.models.GameModel;
import boardcamp.boardcamp.services.GameService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {
  
  final GameService gameService;

  GameController(GameService gameService){
    this.gameService = gameService;
  }

  @GetMapping
  public ResponseEntity<List<GameModel>> getGames(){
    return ResponseEntity.status(HttpStatus.OK).body(gameService.getGames());
  }

  @PostMapping
  public ResponseEntity<GameModel> createGame(@RequestBody @Valid GameDTO body){
    return ResponseEntity.status(HttpStatus.CREATED).body(gameService.createGame(body));
  }
}
