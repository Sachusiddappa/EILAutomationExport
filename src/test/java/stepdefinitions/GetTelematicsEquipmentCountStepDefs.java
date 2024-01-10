package stepdefinitions;

import static io.restassured.RestAssured.given;

import javax.swing.text.AbstractDocument.AbstractElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import payloads.GetTelematicsEquipmentCountPayloads;
import payloads.HourMeterDataPayloads;

public class GetTelematicsEquipmentCountStepDefs {
	
	Logger logger = LogManager.getLogger(GetTelematicsEquipmentCountStepDefs.class);
	final static String baseUrl = "https://tmhnaedmeilfunctionqa01-apim.azure-api.net/graphql";
	Response response;

	@Given("Fetch the GetTelematicsEquipmentCount details using telematicStatus {string}, customerId {string}, activeIndicator {string} and limit {string}")
	public void fetchTheEquipementDetails(String telematicStatus,String customerId,String activeIndicator,String limit) {
		logger.info("Getting the GetTelematicsEquipmentCount Details for the telematic status " + telematicStatus + ", customerId " + customerId+", activeIndicaator "+activeIndicator+", limit "+limit);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetTelematicsEquipmentCountPayloads.getGetTelematicsEquipmentCountBody(telematicStatus, customerId, activeIndicator, limit)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved GetTelematicsEquipmentCount Details");
		logger.info("Response Body is:" + jsonString);
	}

	@Then("Verify the GetTelematicsEquipmentCount statuscode {string} in response body")
	public void verify_the_statuscode_in_response_body(String string) {
		// Write code here that turns the phrase above into concrete actions
		Integer statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Integer.valueOf(string));
	}

	@Then("check GetTelematicsEquipmentCount retrieved data is {string}")
	public void validateData(String typeOfData) {
		
		if(typeOfData.equalsIgnoreCase("invalid")) {
			System.out.println(response.getBody().asString());
			Assert.assertTrue(response.getBody().asString().contains("[]"));
		}else {
			Assert.assertTrue(response.getBody().asString().contains("equipmentCount"));
		}
	}

	@Given("Fetch the GetTelematicsEquipmentCount data details with multiple telematicStatus {string},CustomerGrId {string},activeIndicator {string} and limit {string}")
	public void fetch_the_GetTelematicsEquipmentCount_details_with_multiple_vin_number(String ts,String cid,String ai,String limit ) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Getting the GetTelematicsEquipmentCount Details for the multiple telematic status " + ts+", customerIds "+cid+", activerIndicators "+ai+" and limit "+limit);
		String[] tsNumbers = ts.split(",");
		String[] cidNumbers = cid.split(",");
		String[] aiNumbers= ai.split(",");

		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetTelematicsEquipmentCountPayloads.getGetTelematicsEquipmentCountBody(tsNumbers, cidNumbers, aiNumbers, limit)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved GetTelematicsEquipmentCount Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Verify retrieved response is having GetTelematicsEquipmentCount response")
	public void validateGetTelematicsEquipmentCount() {
		Assert.assertTrue(response.asString().contains("getTelematicsEquipmentCount"));
	}
	
	@Given("Fetch the GetTelematicsEquipmentCount details using telematicStatus {string}, activeIndicator {string} and limit {string}")
	public void fetchTheEquipementDetails(String telematicStatus,String activeIndicator,String limit) {
		logger.info("Getting the GetTelematicsEquipmentCount Details for the telematic status " + telematicStatus + ", activeIndicaator "+activeIndicator+", limit "+limit);
		response = given().headers(utils.qaHeadersMethod()).log().all()
				.body(GetTelematicsEquipmentCountPayloads.getGetTelematicsEquipmentCountBody(telematicStatus, activeIndicator, limit)).when().post(baseUrl);
		String jsonString = response.asString();
		logger.info("Succesfully retrieved GetTelematicsEquipmentCount Details");
		logger.info("Response Body is:" + jsonString);
	}
	
	@Given("Validate GetTelematicsEquipmentCount error message {string}")
	public void getTelematicsEquipmentErrorMessage(String message) {
		Assert.assertTrue(response.asString().contains("Bad input request: Either one of fields customerid or customergrid is required"));
	}
	
@Given("Fetch the GetTelematicsEquipmentCount data details using telematicStatus {string}, activeIndicator {string}, limit {string} and CustomerGrId {string}")
	public void lowerCaseToTelematicsStatus(String telematicStatus,String customerId,String activeIndicator,String limit) {
	logger.info("Getting the GetTelematicsEquipmentCount Details for the telematic status " + telematicStatus + ", customerId " + customerId+", activeIndicaator "+activeIndicator+", limit "+limit);
	response = given().headers(utils.qaHeadersMethod()).log().all()
			.body(GetTelematicsEquipmentCountPayloads.getGetTelematicsEquipmentCountBody(telematicStatus, customerId, activeIndicator, limit)).when().post(baseUrl);
	String jsonString = response.asString();
	logger.info("Succesfully retrieved GetTelematicsEquipmentCount Details");
	logger.info("Response Body is:" + jsonString);
	}

@Given("Fetch the GetTelematicsEquipmentCount details using telematicStatus {string}, activeIndicator {string}, limit {string} and CustomerGrId {string}")
public void lowerCaseToActiveIndicator(String telematicStatus,String customerId,String activeIndicator,String limit) {
	logger.info("Getting the GetTelematicsEquipmentCount Details for the telematic status " + telematicStatus + ", customerId " + customerId+", activeIndicaator "+activeIndicator+", limit "+limit);
	response = given().headers(utils.qaHeadersMethod()).log().all()
			.body(GetTelematicsEquipmentCountPayloads.getGetTelematicsEquipmentCountBody(telematicStatus, customerId, activeIndicator, limit)).when().post(baseUrl);
	String jsonString = response.asString();
	logger.info("Succesfully retrieved GetTelematicsEquipmentCount Details");
	logger.info("Response Body is:" + jsonString);
	}
@Then("Validate GetTelematicsEquipmentCount data error message {string}")
public void invalidValueToTelematicsStatus(String message) {
	Assert.assertTrue(response.asString().contains(message));
}
}
