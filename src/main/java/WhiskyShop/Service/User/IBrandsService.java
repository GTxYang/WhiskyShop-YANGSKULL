package WhiskyShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Entity.Brands;

@Service
public interface IBrandsService {

	
	@Autowired
	public List<Brands> getAllDataBrands();
}
