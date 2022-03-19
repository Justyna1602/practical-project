package pl.sdacademy.repository;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.connection.SessionFactoryProvider;
import pl.sdacademy.entity.Model;

import java.util.List;

public class HibernateModelRepository implements ModelRepository {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private final Logger log = Logger.getLogger(HibernateModelRepository.class);
    Transaction transaction = null;

    @Override
    public Model getCarById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Model model = session.get(Model.class, id);
            transaction.commit();
            return model;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void addCar(Model model) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void updateCar(Model model) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(model);
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
            Model model = session.load(Model.class, id);
            session.delete(model);
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Model> getAllCars() {
        List<Model> models;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            models =
                    session.createQuery("SELECT m FROM Model m", Model.class).getResultList();
            transaction.commit();
            return models;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
