package CPR.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import CPR.Boundary.SampleBoundary;

public interface SampleService {
	
	//CREATE
	public Object createSample(SampleBoundary sample);
	
	//RETRIEVE
	public Object[] retrieveAllSessionSamples(String session_Id);
	
	public Object[] getAllSamples();
	
	//UPDATE
	public void updateSample(SampleBoundary sample);
	
	//DELETE
	public void deleteAllSamples();
	
	public void deleteSample(String sample_Id);


}
