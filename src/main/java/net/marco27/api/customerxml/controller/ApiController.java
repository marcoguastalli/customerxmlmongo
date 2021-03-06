package net.marco27.api.customerxml.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.marco27.api.customerxml.model.Customer;
import net.marco27.api.customerxml.model.Customers;
import net.marco27.api.customerxml.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_XML_VALUE)
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_XML_VALUE)
    public Customers getAllCustomers() {
        List<Customer> customer = (List<Customer>) customerRepository.findAll();
        Customers customers = new Customers();
        customers.setCustomers(customer);

        return customers;
    }

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Customer getCustomerById(@PathVariable String id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
            return customerRepository.findById(id).get();
        }

        throw new RuntimeException("Not Found a customer with id = " + id);
    }

    @PutMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Customer putCustomer(@PathVariable String id,
            @Valid @RequestBody Customer customerUpdated) {

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstname(customerUpdated.getFirstname());
                    customer.setLastname(customerUpdated.getLastname());
                    customer.setAge(customerUpdated.getAge());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new RuntimeException("Customer not found with id = " + id));
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable String id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new RuntimeException("Customer not found with id = " + id));
    }

    @GetMapping(value = "/customerName/{id}")
    public ResponseEntity<String> getCustomer(@PathVariable String id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
            return ResponseEntity.ok(optCustomer.get().getFirstname());
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}