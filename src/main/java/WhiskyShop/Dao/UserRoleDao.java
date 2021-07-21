package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Dto.UserRoleDto;
import WhiskyShop.Dto.UserRoleDtoMapper;
import WhiskyShop.Entity.MapperRole;
import WhiskyShop.Entity.Role;

@Repository
public class UserRoleDao extends BaseDAO{

	public List<UserRoleDto> getUserRoleByID(int id) {
		List<UserRoleDto> listUserRole = new ArrayList<UserRoleDto>();
		StringBuffer sql = new StringBuffer();
		sql.append("select users_roles.id ,users.username,role.name ");
		sql.append("from users, role, users_roles ");
		sql.append("where ");
		sql.append("users.id = "+id);
		sql.append(" and ");
		sql.append("users.id = users_roles.user ");
		sql.append("and ");
		sql.append("users_roles.role = role.id"); 
		listUserRole = _jdbcTemplate.query(sql.toString(),new UserRoleDtoMapper()); 
		return listUserRole;
	}
	
	//Đây sẽ trả về 1 list Role của người dùng đang sở hữa
	public List<Role> getListUserHave(int id)
	{
		 List<Role> listUserRole = new ArrayList<Role>();
		 StringBuffer sql = new StringBuffer();
			sql.append("select role.id,role.name ");
			sql.append("from users, role, users_roles ");
			sql.append("where ");
			sql.append("users.id = "+id);
			sql.append(" and ");
			sql.append("users.id = users_roles.user ");
			sql.append("and ");
			sql.append("users_roles.role = role.id"); 
			listUserRole = _jdbcTemplate.query(sql.toString(),new MapperRole());
			return listUserRole;
		 

	}
	
	
	public int AddRoleForUser(Role role, int id)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `users_roles` ");
		sql.append("( `user`, ");
		sql.append("  `role`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    "+id+", ");
		sql.append("    "+role.getId()+" ");
		sql.append(")");
		int addRole = _jdbcTemplate.update(sql.toString());
		return addRole;
	}
	
	//
	public int DeleteUserRole(int id)
	{
		String sql ="DELETE FROM `users_roles` WHERE id = " + id;
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
	

} 
