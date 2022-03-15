package CPR.Service;

import java.util.Map;

import CPR.Boundary.SessionBoundary;
import CPR.Data.SessionEntity;

public class SessionServiceImpl implements SessionService{

	private Map<String, SessionEntity> storage;

	@Override
	public Object createSession(SessionBoundary session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAllSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAllSessionsByUser(String username) {
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
