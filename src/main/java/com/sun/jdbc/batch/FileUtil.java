package com.sun.jdbc.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.sun.spring.jdbc.model.City;

public class FileUtil {

	public  static List<City> loadCities(){
		String fileName = "D:\\WorkSpace\\SpringJdbc\\src\\main\\resources\\Batch_update.txt";
		final List<City> cityList = new ArrayList<>();
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach((cityDetailsStr) -> {
				String[] cityDetailsArr = cityDetailsStr.split("\\|");
				final City city = new City();	
				city.setId(new Integer(cityDetailsArr[0]));
				city.setName(cityDetailsArr[1]);
				city.setCountryCode(cityDetailsArr[2]);
				city.setDistrict(cityDetailsArr[3]);
				city.setPopulation(new Long(cityDetailsArr[4]));
				cityList.add(city);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cityList;
	}
}
