package com.mcancankaya.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mcancankaya.rentacar.enums.CarBodyType;
import com.mcancankaya.rentacar.enums.CarStatus;
import com.mcancankaya.rentacar.enums.Color;
import com.mcancankaya.rentacar.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars", schema = "rentacar")
public class Car {
    @Id
    @GeneratedValue(generator = "car_id_generator")
    @SequenceGenerator(schema = "rentacar", name = "car_id_generator", sequenceName = "car_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "dailyPrice")
    private BigDecimal dailyPrice;

    @Column(name = "body_type")
    @Enumerated(EnumType.STRING)
    private CarBodyType bodyType;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<RentCar> rentCars;
}
