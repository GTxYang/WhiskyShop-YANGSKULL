package WhiskyShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.CartDto;
import WhiskyShop.Entity.Bill;

@Service
public interface IBill {
	public int AddBill(Bill bill);
	
	public void AddBillDeatils(HashMap<Long, CartDto> cart);
	
}
