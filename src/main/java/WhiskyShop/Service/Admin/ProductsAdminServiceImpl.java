package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.ProductsDao;
import WhiskyShop.Dto.ProductsDto;


@Service
public class ProductsAdminServiceImpl implements IProducts{

	@Autowired
	ProductsDao productsDao;
	
	@Override
	public List<ProductsDto> getListProductsDTO() {
		return productsDao.getProductsDTO(); 
	}

	@Override
	public ProductsDto getDetailProductDTO(int id) {
		ProductsDto products = productsDao.GetDataDeatilProduct(id).get(0);
		return products;
	} 

}
