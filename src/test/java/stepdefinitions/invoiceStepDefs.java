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

public class invoiceStepDefs {

	Response response;
	String actualStatusCode;
	final static String url = "https://tmhnaedmeilfunctiondev01-apim.azure-api.net/graphql";
	utils utilsFile = new utils();
	payLoads payloads = new payLoads();
	Logger logger = LogManager.getLogger(invoiceStepDefs.class);
	String jsonString;
	List<String> values = new ArrayList<String>();

	@Given("I send {string} customerId and {string} invoiceNumber in the invoice api")
	public List<String> i_send_customer_id_and_invoice_number_in_the_invoice_api(String customerId,
			String invoiceNumber) {
		logger.info("I send customerId,invoiceNumber in the invoice api");
		Response response = given().headers(utilsFile.headersMethod()).log().all()
				.body(payloads.getInvoicesInfoByCustomerIdAndInvoices(customerId, invoiceNumber)).when().post(url);
		jsonString = response.asString();
		int statusCode = response.getStatusCode();
		actualStatusCode = String.valueOf(statusCode);
		values.add(actualStatusCode); // 0
		logger.info("Response Body is:" + jsonString);
		return values;
	}

	@Then("Verify the statuscode is {string} in invoice api response body")
	public void verify_the_statuscode_is_in_invoice_api_response_body(String expectedStatusCode) {
		logger.info("Verify the statuscode in invoice api response body");
		String actualStatusCodeValues = String.valueOf(values.get(0));
		assertEquals(expectedStatusCode, actualStatusCodeValues);
		logger.info("status code in response body is" + actualStatusCodeValues);
	}

	@Then("Verify the {string} customerId and {string} invoiceNumber in invoice response body")
	public void verify_the_customer_id_and_invoice_number_in_invoice_response_body(String expCustomerId,
			String expInvoiceNumber) {
		String actualCustomerId = JsonPath.from(jsonString).getString("data.invoices.records[0].customerId");
		String actualInvoiceNumber = JsonPath.from(jsonString)
				.getString("data.invoices.records[0].invoices[0].invoiceNumber");
		assertEquals(expCustomerId, actualCustomerId);
		assertEquals(expInvoiceNumber, actualInvoiceNumber);
		logger.info("" + actualCustomerId + " customerId and " + actualInvoiceNumber
				+ " invoiceNumber in invoice response body");
	}

	@Given("I send {string} customerId and {string} invoiceNumber, {string} equipmentType, {string} workOrder, {string} status, {string} hourMeterAmount, {string} paymentStatus in the invoice api")
	public List<String> i_send_customer_id_and_invoice_number_equipment_type_work_order_status_hour_meter_amount_payment_status_in_the_invoice_api(
			String customerId, String invoiceNumber, String equipmentType, String workOrder, String status,
			String hourMeterAmount, String paymentStatus) {
		logger.info("I send  valid values in invoice api");
		Response response = given()
				.headers(utilsFile.headersMethod()).log().all().body(payloads.getInvoicesInfoByValidValues(customerId,
						invoiceNumber, equipmentType, workOrder, status, hourMeterAmount, paymentStatus))
				.when().post(url);
		jsonString = response.asString();
		int statusCode = response.getStatusCode();
		actualStatusCode = String.valueOf(statusCode);
		values.add(actualStatusCode); // 0
		logger.info("Response Body is:" + jsonString);
		return values;
	}

	@Then("Verify  {string} customerId and {string} invoiceNumber, {string} equipmentType, {string} workOrder, {string} status, {string} hourMeterAmount, {string} paymentStatus in response of  invoice api")
	public void verify_customer_id_and_invoice_number_equipment_type_work_order_status_hour_meter_amount_payment_status_in_response_of_invoice_api(
			String expCustomerId, String expInvoiceNumber, String expEquipmentType, String expWorkOrder, String expStatus,
			String expHourMeterAmount, String expPaymentStatus) {
		logger.info("Verify the valid values in the response of invoice api");
		String actualCustomerId = JsonPath.from(jsonString).getString("data.invoices.records[0].customerId");
		String actualInvoiceNumber = JsonPath.from(jsonString).getString("data.invoices.records[0].invoices[0].invoiceNumber");
		String actualEquipmentType = JsonPath.from(jsonString).getString("data.invoices.records[0].equipmentType");
		String actualWorkOrder = JsonPath.from(jsonString).getString("data.invoices.records[0].workOrder");
		String actualStatus = JsonPath.from(jsonString).getString("data.invoices.records[0].invoices[0].status");
		String actualHourMeterAmount = JsonPath.from(jsonString).getString("data.invoices.records[0].hourMeterAmount");
		String actualPaymentStatus = JsonPath.from(jsonString).get("data.invoices.records[0].invoices[0].paymentStatus");
		boolean paymentstatusValue= expPaymentStatus.equalsIgnoreCase(actualPaymentStatus);
		if(paymentstatusValue== true) {
			logger.info("actualPaymentStatus and expPaymentStatus are match");
		}else {
			logger.info("actualPaymentStatus and expPaymentStatus are not match");
		}										
		assertEquals(expCustomerId, actualCustomerId);
		assertEquals(expInvoiceNumber, actualInvoiceNumber);
		assertEquals(expEquipmentType, actualEquipmentType);
		assertEquals(expWorkOrder, actualWorkOrder);
		assertEquals(expStatus, actualStatus);
		assertEquals(expHourMeterAmount, actualHourMeterAmount);
		logger.info("All the values are the match in the response");
	}
}
