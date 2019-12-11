package pl.szydlowski.restspringbootsimplecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szydlowski.restspringbootsimplecrud.model.Car;
import pl.szydlowski.restspringbootsimplecrud.service.CarService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<Car> carList = carService.getCars();
        model.addAttribute("cars", carList);
        return "carList";
    }

    @GetMapping("/cars/{id}")
    public String getCar(@PathVariable long id, Model model){
        Car car = carService.getCarById(id);
        if (car!=null){
            model.addAttribute("cars",car);
            return "carList";
        }else
            return "emptyList";
    }

    @GetMapping("/addCar")
    public String addCar(Model model){
        List<Car> carList = carService.getCars();
        model.addAttribute("cars", carList);
        model.addAttribute("newCar", new Car());
        return "addCar";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/addCar";
    }

    @GetMapping("updateCar/{id}")
    public String addCar(@PathVariable long id, Model model){
        Car car = carService.getCarById(id);
        if(car != null){
            model.addAttribute("carToUpdate", car);
            return "updateCar";
        }else
            return "emptyList";
    }

    @PostMapping("update-car/{id}")
    public String addCar(@PathVariable long id, @Valid Car newCarData, Model model){
      //carService.findByIdAndUpdate(id, newCarData);
        carService.updateCar(newCarData);
        model.addAttribute("cars",carService.getCars());
      return  "carList";
    }

    @GetMapping("/deleteCar/{id}")
    public String removeCar(@PathVariable long id, Model model){
       Car car = carService.getCarById(id);
        if (car != null) {
            carService.removeCar(id);
            model.addAttribute("cars", carService.getCars());
            return "carList";
        }
        return "emptyList";
    }

}
