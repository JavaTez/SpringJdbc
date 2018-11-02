package com.sun.spring.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sun.jdbc.batch.SpringJDBCBatchUpdateExample1;
import com.sun.jdbc.batch.SpringJDBCBatchUpdateExample2;
import com.sun.jdbc.batch.SpringJDBCBatchUpdateExample3;
import com.sun.jdbc.named.NamedParameterRepository;
import com.sun.jdbc.named.NamedParameterRepositoryImpl;
import com.sun.spring.jdbc.repository.CityRepository;
import com.sun.spring.jdbc.repository.CityRepositoryImpl;

@Configuration
@PropertySource("classpath:jdbc-config.properties")
public class ApplicationConfig {
	
	@Value("${database.url}")
	private String URL; 
	
	@Value("${database.username}")
	private String USER_NAME;
	
	@Value("${database.password}")
	private String PASSWORD;
	
	@Value("${database.drivername}")
	private String driverName;
	
	@Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(mysqlDataSource());
	}
	
	@Bean 
	public CityRepository cityRepository(){
		return new CityRepositoryImpl();
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(mysqlDataSource());
	}
	
	@Bean 
	public NamedParameterRepository namedParameterRepository(){
		return new NamedParameterRepositoryImpl();
	}
	
	@Bean
	public SpringJDBCBatchUpdateExample1 batch1Demo(){
			return new SpringJDBCBatchUpdateExample1();
	}
	
	@Bean
	public SpringJDBCBatchUpdateExample2 batch2Demo(){
			return new SpringJDBCBatchUpdateExample2();
	}
	
	@Bean
	public SpringJDBCBatchUpdateExample3 batch3Demo(){
			return new SpringJDBCBatchUpdateExample3();
	}
	
}
