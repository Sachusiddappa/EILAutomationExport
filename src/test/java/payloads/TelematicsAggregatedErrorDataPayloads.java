package payloads;

public class TelematicsAggregatedErrorDataPayloads {
	public static String getTelematicsAggregatedErrorDataBody(String fromDate, String toDate,String[] vinData)
	{
		String s="{\r\n"
				+ "  \"query\": \"query Records($filter: FilterTelematicsAggregatedErrorData) {\\r\\n  telematicsAggregatedErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n      unknown\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
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
public static String getTelematicsAggregatedErrorDataBodyWithoutVin(String fromDate, String toDate)
{
	return "{\r\n"
			+ "  \"query\": \"query Records($filter: FilterTelematicsAggregatedErrorData) {\\r\\n  telematicsAggregatedErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n      unknown\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"fromDate\": \""+fromDate+"\",\r\n"
			+ "      \"toDate\": \""+toDate+"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
public static String getTelematicsAggregatedErrorDataBodyWithoutFromDate(String toDate,String vin)
{
	return "{\r\n"
			+ "  \"query\": \"query Records($filter: FilterTelematicsAggregatedErrorData) {\\r\\n  telematicsAggregatedErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n      unknown\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"toDate\": \""+toDate+"\",\r\n"
			+ "      \"vin\": [\r\n"
			+ "        \""+vin+"\"\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
public static String getTelematicsAggregatedErrorDataBodyWithoutToDate(String fromDate, String vin)
{
	return "{\r\n"
			+ "  \"query\": \"query Records($filter: FilterTelematicsAggregatedErrorData) {\\r\\n  telematicsAggregatedErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n      unknown\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"fromDate\": \""+fromDate+"\",\r\n"
			+ "      \"vin\": [\r\n"
			+ "        \""+vin+"\"\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
public static String getTelematicsAggregatedErrorDataBodyOnlyWithVin(String vin)
{
	return "{\r\n"
			+ "  \"query\": \"query Records($filter: FilterTelematicsAggregatedErrorData) {\\r\\n  telematicsAggregatedErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      high\\r\\n      medium\\r\\n      low\\r\\n      unknown\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"filter\": {\r\n"
			+ "      \"vin\": [\r\n"
			+ "        \""+vin+"\"\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
}
}
