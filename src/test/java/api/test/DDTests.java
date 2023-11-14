package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
public void testPostUser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password,String Phone) {
	
	//create payload object from user class to define payload for post request
	User payload = new User();
	payload.setId(Integer.parseInt(UserID));
	payload.setUsername(UserName);
	payload.setFirstName(FirstName);
	payload.setLastName(LastName);
	payload.setEmail(Email);
	payload.setPassword(Password);
	payload.setPhone(Phone);
	Response res = UserEndPoints.CreateUser(payload);
	//res.then().log().body();
	Assert.assertEquals(res.getStatusCode(), 200);
	
}
@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
public void testgetUserbyUserName(String UserName) {
	Response res = UserEndPoints.ReadUser(UserName);
	res.then().log().body();
	Assert.assertEquals(res.getStatusCode(), 200);
}
@Test(priority=3,dataProvider="UserNames", dataProviderClass=DataProviders.class)
public void testDeleteUserbyName(String UserName) {
	Response res = UserEndPoints.ReadUser(UserName);
	Assert.assertEquals(res.getStatusCode(), 200);
	
}
}
