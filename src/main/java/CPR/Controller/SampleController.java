package CPR.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import CPR.Boundary.SampleBoundary;
import CPR.Service.SampleService;

@RestController
public class SampleController {
	
	private SampleService sampleService;
	
	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	//POST request, path="/api/samples"
	//Accept: Sample Boundary
	//Return: SampleBoundary
	@RequestMapping(
			path = "/api/samples",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object createSample(@RequestBody SampleBoundary sample) {
		System.out.println("SAMPLE_CONTROLLER /api/samples CREATE SAMPLE TYPE_POST called " + sample.toString());
		return this.sampleService.createSample(sample);
		
		//return sample; // TODO: Return sample via service
	}
	
	//GET request, path="/api/samples/session/{id}"
	//Accept: None
	//Return: SampleBoundary array
	@RequestMapping(
			path="/api/samples/session/{sessionId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public Object[] retrieveAllSessionSamples(
				@PathVariable("sessionId") String session_Id){
			System.out.println("SAMPLE_CONTROLLER /api/samples/session/" + session_Id + " RETRIEVE ALL SAMPLES OF GIVEN SESSION ID TYPE_GET called");
			return this.sampleService.retrieveAllSessionSamples(session_Id);
			
			//return new SampleBoundary[0]; // TODO: Return all samples with given session id
			//return userService.login(userDomain, userEmail);
		}
	
	//PUT request, path="/api/samples"
	//Accept: Sample boundary with id
	//Return: Nothing
	@RequestMapping(
			path="/api/samples",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateSample(@RequestBody SampleBoundary sample) {
		System.out.println("SAMPLE_CONTROLLER /api/samples UPDATE SAMPLE TYPE_PUT called " + sample.toString());
		this.sampleService.updateSample(sample);
		
		// TODO: Implement updating sample
	}
}
