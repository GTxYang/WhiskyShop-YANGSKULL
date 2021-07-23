package WhiskyShop.Controller.Admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Brands;
import WhiskyShop.Entity.MenusDashboard;
import WhiskyShop.Service.Admin.DashBoardServiceImpl;

@Controller
public class BaseAdminController {
	@Autowired
	DashBoardServiceImpl dashboardService;
	ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	@ModelAttribute("menus")
	public List<MenusDashboard> Getdatamenu()
	{
		List<MenusDashboard> listBrand = new ArrayList<MenusDashboard>();
		listBrand =  dashboardService.getMenusDashboard();
		return listBrand;
	}
	
	@PostConstruct
	public ModelAndView Init_2()
	{
		//_mvShare.addObject("menus",dashboardService.getMenusDashboard());
		return _mvShare;
	}
}
