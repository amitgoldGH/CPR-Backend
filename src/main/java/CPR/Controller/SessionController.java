package CPR.Controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import CPR.Boundary.SessionBoundary;

@RestController
public class SessionController {
	
	
	//POST request, path="/api/sessions"
	//Accept: SessionBoundary
	//Return: SessionBoundary
	@RequestMapping(
			path="/api/sessions",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createSession(@RequestBody SessionBoundary session) {
		System.out.println("/api/sessions CREATE SESSION TYPE_POST called " + session.toString());
		return session;
		// TODO CREATE SESSION
	}
	
	//GET request, path="/api/sessions/{id}"
	//Accept: Nothing
	//Return array of all sessions in database
	@RequestMapping(
			path = "/api/sessions/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getSessionById(@PathVariable("id") String session_Id) {
		System.out.println("/api/sessions/" + session_Id + " GET SESSION BY ID TYPE_GET called");
		return new SessionBoundary(session_Id, "borat", new String[]{"Measure1","Measure2"}, new Date()); 
		// TODO: RETURN ALL SESSION BY ID
	}
	
	//PUT request, path="/api/sessions"
	//Accept: Updated SessionBoundary object of an existing SessionBoundary
	//Return: Nothing
	@RequestMapping(
			path = "/api/sessions",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateSession(@RequestBody SessionBoundary session) {
		System.out.println("/api/sessions UPDATE SESSION TYPE_PUT called " + session.toString());
		// TODO: Implement updating.
	}
}
