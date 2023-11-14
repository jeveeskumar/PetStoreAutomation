package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.endpoint.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
    Faker fo;
    User payload;
    public Logger logger;
	@BeforeClass
	public void Setupdata() {
		fo = new Faker();
		payload = new User();
		payload.setId(fo.idNumber().hashCode());
		payload.setUsername(fo.name().username());
		payload.setFirstName(fo.name().firstName());
		payload.setLastName(fo.name().lastName());
		payload.setEmail(fo.internet().safeEmailAddress());
		payload.setPassword(fo.internet().password(5, 10));
		payload.setPhone(fo.phoneNumber().cellPhone());
		logger = LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	public void testPostUser() {
	logger.info("********** creating user **********");	
	//Response res=	UserEndPoints.CreateUser(payload);
	Response res = UserEndPoints2.CreateUser(payload);
	res.then().log().all();
	logger.info("********** user is created **********");
	Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testGetUserbyName() {
		logger.info("********** reading user info **********");
		//Response res =	UserEndPoints.ReadUser(this.payload.getUsername());
		Response res = UserEndPoints2.ReadUser(this.payload.getUsername());
		res.then().log().all();
		logger.info("********** user info is displayed **********");
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	@Test(priority=3)
	public void testUpdateUserbyName() {
		logger.info("********** updating user info **********");
		//update data using payload
		payload.setFirstName(fo.name().firstName());
		payload.setLastName(fo.name().lastName());
		payload.setEmail(fo.internet().safeEmailAddress());
		//Response res =	UserEndPoints.UpdateUser(payload, this.payload.getUsername());
		Response res = UserEndPoints2.UpdateUser(payload,this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("********** user info is updated **********");
		//checking data after update
		logger.info("********** getting user info after update **********");
		//Response update = UserEndPoints.ReadUser(this.payload.getUsername());
		Response update = UserEndPoints2.ReadUser(this.payload.getUsername());
		update.then().log().body();
		logger.info("********** user info after update is retrieved **********");
		Assert.assertEquals(update.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeleteUserbyName() {
		logger.info("********** deleting user info **********");
		//Response res =	UserEndPoints.DeleteUser(this.payload.getUsername());
		Response res = UserEndPoints2.DeleteUser(this.payload.getUsername());
		logger.info("********** user info is deleted **********");
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
}
