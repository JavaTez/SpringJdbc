package com.sun.spring.jdbc.model;

public class City {

	private int id;
	
	private String name;
	
	private String countryCode;
	
	private String district;
	
	private long population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
	
}
