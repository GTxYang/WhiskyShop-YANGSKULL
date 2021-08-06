package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.ProductsDao;
import WhiskyShop.Dto.ProductsDto;
import WhiskyShop.Entity.Products;


@Service
public class ProductsAdminServiceImpl implements IProducts{

	@Autowired
	ProductsDao productsDao;
	
	
	public List<ProductsDto> getListProductsDTO() {
		return productsDao.getProductsDTO(); 
	}

	
	public ProductsDto getDetailProductDTO(int id) {
		ProductsDto products = productsDao.GetDataDeatilProduct(id).get(0);
		return products;
	}

	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);  
	
	
	public int AddProduct(Products product) {
		
		product.setUpdated_at(date);
		product.setCreated_at(date);
		
		int add = productsDao.AddProduct(product);
		return add;
	}

	
	public Products getDetailProduct(int id) {
		return productsDao.GetDetailProduct(id);
	}

	
	public int UpdateProduct(Products product) {
		product.setUpdated_at(date);
		return productsDao.UpdateProduct(product);
	}

	
	public int DeleteProduct(int id) {
		return productsDao.DeleteProduct(id);
	}

	
	public List<Products> getList_WarningQuanty() {
		return productsDao.getList_WarningQuanty();
	} 

}
