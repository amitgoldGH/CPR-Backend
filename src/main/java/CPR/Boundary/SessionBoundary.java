package CPR.Boundary;

import java.util.Arrays;
import java.util.Date;

public class SessionBoundary {

	private String session_Id;
	private String username;
	private String[] measurement_Summary; // Calculated at end of session.
	private Date creation_Date;
	
	public SessionBoundary() {}
	
	public SessionBoundary(String session_Id, String username, String[] measurement_Summary, Date creation_Date) {
		this.setSession_Id(session_Id);
		this.setUsername(username);
		this.setMeasurement_Summary(measurement_Summary);
		this.setCreation_Date(creation_Date);
	}
	
	public String getSession_Id() {
		return session_Id;
	}
	public void setSession_Id(String session_Id) {
		this.session_Id = session_Id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getMeasurement_Summary() {
		return measurement_Summary;
	}
	public void setMeasurement_Summary(String[] measurement_Summary) {
		this.measurement_Summary = measurement_Summary;
	}
	public Date getCreation_Date() {
		return creation_Date;
	}
	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}

	@Override
	public String toString() {
		return "SessionBoundary [session_Id=" + session_Id + ", username=" + username + ", measurement_Summary="
				+ Arrays.toString(measurement_Summary) + ", creation_Date=" + creation_Date + "]";
	}
	
	
	
	
}
