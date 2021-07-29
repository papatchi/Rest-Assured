package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;


public class SoapXMLRequest {

	@Test
	public void validateSoapXML() throws IOException {
		
		File file = new File("./SoapRequest/add.xml");
		
		if(file.exists())
			System.out.println(">>File Exists");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
				
		
		RestAssured.baseURI = "http://www.dneonline.com";
				
				RestAssured.given().
				contentType("text/xml").
				accept(ContentType.XML).
				body("requestBody").
				when().post("/calculator.asmx").
				then().
				statusCode(200).log().all().
				and().body("//*:AddResult.text()", equalTo("5"))
				;
		
	}
	
}
