package CPR.Data;

public class UserEntity {
	
	
	private String username;
	private String password; // Needs to be hashed.
	
	public UserEntity(String username, String hashed_Password)
	{
		super();
		this.username = username;
		this.password = hashed_Password;
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


}
