package com.mcancankaya.rentacar.entities;

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
    @SequenceGenerator(schema = "rentacar", name = "model_id_generator", sequenceName = "model_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<Car> cars;

}
