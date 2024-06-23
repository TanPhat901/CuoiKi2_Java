package model;

import java.io.Serializable;

public class ModelHandBag implements Serializable{
	 private static final long serialVersionUID = 1L;
	private String HandBagid;
    private String HandBagname;
    private String Type;
    private String Color;
    private String Size;
    private int Quantity;
    private double Price;
	public ModelHandBag(String handBagid, String handBagname, String type, String color, String size, int quantity,
			double price) {
		super();
		HandBagid = handBagid;
		HandBagname = handBagname;
		Type = type;
		Color = color;
		Size = size;
		Quantity = quantity;
		Price = price;
	}
	public String getHandBagid() {
		return HandBagid;
	}
	public void setHandBagid(String handBagid) {
		HandBagid = handBagid;
	}
	public String getHandBagname() {
		return HandBagname;
	}
	public void setHandBagname(String handBagname) {
		HandBagname = handBagname;
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
