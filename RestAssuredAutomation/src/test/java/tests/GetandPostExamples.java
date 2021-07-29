package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetandPostExamples {
	
	@Test
	public void testGet() {
		
		baseURI = "http://demo.guru99.com/V4";
		given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!").queryParam("Account_No", "1").
		when().get("/sinkministatement.php")
		.then().statusCode(200)
		.body("x[\"result:\"].statements[1].AMOUNT",equalTo(14))
		.body("x[\"result:\"].statements.TRANSACTION_ID",hasItems("25","12"));
		
	}
	
	@Test
	public void testPost() {		
		 
		 JSONObject request = new JSONObject();	 
		 request.put("name", "Raghav");
		 request.put("job","Teacher");
		 System.out.println(request);
		 System.out.println(request.toJSONString());
		 
		 baseURI = "https://reqres.in/api";
		 given().
		 header("Content-Type","application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		 when().
		 post("/users").
		 then().statusCode(201).log().all();
		 
		 
		
	}

}
