package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import WhiskyShop.Dao.BrandsDao;
import WhiskyShop.Dto.BrandsDto;
import WhiskyShop.Entity.Brands;

@Service
public class BrandsAdminServiceImpl implements IBrandsAdmin {

	@Autowired
	BrandsDao brandDao;
	
	
	public List<Brands> GetListBrands() {
		return brandDao.getAllDataBrands();
	}


	
	public List<BrandsDto> getListBrandDTO() {
		return brandDao.getListBrandDTO();
	}


	
	public int AddBrand(Brands brand) {
		return brandDao.AddBrand(brand);
	}



	public Brands getBrandByID(int id) {
		return brandDao.getBrandByID(id);
	}


	
	public int UpdateBrand(Brands brand) {
		return brandDao.UpdateBrand(brand);
	}


	
	public int DeleteBrand(int id) {
		return brandDao.DeleteBrand(id);
	}

}
