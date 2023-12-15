package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.PM;

@Repository
public interface PMDao extends JpaRepository<PM, Integer>{

}
