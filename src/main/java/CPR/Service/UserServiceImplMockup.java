package CPR.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CPR.Boundary.NewUserBoundary;
import CPR.Boundary.UserBoundary;
import CPR.Data.UserConverter;
import CPR.Data.UserEntity;

@Service
public class UserServiceImpl implements UserService{

	private Map<String, UserEntity> storage;
	private UserConverter converter;
	private AtomicLong counter;
	
	@Autowired
	public UserServiceImpl(UserConverter converter) {
		this.converter = converter;
	}
	
	@PostConstruct
	public void init()
	{
		// initialize thread safe storage
		this.storage = Collections.synchronizedMap(new HashMap<>());
		
		// initialize counter
		this.counter = new AtomicLong(1L);		
	}
	
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
	public List<Object> getAllUsers() {
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
