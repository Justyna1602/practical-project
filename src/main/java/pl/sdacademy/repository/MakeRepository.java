package pl.sdacademy.repository;

import pl.sdacademy.entity.Make;

import java.util.Collection;

public interface MakeRepository {
    Make getMakeById(Integer id);

    void addCar(Make make);

    void updateCar(Make make);

    void deleteCar(Integer id);

    Collection<Make> getAllCars();
}
