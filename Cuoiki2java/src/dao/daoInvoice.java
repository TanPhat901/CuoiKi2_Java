package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.JDBC;
import model.ModelClothes;
import model.ModelInvoice;
import model.ModelInvoiceConfirm;

public class daoInvoice {
	public List<ModelInvoice> getAllInvoicewait() {
		List<ModelInvoice> Invoice = new ArrayList<>();
		String sql = "SELECT * FROM invoice";

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String Customer = resultSet.getString("Customer");
				String Bookingdate = resultSet.getString("Bookingdate");
				String Productid = resultSet.getString("Productid");
				String Productname = resultSet.getString("Productname");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelInvoice model = new ModelInvoice(Customer, Bookingdate, Productid, Productname, Type, Color, Size, Quantity, Price);
				Invoice.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Invoice;
	}
	public void add_invoiceconfirm(ModelInvoiceConfirm invoice) {
		String query = "INSERT INTO invoiceconfirm (Customer, Bookingdate,Invoiceid,Productid, Productname, Type, Color, Size, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try ( Connection connection = JDBC.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, invoice.getCustomer());
            statement.setString(2, invoice.getBookingdate());
            statement.setString(3, invoice.getInvoiceid());
            statement.setString(4, invoice.getProductid());
            statement.setString(5, invoice.getProductname());
            statement.setString(6, invoice.getType());
            statement.setString(7, invoice.getColor());
            statement.setString(8, invoice.getSize());
            statement.setInt(9, invoice.getQuantity());
            statement.setDouble(10, invoice.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public List<ModelInvoiceConfirm> getAllInvoiceConfirm() {
		List<ModelInvoiceConfirm> invoiceconfirm = new ArrayList<>();
		String sql = "SELECT * FROM invoiceconfirm";

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String Invoiceid = resultSet.getString("Invoiceid");
				String Customer = resultSet.getString("Customer");
				String Bookingdate = resultSet.getString("Bookingdate");
				String Productid = resultSet.getString("Productid");
				String Productname = resultSet.getString("Productname");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelInvoiceConfirm	model = new  ModelInvoiceConfirm(Customer, Bookingdate, Invoiceid, Productid, Productname, Type, Color, Size, Quantity, Price);
				invoiceconfirm.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return invoiceconfirm;
	}
	public void deleteInvoiceWaitConfirm(String customer) {
	    String sql = "DELETE FROM invoice WHERE Customer = ?";
	    try {
	        Connection connection = JDBC.getConnection();
	        PreparedStatement st = connection.prepareStatement(sql);
	        st.setString(1, customer);
	        int rowsAffected = st.executeUpdate();
	        st.close();
	        if (rowsAffected > 0) {
	            System.out.println("The data has been deleted successfully");
	        } else {
	            System.out.println("No data deleted. Customer not found.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}




}
