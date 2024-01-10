package stepdefinitions;

public class payLoads {

	public String getCustomerPayloads(String customerID) {
		return "{\r\n" + "  \"query\": \"query CustomerById { contactsByCustomerId(customerID: \\\"" + customerID
				+ "\\\") { records { contactID contactOrganizationReference contactStatus customerID { key value } customerSourceSystem email firstName goldenRecordID lastName name objectType phoneNumber rank } }}\"\r\n"
				+ "}";
	}

	public String getEquipmentbycustomerId(String customerId, String vin) {

		return "{\r\n"
				+ "  \"query\": \"mutation Mutation($input: EquipmentAddInput!) { equipmentAdd(input: $input) { errorMessage queuedAt success }}\",\r\n"
				+ "  \"variables\": {\r\n" + "    \"input\": {\r\n" + "      \"vin\": \"" + vin + "\",\r\n"
				+ "      \"customerId\": \"" + customerId + "\"\r\n" + "    }\r\n" + "  }\r\n" + "}";
	}

	public String getEquipmentbycustomerGrid(String customerGrid, String vin) {
		return "{\r\n"
				+ "  \"query\": \"mutation Mutation($input: EquipmentAddInput!) { equipmentAdd(input: $input) { errorMessage queuedAt success }}\",\r\n"
				+ "  \"variables\": {\r\n" + "    \"input\": {\r\n" + "\"vin\": \"" + vin + "\",\r\n"
				+ "      \"customerGRID\": \"" + customerGrid + "\"\r\n" + "    }\r\n" + "  }\r\n" + "}";
	}

