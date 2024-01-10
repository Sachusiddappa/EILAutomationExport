package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.TelematicsDataPayloads;

public class TelematicsDataStepDefs {
	Logger logger = LogManager.getLogger(TelematicsVehicleDataStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
	
	@Given("Fetch the TelematicsData details using vin {string}")
	public void fetch_the_TelematicsData_details_using_vin_number(String vin) {
		logger.info("Getting the TelematicData Details for the vin " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsDataPayloads.getTelematicsDataBody(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsData Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Then("Verify the TelematicsData statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}
	@Given("Fetch the TelematicsData details using multiple vin {string}")
	public void fetch_the_TelematicsData_details_with_multiple_vin_number(String vin) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the TelematicData Details for the multiple vin numbers " + vin);
		String[] vinNumbers=vin.split(",");
		
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsDataPayloads.getTelematicsDataBody(vinNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicData Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Given("Verify retrieved response is having telematicsData response")
	public void validateTelematicsDataResponse() {
		Assert.assertTrue(response.asString().contains("telematicsData"));
	}
	@Given("Validate the telematics error message {string} in the TelematicsData service")
	public void validateErrorMessage(String message) {
		Assert.assertTrue(response.asString().contains(message));
	}
	
	@Given("Verify vins {string} are present in response")
	public void checkVinNumber(String vins) {
		String vinNumbers[]=vins.split(",");
		String responseValue=response.asString();
		for(String vin:vinNumbers) {
			Assert.assertTrue("Vin "+vin+"number is not present in the response "+responseValue,responseValue.contains(vin));
		}	
	}
}