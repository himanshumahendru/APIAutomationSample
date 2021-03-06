package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utilities.ExcelReader;

public class BaseTest {
	
	public static Properties config = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".//src//test//resources//excel//testdata.xlsx");
	
	
	@BeforeSuite
	public void setup() {
		
		try {
			fis = new FileInputStream(".//src//test//resources//properties//Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//config.getProperty("baseURI");
		RestAssured.baseURI= config.getProperty("baseURI");
		//RestAssured.baseURI = "https://api.stripe.com";
		
		//RestAssured.basePath = config.getProperty("basePath");
		
		
	}
	
	
	@AfterSuite
	public void teardown() {
		
		
	}
	

}
