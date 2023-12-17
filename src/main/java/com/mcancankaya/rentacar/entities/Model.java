package com.mcancankaya.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(generator = "model_id_generator")
    @SequenceGenerator(name = "model_id_generator",sequenceName = "model_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonBackReference
    private Brand brand;

    @Column(name = "name")
    private String name;
}
