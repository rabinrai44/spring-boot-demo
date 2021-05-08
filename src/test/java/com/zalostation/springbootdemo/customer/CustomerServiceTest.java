package com.zalostation.springbootdemo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        // given
//        var karen = new Customer(1L, "karen", "pass", "karen@gmail.com");
//        var alex = new Customer(2L, "Alex", "pass", "alex@gmail.com");
//        var matt = new Customer(3L, "matt", "pass", "matt@gmail.com");
//
//        customerRepository.saveAll(Arrays.asList(karen, alex, matt));

        // when
        var customers = underTest.getCustomer();

        // then
        assertEquals(1000, customers.size());
    }

    @Test
    void testGetCustomer() {
        // given
        var alex = new Customer(1L, "Alex", "pass", "alex@gmail.com");

        customerRepository.save(alex);

        // when
        var actual = underTest.getCustomer(1L);

        // then
        assertEquals(1L, actual.getId());
        assertEquals("Alex", actual.getName());
        assertEquals("pass", actual.getPassword());
        assertEquals("alex@gmail.com", actual.getEmail());

    }
}