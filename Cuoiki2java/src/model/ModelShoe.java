package model;

import java.io.Serializable;

public class ModelShoe implements Serializable{
	 private static final long serialVersionUID = 1L;
	private String Shoeid;
    private String Shoename;
    private String Type;
    private String Color;
    private String Size;
    private int Quantity;
    private double Price;
	public ModelShoe(String shoeid, String shoename, String type, String color, String size, int quantity, double price) {
		super();
		Shoeid = shoeid;
		Shoename = shoename;
		Type = type;
		Color = color;
		Size = size;
		Quantity = quantity;
		Price = price;
	}
	public String getShoeid() {
		return Shoeid;
	}
	public void setShoeid(String shoeid) {
		Shoeid = shoeid;
	}
	public String getShoename() {
		return Shoename;
	}
	public void setShoename(String shoename) {
		Shoename = shoename;
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
    
}
