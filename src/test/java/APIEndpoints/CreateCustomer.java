package APIEndpoints;

import io.restassured.response.Response;
import setup.BaseTest;
import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomer extends BaseTest {
	
	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String,String> data) {
		// test comment 
		Response response = given().auth().basic("sk_test_51HxdAsB2gNNCSqnW0f0xuix3aOTZUqjqH7q2DN3JA4lEXmA35K0IoLz4e0Kjnmwn94R7OCJwNd2SCHyZoclmVu1s00hob0KYGc","").log().all()
				.formParam("email",data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		
		return response;
		
	}

	
public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String, String> data) {

		
		Response response = given().auth().basic(config.getProperty("InvalidSecret"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		
		return response;
	}
}
