package com.sun.jdbc.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.sun.spring.jdbc.model.City;

public class SpringJDBCBatchUpdateExample2 {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	    return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
			this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	

	public int[] batchUpdate() {
		final List<City> cities = FileUtil.loadCities();
		return this.namedParameterJdbcTemplate.batchUpdate(
				"insert into city_new (ID, Name,CountryCode,District,Population) values (:id,:name,:countryCode,:district,:population)",
				SqlParameterSourceUtils.createBatch(cities));
	}

}
