package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.RankingComp;




@Repository
public interface RankingCompRepository extends CrudRepository<RankingComp, Long> {	
	
}	
	

