package WhiskyShop.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Users {
	private int id;
	
	@NotBlank(message = "Không được để trống user name")
	private String username;
	
	@NotBlank(message = "Không được để trống mật khẩu")
	private String password;

	@NotBlank(message = "Không được để trống email")
	private String email;

	@NotBlank(message = "Không được để trống họ")
	private String first_name;

	@NotBlank(message = "Không được để trống tên")
	private String last_name;

	@Size(min=10, max=10)
	@NotBlank(message = "Không được để trống số điện thoại")
	private String phone;
	
	@NotBlank(message = "Không được để trống địa chỉ")
	private String address;
	
	private boolean enabled;

	

	public Users(int id, String username, String password, String email, String first_name, String last_name,
			String phone, String address, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.address = address;
		this.enabled = enabled;
	}

	public Users() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
