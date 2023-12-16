package com.reinext.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinext.rental.service.ifs.AllPrefecturesService;
import com.reinext.rental.service.ifs.PMDetail1Service;


@Controller
public class AllPrefecturesController {
	
	@Autowired
	private AllPrefecturesService allPrefecturesService;
	
	 
    @GetMapping("/get_all_cities")
    public String getAllCities(Model model) {
        List<String> cities = allPrefecturesService.getAllCities();
        model.addAttribute("cities", cities);
        return "sample"; 
    }//http://localhost:8081/get_all_cities
    
    @GetMapping("/get_all_prefectures")
    @ResponseBody
    public List<String> getAllPrefectures() {
    	// 都道府県のリストを返す
        return allPrefecturesService.getAllPrefectures();
    }
	
    @GetMapping("/get_all_city_by_prefectures")
    public String getAllCitiesByPrefecture(@RequestParam(name = "prefecture") String prefecture, Model model) {
    	// 都道府県に属するすべての市町村を取得
        List<String> cities = allPrefecturesService.getAllCitiesByPrefecture(prefecture);
        // モデルに都道府県と市町村のリストを追加
        model.addAttribute("prefecture", prefecture);
        model.addAttribute("cities", cities);
        // 表示するビューの名前を返す
        return "showCity"; 
    }
    
    @GetMapping("/get_all_city_by_prefectures_value")
    @ResponseBody
    public List<String> getAllCitiesByPrefecture(@RequestParam(name = "prefecture") String prefecture) {
    	// 都道府県に属するすべての市町村を取得
    	List<String> cities =allPrefecturesService.getAllCitiesByPrefecture(prefecture);
    	// 取得した市町村のリストをJSON形式で直接返す
        return  cities;
    }

}
