package payloads;

public class EquipmentPayloads {
	
	public static String getEquipmentDetailsBody(String vin,String customerId) {
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      truckNo\\r\\n      equipmentType\\r\\n      equipmentTypeDesc\\r\\n      lineOnDate\\r\\n      vin\\r\\n      telematicsStatus\\r\\n      equipmentId\\r\\n      fleetEquipId\\r\\n      customerAssetNo\\r\\n      corpFleetNo\\r\\n      chassisNo\\r\\n      externalVehNo\\r\\n      frameNo\\r\\n      serialNo\\r\\n      buildDate\\r\\n      mastSerialNo\\r\\n      equipmentStatus\\r\\n      estimatedDeliveryDate\\r\\n      dateAdded\\r\\n      dateFirstUse\\r\\n      age\\r\\n      tsdrNumber\\r\\n      activeIndicator\\r\\n      fleetStatusActiveInd\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"vin\": \""+vin+"\",\r\n"
				+ "      \"customerId\": \""+customerId+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getEquipmentDetailsBody(String customerId) {
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      truckNo\\r\\n      equipmentType\\r\\n      equipmentTypeDesc\\r\\n      lineOnDate\\r\\n      vin\\r\\n      telematicsStatus\\r\\n      equipmentId\\r\\n      fleetEquipId\\r\\n      customerAssetNo\\r\\n      corpFleetNo\\r\\n      chassisNo\\r\\n      externalVehNo\\r\\n      frameNo\\r\\n      serialNo\\r\\n      buildDate\\r\\n      mastSerialNo\\r\\n      equipmentStatus\\r\\n      estimatedDeliveryDate\\r\\n      dateAdded\\r\\n      dateFirstUse\\r\\n      age\\r\\n      tsdrNumber\\r\\n      activeIndicator\\r\\n      fleetStatusActiveInd\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerId\": \""+customerId+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getEquipmentDetailsBodyByVin(String vin) {
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      truckNo\\r\\n      equipmentType\\r\\n      equipmentTypeDesc\\r\\n      lineOnDate\\r\\n      vin\\r\\n      telematicsStatus\\r\\n      equipmentId\\r\\n      fleetEquipId\\r\\n      customerAssetNo\\r\\n      corpFleetNo\\r\\n      chassisNo\\r\\n      externalVehNo\\r\\n      frameNo\\r\\n      serialNo\\r\\n      buildDate\\r\\n      mastSerialNo\\r\\n      equipmentStatus\\r\\n      estimatedDeliveryDate\\r\\n      dateAdded\\r\\n      dateFirstUse\\r\\n      age\\r\\n      tsdrNumber\\r\\n      activeIndicator\\r\\n      fleetStatusActiveInd\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"vin\": \""+vin+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getEquipmentWarrantyDeatilsBody(String vin,String customerId) {
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      warranty {\\r\\n        sellingDealer\\r\\n        type\\r\\n        planCode\\r\\n        applicationNumber\\r\\n        expirationDate\\r\\n        planDescription\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"vin\": \""+vin+"\",\r\n"
				+ "      \"customerId\": \""+customerId+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	public static String getEquipmentWarrantyDeatilsBody(String customerId) {
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      warranty {\\r\\n        sellingDealer\\r\\n        type\\r\\n        planCode\\r\\n        applicationNumber\\r\\n        expirationDate\\r\\n        planDescription\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"customerId\": \""+customerId+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public static String getEquipmentWarrantyDeatilsBodyByVin(String vin) {
		return "{\r\n"
				+ "  \"query\": \"query Equipments($filter: FilterEquipmentInput) {\\r\\n  equipments(filter: $filter) {\\r\\n    records {\\r\\n      warranty {\\r\\n        sellingDealer\\r\\n        type\\r\\n        planCode\\r\\n        applicationNumber\\r\\n        expirationDate\\r\\n        planDescription\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\r\n"
				+ "  \"variables\": {\r\n"
				+ "    \"filter\": {\r\n"
				+ "      \"vin\": \""+vin+"\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}

}
