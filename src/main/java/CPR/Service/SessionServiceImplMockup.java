package CPR.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CPR.Boundary.SessionBoundary;
import CPR.Data.SessionConverter;
import CPR.Data.SessionEntity;

@Service
public class SessionServiceImpl implements SessionService{

	private Map<String, SessionEntity> storage;
	private SessionConverter converter;
	private AtomicLong counter;
	
	@Autowired
	public SessionServiceImpl(SessionConverter converter) {
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
	public Object createSession(SessionBoundary session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAllSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAllSessionsByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSessionById(String session_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSession(SessionBoundary session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllSessions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSessionById(String session_Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSessionByUsername(String username) {
		// TODO Auto-generated method stub
		
	}

}
