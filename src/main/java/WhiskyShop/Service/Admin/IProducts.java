package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.ProductsDto;
import WhiskyShop.Entity.Products;

@Service
public interface IProducts {
	
	public List<ProductsDto> getListProductsDTO();
	
	public ProductsDto getDetailProductDTO(int id);
	
	public int AddProduct(Products product);
	
	
	public Products getDetailProduct(int id);
	
	public int UpdateProduct(Products product);
	
	public int DeleteProduct(int id);
	
	public List<Products> getList_WarningQuanty();
}
