package pl.sdacademy.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.connection.SessionFactoryProvider;
import pl.sdacademy.entity.Car;

import java.util.List;

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
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void updateCar(Car car) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(car);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteCar(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Car car = session.load(Car.class, id);
            session.delete(car);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> carList;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            carList =
                    session.createQuery("SELECT c FROM Car c", Car.class).getResultList();

            transaction.commit();
            return carList;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
