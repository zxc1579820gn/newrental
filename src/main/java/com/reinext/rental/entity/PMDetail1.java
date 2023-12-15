package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



//pm=PropertyManagement
@Entity
@Table(name = "pm_detail_1")//データベーステーブルの名前は "pm_detail_1"
public class PMDetail1 {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //詳細資料頁ID	//詳細情報ページID			
    @Column(name = "PM_ID")
    private int pmId;

    // 建物名稱//名    称				
    @Column(name = "BUILDING_NAME")
    private String buildingName;

    // 棟// 棟
    @Column(name = "BUILDING_TOWER")
    private String buildingTower;

    // 建物樓層//階	
    @Column(name = "BUILDING_FLOOR")
    private String buildingFloor;

    // 建物房號//号室
    @Column(name = "BUILDING_ROOM")
    private String buildingRoom;

    // 住址//住居表示
    @Column(name = "RESIDENCE_ADDRESS")
    private String residenceAddress;

    // 登記記錄//登記簿					
    @Column(name = "REGISTRATION_RECORD")
    private String registrationRecord;

    // 建物類型//種    類				
    @Column(name = "BUILDING_TYPE")
    private String buildingType;

    // 建物結構//構    造
    @Column(name = "BUILDING_STRUCTURE")
    private String buildingStructure;

    // 單位數量//戸    数				
    @Column(name = "NUMBER_OF_UNITS")
    private String numberOfUnits;

    // 建築年份//建築時期
    @Column(name = "CONSTRUCTION_YEAR")
    private String constructionYear;

    // 大規模修繕年份//大規模修繕を					
    @Column(name = "BIG_CONSTRUCTION_DATE")
    private String bigConstructionDate;

    // 單位編號//住戸番号
    @Column(name = "UNIT_NUMBER")
    private String unitNumber;

    // 格局//間取り				
    @Column(name = "LAYOUT")
    private String layout;

    // 樓地板面積//床 面 積				
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

    
    
    
    
    
    
    
    
    public PM getPMData() {
        // 假設這是你的邏輯來創建並返回 PM 對象
        PM pmData = new PM();
        pmData.setBuildingName(this.getBuildingName());
        pmData.setResidenceAddress(this.getResidenceAddress());
        pmData.setBuildingType(this.getBuildingType());
        pmData.setFloorArea(this.getFloorArea());
        pmData.setOtherFloorArea(this.getOtherFloorArea());
        pmData.setLineName(this.getLineName());
        pmData.setStationName(this.getStationName());
        // 設定其他 PM 屬性...
        return pmData;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    


	public int getPmId() {
		return pmId;
	}

	public void setPmId(int pmId) {
		this.pmId = pmId;
	}

	public PMDetail1(String buildingName, String buildingTower, String buildingFloor, String buildingRoom,
			String residenceAddress, String registrationRecord, String buildingType, String buildingStructure,
			String numberOfUnits, String constructionYear, String bigConstructionDate, String unitNumber, String layout,
			String floorArea, String otherFloorArea) {
		super();
		this.buildingName = buildingName;
		this.buildingTower = buildingTower;
		this.buildingFloor = buildingFloor;
		this.buildingRoom = buildingRoom;
		this.residenceAddress = residenceAddress;
		this.registrationRecord = registrationRecord;
		this.buildingType = buildingType;
		this.buildingStructure = buildingStructure;
		this.numberOfUnits = numberOfUnits;
		this.constructionYear = constructionYear;
		this.bigConstructionDate = bigConstructionDate;
		this.unitNumber = unitNumber;
		this.layout = layout;
		this.floorArea = floorArea;
		this.otherFloorArea = otherFloorArea;
	}

	public PMDetail1(int id, String buildingName, String buildingTower, String buildingFloor, String buildingRoom,
			String residenceAddress, String registrationRecord, String buildingType, String buildingStructure,
			String numberOfUnits, String constructionYear, String bigConstructionDate, String unitNumber, String layout,
			String floorArea, String otherFloorArea) {
		super();
		this.id = id;
		this.buildingName = buildingName;
		this.buildingTower = buildingTower;
		this.buildingFloor = buildingFloor;
		this.buildingRoom = buildingRoom;
		this.residenceAddress = residenceAddress;
		this.registrationRecord = registrationRecord;
		this.buildingType = buildingType;
		this.buildingStructure = buildingStructure;
		this.numberOfUnits = numberOfUnits;
		this.constructionYear = constructionYear;
		this.bigConstructionDate = bigConstructionDate;
		this.unitNumber = unitNumber;
		this.layout = layout;
		this.floorArea = floorArea;
		this.otherFloorArea = otherFloorArea;
	}

	public PMDetail1() {
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

	public String getBuildingTower() {
		return buildingTower;
	}

	public void setBuildingTower(String buildingTower) {
		this.buildingTower = buildingTower;
	}

	public String getBuildingFloor() {
		return buildingFloor;
	}

	public void setBuildingFloor(String buildingFloor) {
		this.buildingFloor = buildingFloor;
	}

	public String getBuildingRoom() {
		return buildingRoom;
	}

	public void setBuildingRoom(String buildingRoom) {
		this.buildingRoom = buildingRoom;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getRegistrationRecord() {
		return registrationRecord;
	}

	public void setRegistrationRecord(String registrationRecord) {
		this.registrationRecord = registrationRecord;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(String buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public String getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(String numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public String getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(String constructionYear) {
		this.constructionYear = constructionYear;
	}

	public String getBigConstructionDate() {
		return bigConstructionDate;
	}

	public void setBigConstructionDate(String bigConstructionDate) {
		this.bigConstructionDate = bigConstructionDate;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
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
