package CPR.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CPR.Boundary.SampleBoundary;
import CPR.Data.SampleConverter;
import CPR.Data.SampleEntity;

@Service
public class SampleServiceImpl implements SampleService {

	private Map<String, SampleEntity> storage;
	private SampleConverter converter;
	private AtomicLong counter;
	
	@Autowired
	public SampleServiceImpl(SampleConverter converter)
	{
		this.converter = converter;
	}
	
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
			System.out.println("createSample Success, storing in memory!");
			storage.put(sampleEntity.getSample_Id(), sampleEntity);
			return converter.convertToBoundary(sampleEntity);
		}
		else {
			System.out.println("\nERROR!!!!!!! createSample in SampleServiceImpl\n");
			// TODO: Exception failed to create sample_id or invalid session_id in given sample.
			return converter.convertToBoundary(new SampleEntity("NULL", "NULL", new String[] {"NULL"}));
		}
	}

	@Override
	public List<Object> retrieveAllSessionSamples(String session_Id) {
		List<Object> filteredList = new ArrayList<Object>();
		
		for (SampleEntity entity : storage.values().stream().parallel().collect(Collectors.toList())) {
			if (entity.getSession_Id().equalsIgnoreCase(session_Id))
				filteredList.add(converter.convertToBoundary(entity));
		}
		
		return filteredList;
		
		
	}

	@Override
	public List<Object> getAllSamples() {
		return storage.values().stream().parallel().map(converter::convertToBoundary).collect(Collectors.toList());
	}

	@Override
	public void updateSample(SampleBoundary sample) {
		if (sample.getSample_Id() != null && sample.getSession_Id() != null)
		{
			if (storage.get(sample.getSample_Id()) != null)
			{
				storage.put(sample.getSample_Id(), converter.convertToEntity(sample));
				System.out.println("Update sample success, sample_id: " + sample.getSample_Id() + " updated.");
				
			}
			else 
			{
				// TODO: Exception existing sample with same id doesnt exist.
			}
		}
		else
		{
			// TODO: Exception, invalid sample
		}
	}

	@Override
	public void deleteAllSamples() {
		storage.clear();
		System.out.println("Sample Storage Cleared.");
		
	}

	@Override
	public void deleteSample(String sample_Id) {
		if (sample_Id != null) {
			storage.remove(sample_Id);
			System.out.println("Deleted sample with sample_Id: " + sample_Id);	
		}
		else {
			// TODO : EXCEPTION SAMPLE DOESNT EXIST			
		}
		
	}

}