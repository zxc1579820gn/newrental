package com.reinext.rental.service.impl;

import java.util.List;
import java.util.Optional;

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
    public List<PM> getAllPM() {
        return  pmDao.findAll();
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
    
    @Override
    public void updatePMWithPMDetail1(PMDetail1 pmDetail1) {
    	    // 获取 PM_ID
    	    int pmId = pmDetail1.getPmId();
    	    // 根據pmId获取pmDetail1的id
    	    int pmDId =pmDetail1Dao.findIdByPmId(pmId);
    	  //將 pmDId設定到 PMDetail1
    	    pmDetail1.setId(pmDId);
            // getPMData() 可以取得需要的 PM 相關資料
            PM pmData = pmDetail1.getPMData();
            // 創建新的 PM 物件
            PM pm = new PM();
            // 將需要的資料從 PMData 複製到 PM
            pm.setId(pmId);
            pm.setBuildingName(pmData.getBuildingName());
            pm.setResidenceAddress(pmData.getResidenceAddress());
            pm.setBuildingType(pmData.getBuildingType());
            pm.setFloorArea(pmData.getFloorArea());
            pm.setOtherFloorArea(pmData.getOtherFloorArea());
            pm.setLineName(pmData.getLineName());
            pm.setStationName(pmData.getStationName());
            // 儲存 PM
             pmDao.save(pm);
    	    // 保存更新后的 PMDetail1 对象（包括关联的 PM 对象）
    	    pmDetail1Dao.save(pmDetail1);
    }
    
    @Override
    public void deletePMAndPMDetail1(int pmId) {
        // 根據 PM ID 取得對應的 PM
        PM pm = pmDao.findById(pmId);

        if (pm != null) {
            // 根據 PM ID 取得對應的 PMDetail1
            PMDetail1 pmDetail1 = pmDetail1Dao.findByPmId(pmId);
            if (pmDetail1 != null) {
                // 刪除 PMDetail1
                pmDetail1Dao.delete(pmDetail1);
            }
            // 刪除 PM
            pmDao.delete(pm);
        }
    }


}
