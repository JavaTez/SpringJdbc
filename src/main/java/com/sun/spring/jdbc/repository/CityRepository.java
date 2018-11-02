package com.sun.spring.jdbc.repository;

import java.util.List;

import com.sun.spring.jdbc.model.City;

public interface CityRepository {
	
	List<City> getAllCountries();
	
	int getCityCount();
	
	int getCityCountByCountryCode(final String countryCode);
	
	long getPopulationByCountryAndCity(final String countryCode, final String cityName);
	
	int addCity(final City city);
	
	int updateCity(final int cityId,final String district);
	
	int removeCity(final int cityId);
	
	City getCityById(final int cityId);
	
	void createTable();
	
	void dropTable();
}
