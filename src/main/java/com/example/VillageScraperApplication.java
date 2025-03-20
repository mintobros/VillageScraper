package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.DistrictService;

@SpringBootApplication
public class VillageScraperApplication implements CommandLineRunner {
    @Autowired
    private DistrictService districtService;

    public static void main(String[] args) {
        SpringApplication.run(VillageScraperApplication.class, args);
    }

	
	  @Override 
	  public void run(String... args) throws Exception {
	  districtService.scrapeVillages(); 
	  }
	 
}
