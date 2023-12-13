package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reinext.rental.entity.LineAndStation;

public interface LineAndStationDao extends JpaRepository<LineAndStation, Integer>{

    // 県名に基づいて路線名と駅名を取得するメソッド
	// List<LineAndStation> findLineNameAndStationNameByPrefName(String prefName);
    @Query(value = "SELECT STATION_CD, STATION_NAME, LINE_CD, LINE_NAME, PREF_NAME, ADDRESS FROM line_and_station WHERE PREF_NAME = :prefName", nativeQuery = true)
    List<LineAndStation> findLineNameAndStationNameByPrefName(@Param("prefName") String prefName);

    // 路線名のリストに基づいて駅名を取得するメソッド
	// List<LineAndStation> findStationNameByLineNameIn(List<String> lineName);
    @Query(value = "SELECT STATION_CD, STATION_NAME, LINE_CD, LINE_NAME, PREF_NAME, ADDRESS FROM line_and_station WHERE LINE_NAME IN :lineNames", nativeQuery = true)
    List<LineAndStation> findStationNameByLineNameIn(@Param("lineNames") List<String> lineNames);

    // 住所の一部に基づいて路線名と駅名を取得するメソッド
	// List<LineAndStation> findLineNameAndStationNameByAddressContaining(String address);
    @Query(value = "SELECT STATION_CD, STATION_NAME, LINE_CD, LINE_NAME, PREF_NAME, ADDRESS FROM line_and_station WHERE ADDRESS LIKE %:address%", nativeQuery = true)
    List<LineAndStation> findLineNameAndStationNameByAddressContaining(@Param("address") String address);

    // 路線名に基づいて駅名を取得するメソッド
	// List<LineAndStation> findByLineName(String lineName);
    @Query(value = "SELECT STATION_CD, STATION_NAME, LINE_CD, LINE_NAME, PREF_NAME, ADDRESS FROM line_and_station WHERE LINE_NAME = :lineName", nativeQuery = true)
    List<LineAndStation> findByLineName(@Param("lineName") String lineName);

    // 路線コードに基づいて駅名を取得するメソッド
	// List<LineAndStation> findByLineCd(int lineCd);
    @Query(value = "SELECT STATION_CD, STATION_NAME, LINE_CD, LINE_NAME, PREF_NAME, ADDRESS FROM line_and_station WHERE LINE_CD = :lineCd", nativeQuery = true)
    List<LineAndStation> findByLineCd(@Param("lineCd") int lineCd);

    // 路線名に基づいて駅名を取得するメソッド
	//List<LineAndStation> findStationNameByLineName(String lineName);
    @Query(value = "SELECT STATION_CD, STATION_NAME, LINE_CD, LINE_NAME, PREF_NAME, ADDRESS FROM line_and_station WHERE LINE_NAME = :lineName", nativeQuery = true)
    List<LineAndStation> findStationNameByLineName(@Param("lineName") String lineName);






}
