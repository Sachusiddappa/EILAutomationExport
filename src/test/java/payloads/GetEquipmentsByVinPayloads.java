package payloads;

public class GetEquipmentsByVinPayloads {
	public static String getEquipmentByVinDataBody(String vin) {
	return "{\r\n"
			+ "  \"query\": \"query GetEquipmentsByVin($vin: [String]!) {\\r\\n  getEquipmentsByVin(vin: $vin) {\\r\\n    truckNo\\r\\n    equipmentType\\r\\n    equipmentTypeDesc\\r\\n    lineOnDate\\r\\n    vin\\r\\n    telematicsStatus\\r\\n    equipmentId\\r\\n    fleetEquipId\\r\\n    customerAssetNo\\r\\n    corpFleetNo\\r\\n    chassisNo\\r\\n    externalVehNo\\r\\n    frameNo\\r\\n    serialNo\\r\\n    buildDate\\r\\n    mastSerialNo\\r\\n    equipmentStatus\\r\\n    estimatedDeliveryDate\\r\\n    dateAdded\\r\\n    dateFirstUse\\r\\n    age\\r\\n    tsdrNumber\\r\\n    activeIndicator\\r\\n    fleetStatusActiveInd\\r\\n  }\\r\\n}\",\r\n"
			+ "  \"variables\": {\r\n"
			+ "    \"vin\": \""+vin+"\"\r\n"
			+ "  }\r\n"
			+ "}";

}
	public static String getEquipmentByVinDataBody(String[] vinData) {
		String s="{\r\n"
				+ "  \"query\": \"query GetEquipmentsByVin($vin: [String]!) {\\r\\n  getEquipmentsByVin(vin: $vin) {\\r\\n    truckNo\\r\\n    equipmentType\\r\\n    equipmentTypeDesc\\r\\n    lineOnDate\\r\\n    vin\\r\\n    telematicsStatus\\r\\n    equipmentId\\r\\n    fleetEquipId\\r\\n    customerAssetNo\\r\\n    corpFleetNo\\r\\n    chassisNo\\r\\n    externalVehNo\\r\\n    frameNo\\r\\n    serialNo\\r\\n    buildDate\\r\\n    mastSerialNo\\r\\n    equipmentStatus\\r\\n    estimatedDeliveryDate\\r\\n    dateAdded\\r\\n    dateFirstUse\\r\\n    age\\r\\n    tsdrNumber\\r\\n    activeIndicator\\r\\n    fleetStatusActiveInd\\r\\n  }\\r\\n}\",\r\n"
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