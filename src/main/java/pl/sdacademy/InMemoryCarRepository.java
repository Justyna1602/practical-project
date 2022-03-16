package pl.sdacademy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class InMemoryCarRepository implements CarRepository {
    public Map<Integer, Car> carById;

    @Override
    public Car getCarById(Integer id) {
        return carById.get(id);

    }

    @Override
    public void addCar(Car car) {
        int mapId = carById.keySet().size();
        mapId += 1;
        carById.put(mapId, car);
    }

    @Override
    public void updateCar(Integer id, String carVin, String modelName, String makeName) {
        Car car = getCarById(id);
        car.setVin(carVin);
        Model carModel = new Model(car.getModel().getId(), car.getModel().getMake(), car.getModel().getName());
        carModel.setName(modelName);
        Make carMake = new Make(car.getModel().getMake().getId(), car.getModel().getMake().getName());
        carMake.setName(makeName);
        carModel.setMake(carMake);
        car.setModel(carModel);

    }

    @Override
    public void deleteCar(Integer id) {
        carById.remove(id);

    }

    @Override
    public List<Car> getAllCars() {
        Collection<Car> allCars;
        allCars = carById.values();

        return new ArrayList<>(allCars);
    }
}
