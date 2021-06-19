package coralAcademy.api.test.parent;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ParentRegisterGoogleEmail {
	static String registerEmailResponse;
	public void baseURI()
	{
		RestAssured.baseURI = "http://localhost:3000/";
	}
	@Test
	public void registerEmail()
	{
		RestAssured.baseURI = "http://localhost:3000/";
		registerEmailResponse = given().log().all().header("Content-Type","application/json").body("{\n" + 
				"    \"user\": {\n" + 
				"        \"google_token_id\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6ImUxYWMzOWI2Y2NlZGEzM2NjOGNhNDNlOWNiYzE0ZjY2ZmFiODVhNGMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNTkzOTAyOTI5NjAwLWFobHZpcXY3ZXNmZWJhMDliOXZqcG9kaHBmdmtnbmo2LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNTkzOTAyOTI5NjAwLWFobHZpcXY3ZXNmZWJhMDliOXZqcG9kaHBmdmtnbmo2LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA0NDM0NDE0ODk3Mzk3MDk4NDI4IiwiaGQiOiJwYW5kYXRlY2guaW8iLCJlbWFpbCI6ImZlbGl4QHBhbmRhdGVjaC5pbyIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiMDFGMVdQMFAxdnVnTW5uWjNWcU1CUSIsIm5hbWUiOiJMYXVyZW5zaXVzIEZlbGl4IiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS8tLUR3dE1GR01zaUkvQUFBQUFBQUFBQUkvQUFBQUFBQUFBQUEvQU1adXVjbXQyYWtReUVKQk9aaUowSTJfeFZFZm4tTkV0dy9zOTYtYy9waG90by5qcGciLCJnaXZlbl9uYW1lIjoiTGF1cmVuc2l1cyIsImZhbWlseV9uYW1lIjoiRmVsaXgiLCJsb2NhbGUiOiJlbiIsImlhdCI6MTYxNzU5OTc1NCwiZXhwIjoxNjE3NjAzMzU0LCJqdGkiOiI5NWU1YWRjZGU5NzMwMzdjMDRhZmExMjBiNmNlNDEyYWNlYmY4OTJlIn0.Wd10SGk62eDMnDLCDudpsd_JDj5UyFe__172DbpypOTvngx8hm2Foxw8k8l0F8YDJFFYF3dErRp8yZT7z15rDznuZCfDY8z323kGwLbsCafB9I_gjwyI-AW98m4UXk-AHW9FRYGXgnolqb5lKCB-lZiN3HNsEObWH2ffa8j-TClknVxOHzsoCT7MpQbebzQMY09Q7wh8OlVW6b_3dGnLfR3DnlBvY7K94hgFzyGteStmUO2GCTM8UzFFMU8QKraT-s9doCDgjpBFKUTFcLqjoecd8deLXS3moSUGfmzR-hzdpwLqhZzXUaNKqFWv5RW5-WckbgFXh7p-HDuDJJR-Lg\",\n" + 
				"        \"type\": \"google\"\n" + 
				"    }\n" + 
				"}").when().post("/v1/parents").then().assertThat().statusCode(200).header("Content-Type","application/json; charset=utf-8").
		body("data.user.email",equalTo("test@mail.com")).extract().response().asString();
		System.out.println(registerEmailResponse);
	}

}
