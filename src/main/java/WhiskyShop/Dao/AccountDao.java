package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Dto.ProductsDto;
import WhiskyShop.Dto.ProductsDtoMapper;
import WhiskyShop.Entity.Brands;
import WhiskyShop.Entity.MapperProducts;
import WhiskyShop.Entity.MapperUsers;
import WhiskyShop.Entity.Products;
import WhiskyShop.Entity.Users;

@Repository
public class AccountDao extends BaseDAO {
	public int createAccount(Users user)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `users` ");
		sql.append("( ");
		sql.append(" `username`, ");
		sql.append(" `password`, ");
		sql.append(" `email`, ");
		sql.append(" `first_name`, ");
		sql.append(" `last_name`, ");
		sql.append(" `phone`, ");
		sql.append(" `address`, ");
		sql.append(" `enabled` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '"+ user.getUsername() +"', ");
		sql.append("    '"+ user.getPassword() +"', ");
		sql.append("    '"+ user.getEmail() + "', ");
		sql.append("   '"+ user.getFirst_name() +"', ");
		sql.append("    '"+ user.getLast_name() +"', ");
		sql.append("    '"+ user.getPhone() +"', ");
		sql.append("    '"+ user.getAddress() +"', ");
		sql.append("    '"+1+"' ");
		sql.append(")"); 
		
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Users FindUserByUsername(String username){
		String sql = "SELECT * FROM `users` WHERE `username` = '"+username+"'";
		Users user = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return user;
	}

	public List<Users> ListUsers() {
		List<Users> list = new ArrayList<Users>();
		String sql="SELECT * FROM `users`";
		list = _jdbcTemplate.query(sql, new MapperUsers());
		return list;
	}

	public Users FindUserByID(int id) {
		String sql = "SELECT * FROM `users` WHERE `id` = '"+ id +"'";
		Users user = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return user;
	}

	public int UpdateUserByID(int id,Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE `users` ");
		sql.append("SET ");
		sql.append("`username`='" +user.getUsername() + "', ");
		sql.append("`email`='"+user.getEmail()+"', ");
		sql.append("`first_name`='"+user.getFirst_name()+"', ");
		sql.append("`last_name`='"+user.getLast_name()+"', ");
		sql.append("`phone`='"+user.getPhone()+"', ");
		sql.append("`address`='"+user.getAddress()+"' , ");
		sql.append("`enabled`= "+user.isEnabled()+" ");
		sql.append("WHERE ");
		sql.append("`id`='"+ user.getId()+"'");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}

	public int DeleteUserByID(int id) {
		String sql = "DELETE FROM `users` WHERE `id` = '"+id+"'";
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
	
	
	public int updateUser(Users user)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `users` ");
		sql.append("SET ");
		sql.append("`email`='"+user.getEmail()+"', ");
		sql.append("`first_name`='"+user.getFirst_name()+"', ");
		sql.append("`last_name`='"+user.getLast_name()+"', ");
		sql.append("`phone`='"+user.getPhone()+"', ");
		sql.append("`address`='"+user.getAddress()+"'  ");
		sql.append("WHERE ");
		sql.append("`id`="+ user.getId()+"");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
	
	public int BlockUser(int id)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE `users` ");
		sql.append("SET ");
		sql.append("`enabled`= 0 ");
		sql.append("WHERE ");
		sql.append("`id`='"+ id+"'");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
	
	public int unBlockUser(int id)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE `users` ");
		sql.append("SET ");
		sql.append("`enabled`= 1 ");
		sql.append("WHERE ");
		sql.append("`id`='"+ id+"'");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
	
}
