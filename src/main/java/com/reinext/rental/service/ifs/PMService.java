package com.reinext.rental.service.ifs;

import java.util.List;

import com.reinext.rental.entity.PM;
import com.reinext.rental.entity.PMDetail1;

public interface PMService {

	void savePM(PM pm);

	void savePMWithPMDetail1(PMDetail1 pmDetail1);

	List<PM> getAllPM();

	void updatePMWithPMDetail1(PMDetail1 pmDetail1);

}
