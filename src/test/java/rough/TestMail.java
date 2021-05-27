package rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import utilities.MonitoringMail;
import utilities.TestConfig;

public class TestMail {

	public static void main(String[] args) throws UnknownHostException {

		String messageBody;
		
		MonitoringMail mail = new MonitoringMail();
		messageBody = "http://"+InetAddress.getLocalHost().getHostAddress() + ":8080/job/RestAssuredSampleProject/HTML_20Report/";
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,  TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
