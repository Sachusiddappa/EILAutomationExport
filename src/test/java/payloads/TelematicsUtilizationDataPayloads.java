package payloads;

public class TelematicsUtilizationDataPayloads {
	
	public static String getTelematicsUtilizationDataBody(String fromDate, String toDate,String[] vinData) {
		String s="{\r\n"
				+ "  \"query\": \"query TelematicsUtilizationData($filter: FilterTelematicsUtilization) {\\r\\n  telematicsUtilizationData(filter: $filter) {\\r\\n    records {\\r\\n      averageUtilization\\r\\n      hourMeter\\r\\n      message\\r\\n      vin\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"fromDate\": \""+fromDate+"\",\r\n"
				+ "      \"toDate\": \""+toDate+"\",\r\n"
				+ "      \"vin\": [\r\n"
				+ "        {vinData}\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		
	for(String vin: vinData) {
		s=s.replace("{vinData}", "\""+vin+"\",{vinData}");
	}
	s=s.replace(",{vinData}", "");
	return s;
	}
public static String getTelematicsUtilizationDataBodyWithoutVin(String fromDate, String toDate)
{
	return "{\r\n"
			+ "  \"query\": \"query TelematicsUtilizationData($filter: FilterTelematicsUtilization) {\\r\\n  telematicsUtilizationData(filter: $filter) {\\r\\n    records {\\r\\n      averageUtilization\\r\\n      hourMeter\\r\\n      message\\r\\n      vin\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"fromDate\": \""+fromDate+"\",\r\n"
			+ "      \"toDate\": \""+toDate+"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
public static String getTelematicsUtilizationDataBodyWithoutFromDate(String toDate,String vin)
{
	return "{\r\n"
			+ "  \"query\": \"query TelematicsUtilizationData($filter: FilterTelematicsUtilization) {\\r\\n  telematicsUtilizationData(filter: $filter) {\\r\\n    records {\\r\\n      averageUtilization\\r\\n      hourMeter\\r\\n      message\\r\\n      vin\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"toDate\": \""+toDate+"\",\r\n"
			+ "      \"vin\": \""+vin+"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
public static String getTelematicsUtilizationDataBodyWithoutToDate(String fromDate, String vin)
{
	return "{\r\n"
			+ "  \"query\": \"query TelematicsUtilizationData($filter: FilterTelematicsUtilization) {\\r\\n  telematicsUtilizationData(filter: $filter) {\\r\\n    records {\\r\\n      averageUtilization\\r\\n      hourMeter\\r\\n      message\\r\\n      vin\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"fromDate\": \""+fromDate+"\",\r\n"
			+ "      \"vin\": \""+vin+"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
}
	
