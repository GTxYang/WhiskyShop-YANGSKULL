package WhiskyShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WhiskyShop.Dto.ProductsDto;
import WhiskyShop.Dto.ProductsDtoMapper;
import WhiskyShop.Entity.MapperProducts;
import WhiskyShop.Entity.MapperSlides;
import WhiskyShop.Entity.Products;
import WhiskyShop.Entity.Slides;

@Repository
public class ProductsDao extends BaseDAO {
	public List<Products> getDataProducts() {
		List<Products> list = new ArrayList<Products>();
		String sql = "Select * from products";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	// Lấy sản phẩm mới, lấy ngày mới nhất mà chỉ lấy 8 cái
	public List<Products> getDataNewProducts() {
		List<Products> list = new ArrayList<Products>();
		String sql = "Select * from products order by updated_at DESC limit 8";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	// Sản phẩm nổi bật nên mình lấy random
	public List<Products> getDataHighlightProducts() {
		List<Products> list = new ArrayList<Products>();
		String sql = "SELECT * FROM products ORDER by RAND() limit 8";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	public List<Products> getDataProductByID(int categoryId) {
		List<Products> list = new ArrayList<Products>();
		String sql = "Select * from products " + "where id_category = " + categoryId;
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	public List<Products> GetAllDataPaginate(int start, int end) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "Select * from products limit " + start + " , " + end;
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}

	public List<Products> GetDataProductsPaginateByID(int id, int start, int end) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "Select * from products where id_category = " + id + " limit " + start + " , " + end;
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}

	}

	public List<Products> GetDataProductsPaginateByBrand(int id, int start, int end) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "Select * from products where id_brand = " + id + " limit " + start + " , " + end;
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}

	public List<Products> GetDataProductsByBrand(int id) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "Select * from products where id_brand = " + id;
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}



	///// PRODUCT DTO JOIN VỚI BRAND VÀ CATE NAME
	private StringBuffer sqlStringProducts() {
		StringBuffer varname1 = new StringBuffer();
		varname1.append("SELECT ");
		varname1.append("p.id, ");
		varname1.append("p.volumn, ");
		varname1.append("p.ml, ");
		varname1.append("p.origin, ");
		varname1.append("p.name, ");
		varname1.append("p.price, ");
		varname1.append("p.sale, ");
		varname1.append("p.title, ");
		varname1.append("p.highlight, ");
		varname1.append("p.new_product, ");
		varname1.append("p.detail, ");
		varname1.append("p.created_at, ");
		varname1.append("p.updated_at, ");
		varname1.append("p.img, ");
		varname1.append("b.name as nameBrand, ");
		varname1.append("b.id as idBrand, ");
		varname1.append("c.name as nameCate, ");
		varname1.append("c.id as idCate ");
		varname1.append("FROM `products` as p INNER JOIN brand as b on p.id_brand = b.id ");
		varname1.append("INNER JOIN category as c on p.id_category = c.id ");
		return varname1;
	}
	
	public List<ProductsDto> getProductsDTO()
	{
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = sqlStringProducts().toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list; 
	}
	
	
	private String sqlDetailProductDto(long id)
	{
		StringBuffer sql = sqlStringProducts();
		sql.append("where p.id = "+ id);
		return sql.toString();
	}
	
	public List<ProductsDto> GetDataDeatilProduct(long id){
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = sqlDetailProductDto(id);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	
	public ProductsDto FindProductByID(long id){
		String sql = sqlDetailProductDto(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}

	public List<Products> SearchProductByName(String name) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM `products` WHERE name like '%"+ name +"%'";
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}
	
	

	public List<Products> GetDataProductsPaginateBySeachName(String name, int start, int end) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM `products` WHERE name like '%"+ name +"%' limit " + start+ " , "+ end    ;
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}
}
