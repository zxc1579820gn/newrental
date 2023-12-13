package com.reinext.rental.service.ifs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.reinext.rental.entity.LineAndStation;

public interface LineAndStationService {

	List<LineAndStation> getAllLineAndStations();

	List<String> getLineNameByPrefName(String prefName);

	List<String> getStationNameByLineName(List<String> lineName);
	
	List<String> getStationNameByLineName(String lineName);

	List<String> getLineNameByAddressContaining(String Address);

	void addLine(String stationName, int lineCd, String lineName, String prefName, String address);

	void addStationToLine(String stationName, String lineName, String address);

	

}
