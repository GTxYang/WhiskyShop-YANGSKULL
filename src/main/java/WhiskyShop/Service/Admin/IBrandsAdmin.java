package WhiskyShop.Service.Admin;

import WhiskyShop.Dto.BrandsDto;
import WhiskyShop.Entity.Brands;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IBrandsAdmin {

	public List<Brands> GetListBrands();

	// Mục đích join 2 bản hiển thị 1 list Brand đầy đủ hơn
	public List<BrandsDto> getListBrandDTO();

	public int AddBrand(Brands brand);

	public int UpdateBrand(Brands brand);

	public int DeleteBrand(int id);

	public Brands getBrandByID(int id);

}
