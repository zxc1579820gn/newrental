package com.reinext.rental.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reinext.rental.entity.LineAndStation;
import com.reinext.rental.errorcode.LineNotFoundException;
import com.reinext.rental.errorcode.StationNotFoundException;
import com.reinext.rental.repository.LineAndStationDao;
import com.reinext.rental.service.ifs.LineAndStationService;


@Service
public class LineAndStationServiceImpl implements LineAndStationService{
	
    @Autowired
    private LineAndStationDao lineAndStationDao;
    
    @Override
    public List<LineAndStation> getAllLineAndStations() {
        // 全ての路線と駅のデータを取得
        return lineAndStationDao.findAll();
    }

    @Override
    public List<String> getLineNameByPrefName(String prefName) {
        // 指定した県名に基づいて路線名のデータを取得
        List<LineAndStation> allPrefecturesList = lineAndStationDao.findLineNameAndStationNameByPrefName(prefName);
        // もしデータが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            System.out.println("TARGET NOT FOUND");
            return Collections.emptyList();
        }
        // 各データから路線名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> prefectureData.getLineName().replaceAll("^\"|\"$", ""))
                .filter(prefectureValue -> !prefectureValue.isEmpty()) // nullを避ける
                .distinct() // 重複を防ぐ
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getStationNameByLineName(List<String> lineName) {
        // 指定した路線名リストに基づいて駅名のデータを取得
        List<LineAndStation> allPrefecturesList = lineAndStationDao.findStationNameByLineNameIn(lineName);
        // もしデータが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            System.out.println("TARGET NOT FOUND");
            return Collections.emptyList();
        }
        // 各データから駅名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> {
                    String stationName = prefectureData.getStationName();
                    return (stationName != null) ? stationName.replaceAll("^\"|\"$", "") : null;
                }) // nullを避ける
                .filter(prefectureValue -> prefectureValue != null && !prefectureValue.isEmpty())
                .distinct() // 重複を防ぐ
                .collect(Collectors.toList());
    }
    
	@Override
	public List<String> getStationNameByLineName(String lineName) {
        // 指定した路線名リストに基づいて駅名のデータを取得
        List<LineAndStation> allPrefecturesList = lineAndStationDao.findStationNameByLineName(lineName);
        // もしデータが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            System.out.println("TARGET NOT FOUND");
            return Collections.emptyList();
        }
        // 各データから駅名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> {
                    String stationName = prefectureData.getStationName();
                    return (stationName != null) ? stationName.replaceAll("^\"|\"$", "") : null;
                }) // nullを避ける
                .filter(prefectureValue -> prefectureValue != null && !prefectureValue.isEmpty())
                .distinct() // 重複を防ぐ
                .collect(Collectors.toList());
	}
	
    @Override
    public List<String> getLineNameByAddressContaining(String address) {
        // 指定した住所を含むデータに基づいて路線名のデータを取得
        List<LineAndStation> allPrefecturesList = lineAndStationDao.findLineNameAndStationNameByAddressContaining(address);
        // もしデータが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            System.out.println("TARGET NOT FOUND");
            return Collections.emptyList();
        }
        // 各データから路線名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> prefectureData.getLineName().replaceAll("^\"|\"$", ""))
                .filter(prefectureValue -> !prefectureValue.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }
	
    @Override
    public void addLine(String stationName, int lineCd, String lineName, String prefName, String address) {
        // 既存の路線コードと路線名を確認
        List<LineAndStation> existingLine = lineAndStationDao.findByLineCd(lineCd);
        List<LineAndStation> existingLineName = lineAndStationDao.findByLineName(lineName);
        // 既存のデータが存在しない場合
        if (existingLine.isEmpty() && existingLineName.isEmpty()) {
            // 新しい路線データを作成して保存
            LineAndStation newLine = new LineAndStation();
            newLine.setStationName(stationName);
            newLine.setLineCd(lineCd);
            newLine.setLineName(lineName);
            newLine.setPrefName(prefName);
            newLine.setAddress(address);
            lineAndStationDao.save(newLine);
        } else {
            // 既存の路線または路線名が存在する場合、例外をスロー
            System.out.println("Existing Line Or LineName => " + " Existing LineCd : " + lineCd + " Existing LineName : " + lineName);
            throw new StationNotFoundException("Existing Line Or LineName => " + " Existing LineCd : " + lineCd + " Existing LineName : " + lineName);
        }
    }
    
    @Override
    public void addStationToLine(String stationName, String lineName, String address) {
        // 指定した路線名に基づいて既存のデータを取得
        List<LineAndStation> existingLine = lineAndStationDao.findByLineName(lineName);
        // もしデータが存在しない場合
        if (existingLine.isEmpty()) {
            System.out.println("Line not found =>  " +" LineName : " +lineName);
            // 該当する路線が見つからない場合、例外をスロー
            throw new LineNotFoundException("Line not found for LineName: " + lineName);
        }
        // 新しい駅データを作成して保存
        LineAndStation newStation = new LineAndStation(); 
        newStation.setStationName(stationName);
        newStation.setLineCd(existingLine.get(0).getLineCd());
        newStation.setLineName(lineName);
        newStation.setPrefName(existingLine.get(0).getPrefName());
        newStation.setAddress(address);
        lineAndStationDao.save(newStation);
    }





}
