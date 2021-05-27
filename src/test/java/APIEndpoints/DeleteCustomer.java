package APIEndpoints;

import java.util.Hashtable;

import io.restassured.response.Response;
import setup.BaseTest;
import static io.restassured.RestAssured.*;


public class DeleteCustomer extends BaseTest {
	

	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String, String> data) {
		
		
		Response response = given().auth().basic(config.getProperty("ValidSecret"), "")
		.delete(config.getProperty("customerAPIEndpoint")+"/" +data.get("id"));
		
		return response;
	}

}

