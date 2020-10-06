package ro.andreistoian.SpringRestExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.andreistoian.SpringRestExample.models.Car;
import ro.andreistoian.SpringRestExample.repositories.CarsRepository;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    CarsRepository repository;

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public void insertCar(Car car) {
        repository.save(car);
    }

    public Car findCar(Long id) {
        return repository.getOne(id);
    }

    public List<Car> getCarsMoreExpensiveThan(int limit) {
        return repository.getCarsMoreExpensiveThan(limit);
    }
}
