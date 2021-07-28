package WhiskyShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDtoMapper implements RowMapper<ProductsDto> {


	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto products = new ProductsDto();
		products.setId(rs.getLong("id"));
		products.setVolumn(rs.getInt("volumn"));
		products.setMl(rs.getInt("ml"));
		products.setOrigin(rs.getString("origin"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		products.setSale(rs.getInt("sale"));
		products.setTitle(rs.getString("title"));
		products.setHighlight(rs.getBoolean("highlight"));
		products.setNew_product(rs.getBoolean("new_product"));
		products.setDetail(rs.getString("detail"));
		products.setCreated_at(rs.getDate("created_at"));
		products.setUpdated_at(rs.getDate("updated_at"));
		products.setImg(rs.getString("img"));
		products.setNameBrand(rs.getString("namebrand"));
		products.setIdBrand(rs.getInt("idbrand"));
		products.setNameCate(rs.getString("namecate"));
		products.setIdCate(rs.getInt("idcate"));
		products.setQuanty(rs.getInt("quanty"));
		return products;
	}
	
}
