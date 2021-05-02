package com.zalostation.springbootdemo.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
//        var customers = Arrays.asList(
//                new Customer(1L, "Customer 1", "password", "customer1@mail.com"),
//                new Customer(2L, "Customer 2", "password", "customer2@mail.com"));
//
//        return customers;

        return customerService.getCustomer();
    }

    @GetMapping("{customer_id}")
    public Customer getCustomer(@PathVariable("customer_id") Long id) {
//        return getCustomers().stream()
//                .filter(customer -> customer.getId() == id)
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("Customer was not found with id " + id));

        return customerService.getCustomer(id);
    }
}
