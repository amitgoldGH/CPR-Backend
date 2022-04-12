package CPR.Service;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CPR.Boundary.SessionBoundary;
import CPR.DAL.SessionDao;
import CPR.Data.SessionConverter;
import CPR.Data.SessionEntity;
import CPR.Exception.SessionBadRequestException;
import CPR.Exception.SessionNotFoundException;

@Service
public class SessionServiceImplMongo implements SessionService {
	private Map<String, SessionEntity> storage;
	private SessionConverter converter;
	private SessionDao sessionDao;
	private AtomicLong counter;
	
	@Autowired
	public SessionServiceImplMongo(SessionDao sessionDao, SessionConverter converter) {
		this.sessionDao = sessionDao;
		this.converter = converter;
	}
	
	@PostConstruct
	public void init()
	{	
		// initialize counter
		this.counter = new AtomicLong(1L);		
	}
	@Override
	public Object createSession(SessionBoundary session) {
		if (session.getUsername() != null) {
			SessionEntity entity = converter.convertToEntity(session);
			entity.setCreationDate(new Date());
			entity.setSessionId(String.valueOf(counter.getAndIncrement()));
			entity = sessionDao.save(entity);
			System.out.println("Created and stored session in memory successfully.");
			
			return converter.convertToBoundary(entity);
		}
		else {
			// TODO: Invalid username
			throw new SessionBadRequestException("Invalid Username");
		}
		//return null;
	}

	@Override
	public List<Object> getAllSessions() {
		return sessionDao.findAll()
				.stream().parallel()
				.map(converter::convertToBoundary)
				.collect(Collectors.toList());
	}
	

	@Override
	public List<Object> getAllSessionsByUser(String username) {		
		List<SessionEntity> list = sessionDao.findAllByUsername(username);
		
		return list.stream()
				.map(this.converter::convertToBoundary)
				.collect(Collectors.toList());
	}

	@Override
	public Object getSessionById(String session_Id) {
		if (session_Id != null)
		{
			SessionEntity entity = sessionDao.findBySessionId(session_Id);
			if (entity != null)
				return converter.convertToBoundary(entity);
			else
				throw new SessionNotFoundException("No session found with given id");
		}
		else
			throw new SessionBadRequestException("Invalid session id given.");
	}

	@Override
	public void updateSession(SessionBoundary session) {
		if (session.getSessionId() != null && session.getUsername() != null)
		{
			SessionEntity entity = sessionDao.findBySessionId(session.getSessionId());
			if (entity != null)
			{
				entity.setUsername(session.getUsername());
				
				if (session.getMeasurementSummary() != null)
					entity.setMeasurementSummary(session.getMeasurementSummary());
				
				sessionDao.save(entity);
				System.out.println("Update sample success, sample_id: " + session.getSessionId() + " updated.");
			}
			else 
			{
				// TODO: Exception existing session with same id doesnt exist.
				throw new SessionNotFoundException("Existing session with given id doesn't exist");
			}
		}
		else
		{
			// TODO: Exception, invalid session
			throw new SessionBadRequestException("Invalid session input given.");
		}
		
	}

	@Override
	public void deleteAllSessions() {
		sessionDao.deleteAll();
		System.out.println("Session storage cleared");
		
	}

	@Override
	public void deleteSessionById(String session_Id) {
		if (sessionDao.findBySessionId(session_Id) != null)
			sessionDao.deleteById(session_Id);
		else
			System.out.println("Session doesnt exist");
		// TODO Exception for session not found
		
	}

	@Override
	public void deleteSessionByUsername(String username) {
		int delCounter = 0;
		
		for (SessionEntity entity : sessionDao.findAllByUsername(username).stream().parallel().collect(Collectors.toList())) {
			sessionDao.deleteById(entity.getSessionId());
			delCounter++;
		}
		System.out.println("Delete session by username: " + username + ", Deleted " + delCounter + " sessions.");
		
	}

}

