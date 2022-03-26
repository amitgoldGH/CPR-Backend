package CPR.Boundary;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(session_Id, username, measurement_Summary, creation_Date);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionBoundary other = (SessionBoundary) obj;
		return Objects.equals(session_Id, other.session_Id)
				&& Objects.equals(username, other.username)
				&& Objects.equals(measurement_Summary, other.measurement_Summary)
				&& Objects.equals(creation_Date, other.creation_Date);
	}
	
	
	
	
}
