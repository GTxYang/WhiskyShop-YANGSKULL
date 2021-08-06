package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Entity.MapperMenus;
import WhiskyShop.Entity.MapperSlides;
import WhiskyShop.Entity.Menus;
import WhiskyShop.Entity.Slides;

@Repository
public class MenusDao extends BaseDAO {
	
	public List<Menus> getDataMenus()
	{
		List<Menus> list = new ArrayList<Menus>();
		String sql = "Select * from menus";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
	
	public int InsertMenu(Menus menu) {
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("INSERT INTO `menus`(`name`, `url`) ");
		varname1.append("VALUES( ");
		varname1.append("    '"+menu.getName()+"', ");
		varname1.append("    '"+menu.getUrl()+"' ");
		varname1.append(")");
		int insert = _jdbcTemplate.update(varname1.toString());
		return insert;
	}
	public int UpdateMenu(Menus menu)
	{
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("UPDATE ");
		varname1.append("    `menus` ");
		varname1.append("SET ");
		varname1.append("    `name` = '"+menu.getName()+"', ");
		varname1.append("    `url` = '"+menu.getUrl()+"' ");
		varname1.append("WHERE ");
		varname1.append("     `id` = "+menu.getId()+"");
		int update = _jdbcTemplate.update(varname1.toString());
		return update;
	}
	
	public int DeleteMenu(int id)
	{
		String sql = "DELETE FROM `menus` WHERE id = " + id;
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
	
	public Menus FindMenuByID(int id)
	{
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM `menus` WHERE id = " + id;
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list.get(0);
	}
	
}
