package boardcamp.boardcamp.services;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import boardcamp.boardcamp.dto.CustomerDTO;
import boardcamp.boardcamp.models.CustomerModel;
import boardcamp.boardcamp.repositories.CustomerRepository;

@Service
public class CustomerService {
  final CustomerRepository customerRepository;

  CustomerService(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }

  public CustomerModel create(CustomerDTO body){
    if (customerRepository.existsByCpf(body.getCpf())){
      throw new DuplicateKeyException("Customer already exists");
    }
    CustomerModel customer = new CustomerModel(body);
    return customerRepository.save(customer);
  }

  public CustomerModel getCustomerById(long id) throws FileNotFoundException{
    Optional<CustomerModel> customer = customerRepository.findById(id);
    if (!customer.isPresent()){
      throw new FileNotFoundException("Customer doest not exists");
    }
    return customer.get();
  }
}
