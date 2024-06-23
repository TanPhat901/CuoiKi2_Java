package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBC;
import model.ModelStatistical;

public class daoStatistical {
	public ArrayList<ModelStatistical> findbyDate(String Date) {
		ArrayList<ModelStatistical> list = new ArrayList<>();
		String sql = "SELECT * FROM `managershop`.`invoiceconfirm` WHERE Bookingdate LIKE  ?";
		try {
			Connection c = JDBC.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, "%" + Date + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ModelStatistical hd = new ModelStatistical();
				hd.setInvoiceId(rs.getString("InvoiceId"));;
				hd.setBookingDate(rs.getString("BookingDate"));
				hd.setIntoMoney(rs.getInt("IntoMoney"));
				 list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
