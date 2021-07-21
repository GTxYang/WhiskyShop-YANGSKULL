package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {


	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setId(rs.getInt("id"));
		users.setUsername(rs.getString("username"));
		users.setPassword(rs.getString("password"));
		users.setEmail(rs.getString("email"));
		users.setFirst_name(rs.getString("first_name"));
		users.setLast_name(rs.getString("last_name"));
		users.setPhone(rs.getString("phone"));
		users.setAddress(rs.getString("address"));
		users.setEnabled(rs.getBoolean("enabled"));
		return users;
	}
	
}
