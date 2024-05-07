package web.services;

import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.models.Car;

import java.util.List;

@Service
public class CarService {
    private final CarDAO carDAO;
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }
    public List<Car> getCars() {
        return carDAO.getCars();
    }
}
