package CPR.Data;

import CPR.Boundary.SampleBoundary;

public class SampleConverter {

	public SampleBoundary convertToBoundary(SampleEntity entity)
	{
		SampleBoundary sampleBoundary=new SampleBoundary();

		sampleBoundary.setSample_Id(entity.getSample_Id());
		sampleBoundary.setSession_Id(entity.getSession_Id());
		sampleBoundary.setMeasurements(entity.getMeasurements());
		
		return sampleBoundary;

	}
	public SampleEntity convertToEntity(SampleBoundary boundary)
	{
		SampleEntity sampleEntity=new SampleEntity();
		
		sampleEntity.setSample_Id(boundary.getSample_Id());
		sampleEntity.setSession_Id(boundary.getSession_Id());
		sampleEntity.setMeasurements(boundary.getMeasurements());
		
		return sampleEntity;

	}
}
