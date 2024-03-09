package com.medeiros.reservation.services.customer;

import com.medeiros.reservation.dtos.customer.CreateCustomerDTO;
import com.medeiros.reservation.entities.customer.Customer;
import com.medeiros.reservation.exceptions.customer.CustomerAlreadyExistsException;
import com.medeiros.reservation.repositories.CustomerRepository;
import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

@Service
public class CreateCostumer {
  private final CustomerRepository customerRepository;

  public CreateCostumer (CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer create(CreateCustomerDTO customerDataRequest) {
    checkCustomerExists(customerDataRequest.getEmail());

    Customer customer = createCustomerFromRequest(customerDataRequest);

    validateEmail(customer);

    updateTimestamps(customer);

    return customerRepository.save(customer);
  }

  private void validateEmail(Customer customer) {
    if (!customer.isValidEmailFormat(customer.getEmail())) {
      throw new IllegalArgumentException("Invalid email");
    }
  }

  private void checkCustomerExists(String customerEmail) {
    var customer = customerRepository.findByEmail(customerEmail);

    if (customer.isPresent()) throw new CustomerAlreadyExistsException();
  }

  private Customer createCustomerFromRequest(CreateCustomerDTO customerDataRequest) {
    var customer = new Customer();

    customer.setFirstName(customerDataRequest.getFirstName());
    customer.setLastName(customerDataRequest.getLastName());
    customer.setEmail(customerDataRequest.getEmail());
    customer.setPhoneNumber(customerDataRequest.getPhoneNumber());

    return customer;
  }

  private void updateTimestamps(Customer customer) {
    customer.setCreatedAt(TimeProvider.getInstance().setLocalDateTime());
    customer.setUpdatedAt(TimeProvider.getInstance().setLocalDateTime());
  }
}
