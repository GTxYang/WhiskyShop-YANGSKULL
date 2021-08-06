package WhiskyShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WhiskyShop.Dao.BillDao;
import WhiskyShop.Dao.ProductsDao;
import WhiskyShop.Dto.CartDto;
import WhiskyShop.Entity.Bill;
import WhiskyShop.Entity.BillDetails;

@Service
public class BillServiceImpl implements IBill {

	@Autowired
	BillDao billDao;
	
	@Autowired
	ProductsDao productDao;
	
	
	public int AddBill(Bill bill) {
		return billDao.AddBill(bill);

	}

	

    @Transactional(rollbackFor = Exception.class)
	public void AddBillDeatils(HashMap<Long, CartDto> cart) {
		
		long id = billDao.GetIDLastBill();
		//mỖI BILL SẼ CÓ NHIỀU DETAIL TƯƠNG ỨNG VỚI MỖI SP trong giỏ hàng
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet())
		{
		//int soLuongHienTai = productDao.getQuantyProduct(itemCart.getValue().getProduct().getId());
			int soLuongHienTai =  itemCart.getValue().getProduct().getQuanty();
			int newQuanty = soLuongHienTai - itemCart.getValue().getQuantity();
			productDao.updateQuanty(itemCart.getValue().getProduct().getId(), newQuanty);
			
			BillDetails billDeatils = new BillDetails();
			billDeatils.setId_bill(id);
			billDeatils.setId_product(itemCart.getValue().getProduct().getId());
			billDeatils.setQuanty(itemCart.getValue().getQuantity());
			billDeatils.setTotal_per_product(itemCart.getValue().getPrice());
			billDao.AddBillDetails(billDeatils);
		}
		
	}

}
