package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class MapperMenusDashboard implements RowMapper<MenusDashboard> {

	@Override
	public MenusDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenusDashboard menu = new MenusDashboard();
		menu.setId(rs.getInt("id"));
		menu.setName(rs.getString("name"));
		menu.setUrl(rs.getString("url"));
		menu.setIcon(rs.getString("icon"));
		return menu;
	}

}
