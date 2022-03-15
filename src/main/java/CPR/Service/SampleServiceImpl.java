package CPR.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

import CPR.Boundary.SampleBoundary;
import CPR.Data.SampleEntity;

@Service
public class SampleServiceImpl implements SampleService {

	private Map<String, SampleEntity> storage;
	
	@Override
	public Object createSample(SampleBoundary sample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] retrieveAllSessionSamples(String session_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAllSamples() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSample(SampleBoundary sample) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllSamples() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSample(String sample_Id) {
		// TODO Auto-generated method stub
		
	}

}
