package com.mcancankaya.rentacar.repositories;

import com.mcancankaya.rentacar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByBrandIdAndNameEqualsIgnoreCase(Integer brandId, String name);
}
