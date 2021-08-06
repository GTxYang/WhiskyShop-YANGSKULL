package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.MenusDao;
import WhiskyShop.Entity.Menus;

@Service
public class MenuServiceImpl implements IMenu {

	@Autowired
	MenusDao menuDao;
	
	public List<Menus> getDataMenus() {
		return menuDao.getDataMenus();
	}

	
	public int InsertMenu(Menus menu) {
		return menuDao.InsertMenu(menu);
	}

	
	public int UpdateMenu(Menus menu) {
		return menuDao.UpdateMenu(menu);
	}

	
	public int DeleteMenu(int id) {
		return menuDao.DeleteMenu(id);
	}

	
	public Menus FindMenuByID(int id) {
		return menuDao.FindMenuByID(id);
	}

}
