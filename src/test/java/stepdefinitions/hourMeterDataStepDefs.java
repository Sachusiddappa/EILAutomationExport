package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.HourMeterDataPayloads;
import payloads.TelematicVehicleDataPayloads;

public class hourMeterDataStepDefs {
	Logger logger = LogManager.getLogger(hourMeterDataStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;

	@Given("Fetch the hourmeterdata data details using vin {string}")
	public void fetch_the_hourmeterdata_data_details_using_vin_number(String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the hourmeterdata Details for the vin " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(HourMeterDataPayloads.getHourmeterDataBody(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved hourmeterdata Details");
		logger.info("Response Body is:" + jsonString);
	}

	@Then("Verify the hourmeterdata statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}

	@Given("Fetch the hourmeterdata data details with multiple vin {string}")
	public void fetch_the_hourmeterdata_details_with_multiple_vin_number(String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the hourmeterdata Details for the multiple vin numbers " + vin);
		String[] vinNumbers = vin.split(",");

		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(HourMeterDataPayloads.getHourmeterDataBody(vinNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Hour meter data Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Verify retrieved response is having Hour Meter Data response")
	public void validateHourMeterDataResponse() {
		Assert.assertTrue(response.asString().contains("hourMeterData"));
	}
	
	@Given("Validate the error message {string} in the hourMeterData service")
	public void validateErrorMessage(String message) {
		Assert.assertTrue(response.asString().contains(message));
	}
	
	@Given("Verify vin numbers {string} are present in the response")
	public void verifyVinNumbers(String vins) {
		String vinNumbers[]=vins.split(",");
		String responseValue=response.asString();
		for(String vin:vinNumbers) {
			Assert.assertTrue("Vin "+vin+"number is not present in the response "+responseValue,responseValue.contains(vin));
		}	
	}
}

