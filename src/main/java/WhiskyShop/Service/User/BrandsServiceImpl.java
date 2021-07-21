package WhiskyShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.BrandsDao;
import WhiskyShop.Entity.Brands;

@Service
public class BrandsServiceImpl implements IBrandsService {

	@Autowired
	private BrandsDao brandsDao;
	
	public List<Brands> getAllDataBrands() {
		return brandsDao.getAllDataBrands();
	}

}
