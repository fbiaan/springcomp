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
import org.springframework.web.bind.annotation.RequestParam;
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
			res.put("return", r);
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
		String sql = "select * from InsyteGlobalB2B.company_score_view  limit 20";
		return jdbcTemplate.queryForList(sql);
}

	public List getcompAll() {
		String sql = "select * from InsyteGlobalB2B.company";
	
		return jdbcTemplate.queryForList(sql);
}
	
	@GetMapping("/allcomp")
	public Map<String, Object> getcompAll1() {
		return executeService(() -> {
			return getcompAll();
			
		});
	}

	
	public List getOneComp(String idcom) {
		String sql = "select * from InsyteGlobalB2B.company " +
					"where company_id = " + idcom ;
	
		return jdbcTemplate.queryForList(sql);
}
	
	@GetMapping("/onecompani")
	public Map<String, Object> getOnecompani(@RequestParam (value="idcom") String idcom) {
		return executeService(() -> {
			return getOneComp(idcom);
			
		});
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

	// investment
	
	public List getInvesOver(String idcom) {
		String sql ="select\r\n"
				+ "    `c`.`COMPANY_ID` AS `COMPANY_ID`,\r\n"
				+ "    `c`.`COMPANY_NAME` AS `COMPANY_NAME`,\r\n"
				+ "    `o`.`OUTPUT_NAME` AS `OUTPUT_NAME`,\r\n"
				+ "    `sc`.`TEXT_VALUE` AS `TEXT_VALUE`\r\n"
				+ "from\r\n"
				+ "    (((`InsyteGlobalB2B`.`company` `c`\r\n"
				+ "join `InsyteGlobalB2B`.`SO_COMPANY` `sc` on\r\n"
				+ "    (`c`.`COMPANY_ID` = `sc`.`COMPANY_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT` `so` on\r\n"
				+ "    (`so`.`SO_ID` = `sc`.`SO_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`OUTPUT` `o` on\r\n"
				+ "    (`o`.`OUTPUT_ID` = `so`.`OUTPUT_ID`))\r\n"
				+ "where\r\n"
				+ "    `so`.`OUTPUT_ID` in (1,\r\n"
				+ "    2,\r\n"
				+ "    3,\r\n"
				+ "    4,\r\n"
				+ "    5,\r\n"
				+ "    6,\r\n"
				+ "    7) and `c`.COMPANY_ID = " + idcom ;
	
		return jdbcTemplate.queryForList(sql);
}
	
	@GetMapping("/invesover")
	public Map<String, Object> getInvesOver1(@RequestParam (value="idcom") String idcom) {
		return executeService(() -> {
			return getInvesOver(idcom);
			
		});
	}	
	
	// companies overview

	public List getCompOver(String idcom) {
		String sql ="select\r\n"
				+ "    `c`.`COMPANY_ID` AS `COMPANY_ID`,\r\n"
				+ "    `c`.`COMPANY_NAME` AS `COMPANY_NAME`,\r\n"
				+ "    `o`.`OUTPUT_ID` AS `OUTPUT_ID`,\r\n"
				+ "    `o`.`OUTPUT_NAME` AS `OUTPUT_NAME`,\r\n"
				+ "    `sc`.`VALUE` AS `VALUE`\r\n"
				+ "from\r\n"
				+ "    ((((`InsyteGlobalB2B`.`OUTPUT` `o`\r\n"
				+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT` `so` on\r\n"
				+ "    (`o`.`OUTPUT_ID` = `so`.`OUTPUT_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT_KPI` `sok` on\r\n"
				+ "    (`sok`.`SO_ID` = `so`.`SO_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`SOK_COMPANY` `sc` on\r\n"
				+ "    (`sc`.`SOK_ID` = `sok`.`SOK_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`company` `c` on\r\n"
				+ "    (`c`.`COMPANY_ID` = `sc`.`COMPANY_ID`)) \r\n"
				+ "    where `c`.COMPANY_ID = " + idcom ;
	
		return jdbcTemplate.queryForList(sql);
}
	
	@GetMapping("/companyover")
	public Map<String, Object> getCompOver1(@RequestParam (value="idcom") String idcom) {
		return executeService(() -> {
			return getCompOver(idcom);
			
		});
	}	

	// teck stack overview

	public List getTeckOver(String idcom) {
		String sql ="select\r\n"
				+ "    `c`.`COMPANY_ID` AS `COMPANY_ID`,\r\n"
				+ "    `c`.`COMPANY_NAME` AS `COMPANY_NAME`,\r\n"
				+ "    `o`.`OUTPUT_ID` AS `OUTPUT_ID`,\r\n"
				+ "    `o`.`OUTPUT_NAME` AS `OUTPUT_NAME`,\r\n"
				+ "    `sc`.`VALUE` AS `VALUE`\r\n"
				+ "from\r\n"
				+ "    (((((`InsyteGlobalB2B`.`OUTPUT` `o`\r\n"
				+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT` `so` on\r\n"
				+ "    (`o`.`OUTPUT_ID` = `so`.`OUTPUT_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT_KPI` `sok` on\r\n"
				+ "    (`sok`.`SO_ID` = `so`.`SO_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`SOK_COMPANY` `sc` on\r\n"
				+ "    (`sc`.`SOK_ID` = `sok`.`SOK_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`company` `c` on\r\n"
				+ "    (`c`.`COMPANY_ID` = `sc`.`COMPANY_ID`))\r\n"
				+ "join `InsyteGlobalB2B`.`OUTPUT_TYPE` `ot` on\r\n"
				+ "    (`ot`.`OUTPUT_ID` = `o`.`OUTPUT_ID`))\r\n"
				+ "where\r\n"
				+ "    `ot`.`TYPE_ID` = 5  and  `c`.COMPANY_ID =" + idcom ;
	
		return jdbcTemplate.queryForList(sql);
}
	
	@GetMapping("/teckover")
	public Map<String, Object> getTeckOver1(@RequestParam (value="idcom") String idcom) {
		return executeService(() -> {
			return getTeckOver(idcom);
			
		});
	}		

//----- digital  performance


public List getDigitalOver(String idcom) {
	String sql ="select\r\n"
			+ "    `c`.`COMPANY_ID` AS `COMPANY_ID`,\r\n"
			+ "    `c`.`COMPANY_NAME` AS `COMPANY_NAME`,\r\n"
			+ "    `o`.`OUTPUT_ID` AS `OUTPUT_ID`,\r\n"
			+ "    `o`.`OUTPUT_NAME` AS `OUTPUT_NAME`,\r\n"
			+ "    `sc`.`VALUE` AS `VALUE`\r\n"
			+ "from\r\n"
			+ "    (((((`InsyteGlobalB2B`.`OUTPUT` `o`\r\n"
			+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT` `so` on\r\n"
			+ "    (`o`.`OUTPUT_ID` = `so`.`OUTPUT_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT_KPI` `sok` on\r\n"
			+ "    (`sok`.`SO_ID` = `so`.`SO_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`SOK_COMPANY` `sc` on\r\n"
			+ "    (`sc`.`SOK_ID` = `sok`.`SOK_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`company` `c` on\r\n"
			+ "    (`c`.`COMPANY_ID` = `sc`.`COMPANY_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`OUTPUT_TYPE` `ot` on\r\n"
			+ "    (`ot`.`OUTPUT_ID` = `o`.`OUTPUT_ID`))\r\n"
			+ "where\r\n"
			+ "    `ot`.`TYPE_ID` = 2 and `c`.COMPANY_ID =" + idcom ;

	return jdbcTemplate.queryForList(sql);
}

@GetMapping("/digiover")
public Map<String, Object> getDigitalOver2(@RequestParam (value="idcom") String idcom) {
	return executeService(() -> {
		return getDigitalOver(idcom);
		
	});
}		

//   --- talent

public List getTalentOver(String idcom) {
	String sql ="select\r\n"
			+ "    `c`.`COMPANY_ID` AS `COMPANY_ID`,\r\n"
			+ "    `c`.`COMPANY_NAME` AS `COMPANY_NAME`,\r\n"
			+ "    `o`.`OUTPUT_ID` AS `OUTPUT_ID`,\r\n"
			+ "    `o`.`OUTPUT_NAME` AS `OUTPUT_NAME`,\r\n"
			+ "    `sc`.`VALUE` AS `VALUE`\r\n"
			+ "from\r\n"
			+ "    (((((`InsyteGlobalB2B`.`OUTPUT` `o`\r\n"
			+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT` `so` on\r\n"
			+ "    (`o`.`OUTPUT_ID` = `so`.`OUTPUT_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`SOURCE_OUTPUT_KPI` `sok` on\r\n"
			+ "    (`sok`.`SO_ID` = `so`.`SO_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`SOK_COMPANY` `sc` on\r\n"
			+ "    (`sc`.`SOK_ID` = `sok`.`SOK_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`company` `c` on\r\n"
			+ "    (`c`.`COMPANY_ID` = `sc`.`COMPANY_ID`))\r\n"
			+ "join `InsyteGlobalB2B`.`OUTPUT_TYPE` `ot` on\r\n"
			+ "    (`ot`.`OUTPUT_ID` = `o`.`OUTPUT_ID`))\r\n"
			+ "where\r\n"
			+ "    `ot`.`TYPE_ID` = 4  and `c`.COMPANY_ID =" + idcom ;

	return jdbcTemplate.queryForList(sql);
}

@GetMapping("/talentover")
public Map<String, Object> getTalentOver2(@RequestParam (value="idcom") String idcom) {
	return executeService(() -> {
		return getTalentOver(idcom);
		
	});
}		


}
