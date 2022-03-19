package pl.sdacademy;

import pl.sdacademy.entity.Car;
import pl.sdacademy.entity.Make;
import pl.sdacademy.entity.Model;
import pl.sdacademy.repository.InMemoryCarRepository;

import java.util.HashMap;

public class Init {
    public static void main(String[] args) {
        InMemoryCarRepository inMemoryCarRepository = new InMemoryCarRepository();
        inMemoryCarRepository.carById = new HashMap<>();
        Car car1 = new Car(1, new Model(1, new Make(1, "Astra"), "Opel"), "12548");
        Car car2 = new Car(2, new Model(3, new Make(2, "M3"), "BMW"), "18998");
        inMemoryCarRepository.addCar(car1);
        inMemoryCarRepository.addCar(car2);
        System.out.println(inMemoryCarRepository.getCarById(1));
        System.out.println(inMemoryCarRepository.getCarById(2));
        inMemoryCarRepository.updateCar(1, "5555", "AMG", "Mercedes");
        System.out.println(inMemoryCarRepository.getCarById(1));
        System.out.println(inMemoryCarRepository.getAllCars());
        inMemoryCarRepository.deleteCar(1);
        System.out.println(inMemoryCarRepository.getAllCars());
    }

}
