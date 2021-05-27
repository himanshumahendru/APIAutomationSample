package testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIEndpoints.CreateCustomer;
import io.restassured.response.Response;
import setup.BaseTest;
import utilities.DataUtil;

public class CreateCustomerTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable <String,String> data) {
		
		Response response = CreateCustomer.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomer.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		//ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();

		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}
	
}
