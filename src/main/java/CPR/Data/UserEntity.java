package CPR.Data;

public class UserEntity {
	
	
	private String username;
	private UserRole role;
	private String password; // Needs to be hashed.
	
	public UserEntity() {}
	
	public UserEntity(String username, String hashed_Password, UserRole role)
	{
		super();
		this.username = username;
		this.password = hashed_Password;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [username=" + username + ", role=" + role + ", password=" + password + "]";
	}

	
}
