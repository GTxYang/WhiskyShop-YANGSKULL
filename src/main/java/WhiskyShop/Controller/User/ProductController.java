package WhiskyShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import WhiskyShop.Dto.PaginateDto;
import WhiskyShop.Service.User.BrandsServiceImpl;
import WhiskyShop.Service.User.PaginateServiceImpl;
import WhiskyShop.Service.User.ProductServiceImpl;




@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductServiceImpl productsService;

	@Autowired
	private PaginateServiceImpl paginateService; 
	
	@Autowired
	private BrandsServiceImpl brandsService;

	final private int totalProducts_PerPage = 12;
	
	@RequestMapping(value = { "/san-pham" })
	public ModelAndView Index(@RequestParam(value = "search",required = false ) String search) {
		int totalProduct = 0;
		_mvShare.addObject("categorys", _homeService.getDataCategory());
		_mvShare.addObject("brands",brandsService.getAllDataBrands());
		
		if(search != null)
		{
			 totalProduct = productsService.SearchProductByName(search).size();
			 PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, 1);
			 _mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("products", productsService.GetDataProductsPaginateBySeachName(search, paginateInfo.getStart() - 1, paginateInfo.getEnd()));
			
			
		}else {
			 totalProduct = _homeService.getDataProducts().size();
			PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("products", productsService.GetAllDataPaginate(paginateInfo.getStart() - 1, paginateInfo.getEnd()));
		}
		
		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}
	

	
	

	//Tất cả sản phẩm có phân trang
	@RequestMapping(value = { "/san-pham/{currentPage}" })
	public ModelAndView Index123(@PathVariable int currentPage) {
		_mvShare.addObject("categorys", _homeService.getDataCategory());
		
		int totalProduct = _homeService.getDataProducts().size();
		PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("products", productsService.GetAllDataPaginate(paginateInfo.getStart() - 1, paginateInfo.getEnd()));
		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}
	
	
	////////////////////////////////////////////////////////////////////////
	
	//Tất cả sản phẩm theo loại có phân trang
	@RequestMapping(value = { "/san-pham/category/{id}" })
	public ModelAndView ProductsByCategoryFirstPage(@PathVariable int id) {
		
		_mvShare.addObject("brands",brandsService.getAllDataBrands());
		_mvShare.addObject("categorys", _homeService.getDataCategory());

		int totalProduct = productsService.GetDataProductsByID(id).size();
		PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);

		_mvShare.addObject("productsPaginate",
				productsService.GetDataProductsPaginateByID(id, paginateInfo.getStart() - 1, paginateInfo.getEnd()));
		_mvShare.setViewName("user/products/productbyID");
		return _mvShare;

	}

	@RequestMapping(value = { "/san-pham/category/{id}/{currentPage}" })
	public ModelAndView ProductsByCategoryAnotherPage(@PathVariable int id, @PathVariable int currentPage) {
		
		_mvShare.addObject("categorys", _homeService.getDataCategory());
		_mvShare.addObject("brands",brandsService.getAllDataBrands());
		int totalProduct = productsService.GetDataProductsByID(id).size();
		PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);

		_mvShare.addObject("productsPaginate",
				productsService.GetDataProductsPaginateByID(id, paginateInfo.getStart() - 1, paginateInfo.getEnd()));

		_mvShare.setViewName("user/products/productbyID");
		return _mvShare;

	}

	
	////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = { "/san-pham/brands/{id}" })
	public ModelAndView ProductsByBrandFirstPage(@PathVariable int id) {
		_mvShare.addObject("categorys", _homeService.getDataCategory());
		_mvShare.addObject("brands",brandsService.getAllDataBrands());
		int totalProduct = productsService.GetDataProductsByBrand(id).size();
		
		PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		
		_mvShare.addObject("productsPaginate",
				productsService.GetDataProductsPaginateByBrand(id, paginateInfo.getStart() - 1, paginateInfo.getEnd()));
		
		
		_mvShare.setViewName("user/products/productbyBrand");
		return _mvShare;
	}
	
	
	@RequestMapping(value = { "/san-pham/brands/{id}/{currentPage}" })
	public ModelAndView ProductsByBrandFirstPage(@PathVariable int id,@PathVariable int currentPage) {
		_mvShare.addObject("categorys", _homeService.getDataCategory());
		_mvShare.addObject("brands",brandsService.getAllDataBrands());
		int totalProduct = productsService.GetDataProductsByBrand(id).size();
		
		PaginateDto paginateInfo = paginateService.GetInfoPaginate(totalProduct, totalProducts_PerPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		
		_mvShare.addObject("productsPaginate",
				productsService.GetDataProductsPaginateByBrand(id, paginateInfo.getStart() - 1, paginateInfo.getEnd()));
		
		
		_mvShare.setViewName("user/products/productbyBrand");
		return _mvShare;
	}
	//////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = { "/detail/{id}" })
	public ModelAndView DetailProduct(@PathVariable int id) {
		_mvShare.addObject("categorys", _homeService.getDataCategory());
		_mvShare.addObject("brands",brandsService.getAllDataBrands());
		
		//Lấy các sản phẩm theo id sản phẩm
		_mvShare.addObject("detail",productsService.GetDataDeatilProduct(id));
		//Lấy các tất cả sản phẩm theo id loại sp của sản phẩm => xuất những sp cùng loại suggest ng dùng		
		//Vì mình trả về là 1 list, nhưng list này chỉ có 1 thôi vì là deatil > mình lấy cái đầu tiên > get id 
		int idCate = productsService.GetDataDeatilProduct(id).get(0).getIdCate();
		_mvShare.addObject("productsByCate",productsService.GetDataProductsByID(idCate));
		
		
		_mvShare.setViewName("user/products/detailProduct");
		return _mvShare;
		
	}
	
}
