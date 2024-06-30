package com.krishna.Filtering;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Static_Filtering {
	@GetMapping("/staticfilter")
	public Bean filter() {
		return new Bean("value1","value2","value3");
	}
	@GetMapping("/staticfilter/list")
	public List<Bean> ListFilter() {
		return Arrays.asList(new Bean("value1","value2","value3"),new Bean("value1","value2","value3"));
	}
	@GetMapping("/dynamicfilter")
	public MappingJacksonValue dynamicfilter() {
		Bean bean=new Bean("value1","value2","value3");
		
		MappingJacksonValue mappingjacksonvalue=new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter simplebeanpropertyfilter= SimpleBeanPropertyFilter.serializeAllExcept("field1");
		FilterProvider filter=new SimpleFilterProvider().addFilter("somebeanfilter", simplebeanpropertyfilter);
		mappingjacksonvalue.setFilters(filter) ;
		return mappingjacksonvalue;
	}
	 
	

}
