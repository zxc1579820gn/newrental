package com.reinext.rental.req;

public class StationReq {
	
    private String stationName;
    
    private String lineName;
    
    private String address;

    
    
    
    
    
    
    
	public StationReq(String stationName, String lineName, String address) {
		super();
		this.stationName = stationName;
		this.lineName = lineName;
		this.address = address;
	}

	public StationReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
  
    
    
    
    
    
    
    
    
}
