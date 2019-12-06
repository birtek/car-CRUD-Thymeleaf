package pl.szydlowski.restspringbootsimplecrud.service;

import pl.szydlowski.restspringbootsimplecrud.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(long id);

    List<Car> getCarsByColor(String color);

    boolean addCar(Car car);

    boolean updateCar(Car car);

    boolean modifiedCarMark(long id, String mark);

    boolean modifiedCarModel(long id, String model);

    boolean modifyCarColor(long id, String color);

    boolean removeCar(long id);
}
