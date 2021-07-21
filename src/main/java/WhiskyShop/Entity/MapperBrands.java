package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBrands implements RowMapper<Brands> {

	public Brands mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brands brands = new Brands();
		brands.setId(rs.getInt("id"));
		brands.setId_category(rs.getInt("id_category"));
		brands.setName(rs.getString("name"));
		brands.setDescription(rs.getString("description"));;
		return brands;
	}

}
