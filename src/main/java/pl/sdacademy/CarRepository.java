package pl.sdacademy;

import java.util.Collection;

public interface CarRepository {
    Car getCarById(Integer id);

    void addCar(Car car);

    void updateCar(Integer id, String carVin, String modelName, String makeName);

    void deleteCar(Integer id);

    Collection<Car> getAllCars();


}

