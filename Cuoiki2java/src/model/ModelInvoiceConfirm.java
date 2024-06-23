package model;

import java.io.Serializable;

public class ModelInvoiceConfirm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String Customer;
	private String Bookingdate;
	private String Invoiceid;
	private String Productid;
	private String Productname;
	private String Type;
	private String Color;
	private String Size;
	private int Quantity;
	private double Price;
	public ModelInvoiceConfirm(String customer, String bookingdate, String invoiceid, String productid,
			String productname, String type, String color, String size, int quantity, double price) {
		super();
		Customer = customer;
		Bookingdate = bookingdate;
		Invoiceid = invoiceid;
		Productid = productid;
		Productname = productname;
		Type = type;
		Color = color;
		Size = size;
		Quantity = quantity;
		Price = price;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public String getBookingdate() {
		return Bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		Bookingdate = bookingdate;
	}
	public String getInvoiceid() {
		return Invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		Invoiceid = invoiceid;
	}
	public String getProductid() {
		return Productid;
	}
	public void setProductid(String productid) {
		Productid = productid;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
