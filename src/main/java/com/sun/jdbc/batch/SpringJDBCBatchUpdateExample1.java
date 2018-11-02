package com.sun.jdbc.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.spring.jdbc.model.City;

public class SpringJDBCBatchUpdateExample1 {

   private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int[] batchUpdate() {
		final List<City> cities = FileUtil.loadCities();
        return this.jdbcTemplate.batchUpdate(
                "insert into city_new (ID, Name,CountryCode,District,Population) values (?,?,?,?,?)",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, cities.get(i).getId());
                        ps.setString(2, cities.get(i).getName());
                        ps.setString(3, cities.get(i).getCountryCode());
                        ps.setString(4, cities.get(i).getDistrict());
                        ps.setLong(5, cities.get(i).getPopulation());
                    }
                    public int getBatchSize() {
                        return cities.size();
                    }
                });
    }
}
