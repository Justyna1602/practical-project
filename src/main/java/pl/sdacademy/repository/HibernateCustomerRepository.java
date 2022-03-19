package pl.sdacademy.repository;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.connection.SessionFactoryProvider;
import pl.sdacademy.entity.Customer;

import java.util.List;

public class HibernateCustomerRepository implements CustomerRepository {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private final Logger log = Logger.getLogger(HibernateCustomerRepository.class);
    Transaction transaction = null;

    @Override
    public Customer getCustomerById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            transaction.commit();
            return customer;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.load(Customer.class, id);
            session.delete(customer);
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            customers =
            session.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
            transaction.commit();
            return customers;
        }catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
