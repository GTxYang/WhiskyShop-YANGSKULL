package WhiskyShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRoleDtoMapper implements RowMapper<UserRoleDto> {


	public UserRoleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRoleDto us = new UserRoleDto();
		us.setId(rs.getInt("id"));
		us.setUsername(rs.getString("username"));
		us.setName(rs.getString("name"));
		return us;
	}

}
