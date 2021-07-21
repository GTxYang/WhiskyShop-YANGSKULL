package WhiskyShop.Dto;

public class CartDto {
	private int quantity;
	private double price;
	private ProductsDto product;
	private double totalPrice;
	
	
	public CartDto() {
		super();
	}
	
	public CartDto(int quantity, double price, ProductsDto product,double totalPrice) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductsDto getProduct() {
		return product;
	}

	public void setProduct(ProductsDto product) {
		this.product = product;
	}
	
	
}
