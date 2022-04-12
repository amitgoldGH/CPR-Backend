package CPR.DAL;

import org.springframework.data.mongodb.repository.MongoRepository;

import CPR.Data.UserEntity;

public interface UserDao extends MongoRepository<UserEntity, String>{

}
