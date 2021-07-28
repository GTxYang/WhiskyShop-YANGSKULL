package WhiskyShop.Controller.Admin;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Service.Admin.BillsAdminServiceImpl;
import WhiskyShop.Service.Admin.DashBoardServiceImpl;
import WhiskyShop.Service.Admin.ProductsAdminServiceImpl;
import WhiskyShop.Service.Admin.UsersServiceImpl;


@Controller
public class DashBoardController  extends BaseAdminController {

	@Autowired
	DashBoardServiceImpl dashboardService;

	@Autowired
	UsersServiceImpl userService;
	
	@Autowired
	BillsAdminServiceImpl billService;
	
	@Autowired
	ProductsAdminServiceImpl productService;
	
	
	long millis=System.currentTimeMillis();  
	java.sql.Date today=new java.sql.Date(millis);
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		_mvShare.addObject("listWarningQuanty",productService.getList_WarningQuanty());
		_mvShare.addObject("countBill",billService.getCountBillToday(today));
		_mvShare.addObject("totalBill",billService.getToTalBillOrder_PerDay(today));
		_mvShare.addObject("quantyUser",userService.ListUsers().size());
		_mvShare.setViewName("admin/index");
		return _mvShare;
	}
	
}
