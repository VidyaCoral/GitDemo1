package coralAcademy.api.test.parent;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ParentAddWishlist {
	@Test
	public static void AddWishlist()
	{
		
		
		RestAssured.baseURI = "http://localhost:3000/";
		 
		String response  = given().log().all().
						   header("Content-Type","application/json").
						   body("{\n" + 
						   		"    \"module_id\" : 1\n" + 
						   		"}").
						   when().post("/v1/parents/wishlist").
						   then().assertThat().statusCode(200).extract().response().asString();

//		JsonPath js = WrapperClass.rawToJson(response);
//		Assert.assertEquals("test",js.getString("data.user.first_name"));
	}

}
