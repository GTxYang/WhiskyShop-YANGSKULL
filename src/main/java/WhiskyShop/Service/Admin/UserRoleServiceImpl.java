package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.UserRoleDao;
import WhiskyShop.Dto.UserRoleDto;
import WhiskyShop.Entity.Role;

@Service
public class UserRoleServiceImpl implements IUserRole {

	@Autowired
	UserRoleDao userRoleDao;
	
	@Override
	public List<UserRoleDto> getUserRoleByID(int id) {
		return userRoleDao.getUserRoleByID(id);
	}

	@Override
	public int AddRoleForUser(Role role, int id) {
		return userRoleDao.AddRoleForUser(role, id);
	}

	@Override
	public List<Role> getRoleUserHave(int id) {
		
		return userRoleDao.getListUserHave(id);
	}

	@Override
	public int DeleteUserRole(int id) {
		return userRoleDao.DeleteUserRole(id);
	}

}
