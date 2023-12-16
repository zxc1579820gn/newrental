package com.reinext.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinext.rental.entity.PMDetail1;
import com.reinext.rental.repository.LineAndStationDao;
import com.reinext.rental.req.LineReq;
import com.reinext.rental.req.StationReq;
import com.reinext.rental.service.ifs.AllPrefecturesService;
import com.reinext.rental.service.ifs.LineAndStationService;
import com.reinext.rental.service.ifs.PMDetail1Service;

@Controller
public class MainController {
	
	 @RequestMapping(value = "/home")
	 public void home() {
	 };
	 @RequestMapping(value = "/manager")
	 public void manager() {
	 };
	 @RequestMapping(value = "/client")
	 public void client() {
	 };
	 //PM=PropertyManagement 
	 @RequestMapping(value = "/PMmanager")
	 public void PMmanager() {
	 };
	 //PM=PropertyManagement 
	 @RequestMapping(value = "/creatPMmanager")
	 public void creatPMmanager() {
	 };
	//PM=PropertyManagement 
	 @RequestMapping(value = "/PMclient")
	 public void PMclient() {
	 };
	 @GetMapping("/showDetailPMclient/{buildingId}")
	 public String showDetailPMclient(@PathVariable(name = "buildingId") Long buildingId, Model model) {
	     // 处理逻辑，将数据放入模型
	     return "showDetailPMclient"; // 返回Thymeleaf模板的名称
	 }
	 @GetMapping("/showDtailPMmanager/{buildingId}")
	 public String showDetailPMmanager(@PathVariable(name = "buildingId") Long buildingId, Model model) {
	     // 处理逻辑，将数据放入模型
	     return "showDetailPMmanager"; // 返回Thymeleaf模板的名称
	 }
	 

    
    
    
    
    

    
    
    
    
    
    
}
