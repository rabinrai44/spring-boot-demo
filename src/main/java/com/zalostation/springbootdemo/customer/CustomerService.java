package com.zalostation.springbootdemo.customer;

import com.zalostation.springbootdemo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return this.customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        log.info("getCustomer(id) was called");
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with id '" + id + "' was not found"));
    }


    public Customer addCustomer(Customer customer) {
        log.info("addCustomer was called");
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        log.info("deleteCustomer was called");
        customerRepository.delete(customer);
    }

    public Customer updateCustomer(Customer customer) {
        log.info("updateCustomer was called");
        return customerRepository.save(customer);
    }
}
