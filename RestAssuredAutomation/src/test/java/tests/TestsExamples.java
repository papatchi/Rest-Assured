package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestsExamples {

	@Test
	public void test_1() {
		//Response response = RestAssured.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1");
		Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());		
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_2() {
		baseURI = "http://demo.guru99.com/V4/sinkministatement.php?/results";
				given().get("CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").
				then().statusCode(200).
				body(".statements[1].TRANSACTION_ID",equalTo(23))
				.log().all();
	}
}
