package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProducts implements RowMapper<Products>{

	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products product = new Products();
		product.setId(rs.getLong("id"));
		product.setId_category(rs.getInt("id_category"));
		product.setId_brand(rs.getInt("id_brand"));
		product.setVolumn(rs.getInt("volumn"));
		product.setMl(rs.getInt("ml"));
		product.setOrigin(rs.getString("origin"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setSale(rs.getInt("sale"));
		product.setTitle(rs.getString("title"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNew_product(rs.getBoolean("new_product"));
		product.setDetail(rs.getString("detail"));
		product.setCreated_at(rs.getDate("created_at"));
		product.setUpdated_at(rs.getDate("updated_at"));
		product.setImg(rs.getString("img"));
		product.setQuanty(rs.getInt("quanty"));
		return product;
	}

}
