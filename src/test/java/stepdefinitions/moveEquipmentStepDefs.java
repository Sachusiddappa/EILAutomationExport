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

public class moveEquipmentStepDefs {

	Response response;
	String actualStatusCode;
	String success;

	final static String url = "https://tmhnaedmeilfunctiondev01-apim.azure-api.net/graphql";
	utils utils = new utils();
	payLoads payloads = new payLoads();
	List<String> values = new ArrayList<String>();
	Logger logger = LogManager.getLogger(addEquipmentStepDefs.class);
	
	@Then("Verify the statuscode {string} in equipment move response body")
	public void verify_the_statuscode_is_in_equipment_move_reponse_body(String expectedstatusCode) {
		logger.info("Verify the statuscode in response body");
		System.out.println(values.get(0));
		System.out.println(values.get(1));
		String actualstatusCodeValues = String.valueOf(values.get(1));
		assertEquals(expectedstatusCode, actualstatusCodeValues);
		logger.info("status code in response body is" + actualstatusCodeValues);
	}
	
	@Then("Verify the {string} in equipment move response body is having {string} value")
	public void verify_the_in_equipment_move_response_body_is_(String responseFieldValue ,String expectedFieldValue) {
		logger.info("Verify the responsfield in response body}");
		System.out.println(values.get(0));
		System.out.println(values.get(1));
		String actualfieldValues=String.valueOf(values.get(0));
		assertEquals(expectedFieldValue, actualfieldValues);
		logger.info(responseFieldValue + "  in response body is" + actualfieldValues);
	
	} 

	@Given("I send {string} emailId in move equipment API with {string} and {string}")
	public List<String> i_send_emailId_in_move_equipment_API_with_and(String emailId, String vin,
			String customerGrid) {
		logger.info("I send emailId in move equipment API with vin and customerGrid");
		Response response = given().headers(utils.headersMethod()).log().all()
				.body(payloads.moveEquipmentByEmailId(customerGrid, vin, emailId)).when().post(url);
		String jsonString = response.asString();

		if (emailId.contains("@gmail.com")) {
			success = JsonPath.from(jsonString).getString("data.equipmentMove.success");
			values.add(success);
			System.out.println(values);
		} else if (emailId.contains("gmail.com")) {
			success = JsonPath.from(jsonString).getString("errors[0].message");
			values.add(success);
			System.out.println(values);
		} else {
			success = JsonPath.from(jsonString).getString("data.equipmentMove.errorMessage");
			values.add(success);
			System.out.println(values);
		}
		actualStatusCode = String.valueOf(response.getStatusCode());
		values.add(actualStatusCode);
		logger.info("Response Body is:" + jsonString);
		logger.info("I send equipment API with customerGrid and status code is " + actualStatusCode);
		System.out.println(values);
		System.out.println(values.get(0));
		System.out.println(values.get(1));
		return values;
	}
}
