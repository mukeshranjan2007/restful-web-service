package com.rest.webservice.restfulwebservice.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
public class FilteringController {
	
	
	@GetMapping(path = "/filtering")
	public MappingJacksonValue retriveAllParameter(){
		
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;

	}
	
	@GetMapping(path = "/filteringList")
	public MappingJacksonValue retriveAllParameterList(){
		
		List<SomeBean> list = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),
				new SomeBean("Value12", "Value22", "Value33"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		mappingJacksonValue.setFilters(filters);
		return  mappingJacksonValue;
		
	}
	
	
	

}
