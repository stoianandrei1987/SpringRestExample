package ro.andreistoian.SpringRestExample.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.andreistoian.SpringRestExample.models.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CarsRepositoryCustomImpl implements CarsRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Car> getCarsMoreExpensiveThan(int limit) {
        Query query = entityManager.createQuery("SELECT c FROM Car c WHERE (c.price > ?1)");
        query.setParameter(1, limit);
        return query.getResultList();
    }
}
