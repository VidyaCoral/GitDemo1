package coralAcademy.api.test.parent;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ParentGoogleLoginEmail {
	
	@Test
	public static void parentLogin()
	{
		
		String bearer_token ="ea82c617e24d3d0d65c6b55b8c003a8b973e349f"; 
		RestAssured.baseURI = "http://localhost:3000/";
		 System.out.println("In the class");
		 System.out.println(bearer_token);
		 //String bearer_token = ParentRegisterEmail.bearerToken();
		 
		String response  = given().log().all().
						   header("Content-Type","application/json").
						   body("{\n" + 
						   		"    \"user\": {\n" + 
						   		"        \"google_token_id\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6IjE3MTllYjk1N2Y2OTU2YjU4MThjMTk2OGZmMTZkZmY3NzRlNzA4ZGUiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiMjY5MTUwNzY5OTc4LTNvYTNhNmMyNzdjbGJpOHJzMjRpbmdvcmo3bDRqbzIzLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMjY5MTUwNzY5OTc4LTNvYTNhNmMyNzdjbGJpOHJzMjRpbmdvcmo3bDRqbzIzLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA5NjcxNzkwMDMxODI4NzUwNDA1IiwiZW1haWwiOiJqb3NlcGhyb21hcmlvQHJvY2tldG1haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiJOQXhrNWNoamJsZVBDNVRZZVlkeTNBIiwibmFtZSI6IlIgSm9zZXBoIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hLS9BT2gxNEdqTHFQbm9BOHpCNmJLRW9nNmRsWXFmMm1WTXN0MW5IVGZNQmVPQT1zOTYtYyIsImdpdmVuX25hbWUiOiJSIiwiZmFtaWx5X25hbWUiOiJKb3NlcGgiLCJsb2NhbGUiOiJlbiIsImlhdCI6MTYyMjYwMDcyMSwiZXhwIjoxNjIyNjA0MzIxLCJqdGkiOiJjNTZhMTM4NDc4YzVkNThhZjFiYzZkZjUyYmFkMjE1MTIxNGU4OTU3In0.CwEk0KMuO8OGFa8RYOktyzAJTA8Rc1E89_vjLZHkMV8FsUMkna9nghgHK_scGTLgxKwTSuqqWjySzpeFuQcfCvuGEv1oqXmrxQpLwWxjGjvqT_Ral6bJoqjl2tlaj-umEwckjWbcl3n3zn6AQb7UkCaHWAvCUPQutZMygbH7PqQ1zCJJz6Vwwbrp4kdh0yrusliOnV15Qc4D3XTFyfzJPLKlNWBLGojFSYq-pWuYd7wIRvUDWbXGRnlStbWGZQtGdw58KXGkq3Wg8eaU3JUCVeQkCUUpaYtWnpUJkeexw9JpQEXfwYayF4RSCn-xTLJMXs9da_n3KW5kwYajQUiupQ\",\n" + 
						   		"        \"type\": \"google\"\n" + 
						   		"    }\n" + 
						   		"}").
						   when().post("/v1/parents/login").
						   then().assertThat().statusCode(200).extract().response().asString();

//		JsonPath js = WrapperClass.rawToJson(response);
//		Assert.assertEquals("test",js.getString("data.user.first_name"));
	}

}
