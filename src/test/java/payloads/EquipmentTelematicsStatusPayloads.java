package payloads;

public class EquipmentTelematicsStatusPayloads {
	public static String getEquipmentTelematicsStatus(String vin,String customerId)
	{
	return "{\r\n"
			+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      telematicsStatus\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"vin\": \""+vin+"\",\r\n"
			+ "      \"customerId\": \""+customerId+"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
	public static String getEquipmentTelematicsStatusWithOnlyCustomerId(String customerId)
	{
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      telematicsStatus\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerId\": \""+customerId+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public static String getEquipmentTelematicsStatusBodyWithOnlyVin(String vin)
	{
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      telematicsStatus\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"vin\": \""+vin+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
}