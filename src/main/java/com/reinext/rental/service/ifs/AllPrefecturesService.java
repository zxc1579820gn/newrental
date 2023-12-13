package com.reinext.rental.service.ifs;

import java.util.List;



public interface AllPrefecturesService {
    
    List<String> getAllPrefectures();

	List<String> getAllCities();

	List<String> getAllCitiesByPrefecture(String prefecture);


}
