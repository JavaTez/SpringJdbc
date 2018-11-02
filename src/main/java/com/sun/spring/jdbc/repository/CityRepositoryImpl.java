package com.sun.spring.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSetMetaData;
import com.sun.spring.jdbc.model.City;


public class CityRepositoryImpl implements CityRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<City> getAllCountries() {
		return jdbcTemplate.query("select * from city",
				new RowMapper<City>() {
					public City mapRow(ResultSet rs, int rowNum) throws SQLException {
						City  country = new City();
						country.setId(rs.getInt("ID"));
						country.setName(rs.getString("Name"));
						country.setCountryCode(rs.getString("CountryCode"));
						country.setDistrict(rs.getString("District"));
						country.setPopulation(rs.getLong("Population"));
						return country;
					}
				});
	}

	@Override
	public int getCityCount() {
		return jdbcTemplate.queryForObject("select count(*) from city", Integer.class);
	}

	@Override
	public int getCityCountByCountryCode(final String countryCode) {
		return jdbcTemplate.queryForObject("select count(*) from city where CountryCode = ?", Integer.class,countryCode);
	}

	@Override
	public long getPopulationByCountryAndCity(String countryCode, String cityName) {
		return jdbcTemplate.queryForObject("select population from city where CountryCode = ? and name = ?", 
				Long.class,new Object[]{countryCode,cityName});
	}

	@Override
	public int addCity(final City city) {
		//
		 int cityId = jdbcTemplate.queryForObject("select max(id) from  city", Integer.class); 
		//
		return jdbcTemplate.update("insert into city (id, name,CountryCode, district, population)"+
				 " value (?,?,?,?,?)",
				new Object[]{++cityId, "Mahabubabad","IND","Warangal",100000});
	}

	@Override
	public int updateCity(final int cityId,final String district) {
		return jdbcTemplate.update("update city set district=? where id=?", new Object[]{district,cityId});
	}
	
	@Override
	public int removeCity(final int cityId) {
		return this.jdbcTemplate.update(
		        "delete from city where id = ?",
		        Long.valueOf(cityId));
	}

	@Override
	public City getCityById(int cityId) {
		return  jdbcTemplate.queryForObject("select * from city where id=?",new Object[]{cityId},
				new RowMapper<City>() {
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				City  country = new City();
				country.setId(rs.getInt("ID"));
				country.setName(rs.getString("Name"));
				country.setCountryCode(rs.getString("CountryCode"));
				country.setDistrict(rs.getString("District"));
				country.setPopulation(rs.getLong("Population"));
				return country;
			}});
	}

	@Override
	public void createTable() {
		this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
	}

	@Override
	public void dropTable() {
		this.jdbcTemplate.execute("drop table mytable");
	}
	
}
