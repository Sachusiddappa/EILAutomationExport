package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.TelematicVehicleDataPayloads;

public class TelematicsVehicleDataStepDefs {
	Logger logger = LogManager.getLogger(TelematicsVehicleDataStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
	@Given("Fetch the telematic vehicle data details using vin {string}")
	public void fetch_the_telematicVehicleData_details_using_vin_number(String vin) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the Telematic vehicle data Details for the vin " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicVehicleDataPayloads.getTelematicVehicleDataBody(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Telematic vehicle data Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Then("Verify the telematic vehicle data statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}
	
	@Given("Fetch the telematic vehicle data details with multiple vin {string}")
	public void fetch_the_telematicVehicleData_details_with_multiple_vin_number(String vin) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the Telematic vehicle data Details for the multiple vin numbers " + vin);
		String[] vinNumbers=vin.split(",");
		
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicVehicleDataPayloads.getTelematicVehicleDataBody(vinNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Telematic vehicle data Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Then("validate by passing empty and invalid value vin")
	public void validateData(String typeOfData) {
		
		if(typeOfData.equalsIgnoreCase("invalid")) {
			System.out.println(response.getBody().asString());
			Assert.assertTrue(response.getBody().asString().contains("[null]"));
		}else {
			Assert.assertTrue(response.getBody().asString().contains("vin"));
		}
	}
}
