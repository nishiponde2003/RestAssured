package RA_tests;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Req_PUT {

	public static HashMap<String , Object> map= new HashMap<String, Object>();
	int pathParam=2;
	
	@BeforeClass
public void bodyPayload() {
//	{
//	    "name": "morpheus",
//	    "job": "zion resident"
//	}
	map.put("name", "morpheus");
	map.put("job", "zion resident");

	JSONObject body=new JSONObject(map);
	System.out.println(body.toJSONString());
	baseURI="https://reqres.in/api";
    basePath="/users/"+	pathParam;

}

@Test
public void testPUT() {
	given()
	    .accept(ContentType.JSON).contentType(ContentType.JSON)
	    .body(map)
	.when()
	    .put()
	.then()
	    .statusCode(200)
	    .log().all();
}
}
