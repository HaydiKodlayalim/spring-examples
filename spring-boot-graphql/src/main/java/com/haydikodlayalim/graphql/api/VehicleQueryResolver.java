package com.haydikodlayalim.graphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.haydikodlayalim.graphql.entity.Vehicle;
import com.haydikodlayalim.graphql.repo.VehicleRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type) {
        return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id) {
        return vehicleRepository.findById(id);
    }
}
