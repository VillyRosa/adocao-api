package com.adocao.api.controllers;

import com.adocao.api.services.CustomerService;
import com.adocao.api.utils.dto.CustomerDTO;
import com.adocao.api.entities.Customer;
import com.adocao.api.utils.responses.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomResponse<List<Customer>>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Customer> customersPage = customerService.findAll(pageable);
        List<Customer> customers = customersPage.getContent();
        CustomResponse<List<Customer>> response = new CustomResponse<>((int) customersPage.getTotalElements(), page, customersPage.getTotalPages(), customers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable UUID id) {
        return customerService.findById(id);
    }

    @PostMapping
    public Customer create(@RequestBody CustomerDTO customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable UUID id, @RequestBody CustomerDTO customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        customerService.deleteById(id);
    }

}
