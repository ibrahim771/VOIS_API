package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Steps {
	String BASE_URL = "http://www.colourlovers.com";
	String BASE_Path = "/api/patterns";
	Response response;
	RequestSpecification request;
	int num ;
	 
	@Given("User set the base URL for ColoursLovers")
	public void SetBaseURL() {
		RestAssured.baseURI  = BASE_URL;
		RestAssured.basePath = BASE_Path;
		request = RestAssured.given();		
	}
	
	@When("User send request to GET Pattern")
	public void SendGETRequest() {
		response = request.header("User-Agent", "MyAppName").cookie("troute", "t1").get("/api/patterns");
	}

	@Then("User validate the numViews Greater than 4000")
	public void ValidatenumViews() {
		int count = response.xmlPath().getInt("patterns.pattern.numViews.size()");
		System.out.println(count);
		for(int i=0;i<count;i++) {
			num = response.xmlPath().getInt("patterns.pattern["+i+"].numViews");
			System.out.println(num);
			Assert.assertTrue((num)>4000);
			}
	}

}
