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
	
	@Override
	public List<ProductsDto> getListProductsDTO() {
		return productsDao.getProductsDTO(); 
	}

	@Override
	public ProductsDto getDetailProductDTO(int id) {
		ProductsDto products = productsDao.GetDataDeatilProduct(id).get(0);
		return products;
	}

	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);  
	
	@Override
	public int AddProduct(Products product) {
		
		product.setUpdated_at(date);
		product.setCreated_at(date);
		
		int add = productsDao.AddProduct(product);
		return add;
	}

	@Override
	public Products getDetailProduct(int id) {
		return productsDao.GetDetailProduct(id);
	}

	@Override
	public int UpdateProduct(Products product) {
		product.setUpdated_at(date);
		return productsDao.UpdateProduct(product);
	}

	@Override
	public int DeleteProduct(int id) {
		return productsDao.DeleteProduct(id);
	}

	@Override
	public List<Products> getList_WarningQuanty() {
		return productsDao.getList_WarningQuanty();
	} 

}
