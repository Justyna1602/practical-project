package pl.sdacademy.repository;

import pl.sdacademy.entity.Customer;

import java.util.List;

public class HibernateCustomerRepository implements CustomerRepository{
    @Override
    public Customer getCustomerById(Integer id) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }
}
