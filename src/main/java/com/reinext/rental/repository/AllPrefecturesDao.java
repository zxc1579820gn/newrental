package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reinext.rental.entity.AllPrefectures;



public interface AllPrefecturesDao extends JpaRepository<AllPrefectures, String>{

    // 都道府県に基づいて市区町村を取得するメソッド
	//	List<AllPrefectures> findAllCitiesWardsTownsVillagesByPrefectures(String prefecture);
	@Query(value = "SELECT * FROM allprefectures WHERE PREFECTURES = :prefecture", nativeQuery = true)
    List<AllPrefectures> findAllCitiesWardsTownsVillagesByPrefectures(@Param("prefecture") String prefecture);

    // 部分一致で都道府県に基づいて市区町村を取得するメソッド
	//	List<AllPrefectures> findAllCitiesWardsTownsVillagesByPrefecturesContaining(String prefecture);
    @Query(value = "SELECT * FROM allprefectures WHERE PREFECTURES LIKE %:prefecture%", nativeQuery = true)
    List<AllPrefectures> findAllCitiesWardsTownsVillagesByPrefecturesContaining(@Param("prefecture") String prefecture);
}
