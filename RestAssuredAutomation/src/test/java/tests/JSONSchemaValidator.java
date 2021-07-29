package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
	@Test
	public void get() {
		
		baseURI = "http://localhost:3000/";
		
		given().get("/users").then().
		assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);
		
	}
	

}
