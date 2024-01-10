package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.TelematicsUtilizationDataPayloads;

public class TelematicsUtilizationDataStepDefs {
	
	Logger logger = LogManager.getLogger(TelematicsUtilizationDataStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
 @Given("Fetch the TelematicsUtilizationData service details using from date {string}, to date {string} and vin numbers {string}")
public void fetch_the_TelematicsUtilizationData_Service_Details(String fromDate,String toDate,String vin) {
	 logger.info("Getting the TelematicsUtilizationData Details for the vin number " + vin);
	 String[] vinNumbers=vin.split(",");
	 response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsUtilizationDataPayloads.getTelematicsUtilizationDataBody(fromDate, toDate, vinNumbers)).when().post(baseUrl);
	 String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsUtilizationData Details");
		logger.info("Response Body is:" + jsonString);
}
 @Then("Verify the TelematicsUtilizationData statuscode {string} in response body")
 public void verify_The_TelematicsUtilizationData_Statuscode(String string)
 {
	 Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,Integer.valueOf(string) );
}
 
 @Given("Verify retrieved response is having TelematicsUtilizationData response")
 public void validateTelematicsUtilizationData(){
	 Assert.assertTrue(response.asString().contains("telematicsUtilizationData"));
	 
 }
 
 @Given("Fetch the TelematicsUtilizationData service details using from date {string} and to date {string}")
 public void fetch_The_TelematicsUtilizationData_Service_Deatils(String fromDate, String toDate) {
	 logger.info("Getting the TelematicsUtilizationData Details using from date " +fromDate+" and to date "+toDate);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsUtilizationDataPayloads.getTelematicsUtilizationDataBodyWithoutVin(fromDate, toDate)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsUtilizationData Details");
		logger.info("Response Body is:" + jsonString);
 }
 @Given("Fetch the TelematicsUtilizationData service details using to date {string} and vin numbers {string}")
	public void fetch_The_TelematicsUtilizationData_detailsWithoutFromDate(String toDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the TelematicsUtilizationData Details using to date " + toDate+" and  vinNumber "+vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsUtilizationDataPayloads.getTelematicsUtilizationDataBodyWithoutFromDate(toDate, vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsUtilizationData Details");
		logger.info("Response Body is:" + jsonString);
	}
 @Given("Fetch the TelematicsUtilizationData service details using from date {string} and vin numbers {string}")
	public void fetch_The_TelematicsUtilizationData_detailsWithoutToDate(String fromDate,String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the TelematicsUtilizationData Details using from date " + fromDate+" and  vinNumber "+vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(TelematicsUtilizationDataPayloads.getTelematicsUtilizationDataBodyWithoutToDate(fromDate, vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved TelematicsUtilizationData Details");
		logger.info("Response Body is:" + jsonString);
	}
 
 @Given("Validate error message in TelematicsUtilizationData for the field {string}")
	public void validateTelematicsUtilizationDataerrorMessage(String field) {
		Assert.assertTrue(response.asString().contains("Field \\\""+field+"\\\" of required type"));
	}
 @Given("Validate error message in TelematicsUtilizationData service {string}")
	public void invalidValueToDateFromDateVin(String message) {
		Assert.assertTrue(response.asString().contains(message));
	}
}
