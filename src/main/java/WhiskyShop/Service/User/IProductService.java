package WhiskyShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.ProductsDto;
import WhiskyShop.Entity.Products;
@Service
public interface IProductService {
	public List<Products> GetDataProductsPaginateByID(int id,int start, int end);
	
	public List<Products> GetDataProductsByID(int id);
	
	public List<Products> GetAllDataPaginate(int start, int end);
	
	public List<Products> GetDataProductsPaginateByBrand(int id,int start, int end);
	
	public List<Products> GetDataProductsByBrand(int id);
	
	public List<ProductsDto> GetDataDeatilProduct(long id);
	
	public List<Products> SearchProductByName(String name);
	
	public List<Products> GetDataProductsPaginateBySeachName(String name, int start, int end);
}
