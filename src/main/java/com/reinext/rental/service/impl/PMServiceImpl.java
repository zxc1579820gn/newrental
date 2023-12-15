package com.reinext.rental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinext.rental.entity.PM;
import com.reinext.rental.entity.PMDetail1;
import com.reinext.rental.repository.PMDao;
import com.reinext.rental.repository.PMDetail1Dao;
import com.reinext.rental.service.ifs.PMService;

@Service
public class PMServiceImpl  implements PMService{
	
	@Autowired
	private PMDao pmDao;
	@Autowired
	private PMDetail1Dao pmDetail1Dao;
	
    @Override
    public void savePM(PM pm) {
    	 pmDao.save(pm);
    }


    
    
    @Override
    public void savePMWithPMDetail1 (PMDetail1 pmDetail1) {
        // �o�̰��] PMDetail1 �����@�Ӥ�k getPMData() �i�H���o�ݭn�� PM �������
        PM pmData = pmDetail1.getPMData();

        // �Ыطs�� PM ����
        PM pm = new PM();
        // �N�ݭn����Ʊq PMData �ƻs�� PM
        pm.setBuildingName(pmData.getBuildingName());
        pm.setResidenceAddress(pmData.getResidenceAddress());
        pm.setBuildingType(pmData.getBuildingType());
        pm.setFloorArea(pmData.getFloorArea());
        pm.setOtherFloorArea(pmData.getOtherFloorArea());
        pm.setLineName(pmData.getLineName());
        pm.setStationName(pmData.getStationName());
        // �x�s PM
        PM savedPM = pmDao.save(pm);

        // �N PM_ID �]�w�� PMDetail1
        pmDetail1.setPmId(savedPM.getId());

        // �x�s PMDetail1
        pmDetail1Dao.save(pmDetail1);
    }

}
