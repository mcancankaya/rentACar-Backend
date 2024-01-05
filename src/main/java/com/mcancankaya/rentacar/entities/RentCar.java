package com.mcancankaya.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rent_car", schema = "rentacar")
public class RentCar {
    @Id
    @GeneratedValue(generator = "rentcar_id_generator")
    @SequenceGenerator(schema = "rentacar", name = "rentcar_id_generator", sequenceName = "rentcar_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
