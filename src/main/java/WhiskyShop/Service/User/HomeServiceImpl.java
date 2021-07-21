package WhiskyShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.CategorysDao;
import WhiskyShop.Dao.MenusDao;
import WhiskyShop.Dao.ProductsDao;
import WhiskyShop.Dao.SlidesDao;
import WhiskyShop.Entity.Categorys;
import WhiskyShop.Entity.Menus;
import WhiskyShop.Entity.Products;
import WhiskyShop.Entity.Slides;


@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categorysDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Slides> getDataSlides() {
		return slidesDao.getDataSlides();
	}

	public List<Categorys> getDataCategory() {
		return categorysDao.getDataCategory();
	}

	public List<Menus> getDataMenus() {
		return menusDao.getDataMenus();
	}

	public List<Products> getDataProducts() {
		return productsDao.getDataProducts();
		
	}

	public List<Products> getDataNewProducts() {
		return productsDao.getDataNewProducts();
	}

	public List<Products> getDataHighlightProducts() {
		return productsDao.getDataHighlightProducts();
	
	}
	
	

}
