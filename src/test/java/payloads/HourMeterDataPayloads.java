package payloads;

public class HourMeterDataPayloads {
	public static String getHourmeterDataBody(String vin)
	{
		return "{\r\n"
				+ "  \"query\": \"query HourMeterData($vin: [String]!) {\\r\\n  hourMeterData(vin: $vin) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      keyHours\\r\\n      keyHoursSource\\r\\n      travelHours\\r\\n      travelHoursSource\\r\\n      activityHours\\r\\n      activityHoursSource\\r\\n      operatorPresenceHours\\r\\n      operatorPresenceHourSource\\r\\n      liftHydraulicHours\\r\\n      liftHydraulicHourSource\\r\\n      dateTimeStamp\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"vin\": \""+vin+"\"\r\n"
				+ "  }\r\n"
				+ "}";	
}
	public static String getHourmeterDataBody(String[] vinData)
	{
		String s="{\r\n"
				+ "  \"query\": \"query HourMeterData($vin: [String]!) {\\r\\n  hourMeterData(vin: $vin) {\\r\\n    records {\\r\\n      vin\\r\\n      message\\r\\n      keyHours\\r\\n      keyHoursSource\\r\\n      travelHours\\r\\n      travelHoursSource\\r\\n      activityHours\\r\\n      activityHoursSource\\r\\n      operatorPresenceHours\\r\\n      operatorPresenceHourSource\\r\\n      liftHydraulicHours\\r\\n      liftHydraulicHourSource\\r\\n      dateTimeStamp\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
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
