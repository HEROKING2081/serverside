package org.example.service;

import org.example.model.RailwayCarriage;
import org.example.repository.RailwayCarriageRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleRailwayCarriageService implements RailwayCarriageService {

    private final RailwayCarriageRepository repository;

    public SimpleRailwayCarriageService(RailwayCarriageRepository repository) {
        this.repository = repository;
    }

    @Override
    public RailwayCarriage save(RailwayCarriage railwayCarriage) {
        return repository.save(railwayCarriage);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(RailwayCarriage railwayCarriage) {
        repository.update(railwayCarriage.getLoadCapacity(), railwayCarriage.getWagonWeight(),
                railwayCarriage.getAxialLoad(), railwayCarriage.getType(),
                railwayCarriage.getLocation(), railwayCarriage.getNumber());
    }

    @Override
    public Optional<RailwayCarriage> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<RailwayCarriage> findAll() {
        List<RailwayCarriage> railwayCarriagesList = new ArrayList<>();
        repository.findAll().forEach(railwayCarriagesList::add);
        return railwayCarriagesList;
    }
}
