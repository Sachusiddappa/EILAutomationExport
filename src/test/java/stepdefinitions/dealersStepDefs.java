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

public class dealersStepDefs {
	Response response;
	String actualStatusCode;
	final static String url = "https://tmhnaedmeilfunctiondev01-apim.azure-api.net/graphql";
	utils utilsFile = new utils();
	payLoads payloads = new payLoads();
	Logger logger = LogManager.getLogger(dealersStepDefs.class);
	String jsonString;
	List<String> values = new ArrayList<String>();
	

	@Given("I send  goldenRecordID {string} ,dealerName {string}  in Dealers api")
	public List<String> i_send_golden_record_id_dealer_name_in_dealers_api(String goldenRecordID, String dealerName) {
		logger.info("I send  goldenRecordID ,dealerName in Dealers api");
		Response response = given().headers(utilsFile.headersMethod()).log().all()
				.body(payloads.getDealersInfoByGoldenRecordIDAndDealerName(goldenRecordID, dealerName)).when()
				.post(url);
		jsonString = response.asString();
		int statusCode = response.getStatusCode();
		actualStatusCode = String.valueOf(statusCode);
		values.add(actualStatusCode); // 0
		logger.info("Response Body is:" + jsonString);
		return values;
	}
	
	@Then("Verify the statuscode is {string} in dealers api")
	public void verify_the_statuscode_is(String expectedStatusCode) {
		logger.info("Verify the statuscode in response body");
		String actualStatusCodeValues = String.valueOf(values.get(0));
		assertEquals(expectedStatusCode, actualStatusCodeValues);
		logger.info("status code in response body is" + actualStatusCodeValues);
	} 
	

@Then("Verify dealer service records {string} are not fetched by passing invalid values of goldenRecordID {string} ,dealerName {string}")
public void verify_that_dealer_service_records_are_not_fetched_by_passing_invalid_values_of_goldenRecordID_dealerName(String expectedDealerRecords ,String goldenRecordID ,String dealerName) {
	String actualDealerRecords;
	if(goldenRecordID.equalsIgnoreCase("null") || dealerName.equalsIgnoreCase("null")|| goldenRecordID.isEmpty() || dealerName.isEmpty()) {
		actualDealerRecords = JsonPath.from(jsonString).getString("data.dealers.records");
		assertEquals(expectedDealerRecords, actualDealerRecords);
		logger.info("goldenRecordID or dealerName are null or empty  we don't have any records in DB for goldenRecordID "+goldenRecordID+", "+dealerName+" dealerName and DealerRecords is "+actualDealerRecords+" ");
	}else {
		actualDealerRecords = JsonPath.from(jsonString).getString("data.dealers.records");
		assertEquals(expectedDealerRecords, actualDealerRecords);
		logger.info("goldenRecordID or dealerName are invalid we don't have any records in DB for goldenRecordID "+goldenRecordID+", "+dealerName+"  dealerName and DealerRecords is "+actualDealerRecords+"");
	}
}
}