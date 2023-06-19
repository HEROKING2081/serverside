package org.example.repository;

import org.example.model.RailwayCarriage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RailwayCarriageRepository extends CrudRepository<RailwayCarriage, Integer> {

    @Query("UPDATE railway_carriages SET load_capacity = :loadCapacity, wagon_weight = :wagonWeight, " +
            "axial_load = :axialLoad, + type = :type, location = :location WHERE number = :number")
    void update(@Param("loadCapacity") int loadCapacity, @Param("wagonWeight") int wagonWeight,
                                @Param("axialLoad") int axialLoad, @Param("type") String type,
                                @Param("location") String location, @Param("number") int number);

}
