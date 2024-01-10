package payloads;

public class TelematicVehicleDataPayloads {
	
	public static String getTelematicVehicleDataBody(String vin) {
		return "{\r\n"
				+ "  \"query\": \"query TelematicsVehicleData($vin: [String]!) {\\r\\n  telematicsVehicleData(vin: $vin) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      longitude\\r\\n      latitude\\r\\n      dateTimeStamp\\r\\n      gnssFixType\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"vin\": [\r\n"
				+ "      \""+vin+"\"\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getTelematicVehicleDataBody(String[] vinData) {
		
		String s="{\r\n"
				+ "  \"query\": \"query TelematicsVehicleData($vin: [String]!) {\\r\\n  telematicsVehicleData(vin: $vin) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      longitude\\r\\n      latitude\\r\\n      dateTimeStamp\\r\\n      gnssFixType\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"vin\": [\r\n"
				+ "      {vinData}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}";
		
		for(String vin: vinData) {
			s=s.replace("{vinData}", "\""+vin+"\",{vinData}");
		}
		s=s.replace(",{vinData}", "");
		return s;
	}

}
