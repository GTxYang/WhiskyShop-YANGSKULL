package WhiskyShop.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.CallMetaDataProviderFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Brands;
import WhiskyShop.Entity.Categorys;
import WhiskyShop.Entity.Products;
import WhiskyShop.Service.Admin.BrandsAdminServiceImpl;
import WhiskyShop.Service.Admin.CategoryAdminServiceImpl;
import WhiskyShop.Service.Admin.ProductsAdminServiceImpl;

@Controller
@RequestMapping("/admin/")
public class ProductsController extends BaseAdminController{
	
	@Autowired
	ProductsAdminServiceImpl productsService;
	
	@Autowired
	CategoryAdminServiceImpl categoryService;
	
	@Autowired
	BrandsAdminServiceImpl brandsService;
	
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
	
	//Lấy list Cate có thể tái sử dụng
	@ModelAttribute("listCate")
	public List<Categorys> getCategorys_List()
	{
		List<Categorys> lisCate = new ArrayList<Categorys>();
		lisCate = categoryService.getListCategory();
		return lisCate;
	}
	
	@ModelAttribute("listBrand")
	public List<Brands> getBrands_List()
	{
		List<Brands> listBrand = new ArrayList<Brands>();
		listBrand = brandsService.GetListBrands();
		return listBrand;
	}
	
	@ModelAttribute("listTrueFalse")
	public Map<Integer,String>getListTrueFasle()
	{
		Map<Integer,String> list = new HashMap<>();
		list.put(0, "False");
		list.put(1, "True");
		return list;
		
	}
	
	@GetMapping("addProducts")
	public ModelAndView addProduct()
	{
		_mvShare.addObject("product",new Products());
		_mvShare.setViewName("admin/products/addProducts");
		return _mvShare;
	}
	
	@Autowired
	ServletContext context;
	
	@PostMapping("addProducts")
	public String Action_AddProduct(@ModelAttribute("product") @Valid Products product,BindingResult rs, ModelMap model,MultipartHttpServletRequest request)
	{
		
		if(rs.hasErrors())
		{
			return "admin/products/addProducts";
		}else {
			
			String path_save = context.getRealPath("/assets/products/");
			Iterator<String> listNames = request.getFileNames();
			MultipartFile mpf = request.getFile(listNames.next());
			String name_file = mpf.getOriginalFilename();
			
			File file_save = new File(path_save + name_file);
			try {
				mpf.transferTo(file_save);
				model.addAttribute("status","Thêm thành công");
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      product.setImg(name_file);
		      
		      
		      
		      
		      return "redirect:Products";
		}
		
			}
	
	
	
}
