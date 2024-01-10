package payloads;

public class TelematicsDataPayloads {
	public static String getTelematicsDataBody(String vin) {
		return "{\r\n"
				+ "  \"query\": \"query TelematicsData($vin: [String]!) {\\r\\n  telematicsData(vin: $vin) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      connectionState\\r\\n      vehicleConnectedState\\r\\n      batteryStateOfCharge\\r\\n      batteryVoltage\\r\\n      activeServiceLevels\\r\\n      dhuFirmwareVersion\\r\\n      configurationVersion\\r\\n      lastCommunicationDate\\r\\n      installationDate\\r\\n      installedDeviceId\\r\\n      telematicsDisplayInstalled\\r\\n      impactSensorInstalled\\r\\n      badgeReaderInstalled\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"vin\": \""+vin+"\"\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public static String getTelematicsDataBody(String[] vinData) {
		String s="{\r\n"
				+ "  \"query\": \"query TelematicsData($vin: [String]!) {\\r\\n  telematicsData(vin: $vin) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      connectionState\\r\\n      vehicleConnectedState\\r\\n      batteryStateOfCharge\\r\\n      batteryVoltage\\r\\n      activeServiceLevels\\r\\n      dhuFirmwareVersion\\r\\n      configurationVersion\\r\\n      lastCommunicationDate\\r\\n      installationDate\\r\\n      installedDeviceId\\r\\n      telematicsDisplayInstalled\\r\\n      impactSensorInstalled\\r\\n      badgeReaderInstalled\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
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
