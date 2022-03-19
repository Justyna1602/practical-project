package pl.sdacademy.repository;

import pl.sdacademy.entity.Car;

import java.util.Collection;

public interface CarRepository {
    Car getCarById(Integer id);

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(Integer id);

    Collection<Car> getAllCars();


}

