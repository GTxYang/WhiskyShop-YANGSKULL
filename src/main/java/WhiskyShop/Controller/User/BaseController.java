package WhiskyShop.Controller.User;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Dto.CartDto;
import WhiskyShop.Entity.Products;
import WhiskyShop.Service.User.HomeServiceImpl;


@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeService;

	
	public ModelAndView _mvShare = new ModelAndView();
	
	
	//pOSTcONTRUCTOR ĐỂ CHÚ THÍCH VỚI BEAN LÀ , KHI CHẠY WEB NÓ SẼ CHẠY NÀY TRC
	//MỤC ĐÍCH LÀM NÀY LÀ ĐỂ KH PHẢI KHAI BÁO MENU MỖI KHI LÀM GÌ KHÁC, TRANG NÀO CŨNG CẦN MENU HẾT
	@PostConstruct
	public ModelAndView Init() {
		
		_mvShare.addObject("menus",_homeService.getDataMenus());
		return _mvShare;
	}
}
