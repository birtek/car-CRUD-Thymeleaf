package pl.szydlowski.restspringbootsimplecrud.service;

import pl.szydlowski.restspringbootsimplecrud.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

  List<Car> getCars();

  Optional<Car> getCarById(long id);

  List<Car> getCarsByColor(String color);

  Car addCar(Car car);

  Car updateCar(Car car);

  Car modifyCarField(long id, Car modifyCar);

  List<Car>removeCar(Car car);
}
