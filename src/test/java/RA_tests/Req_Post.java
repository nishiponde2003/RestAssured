package RA_tests;






import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Req_Post {

	public static HashMap<String, Object> map=new HashMap<String, Object>();
	@BeforeMethod
	public void TC001_data() {
		Reporter.log("TC001 execution started",true);

		//sample body:
//		{
//		    "name": "morpheus",
//		    "job": "leader"
//		}
		    map.put("name","morpheus");
		    map.put("job","leader");
		
		    baseURI="https://reqres.in/";
			basePath="api/users";
		   
	}
	
	@Test
	public void TC001_Post() {
		
		 //convert to JSON
        JSONObject body=new JSONObject(map);
    //print in JSON format
	    System.out.println(body.toJSONString());
	    
		given()
		  .accept(ContentType.JSON).contentType(ContentType.JSON)
		  .body(body.toJSONString())
		.when()
		   .post()
		.then()
		   .statusCode(200)
		   .log().all();
	}
	@AfterMethod
	   public void TC001_conclude() {
		Reporter.log("TC001 execution finished");
	}
	
	
	@BeforeMethod
		public void TC002_data() {
			Reporter.log("TC002 execution started",true);
			
			map.put("name","Nishikant");
			map.put("trip", "250");
			map.put("airline", "5");
			baseURI="https://api.instantwebtools.net/";
			basePath="v1/passenger";
		}
	
	@Test
	public void TC002_Post() {
		
		//Map<String, Object> map=new HashMap<String, Object>();
		
		
		JSONObject body=new JSONObject(map);//**Remember: This is the correct sequence to prepare JSON body using map in order to maintain order of insertion in to the HashMap.
		System.out.println(body.toJSONString());
	
		given()
		  .accept(ContentType.JSON).contentType(ContentType.JSON)
		  .body(body.toJSONString())
		.when()
		   .post()
		.then()
		   .statusCode(200)//error: response code is 200 when it should be 201 for a post request.
		   .body("airline[0].name",equalTo("Eva Air"))
		   .assertThat().body("airline[0].country",equalTo("Taiwan"))
		   .log().all();
	}

	@AfterMethod
	public void TC002_conclude() {
		Reporter.log("testPost execution finished", true);
	}
	
	
}
