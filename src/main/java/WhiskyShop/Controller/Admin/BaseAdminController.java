package WhiskyShop.Controller.Admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Service.Admin.DashBoardServiceImpl;

@Controller
public class BaseAdminController {
	@Autowired
	DashBoardServiceImpl dashboardService;
	ModelAndView _mvShare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init_2()
	{
		_mvShare.addObject("menus",dashboardService.getMenusDashboard());
		return _mvShare;
	}
}
