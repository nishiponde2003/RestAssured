package RA_tests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Req_Delete {

	@BeforeMethod
	public void TC003_URI() {
		Reporter.log("TC003 execution started",true);
		baseURI="https://reqres.in/";
		basePath="api/users/2";
		
	}
	
	@Test
	public void TC003_delete() {
		given()
		   .contentType(ContentType.JSON).accept(ContentType.JSON)
		.when()
		   .delete()
		.then()
		   .statusCode(204).log().all();
		
	}
	
	@AfterMethod
	public void TC003_concluded() {
		Reporter.log("TC003 execution finished",true);
	}
}
