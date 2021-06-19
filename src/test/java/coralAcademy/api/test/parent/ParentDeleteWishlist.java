package coralAcademy.api.test.parent;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ParentDeleteWishlist {
	@Test
	public static void AddWishlist()
	{
		
		
		String bearer_token ="ea82c617e24d3d0d65c6b55b8c003a8b973e349f"; 
		 
		RestAssured.baseURI = "http://localhost:3000/";
		String res = given().log().all().header("Authorization", "Bearer " + bearer_token,
	              "Content-Type","application/json").body("{\n" + 
	              		"    \"module_id\" : 1\n" + 
	              		"}").when().delete("v1/parents/wishlist").then().assertThat().statusCode(200).extract().response().asString();;
		String response = res.toString();
		System.out.println("The response is: " + response);
		JsonPath js = new JsonPath (response);
		

//		JsonPath js = WrapperClass.rawToJson(response);
//		Assert.assertEquals("test",js.getString("data.user.first_name"));
	}

}
