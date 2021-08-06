package WhiskyShop.Controller.Admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Menus;
import WhiskyShop.Service.Admin.MenuServiceImpl;

@Controller
@RequestMapping("/admin/")
public class MenuController extends BaseAdminController {
	
	@Autowired
	MenuServiceImpl menuService;
	
	
	@GetMapping("Menu")
	public ModelAndView Index(ModelMap model, @RequestParam(value = "status", required = false) String status) {
		model.addAttribute("status",status);
		model.addAttribute("listMenu",menuService.getDataMenus());
		_mvShare.setViewName("admin/menu/listMenu");
		return _mvShare;
	}
	
	@GetMapping("addMenu")
	public ModelAndView ViewAdd(ModelMap model)
	{
		Menus menu = new Menus();
		_mvShare.addObject("menu",menu);
		_mvShare.setViewName("admin/menu/addMenu");
		return _mvShare;
	}
	@PostMapping("addMenu")
	public String AddMenu(@ModelAttribute("menu") Menus menu,ModelMap model)
	{
		int insert = menuService.InsertMenu(menu);
		if(insert > 0)
		{
			model.addAttribute("status","Thêm thành công");
			return "redirect:Menu";
		}else {
			model.addAttribute("status","Thêm thất bại");
			return "admin/menu/addMenu";
		}
	}
	
	@PostMapping("deleteMenu")
	public String DeleteMenu(ModelMap model, @RequestParam("id") int id)
	{
		int delete = menuService.DeleteMenu(id);
		if(delete > 0)
		{
			model.addAttribute("status","Xóa thành công");
			
		}else {
			model.addAttribute("status","Xóa thất bại");
			
		}
		return "redirect:Menu";
	}
	
	@GetMapping("editMenu")
	public ModelAndView Get_EditMenu(@RequestParam("id") int id)
	{
		Menus menu = menuService.FindMenuByID(id);
		_mvShare.addObject("menu",menu);
		_mvShare.setViewName("admin/menu/addMenu");
		return _mvShare;
	}
	
	@PostMapping("editMenu")
	public String Post_EditMenu(@ModelAttribute("menu") Menus menu, ModelMap model)
	{
		int update = menuService.UpdateMenu(menu);
		if(update > 0)
		{
			model.addAttribute("status","Sửa thành công");
			return "redirect:Menu";
		}else {
			model.addAttribute("status","Sửa thất bại");
			return "admin/menu/addMenu";
		}
		
	}
}
