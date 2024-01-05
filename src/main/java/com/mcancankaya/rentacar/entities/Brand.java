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
@Table(name = "brands", schema = "rentacar")
public class Brand {
    @Id
    @GeneratedValue(generator = "brand_id_generator")
    @SequenceGenerator(schema = "rentacar", name = "brand_id_generator", sequenceName = "brand_id_seq", allocationSize = 1)
    private Integer id;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Model> models;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private byte[] logo;
}
