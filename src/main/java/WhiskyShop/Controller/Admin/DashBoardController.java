package WhiskyShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Service.Admin.DashBoardServiceImpl;


@Controller
public class DashBoardController  extends BaseAdminController {

	@Autowired
	DashBoardServiceImpl dashboardService;

	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		
		_mvShare.setViewName("admin/index");
		return _mvShare;
	}
	
}
