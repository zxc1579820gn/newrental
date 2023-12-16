package com.reinext.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinext.rental.repository.LineAndStationDao;
import com.reinext.rental.req.LineReq;
import com.reinext.rental.req.StationReq;
import com.reinext.rental.service.ifs.AllPrefecturesService;
import com.reinext.rental.service.ifs.LineAndStationService;
import com.reinext.rental.service.ifs.PMDetail1Service;

@Controller
public class LineAndStationController {

	@Autowired
	private LineAndStationService lineAndStationService;
	

	
	@Autowired
	private LineAndStationDao lineAndStationDao;
	

	

    

    
    @GetMapping("/get_line_by_prefectures")
    public String getLineNamesByPrefecture(@RequestParam(name = "prefecture") String prefecture, Model model) {
    	// 都道府県に属するすべての路線名を取得
        List<String> lineNames = lineAndStationService.getLineNameByPrefName(prefecture);
     // 取得した路線名のリストと都道府県名をビューに追加
        model.addAttribute("prefecture", prefecture);
        model.addAttribute("lineNames", lineNames);
     // 路線情報を表示するビュー（"showLine"）を返す
        return "showLine"; 
    }
    
    @GetMapping("/manager_get_line_by_prefectures")
    public String managerGetLineNamesByPrefecture(@RequestParam(name = "prefecture") String prefecture, Model model) {
    	// 都道府県に属するすべての路線名を取得
    	List<String> lineNames = lineAndStationService.getLineNameByPrefName(prefecture);
    	// 取得した路線名のリストと都道府県名をビューに追加
    	model.addAttribute("prefecture", prefecture);
        model.addAttribute("lineNames", lineNames);
     // 路線情報を表示するビュー（"managerShowLine"）を返す
        return "managerShowLine"; 
    }
    
    @GetMapping("/get_line_by_address_containing")
    public String getLineNameByAddressContaining(@RequestParam(name = "address") String address, Model model) {
    	// 都道府県に属するすべての路線名を取得
    	List<String> lineNames = lineAndStationService.getLineNameByAddressContaining(address);
     // 取得した路線名のリストと都道府県名をビューに追加
        model.addAttribute("address", address);
        model.addAttribute("lineNames", lineNames);
     // 路線情報を表示するビュー（"managerShowLine"）を返す
        return "managerShowLine"; 
    }
    
    @GetMapping("/get_line_by_address_containing_value")
    @ResponseBody
    public List<String> getLineNameByAddressContainingValue(@RequestParam(name = "address") String address, Model model) {
    	// 特定のアドレスを含むすべての路線名を取得
    	List<String> lineNames = lineAndStationService.getLineNameByAddressContaining(address);
    	// 取得した路線名のリストを直接 JSON レスポンスとして返す
        return lineNames;
    }
    
    @GetMapping("/get_station_by_line_list")
    @ResponseBody
    public List<String>getStationNamesByLineNameList(@RequestParam(name = "lineName") List<String> lineName, Model model) {
    	// 特定のアドレスを含むすべての路線名を取得
    	List<String> stationNames = lineAndStationService.getStationNameByLineName(lineName);
    	// 取得した路線名のリストを直接 JSON レスポンスとして返す
    	return stationNames;
    }
    
    @GetMapping("/get_station_by_line")
    @ResponseBody
    public List<String>getStationNamesByLineName(@RequestParam(name = "lineName") String lineName, Model model) {
    	// 提供された路線名に対応する駅名を取得
    	List<String> stationNames = lineAndStationService.getStationNameByLineName(lineName);
    	// 取得した駅名のリストをJSON形式で直接返す
    	return stationNames;
    }
    
    @PostMapping(value = "/addLine")
    @ResponseBody
    public ResponseEntity<String> addLine(@RequestBody LineReq lineRequest) {
        // フォームから送信されたデータを受け取る
        String stationName = lineRequest.getStationName();  // 駅名
        int lineCd = lineRequest.getLineCd();  // 路線コード
        String lineName = lineRequest.getLineName();  // 路線名
        String prefName = lineRequest.getPrefName();  // 都道府県名
        String address = lineRequest.getAddress();  // 住所
        try {
            // 路線が既に存在しているか確認
            if (!lineAndStationDao.findByLineCd(lineCd).isEmpty()) {
                return new ResponseEntity<>("同じコードの路線が既に存在しています", HttpStatus.CONFLICT);
            }
            // lineAndStationService の addLine メソッドを呼び出して新しい路線を追加
            lineAndStationService.addLine(stationName, lineCd, lineName, prefName, address);
            // 成功した場合、成功メッセージとHTTPステータスコード200を返す
            return new ResponseEntity<>("路線が正常に追加されました", HttpStatus.OK);
        } catch (Exception e) {
            // 例外が発生した場合、エラーメッセージとHTTPステータスコード400を返す
            return new ResponseEntity<>("路線の追加中にエラーが発生しました: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping(value = "/addStationToLine")
    @ResponseBody
    public ResponseEntity<String> addStationToLine(@RequestBody StationReq stationRequest) {
        // フォームから送信されたデータを受け取る
        String stationName = stationRequest.getStationName();  // 駅名
        String lineName = stationRequest.getLineName();  // 路線名
        String address = stationRequest.getAddress();  // 住所
        try {
            // lineAndStationService の addStationToLine メソッドを呼び出して新しい駅を路線に追加
            lineAndStationService.addStationToLine(stationName, lineName, address);
            // 成功した場合、成功メッセージとHTTPステータスコード200を返す
            return new ResponseEntity<>("駅が正常に路線に追加されました", HttpStatus.OK);
        } catch (Exception e) {
            // 例外が発生した場合、エラーメッセージとHTTPステータスコード400を返す
            return new ResponseEntity<>("駅を路線に追加中にエラーが発生しました: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
