package com.sun.jdbc.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import com.sun.spring.jdbc.model.City;

public class SpringJDBCBatchUpdateExample3 {

	 private JdbcTemplate jdbcTemplate;
		
	public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
	}

    public int[][] batchUpdate() {
    	final List<City> cities = FileUtil.loadCities();
    	int[][] updateCounts = jdbcTemplate.batchUpdate(
        		"insert into city_new(id, name,countryCode,district,population) values (?,?,?,?,?)",
        		cities,
                100,
                new ParameterizedPreparedStatementSetter<City>() {
                    public void setValues(PreparedStatement ps, City argument) throws SQLException {
                    	 ps.setLong(1, argument.getId());
                         ps.setString(2, argument.getName());
                         ps.setString(3, argument.getCountryCode());
                         ps.setString(4, argument.getDistrict());
                         ps.setLong(5, argument.getPopulation());
                    }
                });
        return updateCounts;
    }
}
