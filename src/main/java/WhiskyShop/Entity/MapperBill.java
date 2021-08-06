package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBill  implements RowMapper<Bill>{

	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill bill = new Bill();
		bill.setId(rs.getLong("id"));
		bill.setId_user(rs.getInt("id_user"));
		bill.setDate_order(rs.getDate("date_order"));
		bill.setTotal_bill(rs.getDouble("total_bill"));
		bill.setNote(rs.getString("note"));
		return bill;
	}

}
