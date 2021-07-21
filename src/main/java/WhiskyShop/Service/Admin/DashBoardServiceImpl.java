package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.MenusDashboardDao;
import WhiskyShop.Entity.MenusDashboard;

@Service
public class DashBoardServiceImpl  implements IDashBoard{

	@Autowired
	MenusDashboardDao menusDao;
	
	@Override
	public List<MenusDashboard> getMenusDashboard() {
		return menusDao.getMenusDashboard();
	}

}
