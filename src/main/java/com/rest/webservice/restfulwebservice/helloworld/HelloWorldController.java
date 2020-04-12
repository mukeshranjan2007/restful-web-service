package com.rest.webservice.restfulwebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
//GET
//URI /hello-world
//method "hello"
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hello-world")
	public String hello() {
		return "HelloWorld";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloBean() {
		return new HelloWorldBean("Hello Bean");
	}
	
	@GetMapping(path = "/hello-world/path-varriable/{name}")
	public HelloWorldBean helloBeanPathVarriable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello, %s", name));
	}
	

	@GetMapping(path = "/hello-world-international")
	public String helloWorldInternational() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	

}
