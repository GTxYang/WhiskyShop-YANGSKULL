package WhiskyShop.Dao;

import org.springframework.stereotype.Repository;

import WhiskyShop.Entity.Bill;
import WhiskyShop.Entity.BillDetails;

@Repository
public class BillDao extends BaseDAO {
	
	
	public int AddBill(Bill bill)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `bill` ");
		sql.append("( ");

		sql.append(" `id_user`, ");
		sql.append("    `date_order`, ");
		sql.append("    `total_bill`, ");
		sql.append("    `note` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");

		sql.append("    '"+bill.getId_user()+"', ");
		sql.append("    '"+bill.getDate_order()+"', ");
		sql.append("    '"+bill.getTotal_bill()+"', ");
		sql.append("    '"+bill.getNote()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;	
	}
	
	public long GetIDLastBill()
	{
		String sql = "SELECT MAX(id) FROM Bill";
		long id = _jdbcTemplate.queryForObject(sql,new Object[] {}, Long.class);
		return id;
	}
	
	
	public void AddBillDetails(BillDetails billDetails)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `bill_details` ");
		sql.append("( ");
		sql.append("    `id_bill`, ");
		sql.append("    `id_product`, ");
		sql.append("    `quanty`, ");
		sql.append("    `total_per_product` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '"+billDetails.getId_bill()+"', ");
		sql.append("    '"+billDetails.getId_product()+"', ");
		sql.append("    '"+billDetails.getQuanty()+"', ");
		sql.append("    '"+billDetails.getTotal_per_product()+"' ");
		sql.append(")");
		
		_jdbcTemplate.update(sql.toString());
	}

}
