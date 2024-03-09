package com.medeiros.reservation.controllers.customer;

import com.medeiros.reservation.dtos.customer.CreateCustomerDTO;
import com.medeiros.reservation.entities.customer.Customer;
import com.medeiros.reservation.services.customer.CreateCostumer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers/create")
public class CreateCustomerController {
  private final CreateCostumer createCostumerService;

  public CreateCustomerController(CreateCostumer createCostumerService) {
    this.createCostumerService = createCostumerService;
  }

  @PostMapping
  ResponseEntity<Customer> createCustomer(@RequestBody @Valid CreateCustomerDTO customerDataRequest) {
    return new ResponseEntity<>(createCostumerService.create(customerDataRequest), HttpStatus.CREATED);
  }
}
