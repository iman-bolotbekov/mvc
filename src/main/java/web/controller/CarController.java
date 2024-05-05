package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @GetMapping()
    public String car(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Model number 1", "red"));
        cars.add(new Car(2, "Model number 2", "blue"));
        cars.add(new Car(3, "Model number 3", "green"));
        cars.add(new Car(4, "Model number 4", "yellow"));
        cars.add(new Car(5, "Model number 5", "yellow"));
        if (count == null) {
            model.addAttribute("cars", cars);
        } else {
            if (count > cars.size()) {
                model.addAttribute("cars", cars.subList(0, cars.size()));
            } else {
                model.addAttribute("cars", cars.subList(0, count));
            }
        }
        return "cars";
    }
}
