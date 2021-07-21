package WhiskyShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//coi như đây là chỗ để đựng những dữ liệu từ csdl
//Chuyển đổi dữ liệu từ câu querry select thành các đối tượng
public class MapperSlides implements RowMapper<Slides> {

	public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slides slides = new  Slides();
		slides.setId(rs.getInt("id"));
		slides.setImg(rs.getString("img"));
		slides.setCaption(rs.getString("caption"));
		slides.setContent(rs.getString("content"));
		return slides;
	}
	
}
