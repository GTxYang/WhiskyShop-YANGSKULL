package WhiskyShop.Entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Brands {
	private int id;
	
	private int id_category;
	
	@NotBlank(message = "Không được để trống name")
	private String name;
	@NotBlank(message = "Không được để trống description")
	private String description;
	
	public Brands(int id, int id_category, String name, String description) {
		super();
		this.id = id;
		this.id_category = id_category;
		this.name = name;
		this.description = description;
	}
	
	public Brands() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
