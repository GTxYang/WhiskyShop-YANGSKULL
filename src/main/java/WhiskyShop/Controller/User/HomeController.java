package WhiskyShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.sitemesh.webapp.decorator.BaseWebAppDecorator;

import WhiskyShop.Dao.SlidesDao;
import WhiskyShop.Dto.CartDto;
import WhiskyShop.Service.User.HomeServiceImpl;

@Controller
public class HomeController extends BaseController {
	

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index(HttpSession session) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			session.removeAttribute("TotalQuantyCart");
			session.removeAttribute("TotalPriceCart");
		}
		_mvShare.addObject("slides",_homeService.getDataSlides());
		_mvShare.addObject("newproducts",_homeService.getDataNewProducts());
		_mvShare.addObject("highlightproducts",_homeService.getDataHighlightProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}

}
