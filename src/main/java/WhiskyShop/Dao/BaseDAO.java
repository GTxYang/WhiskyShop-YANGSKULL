package WhiskyShop.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDAO {
	//Dấu xếp gạch đầu để nhận biết là biến chung
	@Autowired
	public JdbcTemplate _jdbcTemplate;
}
