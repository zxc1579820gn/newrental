package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//pm=PropertyManagement
@Entity
@Table(name = "pm_main")//データベーステーブルの名前は "pm"
public class PM {
	
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // 建物名稱//名称		
    @Column(name = "BUILDING_NAME")
    private String buildingName;
    
    // 住址//住居表示
    @Column(name = "RESIDENCE_ADDRESS")
    private String residenceAddress;
    
    // 建物類型//種類			
    @Column(name = "BUILDING_TYPE")
    private String buildingType;
    
    // 樓地板面積//床面積
    @Column(name = "FLOOR_AREA")
    private String floorArea;
    
    // 其他樓地板面積//（左記以外に、バルコニー
    @Column(name = "OTHER_FLOOR_AREA")
    private String otherFloorArea;
    
    // 路線名
    @Column(name = "LINE_NAME")
    private String lineName;
    // 駅名
    @Column(name = "STATION_NAME")
    private String stationName;


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public PM(String buildingName, String residenceAddress, String buildingType, String floorArea,
			String otherFloorArea) {
		super();
		this.buildingName = buildingName;
		this.residenceAddress = residenceAddress;
		this.buildingType = buildingType;
		this.floorArea = floorArea;
		this.otherFloorArea = otherFloorArea;
	}
	public PM(int id, String buildingName, String residenceAddress, String buildingType, String floorArea,
			String otherFloorArea) {
		super();
		this.id = id;
		this.buildingName = buildingName;
		this.residenceAddress = residenceAddress;
		this.buildingType = buildingType;
		this.floorArea = floorArea;
		this.otherFloorArea = otherFloorArea;
	}
	public PM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}
	public String getOtherFloorArea() {
		return otherFloorArea;
	}
	public void setOtherFloorArea(String otherFloorArea) {
		this.otherFloorArea = otherFloorArea;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
