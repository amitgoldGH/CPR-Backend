package CPR.Data;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "SESSIONS")
/* SESSIONS table:
 * ID				| USERNAME			| MEASUREMENT_SUMMARY	| CREATION_DATE
 * VARCHAR(255) <PK>| VARCHAR(255) <FK>	| CLOB					| TIMESTAMP
 * */
public class SessionEntity {
	private String sessionId;
	private String username;
	private String[] measurementSummary; // Calculated at end of session.
	private Date creationDate;
	
	public SessionEntity() {}
	
	public SessionEntity(String session_Id, String username, String[] measurement_Summary, Date creation_Date)
	{
		super();
		this.setSessionId(session_Id);
		this.setUsername(username);
		this.setMeasurementSummary(measurement_Summary);
		this.setCreationDate(creation_Date);
	}
	
	public SessionEntity(String session_Id, String username, String[] measurement_Summary)
	{
		this(session_Id, username, measurement_Summary, new Date());
	}
	
	@MongoId
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String session_Id) {
		this.sessionId = session_Id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Lob
	public String[] getMeasurementSummary() {
		return measurementSummary;
	}
	public void setMeasurementSummary(String[] measurement_Summary) {
		this.measurementSummary = measurement_Summary;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creation_Date) {
		this.creationDate = creation_Date;
	}

	@Override
	public String toString() {
		return "SessionEntity [sessionId=" + sessionId + ", username=" + username + ", measurementSummary="
				+ Arrays.toString(measurementSummary) + ", creationDate=" + creationDate + "]";
	}

	
}
