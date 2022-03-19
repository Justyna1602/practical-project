package pl.sdacademy.repository;

import pl.sdacademy.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(Integer id);

    void addCustomer(Customer customer);

    void update(Customer customer);

    void delete(Integer id);

    List<Customer> getAllCustomer();
}
