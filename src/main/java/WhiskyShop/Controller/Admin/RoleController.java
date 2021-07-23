package WhiskyShop.Controller.Admin;

import java.net.http.HttpRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Role;
import WhiskyShop.Service.Admin.RoleServiceImpl;

@Controller
@RequestMapping(value = "/admin/")
public class RoleController extends BaseAdminController {

	@Autowired
	RoleServiceImpl roleService;

	@GetMapping("Role")
	public ModelAndView RoleIndex(@RequestParam(value = "status", required = false) String status, ModelMap model) {
		model.addAttribute("status", status);
		
		_mvShare.addObject("listRole", roleService.GetAllDataRole());	
		_mvShare.setViewName("admin/role/listRole");
		return _mvShare;
	}

	@GetMapping("addRole")
	public ModelAndView AddRole1(@RequestParam(value = "status", required = false) String status, ModelMap model) {
		model.addAttribute("status", status);
		_mvShare.setViewName("admin/role/doRole");
		return _mvShare;
	} 

	// Trường hợp này chỉ insert mỗi cái tên nên mình không dùng phương pháp Bean
	// model, chỉ đơn giản get tên từ input bằng requestparam thôi
	@PostMapping(value = "addRole")
	public ModelAndView AddRole(@RequestParam("name") String name, ModelMap model, HttpServletRequest request) {

		if (name.isEmpty()) {
			
			model.addAttribute("error", "Không được để trống");
			_mvShare.setViewName("admin/role/doRole");
		} else {
			int insert = roleService.InsertRole(name);
			if (insert > 0) {
				model.addAttribute("status", "Insert Sucessfully");
				
				_mvShare.setViewName("redirect:Role");
			} else {
				model.addAttribute("status", "Insert Failed ");
				// _mvShare.setViewName("admin/role/doRole");
				_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
			}
		}
		return _mvShare;
	}
	
	@GetMapping("editRole")
	public ModelAndView updateRole(@RequestParam("id") int id,@RequestParam(value = "status", required = false) String status, ModelMap model)
	{
		//model.addAttribute("roleInfo1",roleService.FindRoleByID(id));	

		model.addAttribute("status", status);
		_mvShare.addObject("roleInfo1",roleService.FindRoleByID(id));	
		_mvShare.setViewName("admin/role/editRole");
		return _mvShare;
	}
	
	//Do đây m2inh kh có dùng kiểm lỗi bằng annotation nên sẽ ktra bằng tay 
	//Đây là cách đơn giản dùng Servlet request lấy biến
	@PostMapping("editRole")
	public ModelAndView Post_UpdateRole(@RequestParam("id") int id,ModelMap model,HttpServletRequest request)
	{
		String name = request.getParameter("nameRole");
		int update = roleService.UpdateRole(id, name);
		if(update > 0)
		{
			model.addAttribute("status","Cập nhập role thành công");
			//return "redirect:Role";
			_mvShare.setViewName("redirect:Role");
		}else {
			model.addAttribute("status", "Update Failed ");
			_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
			
			//return "admin/role/editRole";
			
		}
		return _mvShare;
		//return "admin/user/editRole";
	}
	
	@GetMapping("deleteRole")
	public ModelAndView DeleteRole(@RequestParam("id") int id,ModelMap model,HttpServletRequest request)
	{
		int delete = roleService.DeleteRole(id);
		if(delete > 0)
		{
			model.addAttribute("status","Xóa Role thành công");
			
			
		}else {
			 model.addAttribute("error","Xóa Role thất bại");
			
		}
		_mvShare.setViewName("redirect:Role");
		return _mvShare;
	}
	
	


}
