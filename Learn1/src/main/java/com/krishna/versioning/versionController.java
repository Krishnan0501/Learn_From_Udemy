package com.krishna.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versionController {
	@GetMapping("/v1/person")
	public person1 getPerson1() {
		return new person1("krishna");
	}
	@GetMapping("/v2/person")
	public person2 getPerson2() {
		return new person2(new Name("krishna","perumal"));
	}
	@GetMapping(path="/person", params="version1")
	public person1 getPerson1requestparam() {
		return new person1("krishna");
	}
	@GetMapping(path="/person",params="version2")
	public person2 getPerson2requestparam() {
		return new person2(new Name("krishna","perumal"));
	}
	@GetMapping(path="/person/header",headers ="X-API-VERSION=1")
	public person1 getPerson1requestheader() {
		return new person1("krishna");
	}
	@GetMapping(path="/person/header",headers="X-API-VERSION=2")
	public person2 getPerson2requestheader() {
		return new person2(new Name("krishna","perumal"));
	}

}
