package WhiskyShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Entity.Categorys;
import WhiskyShop.Entity.Menus;
import WhiskyShop.Entity.Products;
import WhiskyShop.Entity.Slides;

@Service
public interface IHomeService {
	
	@Autowired
	public List<Slides> getDataSlides();
	public List<Categorys> getDataCategory();
	public List<Menus> getDataMenus();
	public List<Products> getDataProducts();
	public List<Products> getDataNewProducts();
	public List<Products> getDataHighlightProducts();
}
