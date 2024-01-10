package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.TelematicsAggregatedErrorDataPayloads;

public class TelematicsAggregatedErrorDataStepDefs {
	Logger logger = LogManager.getLogger(TelematicsAggregatedErrorDataStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
 @Given("Fetch the TelematicsAggregatedErrorData service details using from date {string}, to date {string} and vin numbers {string}")
public void fetch_the_TelematicsAggregatedErrorData_Service_Details(String fromDate,String toDate,String vin) {
	 logger.info("Getting the TelematicsAggregatedErrorData Details for the vin number " + vin);
	 String[] vinNumbers=vin.split(",");
	 response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsAggregatedErrorDataPayloads.getTelematicsAggregatedErrorDataBody(fromDate, toDate, vinNumbers)).when().post(baseUrl);
	 String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsAggregatedErrorData Details");
		logger.info("Response Body is:" + jsonString);
}
 @Then("Verify the TelematicsAggregatedErrorData statuscode {string} in response body")
 public void verify_The_TelematicsAggregatedErrorData_Statuscode(String string)
 {
	 Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,Integer.valueOf(string) );
}
 
 @Given("Verify retrieved response is having telematicsAggregatedErrorData response")
 public void validateTelematicsAggregatedErrorData(){
	 Assert.assertTrue(response.asString().contains("telematicsAggregatedErrorData"));
	 
 }
 
 @Given("Fetch the TelematicsAggregatedErrorData service details using from date {string} and to date {string}")
 public void fetch_The_TelematicsAggregatedErrorData_Service_Deatils(String fromDate, String toDate) {
	 logger.info("Getting the TelematicsAggregatedErrorData Details using from date " +fromDate+" and to date "+toDate);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsAggregatedErrorDataPayloads.getTelematicsAggregatedErrorDataBodyWithoutVin(fromDate, toDate)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsAggregatedErrorData Details");
		logger.info("Response Body is:" + jsonString);
 }
 @Given("Fetch the TelematicsAggregatedErrorData service details using to date {string} and vin numbers {string}")
	public void fetch_The_TelematicsAggregatedErrorData_detailsWithoutFromDate(String toDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the TelematicsAggregatedErrorData Details using to date " + toDate+" and  vinNumber "+vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsAggregatedErrorDataPayloads.getTelematicsAggregatedErrorDataBodyWithoutFromDate(toDate, vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsAggregatedErrorData Details");
		logger.info("Response Body is:" + jsonString);
	}
 @Given("Fetch the TelematicsAggregatedErrorData service details using from date {string} and vin numbers {string}")
	public void fetch_The_TelematicsAggregatedErrorData_detailsWithoutToDate(String fromDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the TelematicsAggregatedErrorData Details using from date " + fromDate+" and  vinNumber "+vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsAggregatedErrorDataPayloads.getTelematicsAggregatedErrorDataBodyWithoutToDate(fromDate, vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsAggregatedErrorData Details");
		logger.info("Response Body is:" + jsonString);
	}
 @Given("Fetch the TelematicsAggregatedErrorData service details using vin {string}")
public void fetch_the_TelematicsAggregatedErrorData_Service_Details(String vin) {
	 logger.info("Getting the TelematicsAggregatedErrorData Details for the vin" + vin);
	 response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsAggregatedErrorDataPayloads.getTelematicsAggregatedErrorDataBodyOnlyWithVin(vin)).when().post(baseUrl);
	 String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsAggregatedErrorData Details");
		logger.info("Response Body is:" + jsonString);
 }
 
 @Given("Validate error message in telematicsAggregatedErrorData for the field {string}")
	public void validateTelematicsAggregatedErrorDataMessage(String field) {
		Assert.assertTrue(response.asString().contains("Field \\\""+field+"\\\" of required type"));
	}
 @Given("Validate error message in TelematicsAggregatedErrorData service {string}")
	public void rangeOfFromDateToDateAndArrayOfVin(String message) {
		Assert.assertTrue(response.asString().contains(message));
		String jsonString = response.asString();
		System.out.println("ResponseBody: " + jsonString);
		System.out.println("Expected Message: " + message);
	}
}
