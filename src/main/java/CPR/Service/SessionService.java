package CPR.Service;

import org.springframework.stereotype.Service;

import CPR.Boundary.SessionBoundary;


public interface SessionService {

	//CREATE
	public Object createSession(SessionBoundary session);
	
	// RETRIVE
	public Object[] getAllSessions();
	
	public Object[] getAllSessionsByUser(String username);
	
	public Object getSessionById(String session_Id);
	
	//UPDATE
	public void updateSession(SessionBoundary session);
	
	//DELETE
	public void deleteAllSessions();
	
	public void deleteSessionById(String session_Id);
	
	public void deleteSessionByUsername(String username);
}
