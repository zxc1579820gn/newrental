package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//pm=PropertyManagement
@Entity
@Table(name = "pm_detail_1") // データベーステーブルの名前は "pm_detail_1"
public class PMDetail1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// 詳細資料頁ID //詳細情報ページID
	@Column(name = "PM_ID")
	private int pmId;

	// 建物名稱//名 称
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

	// 建物類型//種 類
	@Column(name = "BUILDING_TYPE")
	private String buildingType;

	// 建物結構//構 造
	@Column(name = "BUILDING_STRUCTURE")
	private String buildingStructure;

	// 單位數量//戸 数
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

	// 電気
	@Column(name = "ELECTRICITY")
	private String electricity;

	// 電気の文脈
	@Column(name = "ELECTRICITY_CONTEXT")
	private String electricityContext;

	// 電気の備考
	@Column(name = "ELECTRICITY_REMARKS")
	private String electricityRemarks;

	// ガス
	@Column(name = "GAS")
	private String gas;

	// ガスの文脈
	@Column(name = "GAS_CONTEXT")
	private String gasContext;

	// ガスの備考
	@Column(name = "GAS_REMARKS")
	private String gasRemarks;
	
    // コンロ
    @Column(name = "STOVE_VALUE")
    private String stoveValue;

    // コンロのコンテキスト
    @Column(name = "STOVE_CONTEXT", columnDefinition = "TEXT")
    private String stoveContext;

    // コンロの備考
    @Column(name = "STOVE_REMARKS", columnDefinition = "TEXT")
    private String stoveRemarks;

    // 上水道
    @Column(name = "WATER_SUPPLY_VALUE")
    private String waterSupplyValue;

    // 上水道のコンテキスト
    @Column(name = "WATER_SUPPLY_CONTEXT", columnDefinition = "TEXT")
    private String waterSupplyContext;

    // 上水道の備考
    @Column(name = "WATER_SUPPLY_REMARKS", columnDefinition = "TEXT")
    private String waterSupplyRemarks;

    // 下水道
    @Column(name = "SEWERAGE_VALUE")
    private String sewerageValue;

    // 下水道のコンテキスト
    @Column(name = "SEWERAGE_CONTEXT", columnDefinition = "TEXT")
    private String sewerageContext;

    // 下水道の備考
    @Column(name = "SEWERAGE_REMARKS", columnDefinition = "TEXT")
    private String sewerageRemarks;

    // 台所
    @Column(name = "KITCHEN_VALUE")
    private String kitchenValue;

    // 台所のコンテキスト
    @Column(name = "KITCHEN_CONTEXT", columnDefinition = "TEXT")
    private String kitchenContext;

    // 台所の備考
    @Column(name = "KITCHEN_REMARKS", columnDefinition = "TEXT")
    private String kitchenRemarks;

    // トイレ
    @Column(name = "TOILET_VALUE")
    private String toiletValue;

    // トイレのコンテキスト
    @Column(name = "TOILET_CONTEXT", columnDefinition = "TEXT")
    private String toiletContext;

    // トイレの備考
    @Column(name = "TOILET_REMARKS", columnDefinition = "TEXT")
    private String toiletRemarks;
    
    // 浴室
    @Column(name = "BATHROOM_VALUE")
    private String bathroomValue;
    //浴室の文脈
    @Column(name = "BATHROOM_CONTEXT", columnDefinition = "TEXT")
    private String bathroomContext;
    //浴室の備考
    @Column(name = "BATHROOM_REMARKS", columnDefinition = "TEXT")
    private String bathroomRemarks;

    // 洗面台
    @Column(name = "WASHBASIN_VALUE")
    private String washbasinValue;
 // 洗面台の文脈
    @Column(name = "WASHBASIN_CONTEXT", columnDefinition = "TEXT")
    private String washbasinContext;
 // 洗面台の備考
    @Column(name = "WASHBASIN_REMARKS", columnDefinition = "TEXT")
    private String washbasinRemarks;

    // 洗濯機置場
    @Column(name = "LAUNDRY_AREA_VALUE")
    private String laundryAreaValue;
    // 洗濯機置場の文脈
    @Column(name = "LAUNDRY_AREA_CONTEXT", columnDefinition = "TEXT")
    private String laundryAreaContext;
    // 洗濯機置場の備考
    @Column(name = "LAUNDRY_AREA_REMARKS", columnDefinition = "TEXT")
    private String laundryAreaRemarks;

    // 給湯設備
    @Column(name = "WATER_HEATER_VALUE")
    private String waterHeaterValue;
    // 給湯設備の文脈
    @Column(name = "WATER_HEATER_CONTEXT", columnDefinition = "TEXT")
    private String waterHeaterContext;
    // 給湯設備の備考
    @Column(name = "WATER_HEATER_REMARKS", columnDefinition = "TEXT")
    private String waterHeaterRemarks;

    // 冷暖房設備（エアコン）
    @Column(name = "AIR_CONDITIONER_VALUE")
    private String airConditionerValue;
    // 冷暖房設備（エアコン）の文脈
    @Column(name = "AIR_CONDITIONER_CONTEXT", columnDefinition = "TEXT")
    private String airConditionerContext;
    // 冷暖房設備（エアコン）の備考
    @Column(name = "AIR_CONDITIONER_REMARKS", columnDefinition = "TEXT")
    private String airConditionerRemarks;
    
    // 照明器具
    @Column(name = "LIGHTING_VALUE")
    private String lightingValue;
    // 照明器具の文脈
    @Column(name = "LIGHTING_CONTEXT", columnDefinition = "TEXT")
    private String lightingContext;
    //照明器具の備考
    @Column(name = "LIGHTING_REMARKS", columnDefinition = "TEXT")
    private String lightingRemarks;

    // 備付家具
    @Column(name = "FURNITURE_VALUE")
    private String furnitureValue;
    // 備付家具の文脈
    @Column(name = "FURNITURE_CONTEXT", columnDefinition = "TEXT")
    private String furnitureContext;
    // 備付家具の備考
    @Column(name = "FURNITURE_REMARKS", columnDefinition = "TEXT")
    private String furnitureRemarks;

    // 地デジ対応
    @Column(name = "DIGITAL_TV_VALUE")
    private String digitalTvValue;
    // 地デジ対応の文脈
    @Column(name = "DIGITAL_TV_CONTEXT", columnDefinition = "TEXT")
    private String digitalTvContext;
    // 地デジ対応の備考
    @Column(name = "DIGITAL_TV_REMARKS", columnDefinition = "TEXT")
    private String digitalTvRemarks;

    // CATV対応
    @Column(name = "CATV_VALUE")
    private String catvValue;
    // CATV対応の文脈
    @Column(name = "CATV_CONTEXT", columnDefinition = "TEXT")
    private String catvContext;
    // CATV対応の備考
    @Column(name = "CATV_REMARKS", columnDefinition = "TEXT")
    private String catvRemarks;

    // インターネット
    @Column(name = "INTERNET_VALUE")
    private String internetValue;
    // インターネットの文脈
    @Column(name = "INTERNET_CONTEXT", columnDefinition = "TEXT")
    private String internetContext;
    // インターネットの備考
    @Column(name = "INTERNET_REMARKS", columnDefinition = "TEXT")
    private String internetRemarks;
    
    // トランクルーム
    @Column(name = "TRUNK_ROOM")
    private String trunkRoom;

    // トランクルームの文脈
    @Column(name = "TRUNK_ROOM_CONTEXT", columnDefinition = "TEXT")
    private String trunkRoomContext;

    // トランクルームの備考
    @Column(name = "TRUNK_ROOM_REMARKS", columnDefinition = "TEXT")
    private String trunkRoomRemarks;

    // 専用庭
    @Column(name = "PRIVATE_GARDEN")
    private String privateGarden;

    // 専用庭の文脈
    @Column(name = "PRIVATE_GARDEN_CONTEXT", columnDefinition = "TEXT")
    private String privateGardenContext;

    // 専用庭の備考
    @Column(name = "PRIVATE_GARDEN_REMARKS", columnDefinition = "TEXT")
    private String privateGardenRemarks;

    // ルーフバルコニー
    @Column(name = "ROOF_BALCONY")
    private String roofBalcony;

    // ルーフバルコニーの文脈
    @Column(name = "ROOF_BALCONY_CONTEXT", columnDefinition = "TEXT")
    private String roofBalconyContext;

    // ルーフバルコニーの備考
    @Column(name = "ROOF_BALCONY_REMARKS", columnDefinition = "TEXT")
    private String roofBalconyRemarks;

    // 鍵
    @Column(name = "KEY_VALUE")
    private String keyValue;

    // 鍵の文脈
    @Column(name = "KEY_CONTEXT", columnDefinition = "TEXT")
    private String keyContext;

    // 鍵の備考
    @Column(name = "KEY_REMARKS", columnDefinition = "TEXT")
    private String keyRemarks;
    
    // エレベーター
    @Column(name = "ELEVATOR_VALUE")
    private String elevatorValue;
    // エレベーターの文脈
    @Column(name = "ELEVATOR_CONTEXT", columnDefinition = "TEXT")
    private String elevatorContext;
    // エレベーターの備考
    @Column(name = "ELEVATOR_REMARKS", columnDefinition = "TEXT")
    private String elevatorRemarks;

    // オートロック
    @Column(name = "AUTO_LOCK_VALUE")
    private String autoLockValue;
    // オートロックの文脈
    @Column(name = "AUTO_LOCK_CONTEXT", columnDefinition = "TEXT")
    private String autoLockContext;
    // オートロックの備考
    @Column(name = "AUTO_LOCK_REMARKS", columnDefinition = "TEXT")
    private String autoLockRemarks;

    // メールボックス
    @Column(name = "MAILBOX_VALUE")
    private String mailboxValue;
    // メールボックスの文脈
    @Column(name = "MAILBOX_CONTEXT", columnDefinition = "TEXT")
    private String mailboxContext;
    // メールボックスの備考
    @Column(name = "MAILBOX_REMARKS", columnDefinition = "TEXT")
    private String mailboxRemarks;

    // 宅配ボックス
    @Column(name = "DELIVERY_BOX_VALUE")
    private String deliveryBoxValue;
    // 宅配ボックスの文脈
    @Column(name = "DELIVERY_BOX_CONTEXT", columnDefinition = "TEXT")
    private String deliveryBoxContext;
    // 宅配ボックスの備考
    @Column(name = "DELIVERY_BOX_REMARKS", columnDefinition = "TEXT")
    private String deliveryBoxRemarks;
    
    // トランクルーム
    @Column(name = "STORAGE_ROOM")
    private String storageRoom;
    // トランクルームの文脈
    @Column(name = "STORAGE_ROOM_CONTEXT", columnDefinition = "TEXT")
    private String storageRoomContext;
    // トランクルームの備考
    @Column(name = "STORAGE_ROOM_REMARKS", columnDefinition = "TEXT")
    private String storageRoomRemarks;

    // 駐車場
    @Column(name = "PARKING")
    private String parking;
    // 駐車場の文脈
    @Column(name = "PARKING_CONTEXT", columnDefinition = "TEXT")
    private String parkingContext;
    // 駐車場の備考
    @Column(name = "PARKING_REMARKS", columnDefinition = "TEXT")
    private String parkingRemarks;

    // 駐輪場
    @Column(name = "BIKE_PARKING")
    private String bikeParking;
    // 駐輪場の文脈
    @Column(name = "BIKE_PARKING_CONTEXT", columnDefinition = "TEXT")
    private String bikeParkingContext;
    // 駐輪場の備考
    @Column(name = "BIKE_PARKING_REMARKS", columnDefinition = "TEXT")
    private String bikeParkingRemarks;

    // バイク置場
    @Column(name = "MOTORCYCLE_PARKING")
    private String motorcycleParking;
    // バイク置場の文脈
    @Column(name = "MOTORCYCLE_PARKING_CONTEXT", columnDefinition = "TEXT")
    private String motorcycleParkingContext;
    // バイク置場の備考
    @Column(name = "MOTORCYCLE_PARKING_REMARKS", columnDefinition = "TEXT")
    private String motorcycleParkingRemarks;
    
    // 契約始期
    @Column(name = "CONTRACT_START_DATE", length = 255)
    private String contractStartDate;
    
    // 契約終期
    @Column(name = "CONTRACT_END_DATE", length = 255)
    private String contractEndDate;

    // 合計契約時間
    @Column(name = "TOTAL_CONTRACT_DURATION", length = 255)
    private String totalContractDuration;

    // 目的物件の引渡日
    @Column(name = "PROPERTY_DELIVERY_DATE", length = 255)
    private String propertyDeliveryDate;
    
    
    
    
    
    
    
    
    
    

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

		return pmData;
	}








