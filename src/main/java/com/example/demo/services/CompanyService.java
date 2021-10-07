package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Company;
import com.example.demo.repositories.CompanyRepository;

@Service
public class CompanyService {

	
	@Autowired
	CompanyRepository companyRepository;
	
	public ArrayList<Company> obtenerCompanias(){
        return (ArrayList<Company>) companyRepository.findAll();
    }
	 
}
