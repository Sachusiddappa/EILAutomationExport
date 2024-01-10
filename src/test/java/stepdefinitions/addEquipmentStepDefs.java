package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;                         
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class addEquipmentStepDefs {
	Response response;
	String actualStatusCode;
	List<String> values = new ArrayList<String>();
	List<String> ListValues = new ArrayList<String>();
	final static String url = "https://tmhnaedmeilfunctiondev01-apim.azure-api.net/graphql";
	utils utilsFile = new utils();
	payLoads payloads = new payLoads();

	Logger logger = LogManager.getLogger(addEquipmentStepDefs.class);

//	Given I send '<emailID>' emailId in equipment add API with '<vin>' and '<customerGrid>' 
//	Then Verify the statuscode is '<status>' in equipment add response body 
//	And Verify the '<responseFieldName>' in equipment add response body is having '<responseFieldValue>' value
	
	@Then("Verify the statuscode is {string} in equipment add response body")
	public void verify_the_statuscode_is_in_equipment_add_response_body(String expectedstatusCode) {
		logger.info("Verify the statuscode in response body");
		System.out.println(values.get(0));
		System.out.println(values.get(1));
		String actualstatusCodeValues = String.valueOf(values.get(1));
		assertEquals(expectedstatusCode, actualstatusCodeValues);
		logger.info("status code in response body is" + actualstatusCodeValues);
	}
	
	@Then("Verify the {string} in equipment add response body is having {string} value")
	public void verify_the_in_equipment_add_response_body_is_having_value(String responseFieldValue, String expectedFieldValue) {
		logger.info("Verify the responsfield in response body");
		System.out.println(values.get(0));
		System.out.println(values.get(1));
		String actualfieldValues = String.valueOf(values.get(0));
		assertEquals(expectedFieldValue, actualfieldValues);
		logger.info(responseFieldValue + "  in response body is" + actualfieldValues);
	}
	
	@Given("I send equipment API with {string} and {string} customerGrid")
	public List<String> i_send_equipment_api_with_and_customerGrid(String vin, String customerGrid) {
		logger.info("I send equipment api with vin and customerGrid");
		Response response = given().headers(utilsFile.headersMethod()).log().all()
				.body(payloads.getEquipmentbycustomerGrid(customerGrid, vin)).when().post(url);
		String jsonString = response.asString();
		String success = JsonPath.from(jsonString).getString("data.equipmentAdd.success");
		int statusCode = response.getStatusCode();
		actualStatusCode = String.valueOf(statusCode);
		values.add(actualStatusCode);
		values.add(success);
		logger.info("Response Body is:" + jsonString);
		logger.info("I send equipment API with customerGrid and status code is " + actualStatusCode);
		return values;
	}
	

	@Given("I send {string} emailId in equipment add API with {string} and {string}")
	public List<String> i_send_emailId_in_equipment_add_API_with_and(String emailId, String vin,String customerGrid) {
		logger.info("I send email id  in add equipment API with vin and customerGrid");
		Response response = given().headers(utilsFile.headersMethod()).log().all()
				.body(payloads.addEquipmentByEmailId(customerGrid, vin, emailId)).when().post(url);
		String jsonString = response.asString();

		if (emailId.contains("@gmail.com")) {
			String success = JsonPath.from(jsonString).getString("data.equipmentAdd.success");
			values.add(success);
			System.out.println(values);
		} else if (emailId.contains("gmail.com")) {
			String message = JsonPath.from(jsonString).getString("errors[0].message");
			values.add(message);
			System.out.println(values);
		} else {
			String errorMessage = JsonPath.from(jsonString).getString("data.equipmentAdd.errorMessage");
			values.add(errorMessage);
			System.out.println(values);
		}
		actualStatusCode = String.valueOf(response.getStatusCode());
		values.add(actualStatusCode);
		System.out.println(values);
		logger.info("Response Body is:" + jsonString);
		logger.info("I send equipment API with customerGrid and status code is " + actualStatusCode);
		return values;
	}
}