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
        // 這裡假設 PMDetail1 中有一個方法 getPMData() 可以取得需要的 PM 相關資料
        PM pmData = pmDetail1.getPMData();

        // 創建新的 PM 物件
        PM pm = new PM();
        // 將需要的資料從 PMData 複製到 PM
        pm.setBuildingName(pmData.getBuildingName());
        pm.setResidenceAddress(pmData.getResidenceAddress());
        pm.setBuildingType(pmData.getBuildingType());
        pm.setFloorArea(pmData.getFloorArea());
        pm.setOtherFloorArea(pmData.getOtherFloorArea());
        pm.setLineName(pmData.getLineName());
        pm.setStationName(pmData.getStationName());
        // 儲存 PM
        PM savedPM = pmDao.save(pm);

        // 將 PM_ID 設定到 PMDetail1
        pmDetail1.setPmId(savedPM.getId());

        // 儲存 PMDetail1
        pmDetail1Dao.save(pmDetail1);
    }

}
