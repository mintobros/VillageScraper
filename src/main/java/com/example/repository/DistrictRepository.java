package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.District;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findByName(String name);

	boolean existsByName(String districtName);
}