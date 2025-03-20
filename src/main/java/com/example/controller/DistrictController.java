package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.DistrictService;
import java.util.List;
import com.example.entity.District;
import com.example.repository.DistrictRepository;

@RestController
@RequestMapping("/api")
class DistrictController {
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping("/districts")
    public List<District> getDistricts() {
        return districtRepository.findAll();
    }
    
    @PostMapping("/scrape")
    public String scrapeVillages() {
        districtService.scrapeVillages();
        return "Scraping completed and data saved..";
    }
}