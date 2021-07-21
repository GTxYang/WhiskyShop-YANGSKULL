package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.RoleDao;
import WhiskyShop.Entity.Role;

@Service
public class RoleServiceImpl implements IRole{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> GetAllDataRole() {
		return roleDao.GetAllDataRole();
	}

	public int InsertRole(String name) {
		return roleDao.InsertRole(name);
	}

	@Override
	public int UpdateRole(int id,String name) {
		return roleDao.UpdateRole(id, name);
	}

	@Override
	public int DeleteRole(int id) {
		return roleDao.DeleteRole(id);
	}

	@Override
	public Role FindRoleByID(int id) {
		return roleDao.FindRoleByID(id).get(0);
	}
	
}
