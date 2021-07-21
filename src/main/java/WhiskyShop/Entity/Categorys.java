package WhiskyShop.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class Categorys {
	private int id;
	
	@NotBlank(message = "Không được để trống name")
	private String name ;
	private String description ;
	
	
	
	public Categorys() {
		super();
	}
	public Categorys(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
