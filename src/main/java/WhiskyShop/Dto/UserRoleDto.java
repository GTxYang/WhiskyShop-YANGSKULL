package WhiskyShop.Dto;

public class UserRoleDto {
	int id;
	String username;
	String name;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRoleDto(String username, String name,int id) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserRoleDto() {
		super();
		
	}
}
