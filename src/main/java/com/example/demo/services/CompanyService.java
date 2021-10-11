package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Company;
import com.example.demo.models.RankingComp;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.RankingCompRepository;


@Service
public class CompanyService {

	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	RankingCompRepository rankingCompRepository;
	
	public ArrayList<Company> obtenerCompanias(){
        return (ArrayList<Company>) companyRepository.findAll();
    }
	 
	public Company CompaybyID(Long comid){
        return companyRepository.findById(comid).get();
    }

	
	public ArrayList<RankingComp> obtenerRanking(){
        return (ArrayList<RankingComp>) rankingCompRepository.findAll();
    }
	
	
}
