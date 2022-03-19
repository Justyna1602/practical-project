package pl.sdacademy.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sdacademy.entity.Car;
import pl.sdacademy.entity.Make;
import pl.sdacademy.entity.Model;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCarRepositoryTest {
    private static InMemoryCarRepository inMemoryCarRepository = new InMemoryCarRepository();
    private static Car car1 = new Car(1, new Model(1, new Make(1, "Astra"), "Opel"), "12548");
    private static Car car2 = new Car(2, new Model(3, new Make(2, "M3"), "BMW"), "18998");

    @BeforeAll
    private static void setUp() {
        inMemoryCarRepository.carById = new HashMap<>();
        inMemoryCarRepository.addCar(car1);
        inMemoryCarRepository.addCar(car2);
    }

    @Test
    void shouldFindCarById() {
        Car actualResult = inMemoryCarRepository.getCarById(1);

        assertEquals(car1, actualResult);

    }

    @Test
    void shouldAddNewCarInRepository() {
        inMemoryCarRepository.addCar(car1);

        Car addedCar = inMemoryCarRepository.getCarById(1);

        assertEquals(car1, addedCar);

    }

    @Test
    void shouldUpdateCarInRepository() {
        inMemoryCarRepository.updateCar(1, "56888", "Octavia", "Skoda");

        assertEquals(car1.getVin(), "56888");
        assertEquals(car1.getModel().getName(), "Octavia");
        assertEquals(car1.getModel().getMake().getName(), "Skoda");

    }

    @Test
    void shouldDeleteCarOfCarRepository() {
        inMemoryCarRepository.deleteCar(2);
        Car removedCar = inMemoryCarRepository.getCarById(2);

        assertNull(removedCar);
    }


}