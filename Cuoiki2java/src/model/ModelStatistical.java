package model;

public class ModelStatistical {
	private String invoiceId;
	private String bookingDate;
	private double intoMoney;
	
	public ModelStatistical() {
		
	}
	
	public ModelStatistical(String bookingDate, double intoMoney) {
		super();
		
		this.bookingDate = bookingDate;
		this.intoMoney = intoMoney;
	}
	
	public ModelStatistical(String invoiceId, String bookingDate, double intoMoney) {
		super();
		this.invoiceId = invoiceId;
		this.bookingDate = bookingDate;
		this.intoMoney = intoMoney;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getIntoMoney() {
		return intoMoney;
	}

	public void setIntoMoney(double intoMoney) {
		this.intoMoney = intoMoney;
	}
	
	
}