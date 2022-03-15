package CPR.Boundary;

public class NewUserBoundary {
	
	private String username;
	private String password;
	
	
	public NewUserBoundary() {}
	
	public NewUserBoundary(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
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
		return "NewUserBoundary [username=" + username + ", password=" + password + "]";
	}
	
	
}
