package pl.szydlowski.restspringbootsimplecrud.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szydlowski.restspringbootsimplecrud.model.Car;
import pl.szydlowski.restspringbootsimplecrud.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> carList;

    public CarServiceImpl() {
        Car car1 = new Car(1, "Fiat", "123p", Color.WHITE);
        Car car2 = new Car(2, "Polonez", "Caro", Color.BLACK);
        Car car3 = new Car(3, "Audi", "S6", Color.BLUE);
        Car car4 = new Car(4, "Mercedes", "X1", Color.GRAY);
        Car car5 = new Car(5, "BMW", "Shark", Color.RED);
        Car car6 = new Car(6, "BMW", "Shark", Color.RED);
        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carList.stream().filter(car -> car.getColor().name().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    @Override
    public boolean addCar(Car car) {
        return carList.add(car);
    }

    @Override
    public boolean updateCar(Car updatedCar) {
        Optional<Car> found = carList.stream().filter(car -> car.getId() == updatedCar.getId()).findFirst();
        if (found.isPresent()) {
            Car car = found.get();
            car.setMark(updatedCar.getMark());
            car.setModel(updatedCar.getModel());
            car.setColor(updatedCar.getColor());
            return true;
        }
        return false;
    }

    @Override
    public boolean modifiedCarMark(long id, String mark) {
        Optional<Car> found = getCarById(id);
        if (found.isPresent()) {
            Car car = found.get();
            car.setMark(mark);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifiedCarModel(long id, String model) {
        Optional<Car> found = getCarById(id);
        if (found.isPresent()) {
            Car car = found.get();
            car.setModel(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyCarColor(long id, String color) {
        Optional<Car> found = getCarById(id);
        if (found.isPresent()) {
            Car car = found.get();
            car.setColor(Color.valueOf(color));
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCar(long id) {
        Optional<Car> found = getCarById(id);
        if(found.isPresent()) {
            Car car = found.get();
            return carList.remove(car);
        }
        return false;
    }

}
