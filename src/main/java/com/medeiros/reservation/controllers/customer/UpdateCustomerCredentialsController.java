package com.medeiros.reservation.controllers.customer;

import com.medeiros.reservation.dtos.customer.UpdateCustomerDTO;
import com.medeiros.reservation.entities.customer.Customer;
import com.medeiros.reservation.services.customer.UpdateCustomerCredentials;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers/update-customer/{id}")
public class UpdateCustomerCredentialsController {

  private final UpdateCustomerCredentials updateCustomerCredentialsService;

  public UpdateCustomerCredentialsController(UpdateCustomerCredentials updateCustomerCredentialsService) {
    this.updateCustomerCredentialsService = updateCustomerCredentialsService;
  }

  @PutMapping
  ResponseEntity<Customer> updateCustomer (
          @PathVariable UUID customerId,
          @RequestBody @Valid UpdateCustomerDTO customerDataRequest
  ) {
    return new ResponseEntity<>(updateCustomerCredentialsService.updateCustomer(
            customerId,
            customerDataRequest), HttpStatus.OK);
  }
}
