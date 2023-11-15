package com.sportyshoes.restAssuredScripts;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdateRequest {

	@Test(priority='1')
	public void Update_a_request()
	{
		RestAssured
		.given()
		.baseUri("http://localhost:9010")
		.basePath("/update-shoe")
		.queryParam("id","888")
		.queryParam("image","www.image.com")
		.queryParam("name","Nike")
		.queryParam("category","Running")
		.queryParam("sizes","6,7")
		.queryParam("price","5000")
		
	    .when()
	    .put()
	    .then()
	   .statusCode(200)
	   .statusLine("HTTP/1.1 200 ")
	   .log().cookies()
	    .log().all()
		.body("code", equalTo(101),
				  "message", equalTo("Nike Updated Successfully."));
	}
}
