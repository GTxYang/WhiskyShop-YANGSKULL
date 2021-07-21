package WhiskyShop.Entity;

import java.sql.Date;

public class Bill {
	private long id;
	private int id_user;
	private Date date_order;
	private double total_bill;
	private String note;
	public Bill(long id, int id_user, Date date_order, double total_bill, String note) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.date_order = date_order;
		this.total_bill = total_bill;
		this.note = note;
	}
	public Bill() {
		super();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Date getDate_order() {
		return date_order;
	}
	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}
	public double getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(double total_bill) {
		this.total_bill = total_bill;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
