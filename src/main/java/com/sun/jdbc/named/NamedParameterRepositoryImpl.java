package com.sun.jdbc.named;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.sun.spring.jdbc.model.City;

public class NamedParameterRepositoryImpl implements NamedParameterRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public City getCityById(int cityId) {
		final String sql = "select * from city where id=:cityId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("cityId", cityId);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
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
	
	/*@Override
	public City getCityById(int cityId) {
		final String sql = "select * from city where id=:cityId";
		Map<String, Integer> namedParameters = Collections.singletonMap("cityId", cityId);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
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
	}*/

}
