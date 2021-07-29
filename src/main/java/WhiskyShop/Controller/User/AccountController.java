package WhiskyShop.Controller.User;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Users;
import WhiskyShop.Service.User.AccountServiceImpl;

@Controller
public class AccountController extends BaseController {

	@Autowired
	private AccountServiceImpl accountService;

	@RequestMapping(value = "/Login")
	public ModelAndView Login(@RequestParam(value = "error",required = false ) String error, ModelMap model) {
		_mvShare.addObject("user", new Users());
		if (error != null) {
			model.addAttribute("message", "Sai tên tài khoản hoặc mật khẩu");
		}
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}

	//	return "redirect:" + request.getHeader("Referer");
	
//	@RequestMapping("/admin")
//	public String admin() {
//		return "admin/index";
//	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";
	}
	


	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		// khia báo new user đây để bên giao diện mình dùng thư viện spring form cho các input
		
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String CreateAccount(@ModelAttribute("user") @Valid Users user, BindingResult rs, ModelMap model,
			@RequestParam String nhaplaimatkhau) {

		// if(user.getFirst_name().equals("")||user.getFirst_name().trim().length() ==
		// 0)

		// Kiểm tra có bỏ trống kh
		if (rs.hasErrors() || nhaplaimatkhau.isEmpty()) {
			model.addAttribute("menus", _homeService.getDataMenus());
			model.addAttribute("errorMK", "Không được bỏ trống");
			// rs.rejectValue("first_name", "user","Vui lòng nhập họ tên");

		} else {
			// Nếu kh bỏ trống thì mình tiếp tục xét tính hợp lệ
			// đầu tiên là email
			boolean checkEmail = validate(user.getEmail());
			if (checkEmail == true) {
				if (user.getPassword().equals(nhaplaimatkhau)) {
					int count = accountService.createAccount(user);
					if (count > 0) {
						model.addAttribute("menus", _homeService.getDataMenus());
						model.addAttribute("status", "Đăng ký tài khoản thành công");
					} else {
						model.addAttribute("menus", _homeService.getDataMenus());
						model.addAttribute("status", "Đăng ký tài khoản thất bại");
					}
				} else {
					model.addAttribute("menus", _homeService.getDataMenus());
					model.addAttribute("status", "Mật khẩu không trùng khớp");
				}

			} else {
				model.addAttribute("menus", _homeService.getDataMenus());
				model.addAttribute("status", "Email không hợp lệ");
				
			}

		}
		return "user/account/register";
	}

	@GetMapping("/404")
	public ModelAndView error()
	{
		_mvShare.setViewName("user/404");
		return _mvShare;
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
