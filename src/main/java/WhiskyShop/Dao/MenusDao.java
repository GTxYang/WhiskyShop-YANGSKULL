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
	
}
