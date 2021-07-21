package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Entity.Users;

@Service
public interface IUsers {
	@Autowired
	public List<Users> ListUsers();
	
	public int createAccount(Users user);
	
	public Users FindUserByID(int id);
	
	public int UpdateUserByID(int id,Users user);
	
	public int DeleteUserByID(int id);
	
	public int BlockUser(int id);
	
	public int UnBlockUser(int id);
}
