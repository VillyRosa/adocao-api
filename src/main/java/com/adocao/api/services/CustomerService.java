package com.adocao.api.services;

import com.adocao.api.entities.Customer;
import com.adocao.api.repositories.CustomerRepository;
import com.adocao.api.utils.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService extends BaseService<Customer, UUID, CustomerDTO> {

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository, Customer::new);
    }

}
