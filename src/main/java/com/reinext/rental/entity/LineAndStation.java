package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "line_and_station")// データベーステーブルの名前は "line_and_station"
public class LineAndStation{
	
    @Id
    @Column(name = "STATION_CD") // 主キー、データベーステーブルの "STATION_CD" 列に対応
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーの自動生成、データベースの自動増分ストラテジーを使用
    private int stationCd; // 駅コード

    @Column(name = "STATION_NAME") // データベーステーブルの "STATION_NAME" 列に対応
    private String stationName; // 駅名

    @Column(name = "LINE_CD") // データベーステーブルの "LINE_CD" 列に対応
    private int lineCd; // 路線コード

    @Column(name = "LINE_NAME") // データベーステーブルの "LINE_NAME" 列に対応
    private String lineName; // 路線名

    @Column(name = "PREF_NAME") // データベーステーブルの "PREF_NAME" 列に対応
    private String prefName; // 県名

    @Column(name = "ADDRESS") // データベーステーブルの "ADDRESS" 列に対応
    private String address; // 住所
    
    
    
    
    
    
    
    
    




	public LineAndStation(int stationCd, String stationName, int lineCd, String lineName,
			String prefName, String address) {
		super();
		this.stationCd = stationCd;
		this.stationName = stationName;
		this.lineCd = lineCd;
		this.lineName = lineName;
		this.prefName = prefName;
		this.address = address;
	}

	public LineAndStation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStationCd() {
		return stationCd;
	}

	public void setStationCd(int stationCd) {
		this.stationCd = stationCd;
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
