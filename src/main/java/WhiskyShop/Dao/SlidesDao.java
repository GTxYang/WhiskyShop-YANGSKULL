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
}
