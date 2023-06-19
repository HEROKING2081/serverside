package org.example.service;

import org.example.model.RailwayCarriage;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RailwayCarriageService {

    RailwayCarriage save(RailwayCarriage railwayCarriage);

    void deleteById(int id);

    void update(RailwayCarriage railwayCarriage);

    Optional<RailwayCarriage> findById(int id);

    List<RailwayCarriage> findAll();
}
