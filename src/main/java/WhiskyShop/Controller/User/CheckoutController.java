package WhiskyShop.Controller.User;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Dto.CartDto;
import WhiskyShop.Entity.Bill;
import WhiskyShop.Entity.Users;
import WhiskyShop.Dto.*;
import WhiskyShop.Service.User.AccountServiceImpl;
import WhiskyShop.Service.User.BillServiceImpl;

@Controller
public class CheckoutController extends BaseController {
	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	BillServiceImpl billService;
	 
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis); 
	
	@RequestMapping("/checkout")
	public ModelAndView Index(ModelMap model) {
		Authentication authen = SecurityContextHolder.getContext().getAuthentication();
		Bill bill = new Bill();
		if(authen!=null)
		{
			String username = authen.getName();
			Users user = accountService.FindUserByUsername(username);
			
			bill.setId_user(user.getId());
	
			model.addAttribute("userInFo",user);
			model.addAttribute("bill",bill);
		}
		_mvShare.setViewName("user/cart/checkout");
		return _mvShare;
	}
	
	
//Bạn đã đặt hàng thành công, YangSkull sẽ giao hàng cho bạn sớm nhất có thể
	//Bổ sung gửi email cho KH khi đặt hàng thành công
	
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill , ModelMap model)
	{
		
		double totalbill = (Double)session.getAttribute("TotalPriceCart");
		bill.setDate_order(date);
		bill.setTotal_bill(totalbill);
		
		int rs = billService.AddBill(bill);
		if(rs > 0)
		{
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billService.AddBillDeatils(cart);
			session.removeAttribute("Cart");
			model.addAttribute("status","Bạn đã đặt hàng thành công, YangSkull sẽ giao hàng cho bạn sớm nhất có thể");
			
			  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MailContext.xml");
			    MailSender mailSender = (MailSender) context.getBean("mailSender2");
			    System.out.println("Sending text...");
			    SimpleMailMessage message = new SimpleMailMessage();
			    message.setFrom("giagt1312@gmail.com");
			    message.setTo("howl1542@gmail.com");
			    message.setSubject("YANGSKULL - ĐẶT HÀNG THÀNH CÔNG");
			    message.setText("Cảm ơn bạn đã tin tưởng chúng tôi, chúng tôi đã nhận được đơn hàng của bạn ");
			    // sending message
			    mailSender.send(message);
			    System.out.println("Sending text done!");
			    context.close();
			
		}
		model.addAttribute("menus", _homeService.getDataMenus());
		return "user/cart/checkoutSuccessful";
	}
	
}
