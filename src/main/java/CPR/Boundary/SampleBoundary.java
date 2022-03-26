package CPR.Boundary;

import java.util.Arrays;
import java.util.Objects;

public class SampleBoundary {
	private String sample_Id;
	private String session_Id;
	private String[] measurements;
	
	public SampleBoundary() {}
	
	public SampleBoundary(String sample_Id, String session_Id, String[] measurements) {
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
		return "SampleBoundary [sample_Id=" + sample_Id + ", session_Id=" + session_Id + ", measurements="
				+ Arrays.toString(measurements) + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(sample_Id, session_Id, measurements);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleBoundary other = (SampleBoundary) obj;
		return Objects.equals(sample_Id, other.sample_Id)
				&& Objects.equals(session_Id, other.session_Id)
				&& Objects.equals(measurements, other.measurements);
	}
	
	
}
