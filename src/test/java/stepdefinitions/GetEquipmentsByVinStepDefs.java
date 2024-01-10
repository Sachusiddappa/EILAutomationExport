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
import payloads.HourMeterDataPayloads;

public class GetEquipmentsByVinStepDefs {
	Logger logger = LogManager.getLogger(GetEquipmentsByVinStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;
	
	@Given("Fetch the getEquipemetByVin details using vin {string}")
	public void fetch_the_getequipemetByVin_details_using_vin_id(String vin) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Getting the GetEquipmentByVin Details for the vin number " + vin);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetEquipmentsByVinPayloads.getEquipmentByVinDataBody(vin)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved GetEquipementByVin Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Then("Verify the GetEquipmentByVin service statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}
	
	@Given("Fetch the getEquipmentByVin service details with multiple vin {string}")
	public void fetch_the_getEquipmentByVin_details_with_multiple_vin_number(String vin) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the getEquipmentByVin Details for the multiple vin numbers " + vin);
		String[] vinNumbers = vin.split(",");

		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetEquipmentsByVinPayloads.getEquipmentByVinDataBody(vinNumbers)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved getEquipmentByVin service Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Verify retrieved response is having getEquipmentsByVin response")
	public void validateGetEquipmentsByVinResponse() {
		Assert.assertTrue(response.asString().contains("getEquipmentsByVin"));
	}
	
	@Given("Verify getEquipmentByVin vin numbers {string} is present in the response")
	public void verifyVinNumbers(String vins) {
		String vinNumbers[]=vins.split(",");
		String responseValue=response.asString();
		for(String vin:vinNumbers) {
			Assert.assertTrue("Vin "+vin+"number is not present in the response "+responseValue,responseValue.contains(vin));
		}	
	}
	
	@Given("Validate Error response for the vin data {string}")
	public void validateErrorMessage(String vin) {
		Assert.assertTrue(response.getBody().asString().contains("[]"));
	}

	
//	@Given("Get the equipment details by using multiple vin {string}")
//	public void fetch_the_equipment_details_with_multiple_vin_number(String vin) {
//	    // Write code here that turns the phrase above into concrete actions
//		logger.info("Getting the equipment details by using multiple vin numbers " + vin);
//		String[] vinNumbers=vin.split(",");
//		
//		response = given().headers(utils.qaHeadersMethod()).log().all()
//				.body(EquipmentsByVinPayloads.getEquipmentByVinDataBody(vinNumbers)).when().post(baseUrl);
//		String jsonString = response.asString();
//		logger.info("Succesfully retrieved equipment details by using vin");
//		logger.info("Response Body is:" + jsonString);
//	}
//	@Then("validate by passing empty and invalid value vin")
//	public void validateData(String typeOfData) {
//		
//		if(typeOfData.equalsIgnoreCase("invalid")) {
//			System.out.println(response.getBody().asString());
//			Assert.assertTrue(response.getBody().asString().contains("[null]"));
//		}else {
//			Assert.assertTrue(response.getBody().asString().contains("vin"));
//		}
//}
}