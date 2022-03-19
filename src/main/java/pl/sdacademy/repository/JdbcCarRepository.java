package pl.sdacademy.repository;

import pl.sdacademy.entity.Car;
import pl.sdacademy.repository.CarRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

public class JdbcCarRepository implements CarRepository {
    private static PreparedStatement preparedStatement;
    private Connection connection;

    public JdbcCarRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Car getCarById(Integer id) {
        return null;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public Collection<Car> getAllCars() {
        return null;
    }
}
