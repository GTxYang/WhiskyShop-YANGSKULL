package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.MenusDashboardDao;
import WhiskyShop.Entity.MenusDashboard;
import WhiskyShop.Entity.Slides;

@Service
public interface IDashBoard {
	
	@Autowired
	public List<MenusDashboard> getMenusDashboard();
	

	
}
