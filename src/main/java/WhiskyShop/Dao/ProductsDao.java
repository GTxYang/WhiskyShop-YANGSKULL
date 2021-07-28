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

	public List<Products> getList_WarningQuanty()
	{
		List<Products> list = new ArrayList<Products>();
		String sql ="SELECT * FROM `products` WHERE quanty <= 10";
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

	// Lấy số lượng hiện tại của sản phẩm


//Dùng để update số lượng sản phẩm , mỗi lần có ng mua
	public void updateQuanty(long id, int newQuanty) {
		StringBuffer varname1 = new StringBuffer();
		varname1.append("UPDATE ");
		varname1.append("    `products` ");
		varname1.append("SET ");
		varname1.append("    `quanty` =  " + newQuanty);
		varname1.append(" WHERE ");
		varname1.append("   `id` = " + id);
		_jdbcTemplate.update(varname1.toString());
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

	public Products GetDetailProduct(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql = "SELECT * FROM `products` WHERE id = " + id;
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list.get(0);
	}

	public int UpdateProduct(Products product) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append("    `products` ");
		sql.append("SET ");
		sql.append("    `id_category` = '" + product.getId_category() + "', ");
		sql.append("    `id_brand` = '" + product.getId_brand() + "', ");
		sql.append("    `volumn` = '" + product.getVolumn() + "', ");
		sql.append("    `ml` = '" + product.getMl() + "', ");
		sql.append("    `origin` = '" + product.getOrigin() + "', ");
		sql.append("    `name` = '" + product.getName() + "', ");
		sql.append("    `price` = '" + product.getPrice() + "', ");
		sql.append("    `sale` = '" + product.getSale() + "', ");
		sql.append("    `quanty` = '" + product.getQuanty() + "', ");
		sql.append("    `title` = '" + product.getTitle() + "', ");
		sql.append("    `highlight` = " + product.isHighlight() + ", ");
		sql.append("    `new_product` = " + product.isNew_product() + ", ");
		sql.append("    `detail` = '" + product.getDetail() + "', ");
//		sql.append("    `created_at` = '"+product.getCreated_at()+"', ");
		sql.append("    `updated_at` = '" + product.getUpdated_at() + "', ");
		sql.append("    `img` = '" + product.getImg() + "' ");
		sql.append("WHERE ");
		sql.append("      `id` = '" + product.getId() + "'");
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}

	public int DeleteProduct(int id) {
		String sql = "DELETE FROM `products` WHERE id =" + id;
		return _jdbcTemplate.update(sql);
	}

	public int AddProduct(Products product) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `products`( ");
		sql.append("    `id_category`, ");
		sql.append("    `id_brand`, ");
		sql.append("    `volumn`, ");
		sql.append("    `ml`, ");
		sql.append("    `origin`, ");
		sql.append("    `name`, ");
		sql.append("    `price`, ");
		sql.append("    `sale`, ");
		sql.append("    `title`, ");
		sql.append("    `highlight`, ");
		sql.append("    `new_product`, ");
		sql.append("    `detail`, ");
		sql.append("    `created_at`, ");
		sql.append("    `updated_at`, ");
		sql.append("    `img` ,");
		sql.append("    `quanty` ");
		sql.append(") ");
		sql.append("VALUES( ");
		sql.append("    '" + product.getId_category() + "', ");
		sql.append("    '" + product.getId_brand() + "', ");
		sql.append("    '" + product.getVolumn() + "', ");
		sql.append("    '" + product.getMl() + "', ");
		sql.append("    '" + product.getOrigin() + "', ");
		sql.append("    '" + product.getName() + "', ");
		sql.append("    '" + product.getPrice() + "', ");
		sql.append("    '" + product.getSale() + "', ");
		sql.append("    '" + product.getTitle() + "', ");
		sql.append("    " + product.isHighlight() + ", ");
		sql.append("    " + product.isNew_product() + ", ");
		sql.append("    '" + product.getDetail() + "', ");
		sql.append("    '" + product.getCreated_at() + "', ");
		sql.append("    '" + product.getUpdated_at() + "', ");
		sql.append("    '" + product.getImg() + "' ,");
		sql.append("    '" + product.getQuanty() + "' ");
		sql.append(")");
		int add = _jdbcTemplate.update(sql.toString());
		return add;

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
		varname1.append("p.quanty, ");
		varname1.append("b.name as nameBrand, ");
		varname1.append("b.id as idBrand, ");
		varname1.append("c.name as nameCate, ");
		varname1.append("c.id as idCate ");

		varname1.append("FROM `products` as p INNER JOIN brand as b on p.id_brand = b.id ");
		varname1.append("INNER JOIN category as c on p.id_category = c.id ");
		return varname1;
	}

	public List<ProductsDto> getProductsDTO() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = sqlStringProducts().toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}

	private String sqlDetailProductDto(long id) {
		StringBuffer sql = sqlStringProducts();
		sql.append("where p.id = " + id);
		return sql.toString();
	}

	public List<ProductsDto> GetDataDeatilProduct(long id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = sqlDetailProductDto(id);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}

	public ProductsDto FindProductByID(long id) {
		String sql = sqlDetailProductDto(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}

	public List<Products> SearchProductByName(String name) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM `products` WHERE name like '%" + name + "%'";
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}

	public List<Products> GetDataProductsPaginateBySeachName(String name, int start, int end) {
		List<Products> list = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM `products` WHERE name like '%" + name + "%' limit " + start + " , " + end;
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} catch (Exception e) {
			return list = null;
		}
	}
}
