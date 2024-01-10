package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.EquipmentPayloads;
import payloads.GetEquipmentsByVinPayloads;

public class EquipmentStepDefs {
	Logger logger = LogManager.getLogger(EquipmentStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
	@Given("Fetch the equipment details using vin {string} and customerId {string}")
	public void fetchTheEquipementDetails(String vin, String customerId) {
		logger.info("Getting the Equipment Details for the vin number " + vin + " and customerId " + customerId);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentPayloads.getEquipmentDetailsBody(vin, customerId)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the equipment waranty details using vin {string} and customerId {string}")
	public void fetchTheEquipementWarantyDetails(String vin, String customerId) {
		logger.info("Getting the Equipment Details for the vin number " + vin + " and customerId " + customerId);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentPayloads.getEquipmentWarrantyDeatilsBody(vin, customerId)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the equipment waranty details using vin {string}")
	public void fetchTheEquipementWarantyDetailsByVIn(String vin) {
		logger.info("Getting the Equipment Details for the vin number " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentPayloads.getEquipmentWarrantyDeatilsBodyByVin(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the equipment waranty details using customerId {string}")
	public void fetchTheEquipementWarantyDetailsByCustomerId(String customerId) {
		logger.info("Getting the Equipment Details for the customerId " + customerId);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentPayloads.getEquipmentWarrantyDeatilsBody(customerId)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement Details");
		logger.info("Response Body is:" + jsonString);
	}
	

	@Then("Verify the statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}

	@Then("check retrieved data is {string}")
	public void validateData(String typeOfData) {
		
		if(typeOfData.equalsIgnoreCase("invalid")) {
			System.out.println(response.getBody().asString());
			Assert.assertTrue(response.getBody().asString().contains("[]"));
		}else {
			Assert.assertTrue(response.getBody().asString().contains("truckNo"));
		}
	}
	
	@Given("Fetch the equipemet details using customerId {string}")
	public void fetch_the_equipemet_details_using_customer_id(String customerId) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the Equipment Details for the customerId " + customerId);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentPayloads.getEquipmentDetailsBody(customerId)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the equipemet details using vin {string}")
	public void fetch_the_equipemet_details_using_vin_id(String vin) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the Equipment Details for the vin number " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(EquipmentPayloads.getEquipmentDetailsBodyByVin(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Equipement Details");
		logger.info("Response Body is:" + jsonString);
	}
	@Then("validate error message of customerId")
	public void customerIdErrorMessage() {
		Assert.assertTrue(response.getBody().asString().contains("Please provide either Customer ID or customerGRId"));
	}
	
	@Given("Verify retrieved response is having Equipment Data response")
	public void validateHourMeterDataResponse() {
		Assert.assertTrue(response.asString().contains("equipments"));
	}
	
	
}
