package CPR.Data;

import java.util.Arrays;

public class SampleEntity {
	private String sample_Id;
	private String session_Id;
	private String[] measurements; // Might need to be int instead of String, depending on what the manikin transmits.
	
	public SampleEntity() {}
	
	public SampleEntity(String sample_Id, String session_Id, String[] measurements) {
		super();
		this.setSample_Id(sample_Id);
		this.setSession_Id(session_Id);
		this.setMeasurements(measurements);
	}

	public String getSample_Id() {
		return sample_Id;
	}

	public void setSample_Id(String sample_Id) {
		this.sample_Id = sample_Id;
	}

	public String getSession_Id() {
		return session_Id;
	}

	public void setSession_Id(String session_Id) {
		this.session_Id = session_Id;
	}

	public String[] getMeasurements() {
		return measurements;
	}

	public void setMeasurements(String[] measurements) {
		this.measurements = measurements;
	}

	@Override
	public String toString() {
		return "SampleEntity [sample_Id=" + sample_Id + ", session_Id=" + session_Id + ", measurements="
				+ Arrays.toString(measurements) + "]";
	}
	
	
}
