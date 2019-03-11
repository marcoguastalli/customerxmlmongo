package net.marco27.api.customerxml.repository;

import net.marco27.api.customerxml.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}