package com.mcancankaya.rentacar.repositories;

import com.mcancankaya.rentacar.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    List<Rent> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);

    @Query("SELECT r FROM Rent r WHERE YEAR(r.startDate)=:year AND MONTH(r.startDate) =:month")
    List<Rent> findByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);

    @Query("SELECT r FROM Rent r JOIN Car c WHERE c.id =:carId")
    List<Rent> findByCarId(@Param("carId") Integer carId);

    @Query("SELECT r FROM Rent r JOIN Car c WHERE c.id =:carId AND (r.startDate BETWEEN :startDate AND :endDate OR r.endDate BETWEEN :startDate AND :endDate)")
    List<Rent> findByCarAndBetweenDate(@Param("carId") Integer carId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT COUNT(*) FROM Rent WHERE YEAR(startDate) =:year AND MONTH(startDate) =:month AND YEAR(endDate)=:year AND MONTH (endDate) =:month")
    Integer getCountByMonthAndYear(@Param("month") Integer month, @Param("year") Integer year);
}
