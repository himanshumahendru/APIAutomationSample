package test.paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import paypal.APIs.OrderAPI;
import setup.BaseTest;

public class GetOrderTest extends BaseTest {
	
	
	@Test
	public void getOrderTest() {
		
		String access_token = OrderAPI.getAccessToken();
		Response response = OrderAPI.getOrder(access_token);
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),200);
		
	}
	
	

}
