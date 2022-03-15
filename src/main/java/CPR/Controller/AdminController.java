package CPR.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import CPR.Boundary.SampleBoundary;
import CPR.Boundary.SessionBoundary;
import CPR.Boundary.UserBoundary;
import CPR.Service.SampleService;
import CPR.Service.SessionService;
import CPR.Service.UserService;

@RestController
public class AdminController {

	private SampleService sampleService;
	private SessionService sessionService;
	private UserService userService;
	
	@Autowired
	public AdminController(SampleService sampleService, SessionService sessionService, UserService userService) {
		this.sampleService = sampleService;
		this.sessionService = sessionService;
		this.userService = userService;
	}
	
	//GET request, path="/api/users"
	//Accept: Nothing
	//Return: Array of all users in database
	@RequestMapping(
			path="/api/users",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Object[] getAllUsers() {
		System.out.println("ADMIN_CONTROLLER /api/users GET ALL USERS TYPE_GET called");
		
		return userService.getAllUsers();
		
		//return new UserBoundary[0];
		// TODO: IMPLEMENT GET ALL USERS
	}
	
	//DELETE request, path="/api/users"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path="/api/users",
			method = RequestMethod.DELETE)
	public void deleteAllUsers() {
		System.out.println("ADMIN_CONTROLLER /api/users DELETE ALL USERS TYPE_DELETE called");
		
		this.userService.deleteAllUsers();
		
		// TODO: Implement delete all users
	}
	
	//DELETE request, path="/api/users/{username}"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path="/api/users/{username}",
			method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("username") String username) {
		System.out.println("ADMIN_CONTROLLER /api/users/" + username + " DELETE USER TYPE_DELETE called");
		
		this.userService.deleteUser(username);
		
		// TODO: Implement delete user by username
	}
	
	
	
	//GET request, path="/api/sessions"
	//Accept: Nothing
	//Return array of all sessions in database
	@RequestMapping(
			path = "/api/sessions",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Object[] getAllSessions() {
		System.out.println("ADMIN_CONTROLLER /api/sessions GET ALL SESSIONS TYPE_GET called");
		
		return this.sessionService.getAllSessions();
		
		//return new SessionBoundary[0]; // TODO: RETURN ALL SESSIONS
	}
	
	//GET request, path="/api/sessions/user/{username}"
	//Accept: Nothing
	//Return array of all sessions in database related to that username.
	@RequestMapping(
			path = "/api/sessions/user/{username}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Object[] getAllSessionsByUser(@PathVariable("username") String username) {
		System.out.println("ADMIN_CONTROLLER /api/sessions/user/" +username + " GET ALL SESSIONS BY USER TYPE_GET called");
		
		return this.sessionService.getAllSessionsByUser(username);
		
		//return new SessionBoundary[0]; // TODO: RETURN ALL SESSIONS BY USERNAME
	}
	
	//DELETE request, path="/api/sessions"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path = "/api/sessions",
			method = RequestMethod.DELETE)
	public void deleteAllSessions() {
		System.out.println("ADMIN_CONTROLLER /api/sessions DELETE ALL SESSIONS TYPE_DELETE called");

		this.sessionService.deleteAllSessions();
		//TODO: IMPLEMENT  DELETE ALL SESSIONS
	}
	
	//DELETE request, path="/api/sessions/{id}"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path = "/api/sessions/{id}",
			method = RequestMethod.DELETE)
	public void deleteSessionById(@PathVariable("id") String session_Id) {
		System.out.println("ADMIN_CONTROLLER /api/sessions/" + session_Id + " DELETE SESSION BY ID TYPE_DELETE called");
		
		this.sessionService.deleteSessionById(session_Id);
		// TODO: IMPLEMENT  DELETE SESSION BY ID
	}
	
	//DELETE request, path="/api/sessions/user/{username}"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path = "/api/sessions/user/{username}",
			method = RequestMethod.DELETE)
	public void deleteSessionByUsername(@PathVariable("username") String username) {
		System.out.println("ADMIN_CONTROLLER /api/sessions/user/" + username + " DELETE SESSION BY USERNAME TYPE_DELETE called");
		
		this.sessionService.deleteSessionByUsername(username);
		
		// TODO: IMPLEMENT  DELETE SESSION BY USERNAME
	}
	
	
	//GET request, path="/api/samples"
	//Accept: Nothing
	//Return list of all samples in database
	@RequestMapping(
			path = "/api/samples",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getAllSamples() {
		System.out.println("ADMIN_CONTROLLER /api/samples GET ALL SAMPLES TYPE_GET called");
		
		return this.sampleService.getAllSamples();
		
		//return new SampleBoundary[0]; // TODO: RETURN ALL SAMPLES
	}
	
	//DELETE request, path="/api/samples"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path = "/api/samples",
			method = RequestMethod.DELETE)
	public void deleteAllSamples() {
		System.out.println("ADMIN_CONTROLLER /api/samples DELETE ALL SAMPLES TYPE_DELETE called");
		
		this.sampleService.deleteAllSamples();
		
		// TODO: Delete all samples
	}
	
	//DELETE request, path="/api/samples/{id}"
	//Accept: Nothing
	//Return: Nothing
	@RequestMapping(
			path = "/api/samples/{id}",
			method = RequestMethod.DELETE)
	public void deleteSample(@PathVariable("id") String sample_Id) {
		System.out.println("ADMIN_CONTROLLER /api/samples/" + sample_Id + " DELETE SAMPLE BY ID TYPE_DELETE called");
		
		this.sampleService.deleteSample(sample_Id);
		// TODO: Delete sample by id.
	}
		
}
