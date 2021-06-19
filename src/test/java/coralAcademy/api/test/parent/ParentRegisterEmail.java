package coralAcademy.api.test.parent;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import coralAcademy.api.util.WrapperClass;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;


import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class ParentRegisterEmail {
	
	static String registerEmailResponse;
	public void baseURI()
	{
		RestAssured.baseURI = "http://localhost:3000/";
	}
	@Test(dataProvider="ParentDetails")
	public void registerEmail(String fname,String lname,String email_id,String password)
	{
		RestAssured.baseURI = "http://localhost:3000/";
		registerEmailResponse = given().log().all().header("Content-Type","application/json").body("{\n" + 
				"    \"user\": {\n" + 
				"        \"first_name\": \""+fname+"\",\n" + 
				"        \"last_name\": \""+ lname +"\",\n" + 
				"        \"email\": \""+email_id+"\",\n" + 
				"        \"password\": \""+password+"\",\n" + 
				"        \"type\": \"email\"\n" + 
				"    }\n" + 
				"}").when().post("/v1/parents").then().assertThat().statusCode(200).header("Content-Type","application/json; charset=utf-8").
		body("data.user.email",equalTo(email_id)).extract().response().asString();
		System.out.println(registerEmailResponse);
		
	}
	@Test
	public static void verifyEmailRegistration()
	{
		JsonPath js = WrapperClass.rawToJson(registerEmailResponse);
		System.out.println(js.getJsonObject(registerEmailResponse));
		String first_name = js.getString("data.user.first_name");
		String last_name = js.getString("data.user.last_name");
		String email = js.getString("data.user.email");
		String bearer_token = js.getString("data.access_token");
		System.out.println(bearer_token);
		Assert.assertEquals(first_name, "test");
		Assert.assertEquals(last_name, "test_last");
		Assert.assertEquals(email, "test@mail.com");
		//ParentLoginEmail.parentLogin(bearer_token);
		ParentGetDetails.test_retrieve(first_name,bearer_token);
		//return first_name;
	}
	@DataProvider(name="ParentDetails")
	public Object[][] parentDetails()
	{
		return new Object[][] {{"fname","lname","test@mail.com","test123"},
							  //{"fname1","lname1","test1@mail.com","test123"},
							  // {"test2","fname2","lname2","test2@mail.com","password2"}
							  };
	}
	
	

}
