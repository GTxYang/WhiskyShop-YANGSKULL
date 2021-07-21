package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.UserRoleDto;
import WhiskyShop.Entity.Role;

@Service
public interface IUserRole {
	public List<UserRoleDto> getUserRoleByID(int id);
	
	//Danh s�ch role user �ang c�
	public List<Role> getRoleUserHave(int id);
	
	public int AddRoleForUser(Role role, int id);
	
	public int DeleteUserRole(int id);
}
