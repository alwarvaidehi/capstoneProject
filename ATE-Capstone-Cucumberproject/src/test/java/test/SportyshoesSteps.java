package test;

import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class SportyshoesSteps {
	
	@Given("user  Retrieve the list of all products in the store.")
	public void user_retrieve_the_list_of_all_products_in_the_store() {
	
		RestAssured
     		.given()
		.baseUri("http://localhost:9010")
		.basePath("/get-shoes")
	    .when()
	    .get()
	    .then()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 ")
	    .header("Content-Type","application/json")
	    .log().headers()
  		.log().ifError()
  		.log().cookies()
	    .log().all();
		
	}

	@Then("user 	Retrieve the list of all registered users.")
	public void user_retrieve_the_list_of_all_registered_users() {
		RestAssured.given()
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

	@When("user 	Add the product.")
	public void user_add_the_product() {
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

	@Then("user 	Update the product")
	public void user_update_the_product() {
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

	@Then("user Delete the product.")
	public void user_delete_the_product() {
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
