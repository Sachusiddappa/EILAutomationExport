package payloads;

public class GetTelematicsEquipmentCountPayloads {
	

	public static String getGetTelematicsEquipmentCountBody(String telematicStatus,String customerGrid,String activeIndicator,String limit) {
		
		return "{\r\n"
				+ "  \"query\": \"query GetTelematicsEquipmentCount($filter: FilterTelematicsEquipmentCountInput) {\\r\\n  getTelematicsEquipmentCount(filter: $filter) {\\r\\n    customerId\\r\\n    customerGRId\\r\\n    equipmentCount\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"telematicsStatus\": \""+telematicStatus+"\",\r\n"
				+ "      \"customerGRId\": \""+customerGrid+"\",\r\n"
				+ "      \"activeIndicator\": \""+activeIndicator+"\",\r\n"
				+ "      \"limit\": "+limit+"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
   public static String getGetTelematicsEquipmentCountBody(String[] telematicStatus,String[] customerGrid,String[] activeIndicator,String limit) {
		
		String s= "{\r\n"
				+ "  \"query\": \"query GetTelematicsEquipmentCount($filter: FilterTelematicsEquipmentCountInput) {\\r\\n  getTelematicsEquipmentCount(filter: $filter) {\\r\\n    customerId\\r\\n    customerGRId\\r\\n    equipmentCount\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"telematicsStatus\": [{telematicStatus}],\r\n"
				+ "      \"customerGRId\": [{customerGrid}],\r\n"
				+ "      \"activeIndicator\": [{activeIndicator}],\r\n"
				+ "      \"limit\": 10\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		for(String ts: telematicStatus) {
			s=s.replace("{telematicStatus}", "\""+ts+"\",{telematicStatus}");
		}
		s=s.replace(",{telematicStatus}", "");
		
		for(String cg: customerGrid) {
			s=s.replace("{customerGrid}", "\""+cg+"\",{customerGrid}");
		}
		s=s.replace(",{customerGrid}", "");
		
		for(String ai: activeIndicator) {
			s=s.replace("{activeIndicator}", "\""+ai+"\",{activeIndicator}");
		}
		s=s.replace(",{activeIndicator}", "");
		return s;
	}
   
   
   public static String getGetTelematicsEquipmentCountBody(String telematicStatus,String activeIndicator,String limit) {
		
		return "{\r\n"
				+ "  \"query\": \"query GetTelematicsEquipmentCount($filter: FilterTelematicsEquipmentCountInput) {\\r\\n  getTelematicsEquipmentCount(filter: $filter) {\\r\\n    customerId\\r\\n    customerGRId\\r\\n    equipmentCount\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"telematicsStatus\": \""+telematicStatus+"\",\r\n"
				+ "      \"activeIndicator\": \""+activeIndicator+"\",\r\n"
				+ "      \"limit\": "+limit+"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
   

}
