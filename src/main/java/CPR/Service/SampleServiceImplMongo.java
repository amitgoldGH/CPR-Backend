package CPR.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CPR.Boundary.SampleBoundary;
import CPR.DAL.SampleDao;
import CPR.Data.SampleConverter;
import CPR.Data.SampleEntity;
import CPR.Exception.SampleBadRequestException;
import CPR.Exception.SampleNotFoundException;

@Service
public class SampleServiceImplMongo implements SampleService{
	
//	private Map<String, SampleEntity> storage;
	private SampleDao sampleDao;
	private SampleConverter converter;
	private AtomicLong counter;
	
	@Autowired
	public SampleServiceImplMongo(SampleDao sampleDao, SampleConverter converter)
	{
		this.sampleDao = sampleDao;
		this.converter = converter;
	}
	
	@PostConstruct
	public void init()
	{	
		// initialize counter
		this.counter = new AtomicLong(1L);		
	}
	
	@Transactional
	@Override
	public Object createSample(SampleBoundary sample) {
		SampleEntity sampleEntity = converter.convertToEntity(sample);
		sampleEntity.setSampleId(String.valueOf(counter.getAndIncrement()));
		
		if (sampleEntity.getSampleId() != null && sampleEntity.getSessionId() != null)
		{
			System.out.println("createSample Success, storing in memory!");
			return this.sampleDao.save(sampleEntity);
			//return converter.convertToBoundary(sampleEntity);
		}
		else {
			System.out.println("\nERROR!!!!!!! createSample in SampleServiceImpl\n" + sampleEntity.toString());
			// TODO: Exception failed to create sample_id or invalid session_id in given sample.
			//return converter.convertToBoundary(new SampleEntity("NULL", "NULL", new String[] {"NULL"}));
			throw new SampleBadRequestException("Bad sample input given.");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<Object> retrieveAllSessionSamples(String session_Id) {
		
		List<SampleEntity> list =  sampleDao.findAllBySessionId(session_Id);
		
		return list.stream()
				.map(this.converter::convertToBoundary)
				.collect(Collectors.toList());
		
//		for (SampleEntity entity : storage.values().stream().parallel().collect(Collectors.toList())) {
//			if (entity.getSession_Id().equalsIgnoreCase(session_Id))
//				filteredList.add(converter.convertToBoundary(entity));
//		}
//		
//		return filteredList;
		
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Object> getAllSamples() {
		List<SampleEntity> list = sampleDao.findAll();
		
		return list.stream()
				.map(this.converter::convertToBoundary)
				.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public void updateSample(SampleBoundary update_sample) {
		if (update_sample.getSampleId() != null && update_sample.getSessionId() != null)
		{
			SampleEntity existingSample = sampleDao.findBySampleId(update_sample.getSampleId());
			if (existingSample == null)
				throw new SampleNotFoundException("Existing sample not found!");
				
			
			if (update_sample.getSessionId() != null)
				existingSample.setSessionId(update_sample.getSessionId());
			if (update_sample.getMeasurements() != null)
				existingSample.setMeasurements(update_sample.getMeasurements());
			sampleDao.deleteById(existingSample.getSampleId());
			sampleDao.save(existingSample);
			
			System.out.println("Update sample success, sample_id: " + update_sample.getSampleId() + " updated.");
		}
		else
		{
			throw new SampleBadRequestException("Bad input sample, sample id or session id are null");
			// TODO: Exception, invalid sample
		}
	}

	@Transactional
	@Override
	public void deleteAllSamples() {
		sampleDao.deleteAll();
		System.out.println("Sample Storage Cleared.");
		
	}

	@Transactional
	@Override
	public void deleteSample(String sample_Id) {
		if (sample_Id != null) {
			sampleDao.deleteById(sample_Id);
			System.out.println("Deleted sample with sample_Id: " + sample_Id);	
		}
		else {
			// TODO : EXCEPTION SAMPLE DOESNT EXIST			
		}
		
	}

}
