package pl.sdacademy.repository;

import org.junit.jupiter.api.Test;
import pl.sdacademy.entity.Car;
import pl.sdacademy.entity.Make;
import pl.sdacademy.entity.Model;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCarRepositoryTest {

    @Test
    void shouldFindCarById() {
        InMemoryCarRepository inMemoryCarRepository = new InMemoryCarRepository();
        inMemoryCarRepository.carById = new HashMap<>();
        Car car1 = new Car(1, new Model(1, new Make(1, "Astra"), "Opel"), "12548");
        Car car2 = new Car(2, new Model(3, new Make(2, "M3"), "BMW"), "18998");
        inMemoryCarRepository.addCar(car1);
        inMemoryCarRepository.addCar(car2);

        Car actualResult = inMemoryCarRepository.getCarById(1);

        assertEquals(car1, actualResult);

    }

    @Test
    void shouldAddNewCarInRepository() {
        InMemoryCarRepository inMemoryCarRepository = new InMemoryCarRepository();
        inMemoryCarRepository.carById = new HashMap<>();
        Car car1 = new Car(1, new Model(4, new Make(1, "Punto"), "Fiat"), "69348");

        inMemoryCarRepository.addCar(car1);

        Car addedCar = inMemoryCarRepository.getCarById(1);

        assertEquals(car1, addedCar);

    }

    @Test
    void shouldUpdateCarInRepository() {
        InMemoryCarRepository inMemoryCarRepository = new InMemoryCarRepository();
        inMemoryCarRepository.carById = new HashMap<>();
        Car car1 = new Car(1, new Model(1, new Make(1, "Astra"), "Opel"), "12548");
        inMemoryCarRepository.addCar(car1);

        inMemoryCarRepository.updateCar(1, "56888", "Octavia", "Skoda");

        assertEquals(car1.getVin(), "56888");
        assertEquals(car1.getModel().getName(), "Octavia");
        assertEquals(car1.getModel().getMake().getName(), "Skoda");

    }

    @Test
    void shouldDeleteCarOfCarRepository() {
        InMemoryCarRepository inMemoryCarRepository = new InMemoryCarRepository();
        inMemoryCarRepository.carById = new HashMap<>();
        Car car1 = new Car(1, new Model(1, new Make(1, "Astra"), "Opel"), "12548");
        Car car2 = new Car(2, new Model(3, new Make(2, "M3"), "BMW"), "18998");
        inMemoryCarRepository.addCar(car1);
        inMemoryCarRepository.addCar(car2);

        inMemoryCarRepository.deleteCar(2);
        Car removedCar = inMemoryCarRepository.getCarById(2);

        assertNull(removedCar);
    }


}