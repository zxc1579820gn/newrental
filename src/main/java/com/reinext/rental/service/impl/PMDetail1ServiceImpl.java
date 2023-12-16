package com.reinext.rental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinext.rental.entity.PMDetail1;
import com.reinext.rental.repository.PMDetail1Dao;
import com.reinext.rental.service.ifs.PMDetail1Service;

@Service
public class PMDetail1ServiceImpl implements PMDetail1Service{
	
	@Autowired
	private PMDetail1Dao pmDetail1Dao;
	
    @Override
    public void savePropertyDetail(PMDetail1 propertyDetail) {
    	pmDetail1Dao.save(propertyDetail);
    }

    @Override
    public PMDetail1 getPMByPmId(int pmId) {
        return pmDetail1Dao.findByPmId(pmId);
    }
	
	
	
	

}
