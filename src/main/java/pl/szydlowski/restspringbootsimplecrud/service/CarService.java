package pl.szydlowski.restspringbootsimplecrud.service;

import pl.szydlowski.restspringbootsimplecrud.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(long id);

    List<Car> getCarsByColor(String color);

    boolean addCar(Car car);

    boolean updateCar(Car car);

    boolean modifiedCarMark(long id, Map<String, Object> updates);

    boolean modifiedCarModel(long id, Map<String, Object> updates);

    boolean modifyCarColor(long id, Map<String, String> updates);

    boolean removeCar(long id);


}
