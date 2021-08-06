package WhiskyShop.Service.Admin;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.BillDao;

@Service
public class BillsAdminServiceImpl implements IBills{

	@Autowired
	BillDao billDao;
	
	
	long millis=System.currentTimeMillis();  
	java.sql.Date today=new java.sql.Date(millis);  
	
	
	public double getToTalBillOrder_PerDay(Date date) {
		return billDao.getToTalBillOrder_PerDay(date);
	}

	
	public int getCountBillToday(Date date) {
		return billDao.getCountBillToday(date);
	}

}
