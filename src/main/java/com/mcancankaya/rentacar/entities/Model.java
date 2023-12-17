package com.mcancankaya.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models", schema = "rentacar")
public class Model {
    @Id
    @GeneratedValue(generator = "model_id_generator")
    @SequenceGenerator(name = "model_id_generator", sequenceName = "model_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonBackReference
    private Brand brand;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Car> cars;

    @Column(name = "name")
    private String name;
}
