package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import WhiskyShop.Entity.*;
@Repository
public class SlidesDao extends BaseDAO {
	
	public List<Slides> getDataSlides()
	{
		List<Slides> list = new ArrayList<Slides>();
		String sql = "Select * from slides";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
	
	public int InsertSlide(Slides slide)
	{
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("INSERT INTO `slides`(`img`, `caption`, `content`) ");
		varname1.append("VALUES( ");
		varname1.append("    '"+slide.getImg()+"', ");
		varname1.append("    '"+slide.getCaption()+"', ");
		varname1.append("    '"+slide.getContent()+"' ");
		varname1.append(")");
		int insert = _jdbcTemplate.update(varname1.toString());
		return insert;
	}
	
	
	public int UpdateSlide(Slides slide)
	{
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("UPDATE ");
		varname1.append("    `slides` ");
		varname1.append("SET ");
		varname1.append("    `img` = '"+slide.getImg()+"', ");
		varname1.append("    `caption` = '"+slide.getCaption()+"', ");
		varname1.append("    `content` = '"+slide.getContent()+"' ");
		varname1.append("WHERE ");
		varname1.append("     `id` = "+slide.getId()+"");
		int update = _jdbcTemplate.update(varname1.toString());
		return update;
	}
	
	public int DeleteSlide(int id)
	{
		String sql = "DELETE FROM `slides` WHERE id = "+id;
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
	
	public Slides FindSlideByID(int id)
	{
		List<Slides> list = new ArrayList<Slides>();
		String sql  = "SELECT * FROM slides WHERE id = " + id;
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list.get(0);
	}
	
}
