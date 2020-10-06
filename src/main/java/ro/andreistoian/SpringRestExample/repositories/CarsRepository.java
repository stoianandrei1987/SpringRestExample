package ro.andreistoian.SpringRestExample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.andreistoian.SpringRestExample.models.Car;


public interface CarsRepository extends JpaRepository<Car, Long>, CarsRepositoryCustom {
}
