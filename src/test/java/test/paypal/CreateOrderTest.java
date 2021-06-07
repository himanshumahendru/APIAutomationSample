package test.paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import paypal.APIs.OrderAPI;
import setup.BaseTest;

public class CreateOrderTest extends BaseTest {
	
	
	@Test
	public void createOrderTest() {
		
		String access_token = OrderAPI.getAccessToken();
		Response response = OrderAPI.createOrder(access_token);
		Assert.assertEquals(response.jsonPath().get("status").toString(), "CREATED");
		response.prettyPrint();
		
	}

}
