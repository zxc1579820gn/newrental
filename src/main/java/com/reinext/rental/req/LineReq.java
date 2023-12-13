package com.reinext.rental.req;

public class LineReq {
	
    private String stationName ;
    private int lineCd;
    private String lineName;
    private String prefName;
    private String address;
    
    
    
    
    
    
    
    
    
    
	public LineReq(String stationName, int lineCd, String lineName, String prefName, String address) {
		super();
		this.stationName = stationName;
		this.lineCd = lineCd;
		this.lineName = lineName;
		this.prefName = prefName;
		this.address = address;
	}
	public LineReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getLineCd() {
		return lineCd;
	}
	public void setLineCd(int lineCd) {
		this.lineCd = lineCd;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getPrefName() {
		return prefName;
	}
	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    

    
    

}
