package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;

import APIEndpoints.DeleteCustomer;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import setup.BaseTest;
import utilities.DataUtil;
import utilities.TestUtil;

public class DeleteCustomerTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data" )
	public void deleteCustomer(Hashtable<String, String> data) {
		
		Response response = DeleteCustomer.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
		response.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());
		System.out.println(response.statusCode());
		
		//Validation of Key's value in Response 
		//String actual_id = response.jsonPath().get("id").toString();
		//Assert.assertEquals(actual_id, data.get("id"),"Id received is different from Excel data");
		
		// Validation of presence of a key in response 
		//JSONObject jsonObject = new JSONObject(response.asString());
		//System.out.println(jsonObject.has("id"));
		
		// Presence of a key in response 
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(),"id"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(),"deleted"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(),"object"));
		
		// Value of various Keys in Response 
		System.out.println("Value of Id from Response is - " +TestUtil.jsonKeyValue(response.asString(), "id"));
		System.out.println("Value of Deleted from Response is - " +TestUtil.jsonKeyValue(response.asString(), "deleted"));
		System.out.println("Value of Object from Response is - " +TestUtil.jsonKeyValue(response.asString(), "object"));
		
	}
	

}
