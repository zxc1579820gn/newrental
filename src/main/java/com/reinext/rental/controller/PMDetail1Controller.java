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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinext.rental.entity.PM;
import com.reinext.rental.entity.PMDetail1;
import com.reinext.rental.service.ifs.PMDetail1Service;
import com.reinext.rental.service.ifs.PMService;

@Controller
public class PMDetail1Controller {
	
	@Autowired
	private PMDetail1Service pmDetail1Service;

	
    @PostMapping("/save_pm_detail1")
    public ResponseEntity<String> savePropertyDetail(@RequestBody PMDetail1 propertyDetail, Model model) {
        try {
            // 調用 PMDetail1Service 保存詳細信息
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
    @GetMapping("/get_pm_detail1_by_pmid/{pmId}")
    public ResponseEntity<PMDetail1> getPMByPmId(@PathVariable(name = "pmId") int pmId) {
        PMDetail1 pmDetail1 = pmDetail1Service.getPMByPmId(pmId);
        if (pmDetail1 != null) {
            return new ResponseEntity<>(pmDetail1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    
    
    
    
 
}
