package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private List<Car> cars = new ArrayList<>();
    public List<Car> getCars() {
        if (cars.size() < 5) {
            fillCars();
        }
        return cars;
    }
    public void fillCars() {
        cars.add(new Car(1, "Model number 1", "red"));
        cars.add(new Car(2, "Model number 2", "blue"));
        cars.add(new Car(3, "Model number 3", "green"));
        cars.add(new Car(4, "Model number 4", "yellow"));
        cars.add(new Car(5, "Model number 5", "yellow"));
    }
}
