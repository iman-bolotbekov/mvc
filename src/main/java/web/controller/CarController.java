package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.models.Car;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarDAO carDAO;
    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String car(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = carDAO.getCars();
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
