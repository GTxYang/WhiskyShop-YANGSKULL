package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;
import WhiskyShop.Entity.Role;

@Service
public interface IRole {
	
	public List<Role> GetAllDataRole();
	
	public int InsertRole(String name);
	
	public int UpdateRole(int id,String name);
	
	public int DeleteRole(int id);
	
	public Role FindRoleByID(int id);
}
