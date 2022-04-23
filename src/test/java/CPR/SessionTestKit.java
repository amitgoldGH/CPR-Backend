package CPR;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import CPR.Boundary.SessionBoundary;
import CPR.Data.SessionType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class SessionTestKit {
	private int port;
	// setup helper object to invoke HTTP requests
	private RestTemplate client;
	// setup a String used to represent the URL used to access the server
	private String url;
	private String test_Username;

	// get random port used by server
	@LocalServerPort
	public void setPort(int port) {
		this.port = port;
	}


	@PostConstruct
	public void initTestCase() {
		this.url = "http://localhost:" + this.port +"/api/sessions" ;
		this.client = new RestTemplate();
		this.test_Username = "testUser";

	}
	
	@BeforeEach 
	public void setUp() {
	}
	
	@AfterEach 
	public void tearDown() {
		this.client
		.delete(this.url);
	}
	
	//GIVEN
		//the server is up
	//WHEN
		//I invoke the POST request through the URL: /api/sessions
		//Inserting SessionBoundary
	//THEN
		//the respond status is 200(OK) and we get session boundary with generated ID
	//THIS TESTS BOTH CREATE AND READ ASPECTS
	@Test
	void testCreateSession() {
		SessionBoundary test_Session = this.client
				.postForObject(this.url
						, new SessionBoundary(null, test_Username, SessionType.CPR.name(), new String[0], new Date())
						, SessionBoundary.class); 
		
		assertThat(this.client
				.getForObject(this.url + "/{id}", SessionBoundary.class, test_Session.getSessionId()))
				.isNotNull()
				.isEqualTo(test_Session);
	}
	
	//GIVEN
		//the server is up
	//WHEN
		//I invoke the POST request through the URL: /api/sessions
		//Inserting SessionBoundary with null username
	//THEN
		//the respond status is 400(BAD_REQUEST) and we get exception.
	@Test
	void testFailedCreateSession() {
		boolean thrown = false;
		
		try {
			this.client
			.postForObject(this.url
					, new SessionBoundary(null, null, null, new String[0], new Date())
					, SessionBoundary.class); 
			
		}catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			
			assertThat(httpClientOrServerExc.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
			thrown = true;
		}
		
		if (!thrown) {
			fail("no exception was thrown");
		}	
	}
	
	//GIVEN
		//the server is up
		//session boundary with same id exists already
	//WHEN
		//I invoke the PUT request through the URL: /api/sessions
		//Inserting valid SessionBoundary
	//THEN
		//the respond status is 200(OK) and we get updated session boundary
	@Test
	void testUpdateSession() {
		SessionBoundary test_Session = new SessionBoundary(null, test_Username, SessionType.CPR.name(), new String[0], new Date());
		test_Session = this.client.postForObject(this.url, test_Session, SessionBoundary.class); // Put in the new id
		
		test_Session.setMeasurementSummary(new String[]{"Updated Measure Summary"});
		test_Session.setType(SessionType.BVM.name());
		
		this.client.put(this.url, test_Session);
		
		assertThat(this.client
				.getForObject(this.url + "/{id}", SessionBoundary.class, test_Session.getSessionId()))
				.isNotNull()
				.isEqualTo(test_Session);
		
	}
	
	//GIVEN
		//the server is up
	//WHEN
		//I invoke the PUT request through the URL: /api/sessions
		//Inserting SessionBoundary with null id
	//THEN
		//the respond status is 400(BAD_REQUEST) and we get exception.
	@Test
	void testFailedUpdateSession() {
		boolean thrown = false;
		
		SessionBoundary test_Session = new SessionBoundary(null, test_Username, SessionType.CPR.name(), new String[0], new Date());
		
		try {
			this.client.put(this.url, test_Session);
			
			}catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
				
				assertThat(httpClientOrServerExc.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
				thrown = true;
			}
			
			if (!thrown) {
				fail("no exception was thrown");
			}	
	}
	
	//GIVEN
		//the server is up
		//no session with id 1 exists
	//WHEN
		//I invoke the GET request through the URL: /api/sessions/1
	//THEN
		// The response status is 404(NOT_FOUND) and we get exception.
	@Test
	void testFailGetSession() {
		boolean thrown = false;
		
		try {
			this.client.getForObject(this.url + "/{id}", SessionBoundary.class, "1");
			
			}catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
				
				assertThat(httpClientOrServerExc.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
				thrown = true;
			}
			
			if (!thrown) {
				fail("no exception was thrown");
			}	
	}
	
	
	
}
