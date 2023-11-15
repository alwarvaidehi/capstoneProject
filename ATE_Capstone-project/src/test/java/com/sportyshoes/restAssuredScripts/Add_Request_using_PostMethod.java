package com.sportyshoes.restAssuredScripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Add_Request_using_PostMethod {

	@Test(priority='1')
	public void add_a_request()
	{
		RestAssured
		.given()
		.baseUri("http://localhost:9010/add-shoe")
		//.basePath("")
		.queryParam("id","888")
		.queryParam("image","www.image.com")
		.queryParam("name","sneaker")
		.queryParam("category","Running")
		.queryParam("sizes","6,7,8")
		.queryParam("price","5000")
		
	    .when()
	    .post()
	    .then()
	   .statusCode(200)
	   .log().cookies()
	    .log().all();
	}

}
