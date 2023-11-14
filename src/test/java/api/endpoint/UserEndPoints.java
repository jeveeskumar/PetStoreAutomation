package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// UserEndPoints
// Created to perform CRUD operations
public class UserEndPoints {
	public static Response CreateUser(User payload) {
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
		.post(Routes.post_url);
		return res;
		
	}
	public static Response ReadUser(String userName) {
		Response res =given()
				.pathParam("username", userName)
		.when()
		.get(Routes.get_url);
		return res;
		
	}
	public static Response UpdateUser(User payload, String userName) {
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
		.when()
		.put(Routes.put_url);
		return res;
		
	}
	public static Response DeleteUser(String userName) {
		Response res =given()
				.pathParam("username", userName)
		.when()
		.delete(Routes.delete_url);
		return res;
		
	}
}
