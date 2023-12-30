package com.mcancankaya.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mcancankaya.rentacar.enums.FuelTank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rents", schema = "rentacar")
public class Rent {
    @Id
    @GeneratedValue(generator = "rent_id_generator")
    @SequenceGenerator(name = "rent_id_generator", sequenceName = "rent_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "fuel_tank")
    @Enumerated(EnumType.STRING)
    private FuelTank fuelTank;
    
    @OneToMany(mappedBy = "rent", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RentCar> rentCars;
}
