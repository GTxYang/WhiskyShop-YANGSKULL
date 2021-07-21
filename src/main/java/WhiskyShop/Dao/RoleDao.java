package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Entity.MapperRole;
import WhiskyShop.Entity.Role;

@Repository
public class RoleDao extends BaseDAO {
	
	public List<Role> GetAllDataRole()
	{
		List<Role> list = new ArrayList<>();
		String sql = "SELECT * FROM role";
		list = _jdbcTemplate.query(sql, new MapperRole());
		return list;
	}
	
	public int InsertRole(String name)
	{
		String sql = "INSERT INTO `role`(`name`) VALUES ( '"+name+"' )";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public int UpdateRole(int id, String name) {
		String sql = "UPDATE `role` SET `name`='"+name+ "' WHERE id = '"+ id + "'" ;
		int update =  _jdbcTemplate.update(sql);
		return update;
	}
	
	public int DeleteRole(int id)
	{
		String sql = "DELETE FROM `role` WHERE `id` = "+id;
		int delete =  _jdbcTemplate.update(sql);
		return delete;
		
	}
	
	public List<Role> FindRoleByID(int id)
	{
		List<Role> list = new ArrayList<>();
		String sql  = "SELECT * FROM `role` WHERE id = " + id;
		list = _jdbcTemplate.query(sql, new MapperRole());
		return list ;
	}
	
	
}
