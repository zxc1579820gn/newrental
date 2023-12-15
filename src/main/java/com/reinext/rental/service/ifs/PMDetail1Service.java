package com.reinext.rental.service.ifs;

import com.reinext.rental.entity.PMDetail1;


public interface PMDetail1Service {

	void savePropertyDetail(PMDetail1 propertyDetail);

	PMDetail1 getPropertyDetailById(int id);

}
