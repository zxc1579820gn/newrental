package com.reinext.rental.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinext.rental.entity.AllPrefectures;
import com.reinext.rental.repository.AllPrefecturesDao;
import com.reinext.rental.service.ifs.AllPrefecturesService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AllPrefecturesServiceImpl implements AllPrefecturesService{
    @Autowired
    private AllPrefecturesDao allPrefecturesDao;

    @Override
    public List<String> getAllPrefectures() {
        // 全ての都道府県データを取得
        List<AllPrefectures> allPrefecturesList = allPrefecturesDao.findAll();
        // もし都道府県データが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            return Collections.emptyList();
        }
        // 都道府県データから都道府県名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> prefectureData.getPrefectures().replaceAll("^\"|\"$", ""))
                .filter(prefecture -> !prefecture.isEmpty()) // nullを避ける
                .distinct() // 重複を防ぐ
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> getAllCities() {
        // 全ての都道府県データを取得
        List<AllPrefectures> allPrefecturesList = allPrefecturesDao.findAll();
        // もし都道府県データが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            return Collections.emptyList();
        }
        // 各都道府県データから市区町村名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> prefectureData.getCitiesWardsTownsVillages().replaceAll("^\"|\"$", ""))
                .filter(prefecture -> !prefecture.isEmpty()) // nullを避ける
                .distinct() // 重複を防ぐ
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> getAllCitiesByPrefecture(String prefecture) {
        // 指定した都道府県に基づいて市区町村データを取得
        List<AllPrefectures> allPrefecturesList = allPrefecturesDao.findAllCitiesWardsTownsVillagesByPrefectures(prefecture);
        // もし市区町村データが存在しないか空であれば、空のリストを返す
        if (allPrefecturesList == null || allPrefecturesList.isEmpty()) {
            System.out.println("TARGET NOT FOUND");
            return Collections.emptyList();
        }
        // 各市区町村データから市区町村名を抽出し、不正な記号を避ける
        return allPrefecturesList.stream()
                .map(prefectureData -> prefectureData.getCitiesWardsTownsVillages().replaceAll("^\"|\"$", ""))
                .filter(prefectureValue -> !prefectureValue.isEmpty())// nullを避ける
                .distinct() // 重複を防ぐ
                .collect(Collectors.toList());
    }
    

    
    
    
    
}
