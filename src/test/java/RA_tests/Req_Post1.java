package RA_tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;


import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Req_Post1 {

	Map<String, Object> map=new HashMap<String, Object>();
	
	@BeforeClass
	public void post_data() {
		
		map.put("name","Nishikant");
		map.put("trip", "250");
		map.put("airline", "5");
		
		baseURI="https://api.instantwebtools.net/";
		basePath="v1/passenger";
	}
	
	@Test
	public void testPost() {
		
		JSONObject body=new JSONObject(map);//**Remember: This is the correct sequence to prepare JSON body using map in order to maintain order of insertion in to the HashMap.
		System.out.println(body.toJSONString());
		
		given()
		  .accept(ContentType.JSON).contentType(ContentType.JSON)
		  .body(body.toJSONString())
		.when()
		  .post()
		.then()
		   .statusCode(200)
		   .body("airline[0].name",equalTo("Eva Air"))
		   .log().all();
	}
	//before staging.
	
}
