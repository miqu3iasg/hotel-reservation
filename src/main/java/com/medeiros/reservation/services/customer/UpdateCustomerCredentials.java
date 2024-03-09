package com.medeiros.reservation.services.customer;

import com.medeiros.reservation.dtos.customer.UpdateCustomerDTO;
import com.medeiros.reservation.entities.customer.Customer;
import com.medeiros.reservation.exceptions.customer.CustomerNotFoundException;
import com.medeiros.reservation.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCustomerCredentials {
  private final CustomerRepository customerRepository;

  public UpdateCustomerCredentials(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer updateCustomer(UUID customerId, UpdateCustomerDTO customerDataRequest) {
    return customerRepository.findById(customerId)
            .map(customerFound -> {
              updateCustomerFromRequest(customerFound, customerDataRequest);
              return customerRepository.save(customerFound);
            }).orElseThrow(CustomerNotFoundException::new);
  }

  private Customer updateCustomerFromRequest(Customer customer, UpdateCustomerDTO customerDataRequest) {
    customer.setFirstName(customerDataRequest.getFirstName());
    customer.setLastName(customerDataRequest.getLastName());
    customer.setEmail(customerDataRequest.getEmail());
    customer.setPhoneNumber(customerDataRequest.getPhoneNumber());

    return customer;
  }
}
