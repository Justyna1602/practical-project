package pl.sdacademy.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.connection.SessionFactoryProvider;
import pl.sdacademy.entity.Make;

import java.util.List;

import org.apache.log4j.Logger;

public class HibernateMakeRepository implements MakeRepository {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private final Logger log = Logger.getLogger(HibernateMakeRepository.class);
    Transaction transaction = null;

    @Override
    public Make getMakeById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Make make = session.get(Make.class, id);
            transaction.commit();
            return make;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void addCar(Make make) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(make);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void updateCar(Make make) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(make);
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
            Make make = session.load(Make.class, id);
            session.delete(make);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Make> getAllCars() {
        List<Make> makeList;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            makeList = session.createQuery("SELECT m FROM Make m", Make.class).getResultList();
            transaction.commit();
            return makeList;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
