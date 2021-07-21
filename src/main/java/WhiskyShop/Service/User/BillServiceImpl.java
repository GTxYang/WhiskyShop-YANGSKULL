package WhiskyShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.BillDao;
import WhiskyShop.Dto.CartDto;
import WhiskyShop.Entity.Bill;
import WhiskyShop.Entity.BillDetails;

@Service
public class BillServiceImpl implements IBill {

	@Autowired
	BillDao billDao;
	
	@Override
	public int AddBill(Bill bill) {
		return billDao.AddBill(bill);

	}

	@Override
	public void AddBillDeatils(HashMap<Long, CartDto> cart) {
		
		long id = billDao.GetIDLastBill();
		
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet())
		{
			BillDetails billDeatils = new BillDetails();
			billDeatils.setId_bill(id);
			billDeatils.setId_product(itemCart.getValue().getProduct().getId());
			billDeatils.setQuanty(itemCart.getValue().getQuantity());
			billDeatils.setTotal_per_product(itemCart.getValue().getPrice());
			billDao.AddBillDetails(billDeatils);
		}
		
	}

}
