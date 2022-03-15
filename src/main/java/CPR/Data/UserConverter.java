package CPR.Data;

import org.springframework.stereotype.Component;

import CPR.Boundary.UserBoundary;


@Component
public class UserConverter {
	
	public UserBoundary convertToBoundary(UserEntity entity)
	{
		UserBoundary userBoundary=new UserBoundary();

		userBoundary.setUsername(entity.getUsername());
		userBoundary.setPassword(entity.getPassword());
		
		return userBoundary;

	}
	public UserEntity convertToEntity(UserBoundary boundary)
	{
		UserEntity userEntity=new UserEntity();
		
		userEntity.setUsername(boundary.getUsername());
		userEntity.setPassword(boundary.getPassword());
		
		return userEntity;

	}
}
