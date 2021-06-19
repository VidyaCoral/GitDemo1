package coralAcademy.api.util;

import io.restassured.path.json.JsonPath;

public class WrapperClass {
	
	public static JsonPath rawToJson(String response)
	{
		
		JsonPath js = new JsonPath(response);
		System.out.println(js.prettyPrint());
		return js;
	}
	
	public static void payloadParentRegister()
	{
		
	}
	
	public static String payloadParentLogin(String email_id, String password)
	{
		String payload = "{\n" + 
				"    \"user\": {\n" + 
				"        \"email\": \""+email_id+"\",\n" + 
				"        \"password\": \""+password+"\",\n" + 
				"        \"type\": \"email\"\n" + 
				"    }\n" + 
				"}";
		//System.out.println(payload);
		return payload;
		
	}

}
