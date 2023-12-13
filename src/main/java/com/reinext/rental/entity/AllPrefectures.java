package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "allprefectures")//データベーステーブルの名前は "allprefectures"
public class AllPrefectures {
	
    @Id
    @Column(name = "STANDARD_AREA_CODE") // 主キー、データベーステーブルの "STANDARD_AREA_CODE" 列に対応
    private String standardAreaCode; // 標準地域コード（Standard Area Code）
    
    @Column(name = "PREFECTURES") // データベーステーブルの "PREFECTURES" 列に対応
    private String prefectures; // 県名（Prefecture Name）
    
    @Column(name = "CITIES_WARDS_TOWNS_VILLAGES") // データベーステーブルの "CITIES_WARDS_TOWNS_VILLAGES" 列に対応
    private String citiesWardsTownsVillages; // 市区町村（Cities, Wards, Towns, Villages）
    
    @Column(name = "CITIES_WARDS_TOWNS_VILLAGES_(FURIGANA)") // データベーステーブルの "CITIES_WARDS_TOWNS_VILLAGES_(FURIGANA)" 列に対応
    private String citiesWardsTownsVillagesFurigana; // 市区町村（ふりがな）（Cities, Wards, Towns, Villages - Furigana）
    
    
    
    
    

	public AllPrefectures(String standardAreaCode, String prefectures, String citiesWardsTownsVillages,
			String citiesWardsTownsVillagesFurigana) {
		super();
		this.standardAreaCode = standardAreaCode;
		this.prefectures = prefectures;
		this.citiesWardsTownsVillages = citiesWardsTownsVillages;
		this.citiesWardsTownsVillagesFurigana = citiesWardsTownsVillagesFurigana;
	}

	public AllPrefectures() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStandardAreaCode() {
		return standardAreaCode;
	}

	public void setStandardAreaCode(String standardAreaCode) {
		this.standardAreaCode = standardAreaCode;
	}

	public String getPrefectures() {
		return prefectures;
	}

	public void setPrefectures(String prefectures) {
		this.prefectures = prefectures;
	}

	public String getCitiesWardsTownsVillages() {
		return citiesWardsTownsVillages;
	}

	public void setCitiesWardsTownsVillages(String citiesWardsTownsVillages) {
		this.citiesWardsTownsVillages = citiesWardsTownsVillages;
	}

	public String getCitiesWardsTownsVillagesFurigana() {
		return citiesWardsTownsVillagesFurigana;
	}

	public void setCitiesWardsTownsVillagesFurigana(String citiesWardsTownsVillagesFurigana) {
		this.citiesWardsTownsVillagesFurigana = citiesWardsTownsVillagesFurigana;
	}
    
    
    

}
