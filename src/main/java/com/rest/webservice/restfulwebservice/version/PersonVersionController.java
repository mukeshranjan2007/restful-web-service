package com.rest.webservice.restfulwebservice.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	
	//Factors(URI POLLUTION,MISSUE OF HTTP HEADERS,Caching,Can we execute by browser,API Documentation)
	

	//URI Versioning
	
	//Twitter
	@GetMapping("v1/person")
	public PersonV1 personV1() {

		return new PersonV1("Mukesh Ranjan");

	}
   
	@GetMapping("v2/person")
	public PersonV2 personV2() {

		return new PersonV2(new Name("Mukesh","Ranjan"));

	}
	
	//Request Versioning
	//Amazon
	
	@GetMapping(value = "/person/param", params="version=1")
	public PersonV1 paramV1() {

		return new PersonV1("Mukesh Ranjan");

	}
   

	@GetMapping(value = "/person/param", params="version=2")
	public PersonV2 paramV2() {

		return new PersonV2(new Name("Mukesh","Ranjan"));

	}
	
	//Accept Header Versioning
	
	//Microsoft
	@GetMapping(value = "/person/header", headers ="X-API-VERSION=1")
	public PersonV1 headerV1() {

		return new PersonV1("Mukesh Ranjan");

	}
   
	@GetMapping(value = "/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {

		return new PersonV2(new Name("Mukesh","Ranjan"));

	}
	
	//Mime Tyep  Versioning Or media Type 
	//GitHub
	
	
	@GetMapping(value = "/person/produces", produces ="application/company-v1+json")
	public PersonV1 producesV1() {

		return new PersonV1("Mukesh Ranjan");

	}
   
	@GetMapping(value = "/person/produces", produces="application/company-v2+json")
	public PersonV2 producesV2() {

		return new PersonV2(new Name("Mukesh","Ranjan"));

	}

}
