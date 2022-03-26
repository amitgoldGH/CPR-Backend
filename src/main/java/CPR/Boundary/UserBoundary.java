package CPR.Boundary;

import java.util.Objects;

public class UserBoundary {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBoundary [username=" + username + ", password=" + password + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(username, password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBoundary other = (UserBoundary) obj;
		return Objects.equals(username, other.username)
				&& Objects.equals(password, other.password);
	}
	
}
