package WhiskyShop.Service.Admin;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.AccountDao;
import WhiskyShop.Entity.Users;

@Service
public class UsersServiceImpl implements IUsers {
	@Autowired
	AccountDao usersDao;
	
	
	public List<Users> ListUsers() {
		return usersDao.ListUsers();
	}

	public int createAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
		return usersDao.createAccount(user);
	}

	
	public Users FindUserByID(int id) {
		return usersDao.FindUserByID(id);
	}
	
	public int UpdateUserByID(int id,Users user) 
	{
		return usersDao.UpdateUserByID(id,user);
	}

	
	public int DeleteUserByID(int id) {
		return usersDao.DeleteUserByID(id);
	}

	
	public int BlockUser(int id) {
		return usersDao.BlockUser(id);
	}
	
	public int UnBlockUser(int id)
	{
		return usersDao.unBlockUser(id);
		
	}

}
