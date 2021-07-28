package WhiskyShop.Service.Admin;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IBills {
	
	@Autowired
	public double getToTalBillOrder_PerDay(Date date);
	
	public int getCountBillToday(Date date);
}
