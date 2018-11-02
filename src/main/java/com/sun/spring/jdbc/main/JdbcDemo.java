package com.sun.spring.jdbc.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sun.jdbc.batch.SpringJDBCBatchUpdateExample3;
import com.sun.spring.jdbc.config.ApplicationConfig;

public class JdbcDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationConfig.class);
		context.refresh();
		
		//CityRepository repository = context.getBean("cityRepository", CityRepository.class);
		
		/*List<City> countryList = repository.getAllCountries();
		countryList.forEach(System.out::println);*/		
		
		//System.out.println(repository.getCityCount());
		
		//System.out.println(repository.getCityCountByCountryCode("IND"));
		
		//System.out.println("Hyderabad Population : "+repository.getPopulationByCountryAndCity("IND","Hyderabad"));
		
		//System.out.println("The Number of Rows saved in DataBase : "+repository.addCity(null));
		
		//City city = repository.getCityById(4080);
		//System.out.println(city);
		
		//System.out.println("The Number of Rows updated in DataBase : "+repository.updateCity(4080,"Mahabubabad"));
		
        //System.out.println("The Number of Rows deleted in DataBase : "+repository.removeCity(4080));
		
		//repository.createTable();
		
		//repository.dropTable();
		
		/*NamedParameterRepository repo = context.getBean("namedParameterRepository",NamedParameterRepository.class);
		City city = repo.getCityById(1);
		System.out.println(city);*/
		
		
		//Spring batch
		
		// Example 1
		/*SpringJDBCBatchUpdateExample1 demo = context.getBean(SpringJDBCBatchUpdateExample1.class);
		int[] updateCount = demo.batchUpdate();
		for(int countForBatch:updateCount){
			System.out.println("Count For Batch : "+countForBatch);
		}*/
		
		// Example 2
		/*SpringJDBCBatchUpdateExample2 demo = context.getBean(SpringJDBCBatchUpdateExample2.class);
		int[] updateCount = demo.batchUpdate();
		for(int countForBatch:updateCount){
			System.out.println("Count For Batch : "+countForBatch);
		}*/
		
		
		SpringJDBCBatchUpdateExample3 demo = context.getBean(SpringJDBCBatchUpdateExample3.class);
		int[][] updatedCountArrs = demo.batchUpdate();
		System.out.println(updatedCountArrs.length);
	}
}
