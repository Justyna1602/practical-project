package pl.sdacademy;

import java.util.Collection;

public class JdbcCarRepository implements CarRepository{
    @Override
    public Car getCarById(Integer id) {
        return null;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void updateCar(Integer id, String carVin, String modelName, String makeName) {

    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public Collection<Car> getAllCars() {
        return null;
    }
}
