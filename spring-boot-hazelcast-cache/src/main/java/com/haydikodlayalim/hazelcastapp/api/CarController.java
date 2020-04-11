package com.haydikodlayalim.hazelcastapp.api;

import com.haydikodlayalim.hazelcastapp.entity.Car;
import com.haydikodlayalim.hazelcastapp.repo.CarRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carRepository.getOne(id);
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
