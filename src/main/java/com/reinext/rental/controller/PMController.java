package com.reinext.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinext.rental.entity.PM;
import com.reinext.rental.entity.PMDetail1;
import com.reinext.rental.service.ifs.PMService;

@Controller
public class PMController {
	
	@Autowired
	private PMService pmService;
	
	   @PostMapping("/save_pm")
	    public ResponseEntity<String> savePMWithPMDetail1(@RequestBody PMDetail1 pmDetail1) {
	        try {
	        	pmService.savePMWithPMDetail1(pmDetail1);
	            return new ResponseEntity<>("PM and PMDetail1 saved successfully", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error saving PM and PMDetail1: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }
	    @GetMapping("/get_all_pm")
	    @ResponseBody
	    public List<PM> getAllPM() {
	        return pmService.getAllPM();
	    }
	    
	   @PostMapping("/update_pm")
	    public ResponseEntity<String> updatePMWithPMDetail1(@RequestBody PMDetail1 pmDetail1) {
	        try {
	        	pmService.updatePMWithPMDetail1(pmDetail1);
	            return new ResponseEntity<>("PM and PMDetail1 saved successfully", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error saving PM and PMDetail1: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }


}
