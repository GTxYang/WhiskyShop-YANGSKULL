package WhiskyShop.Controller.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController extends BaseController {

	@GetMapping("/error")
	public ModelAndView error() {
		_mvShare.setViewName("user/404");
		return _mvShare;
	}

//	@GetMapping("/404")
//	public String renderErrorPage(HttpServletRequest httpRequest) {
//
//		String errorMsg = "";
//		int httpErrorCode = getErrorCode(httpRequest);
//		switch (httpErrorCode) {
//		case 400: {
//			errorMsg = "Http Error Code: 400. Bad Request";
//			return "redirect:/error";
//		}
//		case 401: {
//			errorMsg = "Http Error Code: 401. Unauthorized";
//			break;
//		}
//		case 404: {
//			errorMsg = "Http Error Code: 404. Resource not found";
//			break;
//		}
//		case 500: {
//			errorMsg = "Http Error Code: 500. Internal Server Error";
//			break;
//		}
//		}
//	
//		return "redirect:/error";
//
//	}
//
//	private int getErrorCode(HttpServletRequest httpRequest) {
//		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
//	}
}
