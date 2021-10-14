package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
//@Table(name = "companies")
public class Company {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long company_id;
	private String company_name;
	private String latitude;
	private String longitude;
	private String logo_file;
	
	private String about;
	
	private String founders;
	private Long err;
	
	
	public Company() {
		super();
	}
/*	
	public Company(Long company_id, String company_name, String web_site, String logourl) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.web_site = web_site;
		this.logourl = logourl;
	}
*/


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


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLogo_file() {
		return logo_file;
	}


	public void setLogo_file(String logo_file) {
		this.logo_file = logo_file;
	}




	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}



	public String getFounders() {
		return founders;
	}


	public void setFounders(String founders) {
		this.founders = founders;
	}


	public Long getErr() {
		return err;
	}


	public void setErr(Long err) {
		this.err = err;
	}



	
	
	
}
