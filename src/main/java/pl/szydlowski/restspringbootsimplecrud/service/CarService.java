package pl.szydlowski.restspringbootsimplecrud.service;

import pl.szydlowski.restspringbootsimplecrud.model.Car;

import java.util.List;

public interface CarService {

  List<Car> getCars();

  Car getCarByid(long id);

  Car getCarByColor(String color);
}
