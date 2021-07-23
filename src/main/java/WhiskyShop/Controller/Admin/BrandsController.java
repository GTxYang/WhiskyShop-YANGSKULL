package WhiskyShop.Controller.Admin;

import javax.validation.Valid;

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
import WhiskyShop.Entity.Users;
import WhiskyShop.Service.Admin.BrandsAdminServiceImpl;
import WhiskyShop.Service.Admin.CategoryAdminServiceImpl;

@Controller
@RequestMapping("/admin/")
public class BrandsController extends BaseAdminController {
	@Autowired
	BrandsAdminServiceImpl brandsService;

	@Autowired
	CategoryAdminServiceImpl categoryService;

	@GetMapping("Brands")
	public ModelAndView GetListBrands(@RequestParam(value = "status", required = false) String status, ModelMap model) {
		model.addAttribute("status", status);
		_mvShare.addObject("listBrandsDTO", brandsService.getListBrandDTO());
		_mvShare.setViewName("admin/brands/listBrands");
		return _mvShare;
	}

	@GetMapping("addBrand")
	public ModelAndView ViewAddBrand() {
		_mvShare.addObject("listCate", categoryService.getListCategory());
		_mvShare.addObject("brand", new Brands());
		_mvShare.setViewName("admin/brands/addBrand");
		return _mvShare;
	}
	
	

	@GetMapping("editBrand")
	public String View_EditBrand(@RequestParam("id") int id, @ModelAttribute("brand") Brands brand, ModelMap model) {
		brand = brandsService.getBrandByID(id);
		model.addAttribute("listCate", categoryService.getListCategory());
		model.addAttribute("brand", brand);
		model.addAttribute("menus", dashboardService.getMenusDashboard());

		return "admin/brands/editBrand";
	}

	@PostMapping("editBrand")
	public String Action_EditBrand(@ModelAttribute("brand") @Valid Brands brand, BindingResult rs, ModelMap model) {
		model.addAttribute("menus", dashboardService.getMenusDashboard());
		model.addAttribute("listCate", categoryService.getListCategory());
		if (rs.hasErrors()) {
			return "admin/brands/editBrand";
		} else {
			int update = brandsService.UpdateBrand(brand);
			if (update > 0) {
				model.addAttribute("status", "Thêm brand thành công");
				return "redirect:Brands";
			} else {
				model.addAttribute("status", "Thêm brand thất bại");
				return "admin/brands/editBrand";
			}
		}

	}

	@GetMapping("deleteBrand")
	public ModelAndView DeleteBrand(@RequestParam("idBrand") int id,ModelMap model) {
		int delete = brandsService.DeleteBrand(id);
		if (delete > 0)
		{	
			model.addAttribute("status", "Xóa brand thành công");
			_mvShare.setViewName("redirect:Brands");
		}else {
			model.addAttribute("status", "Xóa brand thất bại");
			_mvShare.setViewName("redirect:Brands");
		}

			return _mvShare;
	}

	@PostMapping("addBrand")
	public String ViewAddBrand(@ModelAttribute("brand") @Valid Brands brand, BindingResult rs, ModelMap model) {
		model.addAttribute("menus", dashboardService.getMenusDashboard());
		model.addAttribute("listCate", categoryService.getListCategory());
		if (rs.hasErrors()) {
			return "admin/brands/addBrand";
		} else {
			int add = brandsService.AddBrand(brand);
			if (add > 0) {
				model.addAttribute("status", "Thêm brand thành công");
				return "redirect:Brands";
			} else {
				model.addAttribute("status", "Thêm brand thất bại");
				return "admin/brands/addBrand";
			}

		}

	}
}
