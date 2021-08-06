package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillDetails implements RowMapper<BillDetails> {


	public BillDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetails billDetails = new BillDetails();
		billDetails.setId(rs.getLong("id"));
		billDetails.setId_bill(rs.getLong("id_bill"));
		billDetails.setId_product(rs.getLong("id_product"));
		billDetails.setQuanty(rs.getInt("quanty"));
		billDetails.setTotal_per_product(rs.getDouble("total_per_product"));

		return billDetails;
	}

}
