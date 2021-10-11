package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long company_id;
	private String company_name;
	private String latitude;
	private String longitude;
	private String logo_file;
	private String web_site;
	private String about;
	private String founded_date;
	private String founders;
	private Long err;
	private Long noi;
	private Long tfa;
	private String tfc;
	private Long tfcd; 
	private Long nofr;
	private Long noa;
	private String noe;
	private Long noli; 
	private Long pg;
	private Long tr;
	private String bwatc;
	private String city;
	private String state;
	private String country;
	private String region;
	private String hq_location;
	private String industry_groups;
	private Long score;
	
	
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


	public String getWeb_site() {
		return web_site;
	}


	public void setWeb_site(String web_site) {
		this.web_site = web_site;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getFounded_date() {
		return founded_date;
	}


	public void setFounded_date(String founded_date) {
		this.founded_date = founded_date;
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


	public Long getNoi() {
		return noi;
	}


	public void setNoi(Long noi) {
		this.noi = noi;
	}


	public Long getTfa() {
		return tfa;
	}


	public void setTfa(Long tfa) {
		this.tfa = tfa;
	}


	public String getTfc() {
		return tfc;
	}


	public void setTfc(String tfc) {
		this.tfc = tfc;
	}


	public Long getTfcd() {
		return tfcd;
	}


	public void setTfcd(Long tfcd) {
		this.tfcd = tfcd;
	}


	public Long getNofr() {
		return nofr;
	}


	public void setNofr(Long nofr) {
		this.nofr = nofr;
	}


	public Long getNoa() {
		return noa;
	}


	public void setNoa(Long noa) {
		this.noa = noa;
	}


	public String getNoe() {
		return noe;
	}


	public void setNoe(String noe) {
		this.noe = noe;
	}


	public Long getNoli() {
		return noli;
	}


	public void setNoli(Long noli) {
		this.noli = noli;
	}


	public Long getPg() {
		return pg;
	}


	public void setPg(Long pg) {
		this.pg = pg;
	}


	public Long getTr() {
		return tr;
	}


	public void setTr(Long tr) {
		this.tr = tr;
	}


	public String getBwatc() {
		return bwatc;
	}


	public void setBwatc(String bwatc) {
		this.bwatc = bwatc;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getHq_location() {
		return hq_location;
	}


	public void setHq_location(String hq_location) {
		this.hq_location = hq_location;
	}


	public String getIndustry_groups() {
		return industry_groups;
	}


	public void setIndustry_groups(String industry_groups) {
		this.industry_groups = industry_groups;
	}


	public Long getScore() {
		return score;
	}


	public void setScore(Long score) {
		this.score = score;
	}	
	
	
	
	
}
