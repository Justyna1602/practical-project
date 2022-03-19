package pl.sdacademy.repository;

import pl.sdacademy.entity.Model;

import java.util.Collection;

public class HibernateModelRepository implements ModelRepository{
    @Override
    public Model getCarById(Integer id) {
        return null;
    }

    @Override
    public void addCar(Model model) {

    }

    @Override
    public void updateCar(Model model) {

    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public Collection<Model> getAllCars() {
        return null;
    }
}
