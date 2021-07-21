package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import WhiskyShop.Entity.Categorys;
import WhiskyShop.Entity.MapperCategorys;
import WhiskyShop.Entity.MapperSlides;
import WhiskyShop.Entity.Slides;

@Repository
public class CategorysDao extends BaseDAO {
	
	public List<Categorys> getDataCategory()
	{
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "Select * from category";
		list = _jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
	
	
	public int addCategory(Categorys category)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `category`( `name`, `description`) ");
		sql.append("VALUES( ");
		sql.append("    '"+category.getName()+"', ");
		sql.append("    '"+category.getDescription()+"' ");
		sql.append(")");
		int add = _jdbcTemplate.update(sql.toString());
		return add;
	}   
	
	public int updateCategory(Categorys category)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append("    `category` ");
		sql.append("SET ");
		sql.append("    `name` = '"+category.getName()+"', ");
		sql.append("    `description` = '"+category.getDescription()+"' ");
		sql.append("WHERE ");
		sql.append("     `id` = '"+category.getId()+"'");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
	
	public int deleteCategory(int id)
	{
		String sql ="DELETE FROM `category` WHERE id = " + id;
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
	
	public Categorys getCategoryByID(int id)
	{
		List<Categorys> list = new ArrayList<Categorys>();
		String sql ="SELECT * FROM `category` WHERE id = " + id;
		list = _jdbcTemplate.query(sql, new MapperCategorys());
		return list.get(0);
	}
}
