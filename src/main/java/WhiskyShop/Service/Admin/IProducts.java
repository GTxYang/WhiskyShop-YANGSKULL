package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.ProductsDto;

@Service
public interface IProducts {
	
	public List<ProductsDto> getListProductsDTO();
	
	public ProductsDto getDetailProductDTO(int id);
	
}
