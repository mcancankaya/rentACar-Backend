package com.mcancankaya.rentacar.repositories;

import com.mcancankaya.rentacar.entities.RentCar;
import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarDetailResponse;
import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentCarRepository extends JpaRepository<RentCar, Integer> {
    Optional<RentCar> findByCarIdAndRentId(Integer carId, Integer rentId);

    List<RentCar> findAllByRentId(Integer rentId);

    List<RentCar> deleteAllByRent_Id(Integer rentId);

    RentCar deleteRentCarsByRent_IdAndCar_Id(Integer rent_id, Integer car_id);
}
