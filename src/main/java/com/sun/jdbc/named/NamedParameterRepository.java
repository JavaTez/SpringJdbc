package com.sun.jdbc.named;

import com.sun.spring.jdbc.model.City;

public interface NamedParameterRepository {

	City getCityById(final int cityId);
}
