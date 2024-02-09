package boardcamp.boardcamp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import boardcamp.boardcamp.dto.RentalDTO;
import boardcamp.boardcamp.models.CustomerModel;
import boardcamp.boardcamp.models.GameModel;
import boardcamp.boardcamp.models.RentalModel;
import boardcamp.boardcamp.repositories.RentalRepository;

@Service
public class RentalService {
  final RentalRepository rentalRepository;
  final GameService gameService;
  final CustomerService customerService;

  RentalService(RentalRepository rentalRepository, 
  GameService gameService,
  CustomerService customerService){
    this.rentalRepository = rentalRepository;
    this.gameService = gameService;
    this.customerService = customerService;
  }

  public RentalModel create(RentalDTO body){
    CustomerModel customer = customerService.getCustomerById(body.getCustomerId());
    GameModel game = gameService.getGameById(body.getGameId());
    RentalModel rental = new RentalModel(body, customer, game);
    return rentalRepository.save(rental);
  }

  public List<RentalModel> getRentals(){
    return rentalRepository.findAll();
  }
}
