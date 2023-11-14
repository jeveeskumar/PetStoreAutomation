package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// UserEndPoints
// Created to perform CRUD operations
public class UserEndPoints2 {
	static ResourceBundle geturl(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");//load the routes.properties file in test/resources
		return routes;
	}
	
	
	public static Response CreateUser(User payload) {
		String post_url= geturl().getString("post_url");
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
		//.post(Routes.post_url);
		.post(post_url);
		return res;
		
	}
	public static Response ReadUser(String userName) {
		String get_url= geturl().getString("get_url");
		Response res =given()
				.pathParam("username", userName)
		.when()
		//.get(Routes.get_url);
		.get(get_url);
		return res;
		
	}
	public static Response UpdateUser(User payload, String userName) {
		String update_url = geturl().getString("put_url");
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
		.when()
		//.put(Routes.put_url);
		.put(update_url);
		return res;
		
	}
	public static Response DeleteUser(String userName) {
		String delete_url = geturl().getString("delete_url");
		Response res =given()
				.pathParam("username", userName)
		.when()
		//.delete(Routes.delete_url);
		.delete(delete_url);
		return res;
		
	}
}
