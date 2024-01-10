package stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class utils {
	Logger logger = LogManager.getLogger(utils.class);
	List<String> valueslist = new ArrayList<String>();
	
	public Map<String, Object> headersMethod() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("contentType", "application/json");
		m.put("Authorization", "Bearer Coayp73SLJyIH1nsk0YigZ01qxaaUAMl");
		m.put("Ocp-Apim-Subscription-Key", "e04cfddaafe440b595dbc6b0ed058f24");
		m.put("Tenant-id", "tmh");
		return m;
	}
	
	public static Map<String, Object> devHeadersMethod() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("contentType", "application/json");
		m.put("Authorization", "Bearer Coayp73SLJyIH1nsk0YigZ01qxaaUAMl");
		m.put("Ocp-Apim-Subscription-Key", "e04cfddaafe440b595dbc6b0ed058f24");
		m.put("Tenant-id", "tmh");
		return m;
	}
	
	public static Map<String, Object> qaHeadersMethod() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("contentType", "application/json");
		m.put("Authorization", "Bearer eqmwz1b0stRzVg9YtdsdmwjZwg6qPy0Q");
		m.put("Ocp-Apim-Subscription-Key", "764305405adb46a7a89a40802a95b329");
		m.put("Tenant-id", "tmh");
		return m;
	}

}