public PMDetail1(int pmId, String buildingName, String buildingTower, String buildingFloor, String buildingRoom,
		String residenceAddress, String registrationRecord, String buildingType, String buildingStructure,
		String numberOfUnits, String constructionYear, String bigConstructionDate, String unitNumber, String layout,
		String floorArea, String otherFloorArea, String lineName, String stationName, String electricity,
		String electricityContext, String electricityRemarks, String gas, String gasContext, String gasRemarks,
		String stoveValue, String stoveContext, String stoveRemarks, String waterSupplyValue,
		String waterSupplyContext, String waterSupplyRemarks, String sewerageValue, String sewerageContext,
		String sewerageRemarks, String kitchenValue, String kitchenContext, String kitchenRemarks,
		String toiletValue, String toiletContext, String toiletRemarks, String bathroomValue,
		String bathroomContext, String bathroomRemarks, String washbasinValue, String washbasinContext,
		String washbasinRemarks, String laundryAreaValue, String laundryAreaContext, String laundryAreaRemarks,
		String waterHeaterValue, String waterHeaterContext, String waterHeaterRemarks, String airConditionerValue,
		String airConditionerContext, String airConditionerRemarks, String lightingValue, String lightingContext,
		String lightingRemarks, String furnitureValue, String furnitureContext, String furnitureRemarks,
		String digitalTvValue, String digitalTvContext, String digitalTvRemarks, String catvValue,
		String catvContext, String catvRemarks, String internetValue, String internetContext,
		String internetRemarks, String trunkRoom, String trunkRoomContext, String trunkRoomRemarks,
		String privateGarden, String privateGardenContext, String privateGardenRemarks, String roofBalcony,
		String roofBalconyContext, String roofBalconyRemarks, String keyValue, String keyContext, String keyRemarks,
		String elevatorValue, String elevatorContext, String elevatorRemarks, String autoLockValue,
		String autoLockContext, String autoLockRemarks, String mailboxValue, String mailboxContext,
		String mailboxRemarks, String deliveryBoxValue, String deliveryBoxContext, String deliveryBoxRemarks,
		String storageRoom, String storageRoomContext, String storageRoomRemarks, String parking,
		String parkingContext, String parkingRemarks, String bikeParking, String bikeParkingContext,
		String bikeParkingRemarks, String motorcycleParking, String motorcycleParkingContext,
		String motorcycleParkingRemarks, String contractStartDate, String contractEndDate,
		String totalContractDuration, String propertyDeliveryDate) {
	super();
	this.pmId = pmId;
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
	this.lineName = lineName;
	this.stationName = stationName;
	this.electricity = electricity;
	this.electricityContext = electricityContext;
	this.electricityRemarks = electricityRemarks;
	this.gas = gas;
	this.gasContext = gasContext;
	this.gasRemarks = gasRemarks;
	this.stoveValue = stoveValue;
	this.stoveContext = stoveContext;
	this.stoveRemarks = stoveRemarks;
	this.waterSupplyValue = waterSupplyValue;
	this.waterSupplyContext = waterSupplyContext;
	this.waterSupplyRemarks = waterSupplyRemarks;
	this.sewerageValue = sewerageValue;
	this.sewerageContext = sewerageContext;
	this.sewerageRemarks = sewerageRemarks;
	this.kitchenValue = kitchenValue;
	this.kitchenContext = kitchenContext;
	this.kitchenRemarks = kitchenRemarks;
	this.toiletValue = toiletValue;
	this.toiletContext = toiletContext;
	this.toiletRemarks = toiletRemarks;
	this.bathroomValue = bathroomValue;
	this.bathroomContext = bathroomContext;
	this.bathroomRemarks = bathroomRemarks;
	this.washbasinValue = washbasinValue;
	this.washbasinContext = washbasinContext;
	this.washbasinRemarks = washbasinRemarks;
	this.laundryAreaValue = laundryAreaValue;
	this.laundryAreaContext = laundryAreaContext;
	this.laundryAreaRemarks = laundryAreaRemarks;
	this.waterHeaterValue = waterHeaterValue;
	this.waterHeaterContext = waterHeaterContext;
	this.waterHeaterRemarks = waterHeaterRemarks;
	this.airConditionerValue = airConditionerValue;
	this.airConditionerContext = airConditionerContext;
	this.airConditionerRemarks = airConditionerRemarks;
	this.lightingValue = lightingValue;
	this.lightingContext = lightingContext;
	this.lightingRemarks = lightingRemarks;
	this.furnitureValue = furnitureValue;
	this.furnitureContext = furnitureContext;
	this.furnitureRemarks = furnitureRemarks;
	this.digitalTvValue = digitalTvValue;
	this.digitalTvContext = digitalTvContext;
	this.digitalTvRemarks = digitalTvRemarks;
	this.catvValue = catvValue;
	this.catvContext = catvContext;
	this.catvRemarks = catvRemarks;
	this.internetValue = internetValue;
	this.internetContext = internetContext;
	this.internetRemarks = internetRemarks;
	this.trunkRoom = trunkRoom;
	this.trunkRoomContext = trunkRoomContext;
	this.trunkRoomRemarks = trunkRoomRemarks;
	this.privateGarden = privateGarden;
	this.privateGardenContext = privateGardenContext;
	this.privateGardenRemarks = privateGardenRemarks;
	this.roofBalcony = roofBalcony;
	this.roofBalconyContext = roofBalconyContext;
	this.roofBalconyRemarks = roofBalconyRemarks;
	this.keyValue = keyValue;
	this.keyContext = keyContext;
	this.keyRemarks = keyRemarks;
	this.elevatorValue = elevatorValue;
	this.elevatorContext = elevatorContext;
	this.elevatorRemarks = elevatorRemarks;
	this.autoLockValue = autoLockValue;
	this.autoLockContext = autoLockContext;
	this.autoLockRemarks = autoLockRemarks;
	this.mailboxValue = mailboxValue;
	this.mailboxContext = mailboxContext;
	this.mailboxRemarks = mailboxRemarks;
	this.deliveryBoxValue = deliveryBoxValue;
	this.deliveryBoxContext = deliveryBoxContext;
	this.deliveryBoxRemarks = deliveryBoxRemarks;
	this.storageRoom = storageRoom;
	this.storageRoomContext = storageRoomContext;
	this.storageRoomRemarks = storageRoomRemarks;
	this.parking = parking;
	this.parkingContext = parkingContext;
	this.parkingRemarks = parkingRemarks;
	this.bikeParking = bikeParking;
	this.bikeParkingContext = bikeParkingContext;
	this.bikeParkingRemarks = bikeParkingRemarks;
	this.motorcycleParking = motorcycleParking;
	this.motorcycleParkingContext = motorcycleParkingContext;
	this.motorcycleParkingRemarks = motorcycleParkingRemarks;
	this.contractStartDate = contractStartDate;
	this.contractEndDate = contractEndDate;
	this.totalContractDuration = totalContractDuration;
	this.propertyDeliveryDate = propertyDeliveryDate;
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

	public int getPmId() {
		return pmId;
	}

	public void setPmId(int pmId) {
		this.pmId = pmId;
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

	public String getElectricity() {
		return electricity;
	}

	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}

	public String getElectricityContext() {
		return electricityContext;
	}

	public void setElectricityContext(String electricityContext) {
		this.electricityContext = electricityContext;
	}

	public String getElectricityRemarks() {
		return electricityRemarks;
	}

	public void setElectricityRemarks(String electricityRemarks) {
		this.electricityRemarks = electricityRemarks;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getGasContext() {
		return gasContext;
	}

	public void setGasContext(String gasContext) {
		this.gasContext = gasContext;
	}

	public String getGasRemarks() {
		return gasRemarks;
	}

	public void setGasRemarks(String gasRemarks) {
		this.gasRemarks = gasRemarks;
	}

	public String getStoveValue() {
		return stoveValue;
	}

	public void setStoveValue(String stoveValue) {
		this.stoveValue = stoveValue;
	}

	public String getStoveContext() {
		return stoveContext;
	}

	public void setStoveContext(String stoveContext) {
		this.stoveContext = stoveContext;
	}

	public String getStoveRemarks() {
		return stoveRemarks;
	}

	public void setStoveRemarks(String stoveRemarks) {
		this.stoveRemarks = stoveRemarks;
	}

	public String getWaterSupplyValue() {
		return waterSupplyValue;
	}

	public void setWaterSupplyValue(String waterSupplyValue) {
		this.waterSupplyValue = waterSupplyValue;
	}

	public String getWaterSupplyContext() {
		return waterSupplyContext;
	}

	public void setWaterSupplyContext(String waterSupplyContext) {
		this.waterSupplyContext = waterSupplyContext;
	}

	public String getWaterSupplyRemarks() {
		return waterSupplyRemarks;
	}

	public void setWaterSupplyRemarks(String waterSupplyRemarks) {
		this.waterSupplyRemarks = waterSupplyRemarks;
	}

	public String getSewerageValue() {
		return sewerageValue;
	}

	public void setSewerageValue(String sewerageValue) {
		this.sewerageValue = sewerageValue;
	}

	public String getSewerageContext() {
		return sewerageContext;
	}

	public void setSewerageContext(String sewerageContext) {
		this.sewerageContext = sewerageContext;
	}

	public String getSewerageRemarks() {
		return sewerageRemarks;
	}

	public void setSewerageRemarks(String sewerageRemarks) {
		this.sewerageRemarks = sewerageRemarks;
	}

	public String getKitchenValue() {
		return kitchenValue;
	}

	public void setKitchenValue(String kitchenValue) {
		this.kitchenValue = kitchenValue;
	}

	public String getKitchenContext() {
		return kitchenContext;
	}

	public void setKitchenContext(String kitchenContext) {
		this.kitchenContext = kitchenContext;
	}

	public String getKitchenRemarks() {
		return kitchenRemarks;
	}

	public void setKitchenRemarks(String kitchenRemarks) {
		this.kitchenRemarks = kitchenRemarks;
	}

	public String getToiletValue() {
		return toiletValue;
	}

	public void setToiletValue(String toiletValue) {
		this.toiletValue = toiletValue;
	}

	public String getToiletContext() {
		return toiletContext;
	}

	public void setToiletContext(String toiletContext) {
		this.toiletContext = toiletContext;
	}

	public String getToiletRemarks() {
		return toiletRemarks;
	}

	public void setToiletRemarks(String toiletRemarks) {
		this.toiletRemarks = toiletRemarks;
	}

	public String getBathroomValue() {
		return bathroomValue;
	}

	public void setBathroomValue(String bathroomValue) {
		this.bathroomValue = bathroomValue;
	}

	public String getBathroomContext() {
		return bathroomContext;
	}

	public void setBathroomContext(String bathroomContext) {
		this.bathroomContext = bathroomContext;
	}

	public String getBathroomRemarks() {
		return bathroomRemarks;
	}

	public void setBathroomRemarks(String bathroomRemarks) {
		this.bathroomRemarks = bathroomRemarks;
	}

	public String getWashbasinValue() {
		return washbasinValue;
	}

	public void setWashbasinValue(String washbasinValue) {
		this.washbasinValue = washbasinValue;
	}

	public String getWashbasinContext() {
		return washbasinContext;
	}

	public void setWashbasinContext(String washbasinContext) {
		this.washbasinContext = washbasinContext;
	}

	public String getWashbasinRemarks() {
		return washbasinRemarks;
	}

	public void setWashbasinRemarks(String washbasinRemarks) {
		this.washbasinRemarks = washbasinRemarks;
	}

	public String getLaundryAreaValue() {
		return laundryAreaValue;
	}

	public void setLaundryAreaValue(String laundryAreaValue) {
		this.laundryAreaValue = laundryAreaValue;
	}

	public String getLaundryAreaContext() {
		return laundryAreaContext;
	}

	public void setLaundryAreaContext(String laundryAreaContext) {
		this.laundryAreaContext = laundryAreaContext;
	}

	public String getLaundryAreaRemarks() {
		return laundryAreaRemarks;
	}

	public void setLaundryAreaRemarks(String laundryAreaRemarks) {
		this.laundryAreaRemarks = laundryAreaRemarks;
	}

	public String getWaterHeaterValue() {
		return waterHeaterValue;
	}

	public void setWaterHeaterValue(String waterHeaterValue) {
		this.waterHeaterValue = waterHeaterValue;
	}

	public String getWaterHeaterContext() {
		return waterHeaterContext;
	}

	public void setWaterHeaterContext(String waterHeaterContext) {
		this.waterHeaterContext = waterHeaterContext;
	}

	public String getWaterHeaterRemarks() {
		return waterHeaterRemarks;
	}

	public void setWaterHeaterRemarks(String waterHeaterRemarks) {
		this.waterHeaterRemarks = waterHeaterRemarks;
	}

	public String getAirConditionerValue() {
		return airConditionerValue;
	}

	public void setAirConditionerValue(String airConditionerValue) {
		this.airConditionerValue = airConditionerValue;
	}

	public String getAirConditionerContext() {
		return airConditionerContext;
	}

	public void setAirConditionerContext(String airConditionerContext) {
		this.airConditionerContext = airConditionerContext;
	}

	public String getAirConditionerRemarks() {
		return airConditionerRemarks;
	}

	public void setAirConditionerRemarks(String airConditionerRemarks) {
		this.airConditionerRemarks = airConditionerRemarks;
	}

	public String getLightingValue() {
		return lightingValue;
	}

	public void setLightingValue(String lightingValue) {
		this.lightingValue = lightingValue;
	}

	public String getLightingContext() {
		return lightingContext;
	}

	public void setLightingContext(String lightingContext) {
		this.lightingContext = lightingContext;
	}

	public String getLightingRemarks() {
		return lightingRemarks;
	}

	public void setLightingRemarks(String lightingRemarks) {
		this.lightingRemarks = lightingRemarks;
	}

	public String getFurnitureValue() {
		return furnitureValue;
	}

	public void setFurnitureValue(String furnitureValue) {
		this.furnitureValue = furnitureValue;
	}

	public String getFurnitureContext() {
		return furnitureContext;
	}

	public void setFurnitureContext(String furnitureContext) {
		this.furnitureContext = furnitureContext;
	}

	public String getFurnitureRemarks() {
		return furnitureRemarks;
	}

	public void setFurnitureRemarks(String furnitureRemarks) {
		this.furnitureRemarks = furnitureRemarks;
	}

	public String getDigitalTvValue() {
		return digitalTvValue;
	}

	public void setDigitalTvValue(String digitalTvValue) {
		this.digitalTvValue = digitalTvValue;
	}

	public String getDigitalTvContext() {
		return digitalTvContext;
	}

	public void setDigitalTvContext(String digitalTvContext) {
		this.digitalTvContext = digitalTvContext;
	}

	public String getDigitalTvRemarks() {
		return digitalTvRemarks;
	}

	public void setDigitalTvRemarks(String digitalTvRemarks) {
		this.digitalTvRemarks = digitalTvRemarks;
	}

	public String getCatvValue() {
		return catvValue;
	}

	public void setCatvValue(String catvValue) {
		this.catvValue = catvValue;
	}

	public String getCatvContext() {
		return catvContext;
	}

	public void setCatvContext(String catvContext) {
		this.catvContext = catvContext;
	}

	public String getCatvRemarks() {
		return catvRemarks;
	}

	public void setCatvRemarks(String catvRemarks) {
		this.catvRemarks = catvRemarks;
	}

	public String getInternetValue() {
		return internetValue;
	}

	public void setInternetValue(String internetValue) {
		this.internetValue = internetValue;
	}

	public String getInternetContext() {
		return internetContext;
	}

	public void setInternetContext(String internetContext) {
		this.internetContext = internetContext;
	}

	public String getInternetRemarks() {
		return internetRemarks;
	}

	public void setInternetRemarks(String internetRemarks) {
		this.internetRemarks = internetRemarks;
	}

	public String getTrunkRoom() {
		return trunkRoom;
	}

	public void setTrunkRoom(String trunkRoom) {
		this.trunkRoom = trunkRoom;
	}

	public String getTrunkRoomContext() {
		return trunkRoomContext;
	}

	public void setTrunkRoomContext(String trunkRoomContext) {
		this.trunkRoomContext = trunkRoomContext;
	}

	public String getTrunkRoomRemarks() {
		return trunkRoomRemarks;
	}

	public void setTrunkRoomRemarks(String trunkRoomRemarks) {
		this.trunkRoomRemarks = trunkRoomRemarks;
	}

	public String getPrivateGarden() {
		return privateGarden;
	}

	public void setPrivateGarden(String privateGarden) {
		this.privateGarden = privateGarden;
	}

	public String getPrivateGardenContext() {
		return privateGardenContext;
	}

	public void setPrivateGardenContext(String privateGardenContext) {
		this.privateGardenContext = privateGardenContext;
	}

	public String getPrivateGardenRemarks() {
		return privateGardenRemarks;
	}

	public void setPrivateGardenRemarks(String privateGardenRemarks) {
		this.privateGardenRemarks = privateGardenRemarks;
	}

	public String getRoofBalcony() {
		return roofBalcony;
	}

	public void setRoofBalcony(String roofBalcony) {
		this.roofBalcony = roofBalcony;
	}

	public String getRoofBalconyContext() {
		return roofBalconyContext;
	}

	public void setRoofBalconyContext(String roofBalconyContext) {
		this.roofBalconyContext = roofBalconyContext;
	}

	public String getRoofBalconyRemarks() {
		return roofBalconyRemarks;
	}

	public void setRoofBalconyRemarks(String roofBalconyRemarks) {
		this.roofBalconyRemarks = roofBalconyRemarks;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getKeyContext() {
		return keyContext;
	}

	public void setKeyContext(String keyContext) {
		this.keyContext = keyContext;
	}

	public String getKeyRemarks() {
		return keyRemarks;
	}

	public void setKeyRemarks(String keyRemarks) {
		this.keyRemarks = keyRemarks;
	}

	public String getElevatorValue() {
		return elevatorValue;
	}

	public void setElevatorValue(String elevatorValue) {
		this.elevatorValue = elevatorValue;
	}

	public String getElevatorContext() {
		return elevatorContext;
	}

	public void setElevatorContext(String elevatorContext) {
		this.elevatorContext = elevatorContext;
	}

	public String getElevatorRemarks() {
		return elevatorRemarks;
	}

	public void setElevatorRemarks(String elevatorRemarks) {
		this.elevatorRemarks = elevatorRemarks;
	}

	public String getAutoLockValue() {
		return autoLockValue;
	}

	public void setAutoLockValue(String autoLockValue) {
		this.autoLockValue = autoLockValue;
	}

	public String getAutoLockContext() {
		return autoLockContext;
	}

	public void setAutoLockContext(String autoLockContext) {
		this.autoLockContext = autoLockContext;
	}

	public String getAutoLockRemarks() {
		return autoLockRemarks;
	}

	public void setAutoLockRemarks(String autoLockRemarks) {
		this.autoLockRemarks = autoLockRemarks;
	}

	public String getMailboxValue() {
		return mailboxValue;
	}

	public void setMailboxValue(String mailboxValue) {
		this.mailboxValue = mailboxValue;
	}

	public String getMailboxContext() {
		return mailboxContext;
	}

	public void setMailboxContext(String mailboxContext) {
		this.mailboxContext = mailboxContext;
	}

	public String getMailboxRemarks() {
		return mailboxRemarks;
	}

	public void setMailboxRemarks(String mailboxRemarks) {
		this.mailboxRemarks = mailboxRemarks;
	}

	public String getDeliveryBoxValue() {
		return deliveryBoxValue;
	}

	public void setDeliveryBoxValue(String deliveryBoxValue) {
		this.deliveryBoxValue = deliveryBoxValue;
	}

	public String getDeliveryBoxContext() {
		return deliveryBoxContext;
	}

	public void setDeliveryBoxContext(String deliveryBoxContext) {
		this.deliveryBoxContext = deliveryBoxContext;
	}

	public String getDeliveryBoxRemarks() {
		return deliveryBoxRemarks;
	}

	public void setDeliveryBoxRemarks(String deliveryBoxRemarks) {
		this.deliveryBoxRemarks = deliveryBoxRemarks;
	}

	public String getStorageRoom() {
		return storageRoom;
	}

	public void setStorageRoom(String storageRoom) {
		this.storageRoom = storageRoom;
	}

	public String getStorageRoomContext() {
		return storageRoomContext;
	}

	public void setStorageRoomContext(String storageRoomContext) {
		this.storageRoomContext = storageRoomContext;
	}

	public String getStorageRoomRemarks() {
		return storageRoomRemarks;
	}

	public void setStorageRoomRemarks(String storageRoomRemarks) {
		this.storageRoomRemarks = storageRoomRemarks;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getParkingContext() {
		return parkingContext;
	}

	public void setParkingContext(String parkingContext) {
		this.parkingContext = parkingContext;
	}

	public String getParkingRemarks() {
		return parkingRemarks;
	}

	public void setParkingRemarks(String parkingRemarks) {
		this.parkingRemarks = parkingRemarks;
	}

	public String getBikeParking() {
		return bikeParking;
	}

	public void setBikeParking(String bikeParking) {
		this.bikeParking = bikeParking;
	}

	public String getBikeParkingContext() {
		return bikeParkingContext;
	}

	public void setBikeParkingContext(String bikeParkingContext) {
		this.bikeParkingContext = bikeParkingContext;
	}

	public String getBikeParkingRemarks() {
		return bikeParkingRemarks;
	}

	public void setBikeParkingRemarks(String bikeParkingRemarks) {
		this.bikeParkingRemarks = bikeParkingRemarks;
	}

	public String getMotorcycleParking() {
		return motorcycleParking;
	}

	public void setMotorcycleParking(String motorcycleParking) {
		this.motorcycleParking = motorcycleParking;
	}

	public String getMotorcycleParkingContext() {
		return motorcycleParkingContext;
	}

	public void setMotorcycleParkingContext(String motorcycleParkingContext) {
		this.motorcycleParkingContext = motorcycleParkingContext;
	}

	public String getMotorcycleParkingRemarks() {
		return motorcycleParkingRemarks;
	}

	public void setMotorcycleParkingRemarks(String motorcycleParkingRemarks) {
		this.motorcycleParkingRemarks = motorcycleParkingRemarks;
	}

	public String getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getTotalContractDuration() {
		return totalContractDuration;
	}

	public void setTotalContractDuration(String totalContractDuration) {
		this.totalContractDuration = totalContractDuration;
	}

	public String getPropertyDeliveryDate() {
		return propertyDeliveryDate;
	}

	public void setPropertyDeliveryDate(String propertyDeliveryDate) {
		this.propertyDeliveryDate = propertyDeliveryDate;
	}
	
	
	
	
	

}
