package ro.andreistoian.SpringRestExample.repositories;

import ro.andreistoian.SpringRestExample.models.Car;

import java.util.List;

public interface CarsRepositoryCustom {

    public List<Car> getCarsMoreExpensiveThan(int limit);
}
