package WhiskyShop.Dto;

import java.sql.Date;

public class ProductsDto {
	private long id;
	private int volumn;
	private int ml;
	private String origin;
	private String name;
	private double price;
	private int sale;
	private String title;
	private boolean highlight;
	private boolean new_product;
	private String detail;
	private Date created_at;
	private Date updated_at;
	private String img;
	private String nameBrand;
	private int idBrand;
	private String nameCate;
	private int idCate;
	public ProductsDto(long id, int volumn, int ml, String origin, String name, double price, int sale, String title,
			boolean highlight, boolean new_product, String detail, Date created_at, Date updated_at, String img,
			String nameBrand, int idBrand, String nameCate, int idCate) {
		super();
		this.id = id;
		this.volumn = volumn;
		this.ml = ml;
		this.origin = origin;
		this.name = name;
		this.price = price;
		this.sale = sale;
		this.title = title;
		this.highlight = highlight;
		this.new_product = new_product;
		this.detail = detail;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.img = img;
		this.nameBrand = nameBrand;
		this.idBrand = idBrand;
		this.nameCate = nameCate;
		this.idCate = idCate;
	}
	public ProductsDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getVolumn() {
		return volumn;
	}
	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
	public int getMl() {
		return ml;
	}
	public void setMl(int ml) {
		this.ml = ml;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isHighlight() {
		return highlight;
	}
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
	public boolean isNew_product() {
		return new_product;
	}
	public void setNew_product(boolean new_product) {
		this.new_product = new_product;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getNameBrand() {
		return nameBrand;
	}
	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}
	public int getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}
	public String getNameCate() {
		return nameCate;
	}
	public void setNameCate(String nameCate) {
		this.nameCate = nameCate;
	}
	public int getIdCate() {
		return idCate;
	}
	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}
	
	
}
