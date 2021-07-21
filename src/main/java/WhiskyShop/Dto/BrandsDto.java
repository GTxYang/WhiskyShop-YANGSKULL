package WhiskyShop.Dto;

public class BrandsDto {
	private int idbrand;
	private String namebrand;
	private int id_category;
	private String description;
	private String namecate;
	public BrandsDto(int idbrand, String namebrand, int id_category, String description, String namecate) {
		super();
		this.idbrand = idbrand;
		this.namebrand = namebrand;
		this.id_category = id_category;
		this.description = description;
		this.namecate = namecate;
	}
	public BrandsDto() {
		super();
	}
	public int getIdbrand() {
		return idbrand;
	}
	public void setIdbrand(int idbrand) {
		this.idbrand = idbrand;
	}
	public String getNamebrand() {
		return namebrand;
	}
	public void setNamebrand(String namebrand) {
		this.namebrand = namebrand;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNamecate() {
		return namecate;
	}
	public void setNamecate(String namecate) {
		this.namecate = namecate;
	}
	
	
}
