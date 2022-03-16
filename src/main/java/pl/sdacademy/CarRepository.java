package pl.sdacademy;

import java.util.List;

public interface CarRepository {
    Car getCarById();

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCr(Integer id);

    List<Car> getAllCars();


}