	public String getEquipmentByCustomerGridAsNull(String vin) {
		return "{\r\n"
				+ "  \"query\": \"mutation Mutation($input: EquipmentAddInput!) { equipmentAdd(input: $input) { errorMessage queuedAt success }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"input\": {\r\n"
				+ "      \"vin\": \""+vin+"\",\r\n"
				+ "      \"customerGRID\": null\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
		
		public String addEquipmentByEmailId(String customerGrid, String vin,String emailID ) {
			return"{\r\n"
					+ "  \"query\": \"mutation EquipmentAdd($input: EquipmentAddInput!) { equipmentAdd(input: $input) { success queuedAt errorMessage }}\",\r\n"
					+ "  \"variables\": {\r\n"
					+ "    \"input\": {\r\n"
					+ "      \"firstName\": \"Johwn\",\r\n"
					+ "      \"lastName\": \"desozwwa\",\r\n"
					+ "      \"email\": \""+emailID+"\",\r\n"
					+ "      \"vin\": \""+vin+"\",\r\n"
					+ "      \"customerGRID\": \""+customerGrid+"\"\r\n"
					+ "    }\r\n"
					+ "  }\r\n"
					+ "}";
	}
		public String moveEquipmentByEmailId(String customerGrid, String vin,String emailID ) {
			return"{\r\n"
					+ "  \"query\": \"mutation EquipmentMove($input: EquipmentMoveInput!) { equipmentMove(input: $input) { success queuedAt errorMessage }}\",\r\n"
					+ "  \"variables\": {\r\n"
					+ "    \"input\": {\r\n"
					+ "      \"firstName\": \"Johwn\",\r\n"
					+ "      \"lastName\": \"desozwwa\",\r\n"
					+ "      \"email\": \""+emailID+"\",\r\n"
					+ "      \"vin\": \""+vin+"\",\r\n"
					+ "      \"customerGRID\": \""+customerGrid+"\"\r\n"
					+ "    }\r\n"
					+ "  }\r\n"
					+ "}";
	}
		public String removeEquipmentByEmailId(String customerId, String vin,String emailID ) {
			return"{\r\n"
					+ "  \"query\": \"mutation EquipmentRemove($input: EquipmentRemoveInput!) { equipmentRemove(input: $input) { success queuedAt errorMessage }}\",\r\n"
					+ "  \"variables\": {\r\n"
					+ "    \"input\": {\r\n"
					+ "      \"vin\": \""+vin+"\",\r\n"
					+ "      \"reason\": \"SOLD\",\r\n"
					+ "      \"firstName\": \"test\",\r\n"
					+ "      \"lastName\": \"testnh\",\r\n"
					+ "      \"email\": \""+emailID+"\",\r\n"
					+ "      \"comments\": \"testing\",\r\n"
					+ "      \"customerId\": \""+customerId+"\"\r\n"
					+ "    }\r\n"
					+ "  }\r\n"
					+ "}";
	}
 
	public String getEquipmentByCustomerIdAsNull(String vin) {
		return "{\r\n"
				+ "  \"query\": \"mutation Mutation($input: EquipmentAddInput!) { equipmentAdd(input: $input) { errorMessage queuedAt success }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"input\": {\r\n"
				+ "      \"vin\": \""+vin+"\",\r\n"
				+ "      \"customerID\": null\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}

	public String removeEquipmentByCustomerId(String customerId, String vin, String reason) {
		return "{\r\n"
				+ "  \"query\": \"mutation Mutation($input: EquipmentRemoveInput!) { equipmentRemove(input: $input) { success queuedAt errorMessage }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"input\": {\r\n"
				+ "      \"customerId\": \""+customerId+"\",\r\n"
				+ "      \"vin\": \""+vin+"\",\r\n"
				+ "      \"comments\": \"its "+reason+"\",\r\n"
				+ "      \"reason\": \""+reason+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public String getRetailOrdersByCustomerIdAndCustomerGrid(String customerId, String customerGrid, String truckNumber) {
		return "{\r\n"
				+ "  \"query\": \"query GetRetailOrders($filter: FilterRetailOrderInput) { getRetailOrders(filter: $filter) { records { customerId customerGRId truckNumber equipment { truckNo equipmentType } } }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerId\": \""+customerId+"\",\r\n"
				+ "      \"customerGrid\": \""+customerGrid+"\",\r\n"
				+ "      \"truckNumber\": \""+truckNumber+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public String getDealersInfoByGoldenRecordIDAndDealerName(String customerGrid, String dealerName) {
		return"{\r\n"
				+ "  \"query\": \"query Dealers($filter: FilterDealerInput) { dealers(filter: $filter) { records { goldenRecordID dealerNumber dealerName city county countryCode stateCode postalCode mainDealerNumber mainDealerName mainDealerFlag districtNumber districtName accountgroup accountGroup itaStateCode itaCountyCode addressLine1 } }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"goldenRecordID\": \""+customerGrid+"\",\r\n"
				+ "      \"dealerName\": \""+dealerName+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
		
	public String getInvoicesInfoByCustomerIdAndInvoices(String customerId,String invoicesNumber ) {
		return"{\r\n"
				+ "  \"query\": \"query Invoices($filter: FilterInvoiceInput) { invoices(filter: $filter) { records { customerId invoices { invoiceNumber invoiceDate status paymentTerm invoiceDueDate netAmt taxAmt currency repairDescription paymentStatus } equipmentType workOrder hourMeterAmount } }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"invoiceNumber\": \""+invoicesNumber+"\",\r\n"
				+ "      \"customerId\": \""+customerId+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}

	public String getInvoicesInfoByValidValues(String customerId,String invoicesNumber, String equipmentType, String workOrder, String status, String hourMeterAmount, String paymentStatus ) {
		return"{\r\n"
				+ "  \"query\": \"query Invoices($filter: FilterInvoiceInput) { invoices(filter: $filter) { records { customerId invoices { invoiceNumber invoiceDate status paymentTerm invoiceDueDate netAmt taxAmt currency repairDescription paymentStatus } equipmentType workOrder hourMeterAmount } }}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"invoiceNumber\": \""+invoicesNumber+"\",\r\n"
				+ "      \"customerId\": \""+customerId+"\",\r\n"
				+ "      \"equipmentType\": \""+equipmentType+"\",\r\n"
				+ "      \"workOrder\": \""+workOrder+"\",\r\n"
				+ "      \"status\": \""+status+"\",\r\n"
				+ "      \"hourMeterAmount\": "+hourMeterAmount+",\r\n"
				+ "      \"paymentStatus\": \""+paymentStatus+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
}
