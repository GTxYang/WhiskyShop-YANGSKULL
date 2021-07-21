package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Dto.BrandsDto;
import WhiskyShop.Dto.BrandsDtoMapper;
import WhiskyShop.Entity.Brands;
import WhiskyShop.Entity.MapperBrands;
import WhiskyShop.Entity.MapperCategorys;

@Repository
public class BrandsDao extends BaseDAO{
	public List<Brands> getAllDataBrands()
	{
		List<Brands> list = new ArrayList<Brands>();
		String sql = "Select * from brand";
		list = _jdbcTemplate.query(sql, new MapperBrands());
		return list;
	}
	
	public List<BrandsDto> getListBrandDTO()
	{
		List<BrandsDto> list = new ArrayList<BrandsDto>();
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    b.id AS idbrand, ");
		sql.append("    b.name AS namebrand, ");
		sql.append("    b.id_category, ");
		sql.append("    b.description, ");
		sql.append("    c.name AS namecate ");
		sql.append("FROM ");
		sql.append("    brand AS b ");
		sql.append("INNER JOIN category AS c ");
		sql.append("ON ");
		sql.append("    b.id_category = c.id");
		list = _jdbcTemplate.query(sql.toString(),new BrandsDtoMapper());
		return list;
	}
	
	public int AddBrand(Brands brand)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `brand`( ");
		sql.append("    `id_category`, ");
		sql.append("    `name`, ");
		sql.append("    `description` ");
		sql.append(") ");
		sql.append("VALUES( ");
		sql.append("    '"+brand.getId_category()+"', ");
		sql.append("    '"+brand.getName()+"', ");
		sql.append("    '"+brand.getDescription()+"' ");
		sql.append(")");
		int add = _jdbcTemplate.update(sql.toString());
		return add;
	}
	
	public Brands getBrandByID(int id)
	{
		List<Brands> list = new ArrayList<Brands>();
		String sql ="SELECT * FROM `brand` WHERE id = " + id;
		list = _jdbcTemplate.query(sql, new MapperBrands());
		return list.get(0);
	}
	
	public int UpdateBrand(Brands brand)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append("    `brand` ");
		sql.append("SET ");
		sql.append("    `id_category` = '"+brand.getId_category()+"', ");
		sql.append("    `name` = '"+brand.getName()+"', ");
		sql.append("    `description` = '"+brand.getDescription()+"' ");
		sql.append("WHERE ");
		sql.append("    `id` = '"+brand.getId()+"'");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
	
	public int DeleteBrand(int id)
	{
		String sql = "DELETE FROM `brand` WHERE id = "+id;
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
}
