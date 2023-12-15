package com.reinext.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.reinext.rental.entity.PMDetail1;
import com.reinext.rental.service.ifs.PMDetail1Service;
import com.reinext.rental.service.ifs.PMService;

@Controller
public class PMDetail1Controller {
	
	@Autowired
	private PMDetail1Service pmDetail1Service;
	@Autowired
	private PMService pmService;
	
    @PostMapping("/save_pm_detail1")
    public ResponseEntity<String> savePropertyDetail(@RequestBody PMDetail1 propertyDetail, Model model) {
        try {
            // 調用 PMDetail1Service 保存物業詳細信息
            pmDetail1Service.savePropertyDetail(propertyDetail);
            // 在模型中添加成功消息
            model.addAttribute("successMessage", "Property detail saved successfully");
            // 你可以添加其他的模型属性，以便在Thymeleaf中使用
            return new ResponseEntity<>("Property detail saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            // 發生異常時返回錯誤信息
            model.addAttribute("errorMessage", "Error saving property detail: " + e.getMessage());
            return new ResponseEntity<>("Error saving property detail: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @PostMapping("/save_pm")
    public ResponseEntity<String> savePMWithPMDetail1(@RequestBody PMDetail1 pmDetail1) {
        try {
        	pmService.savePMWithPMDetail1(pmDetail1);
            return new ResponseEntity<>("PM and PMDetail1 saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving PM and PMDetail1: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
