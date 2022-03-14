package CPR.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import CPR.Boundary.SampleBoundary;

@RestController
public class SampleController {
	
	
	//POST request, path="/iob/activities"
	//Accept: Activity Boundary with null activityId
	//Return: Any JSON Object
	@RequestMapping(
			path = "/cpr/samples",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object invokeActivity(@RequestBody SampleBoundary sample) {
		System.out.println(sample.toString());
		return sample;
	}
}
