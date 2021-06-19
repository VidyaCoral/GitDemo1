package coralAcademy.api.test.parent;

import org.junit.Assert;
import org.testng.annotations.Test;

import coralAcademy.api.util.WrapperClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ParentLoginEmail {
	
	@Test
	public static void parentLogin()
	{
		
		String bearer_token ="ea82c617e24d3d0d65c6b55b8c003a8b973e349f"; 
		RestAssured.baseURI = "http://localhost:3000/";
		 System.out.println("In the class");
		 System.out.println(bearer_token);
		 //String bearer_token = ParentRegisterEmail.bearerToken();
		 
		String response  = given().log().all().
						   header("Authorization", "Bearer " + bearer_token,"Content-Type","application/json").
						   body("{\n" + 
						   		"    \"user\": {\n" + 
						   		"        \"email\": \"test@mail.com\",\n" + 
						   		"        \"password\": \"test123\",\n" + 
						   		"        \"type\": \"email\"\n" + 
						   		"    }\n" + 
						   		"}").
						   when().post("/v1/parents/login").
						   then().assertThat().statusCode(200).extract().response().asString();

//		JsonPath js = WrapperClass.rawToJson(response);
//		Assert.assertEquals("test",js.getString("data.user.first_name"));
	}

}
