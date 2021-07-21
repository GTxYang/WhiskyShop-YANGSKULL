package WhiskyShop.Controller.Admin;

import javax.validation.Valid;
import javax.validation.constraintvalidation.SupportedValidationTarget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Brands;
import WhiskyShop.Entity.Categorys;
import WhiskyShop.Service.Admin.CategoryAdminServiceImpl;

@Controller
@RequestMapping("/admin/")
public class CategorysController extends BaseAdminController {

	
	
	@Autowired
	CategoryAdminServiceImpl categoryService;

	@GetMapping("Categorys")
	public ModelAndView ListCategorys(@RequestParam(value = "status", required = false) String status, ModelMap model) {
		model.addAttribute("status", status);
		_mvShare.addObject("listCate", categoryService.getListCategory());
		_mvShare.setViewName("admin/categorys/listCategorys");
		return _mvShare;
	}

/////////////////////////////////////////////////////// --ADD CATEGORY-- ///////////////////////////////////////////////////////
	@GetMapping("addCategory")
	public ModelAndView View_AddCategorys() {

		_mvShare.addObject("category", new Categorys());
		_mvShare.setViewName("admin/categorys/addCategorys");
		return _mvShare;
	}

	@PostMapping("addCategory")
	public String Action_AddCategory(@ModelAttribute("category") @Valid Categorys category, BindingResult rs,
			ModelMap model) {
		model.addAttribute("menus", dashboardService.getMenusDashboard());
		if (rs.hasErrors()) {
			return "admin/categorys/addCategorys";
		} else {
			int add = categoryService.addCategory(category);
			if (add > 0) {
				model.addAttribute("status", "Thêm Category thành công");
				return "redirect:Categorys";
			} else {
				model.addAttribute("status", "Thêm Category thất bại");
				return "admin/categorys/addCategorys";
			}
		}
	}

/////////////////////////////////////////////////////// --FINISH ADD CATEGORY-- ///////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////// --EDIT CATEGORY-- ///////////////////////////////////////////////////////
	@GetMapping("editCategory")
	public String View_EditCategory(@RequestParam("id") int id, @ModelAttribute("category") Categorys category,
			ModelMap model) {
		category = categoryService.getCategoryByID(id);
		model.addAttribute("category", category);
		model.addAttribute("menus", dashboardService.getMenusDashboard());
		return "admin/categorys/addCategorys";
	}

	@PostMapping("editCategory")
	public String Action_EditCategory(@ModelAttribute("category") @Valid Categorys category, BindingResult rs,
			ModelMap model) {
		model.addAttribute("menus", dashboardService.getMenusDashboard());
		if (rs.hasErrors()) {
			return "admin/categorys/addCategorys";
		} else {
			int update = categoryService.updateCategory(category);

			if (update > 0) {
				model.addAttribute("status", "update category thành công");
				return "redirect:Categorys";
			} else {
				model.addAttribute("status", "update category thất bại");
				return "admin/categorys/addCategorys";
			}
		}
	}
/////////////////////////////////////////////////////// --FINISH EDIT CATEGORY-- ///////////////////////////////////////////////////////

	@GetMapping("deleteCategory")
	public String deleteCategory(@RequestParam("idCate") int id, ModelMap model) {
		int delete = categoryService.deleteCategory(id);
		if (delete > 0) {
			model.addAttribute("status", "xóa category thành công");
		} else {
			model.addAttribute("status", "xóa category thất bại");
		}
		return "redirect:Categorys";
	}
}
