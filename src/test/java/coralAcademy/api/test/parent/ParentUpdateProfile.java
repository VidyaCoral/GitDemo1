package coralAcademy.api.test.parent;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ParentUpdateProfile {
	@Test
	public static void profileUpdate()
	{
		
		String bearer_token ="ea82c617e24d3d0d65c6b55b8c003a8b973e349f"; 
		RestAssured.baseURI = "http://localhost:3000/";
		System.out.println(bearer_token);
		 //String bearer_token = ParentRegisterEmail.bearerToken();
		 
		String response  = given().log().all().
						   header("Content-Type","application/json").
						   body("{\n" + 
						   		"    \"profile\" : {\n" + 
						   		"        \"create\" : {\n" + 
						   		"            \n" + 
						   		"        },\n" + 
						   		"        \"update\" : {\n" + 
						   		"            \"Kids\" : [\n" + 
						   		"                {\n" + 
						   		"                    \"id\" : 55,\n" + 
						   		"                    \"name\" : \"Kids 1\",\n" + 
						   		"                    \"profile_picture\" : \" \",\n" + 
						   		"                    \"description\" : \"Kidss 1\",\n" + 
						   		"                    \"birth_date\" : \"2000-01-01\",\n" + 
						   		"                    \"info\" : \"Anak 1\"\n" + 
						   		"                },\n" + 
						   		"                {\n" + 
						   		"                    \"id\" : 54,\n" + 
						   		"                    \"name\" : \"Kids 2\",\n" + 
						   		"                    \"profile_picture\" : \" \",\n" + 
						   		"                    \"description\" : \"Kidss 2\",\n" + 
						   		"                    \"birth_date\" : \"2000-01-02\",\n" + 
						   		"                    \"info\" : \"Anak 2\"\n" + 
						   		"                }\n" + 
						   		"            ],\n" + 
						   		"            \"AdditionalEmails\" : [\n" + 
						   		"                {\n" + 
						   		"                    \"id\" : 36,\n" + 
						   		"                    \"email\" : \"hey@hey.com\"\n" + 
						   		"                },\n" + 
						   		"                {\n" + 
						   		"                    \"id\" : 35,\n" + 
						   		"                    \"email\" : \"hey2@hey.com\"\n" + 
						   		"                }\n" + 
						   		"            ],\n" + 
						   		"            \"TimePreferences\" : [\n" + 
						   		"                {\n" + 
						   		"                    \"id\" : 39,\n" + 
						   		"                    \"day\" : \"Monday\",\n" + 
						   		"                    \"start_time\" : \"07:00\",\n" + 
						   		"                    \"end_time\" : \"09:00\"\n" + 
						   		"                },\n" + 
						   		"                {\n" + 
						   		"                    \"id\" : 38,\n" + 
						   		"                    \"day\" : \"Tuesday\",\n" + 
						   		"                    \"start_time\" : \"07:00\",\n" + 
						   		"                    \"end_time\" : \"09:00\"\n" + 
						   		"                }\n" + 
						   		"            ]\n" + 
						   		"        },\n" + 
						   		"        \"delete\" : {},\n" + 
						   		"        \"timezone\" : \"Asia/Jakarta\",\n" + 
						   		"        \"first_name\" : \"budi\",\n" + 
						   		"        \"last_name\" : \"jek\"\n" + 
						   		"    }\n" + 
						   		"}").
						   when().post("/v1/parents/profile").
						   then().assertThat().statusCode(200).extract().response().asString();
	}
}
