package pl.szydlowski.restspringbootsimplecrud.service;

import pl.szydlowski.restspringbootsimplecrud.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private List<Car> carList;

    public CarServiceImpl(){
        Car car1 = new Car(1,"Fiat","123p","red");
        Car car2 = new Car(2,"Polonez","Caro","white");
        Car car3 = new Car(3,"Audi","S6","blue");
        Car car4 = new Car(4,"Mercedes","X1","black");
        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
    }

    @Override
    public List<Car> getCars() {
        return null;
    }
}
