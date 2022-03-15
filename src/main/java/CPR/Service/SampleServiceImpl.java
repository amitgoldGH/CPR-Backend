package CPR.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import CPR.Boundary.SampleBoundary;
import CPR.Data.SampleConverter;
import CPR.Data.SampleEntity;

@Service
public class SampleServiceImpl implements SampleService {

	private Map<String, SampleEntity> storage;
	private SampleConverter converter;
	private AtomicLong counter;
	
	@PostConstruct
	public void init()
	{
		// initialize thread safe storage
		this.storage = Collections.synchronizedMap(new HashMap<>());
		
		// initialize counter
		this.counter = new AtomicLong(1L);		
	}
	
	@Override
	public Object createSample(SampleBoundary sample) {
		SampleEntity sampleEntity = converter.convertToEntity(sample);
		sampleEntity.setSample_Id(String.valueOf(counter.getAndIncrement()));
		
		if (sampleEntity.getSample_Id() != null && sampleEntity.getSession_Id() != null)
		{
			storage.put(sampleEntity.getSample_Id(), sampleEntity);
			return sample;
		}
		else {
			System.out.println("\nERROR!!!!!!! createSample in SampleServiceImpl\n");
			return converter.convertToBoundary(new SampleEntity("NULL", "NULL", new String[] {"NULL"}));
		}
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
