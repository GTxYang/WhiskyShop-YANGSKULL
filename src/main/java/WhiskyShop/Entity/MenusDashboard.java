package WhiskyShop.Entity;

public class MenusDashboard {
	private int id;
	private String name;
	private String url;
	private String icon;
	public MenusDashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenusDashboard(int id, String name, String url,String icon) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
