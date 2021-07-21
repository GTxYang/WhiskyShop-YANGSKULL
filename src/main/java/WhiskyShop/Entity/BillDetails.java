package WhiskyShop.Entity;

public class BillDetails {
	private long id;
	private long id_bill;
	private long id_product;
	private int quanty;
	private double total_per_product;
	public BillDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillDetails(long id, long id_bill, long id_product, int quanty, double total_per_product) {
		super();
		this.id = id;
		this.id_bill = id_bill;
		this.id_product = id_product;
		this.quanty = quanty;
		this.total_per_product = total_per_product;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_bill() {
		return id_bill;
	}
	public void setId_bill(long id_bill) {
		this.id_bill = id_bill;
	}
	public long getId_product() {
		return id_product;
	}
	public void setId_product(long id_product) {
		this.id_product = id_product;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotal_per_product() {
		return total_per_product;
	}
	public void setTotal_per_product(double total_per_product) {
		this.total_per_product = total_per_product;
	}
}
