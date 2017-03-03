package gov.noaa.pmel.sdig.server;

import gov.noaa.pmel.sdig.client.ValueService;
import gov.noaa.pmel.sdig.shared.CountryCodes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ValueServiceImpl extends RemoteServiceServlet implements ValueService {

//	public String greetServer(String input) throws IllegalArgumentException {
//		// Verify that the input is valid. 
//		if (!FieldVerifier.isValidName(input)) {
//			// If the input is not valid, throw an IllegalArgumentException back to
//			// the client.
//			throw new IllegalArgumentException("Name must be at least 4 characters long");
//		}
//
//		String serverInfo = getServletContext().getServerInfo();
//		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
//
//		// Escape data from the client to avoid cross-site script vulnerabilities.
//		input = escapeHtml(input);
//		userAgent = escapeHtml(userAgent);
//
//		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
//				+ userAgent;
//	}
//
//	/**
//	 * Escape an html string. Escaping data received from the client helps to
//	 * prevent cross-site script vulnerabilities.
//	 * 
//	 * @param html the html string to escape
//	 * @return the escaped string
//	 */
//	private String escapeHtml(String html) {
//		if (html == null) {
//			return null;
//		}
//		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//	}

	/* (non-Javadoc)
	 * @see gov.noaa.pmel.sdig.client.GreetingService#getCountryCodes()
	 */
	@Override
	public CountryCodes getCountryCodes() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		SortedMap<String, String> countryMap = parseCountryCodeJson();
		CountryCodes countryCodes = new CountryCodes();
		countryCodes.setCountryCodes(countryMap);
		return countryCodes;
	}
	
	private SortedMap<String, String> parseCountryCodeJson() {
		  JSONParser parser = new JSONParser();
		  SortedMap<String, String> countryMap = new TreeMap<String, String>();
		  
	        try {

	            String country_path = getServletContext().getRealPath("resources/country_codes.json");
	            Object obj = parser.parse(new FileReader(country_path));
	 
	            JSONObject jsonObject = (JSONObject) obj;
	            JSONArray countries = (JSONArray) jsonObject.get("countries");
	            
	            System.out.println("\nCompany List:");
	     
	            for (int ii = 0; ii < countries.size(); ii++) {
	            	JSONObject jso = (JSONObject)countries.get(ii);
	            	countryMap.put(jso.get("name").toString(), jso.get("code").toString());
	            	System.out.println(jso.toString());
	            }
	   
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return countryMap;
	}
}
