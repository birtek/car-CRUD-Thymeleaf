package pl.szydlowski.restspringbootsimplecrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szydlowski.restspringbootsimplecrud.model.Car;
import pl.szydlowski.restspringbootsimplecrud.service.CarService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(value = "/cars")
public class CarAPI {

    private CarService carService;

    @Autowired
    public CarAPI(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = carService.getCars();
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCars(@PathVariable String color) {
        List<Car> carList = carService.getCarsByColor(color);
        if (carList.isEmpty()) {
            return new ResponseEntity<>(carList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(car1 -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        if (carService.addCar(car)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateCar(@RequestBody Car car) {
        if (carService.updateCar(car)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/{id}/mark")
    public ResponseEntity<Boolean> updateCarMark(@PathVariable long id, @RequestBody Map<String, Object> updates) {
        if (carService.modifiedCarMark(id, updates)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/{id}/model")
    public ResponseEntity<Boolean> updateCarModel(@PathVariable long id, @RequestBody Map<String, Object> updates) {
        if (carService.modifiedCarModel(id, updates)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/{id}/color")
    public ResponseEntity<Boolean> updateCarColor(@PathVariable long id, @RequestBody Map<String, String> updates) {
        if (carService.modifyCarColor(id, updates)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeCar(@PathVariable long id) {
        if (carService.removeCar(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
