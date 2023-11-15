package com.sportyshoes.restAssuredScripts;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteProduct {
	@Test
	public void deleteProduct()
	{
	RestAssured.given()
	.baseUri("http://localhost:9010")
	.basePath("/delete-shoe") 
	.queryParam("id", "1444") 
	. when().delete() 

	. then().log().all()
	.statusCode(200)
	.statusLine("HTTP/1.1 200 ")
	   .log().cookies()
	    .log().all()
		.body("code", equalTo(101),
				  "message", equalTo("Shoe with ID 1444 Deleted Successfully."));

}
}
