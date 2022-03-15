package CPR.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

import CPR.Boundary.NewUserBoundary;
import CPR.Boundary.UserBoundary;
import CPR.Data.UserEntity;

@Service
public class UserServiceImpl implements UserService{

	private Map<String, UserEntity> storage;

	
	@Override
	public Object createUser(NewUserBoundary new_User_Boundary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object login(UserBoundary user_Boundary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserBoundary user_Boundary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

}
