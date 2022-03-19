package pl.sdacademy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

public class JdbcCarRepository implements CarRepository{
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
