package coralAcademy.api.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.testng.annotations.Test;
import coralAcademy.api.util.WrapperClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Test_First {
	 String bearer_id ;
	 String parent_fname;
	@Test
	 void test_method1()
	{
		RestAssured.baseURI = "http://localhost:3000/";
		String response = given().log().all().header("Content-Type","application/json").body("{\n" + 
				"    \"user\": {\n" + 
				"        \"first_name\": \"test\",\n" + 
				"        \"last_name\": \"test_last\",\n" + 
				"        \"email\": \"test@mail.com\",\n" + 
				"        \"password\": \"test123\",\n" + 
				"        \"type\": \"email\"\n" + 
				"    }\n" + 
				"}").when().post("v1/parents")
		.then().
		assertThat().statusCode(200).header("Content-Type","application/json; charset=utf-8").body("data.user.first_name",equalTo("test"))
		.extract().response().asString();
		System.out.println(response);
		JsonPath js = WrapperClass.rawToJson(response);
		bearer_id= js.getString("data.access_token");
		parent_fname = js.getString("data.user.first_name");
		System.out.println(bearer_id);
	}

	void test_update()
	{
		RestAssured.baseURI = "http://localhost:3000/";
		given().log().all().header("Content-Type","application/json").body("{\n" + 
				"    \"user\": {\n" + 
				"        \"first_name\": \"test\",\n" + 
				"        \"last_name\": \"test_last\",\n" + 
				"        \"email\": \"test@mail.com\",\n" + 
				"        \"password\": \"test123\",\n" + 
				"        \"type\": \"email\"\n" + 
				"    }\n" + 
				"}").when().put("v1/parents").then().assertThat().statusCode(200);
	}
	@Test
	void test_retrieve()
	{
		
		RestAssured.baseURI = "http://localhost:3000/";
		String res = given().log().all().header("Authorization", "Bearer " + bearer_id,
	              "Content-Type","application/json").when().get("/v1/parents/profile").then().assertThat().statusCode(200).extract().response().asString();;
		String response = res.toString();
		System.out.println("The response is: " + response);
		JsonPath js = new JsonPath (response);
		Assert.assertEquals(parent_fname, js.getString("data.User.first_name"));
		
	}

}
