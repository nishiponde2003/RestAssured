package RA_tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.RestAssured.*;

public class Req_GET {
	
	
	
	@Test
 void testGET() {
	
	 given().
	    contentType(ContentType.JSON).accept(ContentType.JSON). 
	 when().
	    get("https://reqres.in/api/users/2").
	 then().
	    statusCode(200)
	   .statusLine("HTTP/1.1 200 OK")
	   .header("Content-Type", "application/json; charset=utf-8")
	   .assertThat().body("data.email", equalTo("janet.weaver@reqres.in")).log().all();
	   
	 //Response resp=get("https://gorest.co.in/public/v2/users");
	//System.out.println(resp.getBody().asString()) ; (to print the response body)
	 
	}
	
	@Test
	void getProducts() {
		given()
		    .accept(ContentType.JSON)
		    .contentType(ContentType.JSON)
		.when()
		    .get("https://dummyjson.com/products")
		.then()
		.statusCode(200)
		.header("Server","Cowboy")
		.assertThat().body("products[1].title",equalTo("iPhone X")).log().all();
	}
 }
