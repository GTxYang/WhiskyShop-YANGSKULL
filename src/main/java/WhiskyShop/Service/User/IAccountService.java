package WhiskyShop.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Entity.Users;

@Service
public interface IAccountService {
	@Autowired
	public int createAccount(Users user);
	
	public Users FindUserByUsername(String username);
	
	public int updateUser(Users user);

}
