package com.mcancankaya.rentacar.entities;

import com.mcancankaya.rentacar.enums.CarBodyType;
import com.mcancankaya.rentacar.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(generator = "car_id_generator")
    @SequenceGenerator(name = "car_id_generator", sequenceName = "car_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "body_type")
    @Enumerated(EnumType.STRING)
    private CarBodyType bodyType;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;


}
