package paypal.APIs;

import setup.BaseTest;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import POJO.Order;
import POJO.PurchaseUnits;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderAPI extends BaseTest {

	static String access_token;
	static String orderID;
	static String clientId = config.getProperty("paypalClientID");
	static String secret = config.getProperty("paypalSecret");

	public static String getAccessToken() {

		access_token = given().param("grant_type", "client_credentials").auth().preemptive().basic(clientId, secret)
				.post("v1/oauth2/token").jsonPath().get("access_token").toString();
		System.out.println("access Token is " + access_token);

		return access_token;

	}

	public static Response createOrder(String access_token) {

		ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
		list.add(new PurchaseUnits("USD", "100.00"));
		Order order = new Order("CAPTURE", list);

		Response response = given().auth().oauth2(access_token).contentType(ContentType.JSON).body(order)
				.post("v2/checkout/orders");

		System.out.println("Status code of response is " + response.statusCode());
		System.out.println(order);
		response.prettyPrint();

		orderID = response.jsonPath().get("id").toString();

		return response;

	}

	public static Response getOrder(String access_token) {
		
		Response response = given().auth().oauth2(access_token)
				.contentType(ContentType.JSON)
				.post("/v2/checkout/orders"+"/"+ orderID);
		
		return response;

	}

}
