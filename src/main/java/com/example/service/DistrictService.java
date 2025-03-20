package com.example.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.District;
import com.example.entity.Village;
import com.example.repository.DistrictRepository;
import com.example.repository.VillageRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private VillageRepository villageRepository;

    //private static final String URL = "https://vlist.in/district/176.html";

    public void scrapeVillages() {
        try {
        	String url = "https://vlist.in/state/09/";
        	//String url1 = "https://vlist.in/";
        	//String url = "https://vlist.in/sub-district";
        	//String url = "https://www.viewvillage.in/districts/uttar-pradesh-9";
        	//String url1 = "https://www.viewvillage.in/";
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .get();

            System.out.println("Page Fetched Successfully!");
           // System.out.println(doc.select("a")); // Print full page HTML
           // String n = doc.select("a").text().trim();
           // System.out.println(n);
            
            
           List<District> districtsToSave = new ArrayList<>();

            for (Element element : doc.select("a")) {
                String districtName = element.text().trim();  // Extract clean name
                System.out.println("Scraped District: " + districtName);
 /*              
                String districtUrl = url1 + districtName;
                System.out.println("abcd ::" +districtUrl);
                //String districtUrl = url1 + element.attr("href");
               // String districtUrl = url + element;
               // System.out.println(districtUrl.trim());
                Document document = Jsoup.connect(districtUrl).userAgent("Mozilla/5.0").get();
                for (Element element1 : document.select("a")) {
                    String districtName1 = element1.text().trim(); 
                    System.out.println(districtName1);
                 */   
               // }
               
                // Create and add to list
                District district = new District();
                district.setName(districtName);
                districtsToSave.add(district);
            }

            // Save all in DB
          //  districtRepository.saveAll(districtsToSave);
         //   System.out.println("Districts saved successfully!");
            
            
        	
   /*         Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
           // Elements districtElements = doc.select("a"); // Modify based on actual HTML structure
            
            List<District> districtsToSave = new ArrayList<>();

            for (Element element : doc.select("a")) {
                String districtName = element.text().trim();  // Extract clean name
                System.out.println("Scraped District: " + districtName);
                
                // Create and add to list
                District district = new District();
                district.setName(districtName);
                districtsToSave.add(district);
                
            
           
     //       for (Element districtElement : districtElements) {
     //           String districtName = districtElement.text();
     //           System.out.println("Scraped District: " + districtName);
     //           String districtUrl = url + districtElement.attr("href");
                String districtUrl = url + element.attr("href");
               // String districtUrl = "https://www.viewvillage.in/villages-of-district/agra-118";
                
                
     //          Optional<District> existingDistrict = districtRepository.findByName(districtName);
     //           District district = existingDistrict.orElseGet(() -> {
     //               District newDistrict = new District(districtName);
     //               return districtRepository.save(newDistrict);
     //           });
                
                Document districtDoc = Jsoup.connect(districtUrl).userAgent("Mozilla/5.0").get();
               // List<Village> villagesToSave = new ArrayList<>();
                //Elements villageElements = districtDoc.select(".village-list a"); // Modify based on actual HTML structure

                for (Element villageElement : districtDoc.select("a")) {
                    String villageName = villageElement.text().trim();
                    System.out.println("Scraped villages: " + villageName);
                    Village village = new Village(villageName, district);
                    
                    // Save all in DB
                    districtRepository.saveAll(districtsToSave);
                    System.out.println("Districts saved successfully!");
                    villageRepository.save(village);
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}