package WhiskyShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.ProductsDao;
import WhiskyShop.Dto.ProductsDto;
import WhiskyShop.Entity.Products;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductsDao productDao;

	public List<Products> GetDataProductsByID(int id) {
		return productDao.getDataProductByID(id);
	}

	public List<Products> GetDataProductsPaginateByID(int id,int start, int end) {
		List<Products> products = productDao.GetDataProductsPaginateByID(id,start, end);
		return products;
	}
	
	public List<Products> GetDataProductsPaginateByBrand(int id, int start, int end) {
		List<Products> products = productDao.GetDataProductsPaginateByBrand(id,start, end);
		return products;
	}
	
	
	public List<Products> GetAllDataPaginate(int start,int end){
		List<Products> products = productDao.GetAllDataPaginate(start, end);
		return products;
	}

	
	public List<Products> GetDataProductsByBrand(int id)
	{
		List<Products> products = productDao.GetDataProductsByBrand(id);
		return products;
	}

	public List<ProductsDto> GetDataDeatilProduct(long id) {
		List<ProductsDto> products = productDao.GetDataDeatilProduct(id);
		return products;
	}

	
	public List<Products> SearchProductByName(String name) {
		List<Products> products = productDao.SearchProductByName(name);
		return products;
	}
	
	public List<Products> GetDataProductsPaginateBySeachName(String name, int start, int end)
	{
		List<Products> products = productDao.GetDataProductsPaginateBySeachName(name, start, end);
		return products;
	}


}
