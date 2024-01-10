package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.GetRetailOrdersPayloads;


public class GetRetailOrdersStepDefs {
	
	Logger logger = LogManager.getLogger(GetRetailOrdersStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;	
	
	@Given("Fetch the GetRetailOrders data details with multiple customer id {string}")
	public void fetch_the_hourmeterdata_details_with_multiple_vin_number(String customerIds) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the hourmeterdata Details for the multiple customerId numbers " + customerIds);
		String[] customerNumbers = customerIds.split(",");

		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetRetailOrdersPayloads.getReatilOrdersDetailsBodyForCustomerId(customerNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Hour meter data Details");
		logger.info("Response Body is:" + jsonString);
	}

	@Given("Fetch the GetRetailOrders data details with multiple customerGrid {string}")
	public void fetch_the_hourmeterdata_details_with_multiple_customerGrid_number(String customerGrids) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the hourmeterdata Details for the multiple customerId numbers " + customerGrids);
		String[] customerGridNumbers = customerGrids.split(",");

		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetRetailOrdersPayloads.getReatilOrdersDetailsBodyForCustomerGrid(customerGridNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Hour meter data Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Fetch the GetRetailOrders data details with multiple customerId {string} and customerGrid {string}")
	public void fetch_the_hourmeterdata_details_with_customerGrid_and_customerId_number(String customerGrids,String customerIds) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the hourmeterdata Details for the multiple customerId numbers " + customerGrids);
		String[] customerNumbers = customerIds.split(",");
		String[] customerGridNumbers = customerGrids.split(",");

		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetRetailOrdersPayloads.getRetailOrderDetailsBody(customerNumbers,customerGridNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved Hour meter data Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Then("Verify the GetRetailOrders statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}
	
	@Given("Verify retrieved response is having GetRetailOrders Data response")
	public void validateHourMeterDataResponse() {
		Assert.assertTrue(response.asString().contains("getRetailOrders"));
	}
	
	@Given("check retrieved getRetailOrders data is {string}")
	public void checkData(String typeOfData) {
		if(typeOfData.equalsIgnoreCase("invalid")) {
			Assert.assertTrue(response.asString().contains("[]"));
		}else {
			Assert.assertTrue(response.asString().contains("orderNumber"));
		}
	}

}
