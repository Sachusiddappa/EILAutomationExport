package payloads;

public class TelematicsErrorDataPayloads {

	public static String getTelematicsErrorDataPayloads(String fromDate, String toDate,String[] vinData)
	{
		String s="{\r\n"
				+ "  \"query\": \"query TelematicsErrorData($filter: FilterTelematicsErrorDataInput) {\\r\\n  telematicsErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      errorCodeData {\\r\\n        errorCode\\r\\n        errorCodeDescription\\r\\n        severity\\r\\n        dateTimeStamp\\r\\n        vehicleReaction\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
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
	public static String getTelematicsErrorDataPayloadsWithoutVin(String fromDate, String toDate)
	{
		return "{\r\n"
				+ "  \"query\": \"query TelematicsErrorData($filter: FilterTelematicsErrorDataInput) {\\r\\n  telematicsErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      errorCodeData {\\r\\n        errorCode\\r\\n        errorCodeDescription\\r\\n        severity\\r\\n        dateTimeStamp\\r\\n        vehicleReaction\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"fromDate\": \""+fromDate+"\",\r\n"
				+ "      \"toDate\": \""+toDate+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		
	}
	public static String getTelematicsErrorDataPayloadsWithoutFromDate(String toDate,String vin)
	{
		return "{\r\n"
				+ "  \"query\": \"query TelematicsErrorData($filter: FilterTelematicsErrorDataInput) {\\r\\n  telematicsErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      errorCodeData {\\r\\n        errorCode\\r\\n        errorCodeDescription\\r\\n        severity\\r\\n        dateTimeStamp\\r\\n        vehicleReaction\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"toDate\": \""+toDate+"\",\r\n"
				+ "      \"vin\": \""+vin+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public static String getTelematicsErrorDataPayloadsWithoutToDate(String fromDate,String vin)
	{
		return "{\r\n"
				+ "  \"query\": \"query TelematicsErrorData($filter: FilterTelematicsErrorDataInput) {\\r\\n  telematicsErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      errorCodeData {\\r\\n        errorCode\\r\\n        errorCodeDescription\\r\\n        severity\\r\\n        dateTimeStamp\\r\\n        vehicleReaction\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"fromDate\": \""+fromDate+"\",\r\n"
				+ "      \"vin\": \""+vin+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public static String getTelematicsErrorDataPayloadsOnlyWithVin(String vin)
	{
		return "{\r\n"
				+ "  \"query\": \"query TelematicsErrorData($filter: FilterTelematicsErrorDataInput) {\\r\\n  telematicsErrorData(filter: $filter) {\\r\\n    records {\\r\\n      vin\\r\\n      errorCodeData {\\r\\n        errorCode\\r\\n        errorCodeDescription\\r\\n        severity\\r\\n        dateTimeStamp\\r\\n        vehicleReaction\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"vin\": \""+vin+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	}
