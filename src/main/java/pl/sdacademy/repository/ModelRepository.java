package pl.sdacademy.repository;

import pl.sdacademy.entity.Model;

import java.util.Collection;

public interface ModelRepository {
    Model getCarById(Integer id);

    void addCar(Model model);

    void updateCar(Model model);

    void deleteCar(Integer id);

    Collection<Model> getAllCars();

}
