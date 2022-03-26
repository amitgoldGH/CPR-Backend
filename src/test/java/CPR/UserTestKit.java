package CPR;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class UserTestKit {
	private int port;
	// setup helper object to invoke HTTP requests
	private RestTemplate client;
	// setup a String used to represent the URL used to access the server
	private String url;
	private String deleteUsersURL;
	private String username, password;

	// get random port used by server
	@LocalServerPort
	public void setPort(int port) {
		this.port = port;
	}


	@PostConstruct
	public void initTestCase() {
		this.url = "http://localhost:" + this.port +"/api/users" ;
		this.client = new RestTemplate();
		this.username = "testUser";
		this.password = "testPassword";
		this.deleteUsersURL = "http://localhost:" + this.port + "/api/users/{username}";

	}
	
	@BeforeEach 
	public void setUp() {
		//create test user
		this.client.postForObject(this.url, new CPR.Boundary.NewUserBoundary(
				username, password
				),
				CPR.Boundary.NewUserBoundary.class);
	}
	
	@AfterEach 
	public void tearDown() {
		
		this.client
		.delete(this.deleteUsersURL, username);
	}
	
	//GIVEN
		//the server is up
	//WHEN
		//I invoke the POST request through the URL: /api/users
		//Inserting new UserBoundary
	//THEN
		//the respond status is 200(OK) and we get user boundary
	@Test
	void testCreateUser() {
			
			CPR.Boundary.NewUserBoundary newUserBoundary=new CPR.Boundary.NewUserBoundary("TestUsername", "TestPassword");
			
			CPR.Boundary.UserBoundary userBoundary = this.client.postForObject(this.url, newUserBoundary, CPR.Boundary.UserBoundary.class);
			
			
			assertThat(this.client
					.postForObject(this.url + "/login" , userBoundary, CPR.Boundary.UserBoundary.class))
					.isNotNull()
					.isEqualTo(userBoundary);
		}
}
