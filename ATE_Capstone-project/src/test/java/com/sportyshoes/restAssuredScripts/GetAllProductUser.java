package com.sportyshoes.restAssuredScripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllProductUser {
	@Test(priority='1')
	public void get_all_Register_User()
	{
		RestAssured
		.given()
		.baseUri("http://localhost:9010")
		.basePath("/get-users")
	    .when()
	    .get()
	    
	    .then()
	   
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 ")
	    .header("Content-Type","application/json")
	   
	    .log().all();
	}
}
