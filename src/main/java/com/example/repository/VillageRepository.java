package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Village;

public interface VillageRepository extends JpaRepository<Village, Long> {}