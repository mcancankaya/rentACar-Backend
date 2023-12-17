package com.mcancankaya.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(generator = "brand_id_generator")
    @SequenceGenerator(name = "brand_id_generator", sequenceName = "car_id_seq")
    private Integer id;

    @OneToMany(mappedBy = "models", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Model> models;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private byte[] logo;
}
