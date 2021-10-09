package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.services.CompanyService;

@RestController
@RequestMapping("/democompany") 
public class CompanyController {
	@Autowired
    CompanyService companyService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin
	@GetMapping("/listar")
	    public ArrayList<Company> obtenerCompanias(){
			return companyService.obtenerCompanias();
	}
	@GetMapping
		public String Saludo() {
			return "HOLA COMPANIES";
	}

	
	public List<String>  getCompanias() {
		String sql = "select company_id, company_name from test.companies";
		//String sql = "select * from test.companies";
		List<Map<String, Object>> listMapQuery = jdbcTemplate.queryForList(sql);
		List<String> singerList = new ArrayList<>();
		listMapQuery.forEach(singer -> singerList.add(singer.toString()));
		return singerList;
}

	
	@GetMapping("/query")
	public List<String> query() {
		return getCompanias();
	}
}
