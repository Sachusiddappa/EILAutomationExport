package payloads;

public class GetRetailOrdersPayloads {

	public static String getReatilOrdersDetailsBodyForCustomerId(String[] customerIdData) {
		String s = "{\r\n"
				+ "  \"query\": \"query GetRetailOrders($filter: FilterRetailOrderInput) {\\r\\n  getRetailOrders(filter: $filter) {\\r\\n    records {\\r\\n      customerId\\r\\n      customerGRId\\r\\n      orderNumber\\r\\n      orderDate\\r\\n      primaryStatus\\r\\n      equipPrimaryStatus\\r\\n      highLevelStatus\\r\\n      customerStatus\\r\\n      vin\\r\\n      model\\r\\n      estimatedDeliveryDate\\r\\n      custAddressLine1\\r\\n      custAddressLine2\\r\\n      custCountryCode\\r\\n      custPostalCode\\r\\n      custCity\\r\\n      custState\\r\\n      lineOnDate\\r\\n      modelName\\r\\n      salesPersonName\\r\\n      truckNumber\\r\\n      leaseInd\\r\\n      equipmentType\\r\\n      equipmentTypeDesc\\r\\n      salesPrice\\r\\n      crmOppNumber\\r\\n      shipToCity\\r\\n      shipToState\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerId\": [\r\n"
				+ "        {customerId}\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		for (String customerId : customerIdData) {
			s = s.replace("{customerId}", "\"" + customerId + "\",{customerId}");
		}
		s = s.replace(",{customerId}", "");
		return s;
	}

	public static String getReatilOrdersDetailsBodyForCustomerGrid(String[] customerGridData) {
		String s ="{\r\n"
				+ "  \"query\": \"query GetRetailOrders($filter: FilterRetailOrderInput) {\\r\\n  getRetailOrders(filter: $filter) {\\r\\n    records {\\r\\n      customerId\\r\\n      customerGRId\\r\\n      orderNumber\\r\\n      orderDate\\r\\n      primaryStatus\\r\\n      equipPrimaryStatus\\r\\n      highLevelStatus\\r\\n      customerStatus\\r\\n      vin\\r\\n      model\\r\\n      estimatedDeliveryDate\\r\\n      custAddressLine1\\r\\n      custAddressLine2\\r\\n      custCountryCode\\r\\n      custPostalCode\\r\\n      custCity\\r\\n      custState\\r\\n      lineOnDate\\r\\n      modelName\\r\\n      salesPersonName\\r\\n      truckNumber\\r\\n      leaseInd\\r\\n      equipmentType\\r\\n      equipmentTypeDesc\\r\\n      salesPrice\\r\\n      crmOppNumber\\r\\n      shipToCity\\r\\n      shipToState\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerGrid\": [\r\n"
				+ "        {customerGrid}\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}"; 
				
				
				
		for (String customerGrid : customerGridData) {
			s = s.replace("{customerGrid}", "\"" + customerGrid + "\",{customerGrid}");
		}
		s = s.replace(",{customerGrid}", "");
		return s;
	}
	
	public static String getRetailOrderDetailsBody(String[] customerIdData,String[] customerGridData) {
		String s ="{\r\n"
				+ "  \"query\": \"query GetRetailOrders($filter: FilterRetailOrderInput) {\\r\\n  getRetailOrders(filter: $filter) {\\r\\n    records {\\r\\n      customerId\\r\\n      customerGRId\\r\\n      orderNumber\\r\\n      orderDate\\r\\n      primaryStatus\\r\\n      equipPrimaryStatus\\r\\n      highLevelStatus\\r\\n      customerStatus\\r\\n      vin\\r\\n      model\\r\\n      estimatedDeliveryDate\\r\\n      custAddressLine1\\r\\n      custAddressLine2\\r\\n      custCountryCode\\r\\n      custPostalCode\\r\\n      custCity\\r\\n      custState\\r\\n      lineOnDate\\r\\n      modelName\\r\\n      salesPersonName\\r\\n      truckNumber\\r\\n      leaseInd\\r\\n      equipmentType\\r\\n      equipmentTypeDesc\\r\\n      salesPrice\\r\\n      crmOppNumber\\r\\n      shipToCity\\r\\n      shipToState\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerId\": [\r\n"
				+ "        {customerId}\r\n"
				+ "      ],\r\n"
				+ "      \"customerGrid\": [\r\n"
				+ "        {customerGrid}\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
				
				
		for (String customerGrid : customerGridData) {
			s = s.replace("{customerGrid}", "\"" + customerGrid + "\",{customerGrid}");
		}
		s = s.replace(",{customerGrid}", "");
		for (String customerId : customerIdData) {
			s = s.replace("{customerId}", "\"" + customerId + "\",{customerId}");
		}
		s = s.replace(",{customerId}", "");
		return s;
	}
}
