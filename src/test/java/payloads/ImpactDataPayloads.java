package payloads;

public class ImpactDataPayloads {

	public static String getImpactDataBody(String fromDate,String toDate,String[] vinData) {
		String s="{\r\n"
				+ "  \"query\": \"query ImpactData($filter: FilterImpactData) {\\r\\n  impactData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      fromDate\\r\\n      toDate\\r\\n      critical\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
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
	
	public static String getImpactDataBodyWithoutVin(String fromDate,String toDate) {
		return "{\r\n"
				+ "  \"query\": \"query ImpactData($filter: FilterImpactData) {\\r\\n  impactData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      fromDate\\r\\n      toDate\\r\\n      critical\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"fromDate\": \""+fromDate+"\",\r\n"
				+ "      \"toDate\": \""+toDate+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getImpactDataBodyWithoutToDate(String fromDate,String vin) {
		return "{\r\n"
				+ "  \"query\": \"query ImpactData($filter: FilterImpactData) {\\r\\n  impactData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      fromDate\\r\\n      toDate\\r\\n      critical\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"fromDate\": \""+fromDate+"\",\r\n"
				+ "      \"vin\": [\""+vin+"\"]\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getImpactDataBodyWithoutFromDate(String toDate,String vin) {
		return "{\r\n"
				+ "  \"query\": \"query ImpactData($filter: FilterImpactData) {\\r\\n  impactData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      fromDate\\r\\n      toDate\\r\\n      critical\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"toDate\": \""+toDate+"\",\r\n"
				+ "      \"vin\": [\""+vin+"\"]\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
}
