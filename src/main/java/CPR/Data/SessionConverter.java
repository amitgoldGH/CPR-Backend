package CPR.Data;

import org.springframework.stereotype.Component;

import CPR.Boundary.SessionBoundary;

@Component
public class SessionConverter {
	
	public SessionBoundary convertToBoundary(SessionEntity entity)
	{
		SessionBoundary sessionBoundary=new SessionBoundary();

		sessionBoundary.setSession_Id(entity.getSession_Id());
		sessionBoundary.setUsername(entity.getUsername());
		sessionBoundary.setMeasurement_Summary(entity.getMeasurement_Summary());
		sessionBoundary.setCreation_Date(entity.getCreation_Date());
		
		return sessionBoundary;

	}
	public SessionEntity convertToEntity(SessionBoundary boundary)
	{
		SessionEntity sessionEntity=new SessionEntity();

		sessionEntity.setSession_Id(boundary.getSession_Id());
		sessionEntity.setUsername(boundary.getUsername());
		sessionEntity.setMeasurement_Summary(boundary.getMeasurement_Summary());
		sessionEntity.setCreation_Date(boundary.getCreation_Date());
		
		return sessionEntity;

	}

}
