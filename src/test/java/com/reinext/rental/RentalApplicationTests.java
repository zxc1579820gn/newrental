package com.reinext.rental;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reinext.rental.entity.LineAndStation;
import com.reinext.rental.repository.AllPrefecturesDao;
import com.reinext.rental.service.ifs.AllPrefecturesService;
import com.reinext.rental.service.ifs.LineAndStationService;



@SpringBootTest
class RentalApplicationTests {
	
	@Autowired
	private AllPrefecturesService allPrefecturesService;
	
	@Autowired
	private LineAndStationService lineAndStationService;
	
    
	
    
	
	@Test
    public void testAddLine() {
    	System.out.println("================================");
    	String stationName = "testStationName"; 
    	int lineCd = 99999; 
    	String lineName= "testLineName";  
    	String prefName="その他"; 
    	String address = "t"; 
        lineAndStationService.addLine(stationName, lineCd, lineName, prefName,address);
        System.out.println("================================");
    }
    
    
    public void testAddStationToLine() {
    	System.out.println("================================");
        String stationName = "testStationName2"; 
        String lineName= "testLineName";  
        String address = "t"; 
        lineAndStationService.addStationToLine(stationName ,  lineName, address);
        System.out.println("================================");
    }
	
	
	
	
	
    public void testFindLineNameAndStationNameByAddressContaining() {
    	System.out.println("================================");
        String address = "函館"; 
        List<String> result = lineAndStationService.getLineNameByAddressContaining(address);
        System.out.println("Result: " + result);
        System.out.println("================================");
    }
    
    public void testGetLineNameByPrefName() {
    	System.out.println("================================");
        String prefName = "北海道"; 
        List<String> result = lineAndStationService.getLineNameByPrefName(prefName);
        System.out.println("Result: " + result);
        System.out.println("================================");
    }
    

    
    public void testGetAllLineAndStations() {
    	System.out.println("================================");
        List<LineAndStation> result = lineAndStationService.getAllLineAndStations();
        System.out.println("Result: " + result);
        System.out.println("================================");
    }

	
    public void testGetAllPrefectures() {
    	System.out.println("================================");
        List<String> result = allPrefecturesService.getAllPrefectures();
        System.out.println("Result: " + result);
        System.out.println("================================");
    }
    
    
    public void testGetAllCities() {
    	System.out.println("================================");
        List<String> result = allPrefecturesService.getAllCities();
        System.out.println("Result: " + result);
        System.out.println("================================");
    }
    
    
    public void testGetAllCitiesByPrefecture() {
    	System.out.println("================================");
    	List<String> result = allPrefecturesService.getAllCitiesByPrefecture("北海道");
    	System.out.println("Result: " + result);
        System.out.println("================================");

    }
}
