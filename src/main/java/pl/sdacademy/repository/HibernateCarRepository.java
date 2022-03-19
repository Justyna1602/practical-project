package pl.sdacademy.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.connection.SessionFactoryProvider;
import pl.sdacademy.entity.Car;

import java.util.Collection;

import org.apache.log4j.Logger;

public class HibernateCarRepository implements CarRepository {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private final Logger log = Logger.getLogger(HibernateCarRepository.class);
    Transaction transaction = null;


    @Override
    public Car getCarById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Car car = session.get(Car.class, id);

            transaction.commit();

            return car;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            log.error(e.getMessage(), e);
        }

        return null;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public Collection<Car> getAllCars() {
        return null;
    }
}
