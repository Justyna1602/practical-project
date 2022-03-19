package pl.sdacademy.repository;

import pl.sdacademy.entity.Make;

import java.util.Collection;

public class HibernateMakeRepository implements MakeRepository{
    @Override
    public Make getMakeById(Integer id) {
        return null;
    }

    @Override
    public void addCar(Make make) {

    }

    @Override
    public void updateCar(Make make) {

    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public Collection<Make> getAllCars() {
        return null;
    }
}
