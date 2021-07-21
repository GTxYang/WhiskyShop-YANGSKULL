package WhiskyShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Service.Admin.ProductsAdminServiceImpl;

@Controller
@RequestMapping("/admin/")
public class ProductsController extends BaseAdminController{
	
	@Autowired
	ProductsAdminServiceImpl productsService;
	
	@GetMapping("Products")
	public ModelAndView ViewProdcuts(ModelMap model)
	{
		_mvShare.addObject("listProductsDTO",productsService.getListProductsDTO());
		_mvShare.setViewName("admin/products/listProducts");
		return _mvShare;
	}
	
	@GetMapping("Products/{id}")
	public ModelAndView ViewDetailProductsDTO(@PathVariable("id") int id,ModelMap model)
	{
		_mvShare.addObject("detailProductDTO",productsService.getDetailProductDTO(id));
		_mvShare.setViewName("admin/products/detailProducts");
		return _mvShare;
	}
	
}
