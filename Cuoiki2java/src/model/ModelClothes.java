package model;

import java.io.Serializable;

public class ModelClothes implements Serializable{
	 private static final long serialVersionUID = 1L;
	private String Clothesid;
    private String Clothesname;
    private String Type;
    private String Color;
    private String Size;
    private int Quantity;
    private double Price;
	public ModelClothes(String clothesid, String clothesname, String type, String color, String size, int quantity,
			double price) {
		super();
		Clothesid = clothesid;
		Clothesname = clothesname;
		Type = type;
		Color = color;
		Size = size;
		Quantity = quantity;
		Price = price;
	}
	public String getClothesid() {
		return Clothesid;
	}
	public void setClothesid(String clothesid) {
		Clothesid = clothesid;
	}
	public String getClothesname() {
		return Clothesname;
	}
	public void setClothesname(String clothesname) {
		Clothesname = clothesname;
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
