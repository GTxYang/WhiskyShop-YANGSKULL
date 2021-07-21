package WhiskyShop.Controller.Admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import WhiskyShop.Dto.UserRoleDto;
import WhiskyShop.Entity.Role;
import WhiskyShop.Service.Admin.RoleServiceImpl;
import WhiskyShop.Service.Admin.UserRoleServiceImpl;
@Controller
@RequestMapping("/admin/")
public class UserRoleController extends BaseAdminController{
	
	@Autowired
	UserRoleServiceImpl userRoleService;
	
	@Autowired
	RoleServiceImpl roleService;
	
	
	
	
	
	@ModelAttribute("ro")
	public Collection<Role> getListRole(@PathVariable("id") int id)
	{	
				List<WhiskyShop.Entity.Role> list = roleService.GetAllDataRole();		
//		//Danh sác quyền user đang có 
				List<UserRoleDto> roleUserHave = userRoleService.getUserRoleByID(id);	

//				
		if(list.size() == roleUserHave.size()) {
			list = null;
			return list;
		}else {
			int remove_n = -1;
			int size = list.size();
			for(int i = 0; i < size ;i++ )
			 {
			 		for(int j = 0; j < roleUserHave.size()  ; j++)
			 		{  
			 			if(list.get(i).getName().equals(roleUserHave.get(j).getName()))
			 			{
			 				remove_n = i;
			 			}
			 			if(remove_n > -1)
				         {
				 			 list.remove(remove_n);
				             remove_n = -1;
				             //update lại size của list vì khi xóa vị trị i đi , thì các phần tử sau sẽ bị tác động
				             size = list.size();   
				         }
			 		}	  
			 }
			return  list;
		}
		
		
	}
	
	@RequestMapping("user-role/{id}")
	public ModelAndView getRoleByID(ModelMap model,@RequestParam(value = "status", required = false) String status,@PathVariable("id") int id)
	{

		//Lấy các quyền mà user sở hữu
		model.addAttribute("status",status);
		model.addAttribute("id",id);
		List<UserRoleDto> list = userRoleService.getUserRoleByID(id);
		_mvShare.addObject("role",list);
		_mvShare.addObject("tt",new Role());
		_mvShare.setViewName("admin/user/userRole");
		return _mvShare;
	}
	
	
	@PostMapping(value="user-role/{id}", params = "buttonAddRole")
	public ModelAndView AddRoleForUser(@ModelAttribute("tt")Role role ,@PathVariable("id") int id,ModelMap model,HttpServletRequest request)
	{
		int add = userRoleService.AddRoleForUser(role, id);
		if(add > 0)
		{
			model.addAttribute("status","Thêm thành công");
			_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
		}
		return _mvShare;
	}
	@PostMapping(value="user-role/{id}", params = "buttonDeleteRole")
	public ModelAndView DeleteUserRole(@RequestParam("idRole")int idRole,ModelMap model,HttpServletRequest request)
	{
		int delete = userRoleService.DeleteUserRole(idRole);
		if(delete > 0)
		{
		model.addAttribute("status","Xóa thành công");
		_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
		}else {
			model.addAttribute("status","Xóa thất bại");
			_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
		}
		
		return _mvShare;
	}
	
}
