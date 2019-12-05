package pl.szydlowski.restspringbootsimplecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szydlowski.restspringbootsimplecrud.model.Car;
import pl.szydlowski.restspringbootsimplecrud.service.CarService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = carService.getCars();
        return new ResponseEntity(carList, HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCars(@PathVariable String color) {
        List<Car> carList = carService.getCarsByColor(color);
        if(carList.isEmpty()){
            return new ResponseEntity<>(carList,HttpStatus.NOT_FOUND);
        }
       return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable long id){
        Optional<Car> car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);

    }
}
