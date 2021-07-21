package WhiskyShop.Controller.User;

import java.net.http.HttpRequest;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Dto.CartDto;
import WhiskyShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	
	@Autowired
	private CartServiceImpl cartService;
	
	@RequestMapping("/Cart")
	public ModelAndView Index(HttpSession session) {
		
		_mvShare.setViewName("user/cart/cart");
		return _mvShare;
	}
	
	
	@RequestMapping(value="AddCart/{id}")
	//Khai báo reuest để nhờ nó mà có thể chuyển trang về trang trc đó đã đặt hàng 
	//Trang chủ > thêm giỏ hàng > thêm xong trả về trang chủ
	//Chi tiết > ... > thêm xong trả về trang chi tiết
	public String AddCart(HttpServletRequest request,HttpSession session,@PathVariable int id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDto>();
			session.removeAttribute("TotalQuantyCart");
			session.removeAttribute("TotalPriceCart");
		}
		cart =  cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
//		return "redirect:/detail/"+id;
		//dưới đây là cách trả về trang trc đó
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	
	@RequestMapping(value="DeleteCart/{id}")
	//Khai báo reuest để nhờ nó mà có thể chuyển trang về trang trc đó đã đặt hàng 
	//Trang chủ > thêm giỏ hàng > thêm xong trả về trang chủ
	//Chi tiết > ... > thêm xong trả về trang chi tiết
	public String DeleteCart(HttpServletRequest request,HttpSession session,@PathVariable int id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDto>();
		}
		cart =  cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
//		return "redirect:/detail/"+id;
		//dưới đây là cách trả về trang trc đó
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	@RequestMapping(value="EditCart/{id}/{quanty}")
	//Khai báo reuest để nhờ nó mà có thể chuyển trang về trang trc đó đã đặt hàng 
	//Trang chủ > thêm giỏ hàng > thêm xong trả về trang chủ
	//Chi tiết > ... > thêm xong trả về trang chi tiết
	public String EditCart(HttpServletRequest request,HttpSession session,@PathVariable int id,@PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDto>();
		}
		cart =  cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
//		return "redirect:/detail/"+id;
		//dưới đây là cách trả về trang trc đó
		return "redirect:" + request.getHeader("Referer");
	}
	
}
