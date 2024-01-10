package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.HourMeterDataPayloads;
import payloads.ImpactDataPayloads;

public class ImpactDataStepDefs {
	
	Logger logger = LogManager.getLogger(ImpactDataStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
	@Given("Fetch the ImpactData service details using from date {string}, to date {string} and vin numbers {string}")
	public void fetch_the_ImpactData_data_details_using_vin_number(String fromDate,String toDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the ImpactData Details for the vin number " + vin);
		String[] vinNumbers=vin.split(",");
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(ImpactDataPayloads.getImpactDataBody(fromDate, toDate, vinNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved ImpactData Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Then("Verify the impact data statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,Integer.valueOf(string) );
	}
	
	@Given("Verify retrieved response is having Impact Data response")
	public void validateHourMeterDataResponse() {
		Assert.assertTrue(response.asString().contains("impactData"));
	}
	
	@Given("Fetch the ImpactData service details using from date {string} and to date {string}")
	public void fetch_the_ImpactData_data_detailsWithoutVin(String fromDate,String toDate) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the ImpactData Details using from date " + fromDate+" and to date "+toDate);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(ImpactDataPayloads.getImpactDataBodyWithoutVin(fromDate, toDate)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved ImpactData Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the ImpactData service details using to date {string} and vin {string}")
	public void fetch_the_ImpactData_data_detailsWithoutFromDate(String toDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the ImpactData Details using to date " + toDate+" and  vinNumber "+vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(ImpactDataPayloads.getImpactDataBodyWithoutFromDate(toDate, vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved ImpactData Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the ImpactData service details using from date {string} and vin {string}")
	public void fetch_the_ImpactData_data_detailsWithoutToDate(String fromDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the ImpactData Details using from date " + fromDate+" and  vinNumber "+vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(ImpactDataPayloads.getImpactDataBodyWithoutToDate(fromDate, vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved ImpactData Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Validate error message in Impact Data for the field {string}")
	public void errorMessage(String field) {
		Assert.assertTrue(response.asString().contains("Field \\\""+field+"\\\" of required type"));
	}
	
	@Given("Validate error message in Impact Data service {string}")
	public void errorMessageOfImpactData(String message) {
		Assert.assertTrue(response.asString().contains(message));
	}
	
	
}
