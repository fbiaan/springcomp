package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ranking20")
public class Ranking20 {
	@Id 
	private Long company_id;
	private String company_name;
	private String country;
	private Long score;
	private String logo_file;
	
	
	public Ranking20() {
		super();
	}
	
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getLogo_file() {
		return logo_file;
	}
	public void setLogo_file(String logo_file) {
		this.logo_file = logo_file;
	}
	
	
	
	
	
}
