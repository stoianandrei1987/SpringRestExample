package ro.andreistoian.SpringRestExample.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.andreistoian.SpringRestExample.models.Car;
import ro.andreistoian.SpringRestExample.services.CarsService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private static Logger logger = LoggerFactory.getLogger(CarsController.class);

    @Autowired
    CarsService service;

    @GetMapping(path = "/{id}/", produces = "application/json")
    public ResponseEntity<Car> getSomeCar(@PathVariable(name = "id") Long id) {

        Car foundCar = service.findCar(id);
        if(foundCar == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Car>(service.findCar(id), HttpStatus.OK);
    }

    @GetMapping(path = "/cmex")
    public ResponseEntity<List<Car>> getCarsMoreExpensiveThan(@RequestParam(name = "limit", required = true)int limit) {
        logger.info("Accessing cmex function with reqparam " + limit);
        List<Car> list = service.getCarsMoreExpensiveThan(limit);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(service.getAllCars(), HttpStatus.OK);
    }
}
