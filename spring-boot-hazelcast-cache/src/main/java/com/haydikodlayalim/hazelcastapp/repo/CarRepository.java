package com.haydikodlayalim.hazelcastapp.repo;

import com.haydikodlayalim.hazelcastapp.entity.Car;
import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Car> findAll();

}
