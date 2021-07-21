package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Entity.MapperMenus;
import WhiskyShop.Entity.MapperMenusDashboard;
import WhiskyShop.Entity.Menus;
import WhiskyShop.Entity.MenusDashboard;


@Repository
public class MenusDashboardDao extends BaseDAO {

	public List<MenusDashboard> getMenusDashboard() {

		List<MenusDashboard> list = new ArrayList<MenusDashboard>();
		String sql = "SELECT * FROM `menus_dashboard`";
		list = _jdbcTemplate.query(sql, new MapperMenusDashboard());
		return list;

	}

}
