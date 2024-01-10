package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.EquipmentTelematicsStatusPayloads;

public class EuipmentTelematicsStatusStepDefs {
	Logger logger = LogManager.getLogger(EuipmentTelematicsStatusStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
	@Given("check the TelematicsStatus by using vin {string} and customerId {string}")
	public void fetch_TheEquipementTelematicsStatus_Details(String vin, String customerId) {
		logger.info("Getting the Equipment telematics status Details for the vin number " + vin + " and customerId " + customerId);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentTelematicsStatusPayloads.getEquipmentTelematicsStatus(vin, customerId)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement telematics status Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Then("Verify the TelematicsStatus statuscode {string} in response body")
	public void verify_The_TelematicsStatus_Statuscode_In_Response_Body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}

	
	@Given("check the TelematicsStatus by using customerId {string}")
	public void fetch_the_TelematicsStatus_details_using_customer_id(String customerId) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the Equipment telematics status Details for the customerId " + customerId);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentTelematicsStatusPayloads.getEquipmentTelematicsStatusWithOnlyCustomerId(customerId)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement telematics status Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Given("check the TelematicsStatus by using vin {string}")
	public void fetch_the_TelematicsStatus_details_using_vin_id(String vin) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the Equipment telematics status Details for the vin number " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentTelematicsStatusPayloads.getEquipmentTelematicsStatusBodyWithOnlyVin(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement telematics status Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Then("validate the error message for the customerId")
	public void customerIdErrorMessage() {
		Assert.assertTrue(response.getBody().asString().contains("Please provide either Customer ID or customerGRId"));
		String jsonString = response.asString();
		System.out.println("ResponseBody: " + jsonString);
		System.out.println("Expected Message: " + "Please provide either Customer ID or customerGRId");
	}
	}
