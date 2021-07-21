package WhiskyShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.w3c.dom.html.HTMLTableRowElement;

public class BrandsDtoMapper implements RowMapper<BrandsDto>{

	@Override
	public BrandsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BrandsDto brand = new BrandsDto();
		brand.setIdbrand(rs.getInt("idbrand"));
		brand.setNamebrand(rs.getString("namebrand"));
		brand.setId_category(rs.getInt("id_category"));
		brand.setDescription(rs.getString("description"));
		brand.setNamecate(rs.getString("namecate"));
		return brand;
	}

}
