package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.models.Ranking20;
import com.example.demo.models.RankingComp;
import com.example.demo.services.CompanyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/democompany") 
public class CompanyController {
	
	public interface RestServiceExecution {

		public Object execute() throws Exception;
		
	}
	public Map<String, Object> executeService(RestServiceExecution e) {
		Map<String, Object> res = new HashMap<>();
		try {
			Object r = e.execute();
			res.put("", r);
		} catch (Exception e2) {
			
			res.put("result", "Error");
			res.put("error", e2.getMessage());
		}
		return res;
	}
	
	@Autowired
    CompanyService companyService;
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@CrossOrigin(origins = "http://localhost:3000")

	@GetMapping("/listar")
	    public ArrayList<Company> obtenerCompanias(){
			return companyService.obtenerCompanias();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/buscaxid/{id}")
    public Company CompaybyID(@PathVariable("id") long id){
		return companyService.CompaybyID(id);
}

	
	@GetMapping
		public String Saludo() {
			return "HOLA COMPANIES";
	}

	
	public List<String>  getCompanias() {
		String sql = "select company_id, company_name from company";
		//String sql = "select * from test.companies";
		List<Map<String, Object>> listMapQuery = jdbcTemplate.queryForList(sql);
		List<String> singerList = new ArrayList<>();
		listMapQuery.forEach(singer -> singerList.add(singer.toString()));
		return singerList;
}

	
	public Map<String, Object> getRanking() {
		String sql = "select company_id, company_name from company";
		return jdbcTemplate.queryForMap(sql);
}

	public List getRanking4() {
		String sql = "select company_id, company_name, country, score, logo_file  from InsyteGlobalB2B.company \r\n"
				+ "order by score desc LIMIT 20 ";
		return jdbcTemplate.queryForList(sql);
}
	
	
	@GetMapping("/query")
	public List<String> query() {
		return getCompanias();
		//return getRanking();
	}

	@GetMapping("/ranking44")
	public Map<String, Object> getRankingcomp() {
		return executeService(() -> {
			return getRanking4();
			
		});
	}
	
	
	@GetMapping("/ranking")
    public ArrayList<RankingComp> obtenerRanking(){
		return companyService.obtenerRanking();
}

	@GetMapping("/ranking20")
    public ArrayList<Ranking20> obtenerRanking20(){
		return companyService.obtenerRanking20();
}
	
}
