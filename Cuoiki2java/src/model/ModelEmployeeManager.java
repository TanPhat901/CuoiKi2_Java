package model;

public class ModelEmployeeManager {
	private int Employeeid;
	private	String Employeename;
	private String Gender;
	private String Position;	
	private String Date;
	private String Address;
	private	String Email;
	private String Phone;
	private double Salary;
	public ModelEmployeeManager(int employeeid, String employeename, String gender, String position, String date,
			String address, String email, String phone, double salary) {
		super();
		Employeeid = employeeid;
		Employeename = employeename;
		Gender = gender;
		Position = position;
		Date = date;
		Address = address;
		Email = email;
		Phone = phone;
		Salary = salary;
	}
	public int getEmployeeid() {
		return Employeeid;
	}
	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}
	public String getEmployeename() {
		return Employeename;
	}
	public void setEmployeename(String employeename) {
		Employeename = employeename;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
}
