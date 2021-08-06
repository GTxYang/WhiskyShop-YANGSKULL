package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import WhiskyShop.Entity.Menus;

@Service
public interface IMenu {
	public List<Menus> getDataMenus();
	
	public int InsertMenu(Menus menu);
	
	public int UpdateMenu(Menus menu);
	
	public int DeleteMenu(int id);
	
	public Menus FindMenuByID(int id);
}
