package com.reinext.rental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.PMDetail1;

@Repository
public interface PMDetail1Dao extends JpaRepository<PMDetail1,  Integer>{

	PMDetail1 findByPmId(int pmId);

    @Query("SELECT p FROM PMDetail1 p WHERE p.pmId = :pmid")
    Optional<PMDetail1> findByPmId1(@Param("pmid") int pmid);

    @Query("SELECT p.id FROM PMDetail1 p WHERE p.pmId = :pmid")
    int findIdByPmId(@Param("pmid") int pmid);


}
