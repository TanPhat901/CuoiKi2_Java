package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Database.JDBC;
import model.ModelClothes;
import model.ModelEmployeeManager;

public class daoEmployeeManager {
	public void add_data_employee(ModelEmployeeManager model) {
		try {
			Connection connection = JDBC.getConnection();
			Statement st = connection.createStatement();
			String sql = "INSERT INTO employee (Employeeid,Employeename,Gender,Position,Date,Address,Email,Phone,Salary) "
					+ "VALUES (" + model.getEmployeeid() + ", '" + model.getEmployeename() +  "', '"
					+ model.getGender() + "', '" + model.getPosition() + "', '" + model.getDate()
					+ "', '" + model.getAddress()+ "', '" + model.getEmail()+ "', '" + model.getPhone()+ "', '" + model.getSalary() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	public void delete_data_employee(ModelEmployeeManager modelde) {
		String sql = "DELETE FROM employee WHERE Employeeid = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1,modelde.getEmployeeid());
			st.executeUpdate();
			st.close();
			System.out.println("The data has been deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean update_data_employee(ModelEmployeeManager model) {
	    String sql = "UPDATE employee SET Employeename=?, Gender=?, Position=?, Date=?, Address=?, Email=?, Phone=?, Salary=? WHERE Employeeid=?";
	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, model.getEmployeename());
	        preparedStatement.setString(2, model.getGender());
	        preparedStatement.setString(3, model.getPosition());
	        preparedStatement.setString(4, model.getDate());
	        preparedStatement.setString(5, model.getAddress());
	        preparedStatement.setString(6, model.getEmail());
	        preparedStatement.setString(7, model.getPhone());
	        preparedStatement.setDouble(8, model.getSalary());
	        preparedStatement.setInt(9, model.getEmployeeid());
	        
	        int rowsUpdated = preparedStatement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Employee data updated successfully");
	        } else {
	            System.out.println("No employee data found to update");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	//hiển thị
	 public List<ModelEmployeeManager> getAllEmployees() {
	        List<ModelEmployeeManager> employees = new ArrayList<>();
	        String sql = "SELECT * FROM employee"; // Điều chỉnh câu truy vấn theo cấu trúc của bảng nhân viên trong cơ sở dữ liệu của bạn

	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                int Employeeid = resultSet.getInt("Employeeid");
	                String Employeename = resultSet.getString("Employeename");
	                String Gender = resultSet.getString("Gender");
	                String Position = resultSet.getString("Position");
	                String Date = resultSet.getString("Date");
	                String Address = resultSet.getString("Address");
	                String Email = resultSet.getString("Email");
	                String Phone = resultSet.getString("Phone");
	                double Salary = resultSet.getDouble("Salary");

	                ModelEmployeeManager employee = new ModelEmployeeManager(Employeeid, Employeename, Gender, Position, Date, Address, Email, Phone, Salary);
	                employees.add(employee);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return employees;
	    }

	 public ArrayList<ModelEmployeeManager> SearchEmployee(Integer ma, String name) {
		    ArrayList<ModelEmployeeManager> ketQua = new ArrayList<ModelEmployeeManager>();

		    try {
		        Connection connection = JDBC.getConnection();
		        
		        // Xây dựng câu lệnh SQL cơ bản
		        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM employee WHERE 1=1");

		        // Thêm các điều kiện vào câu lệnh SQL dựa trên các tham số được cung cấp
		        if (ma != null) {
		            sqlBuilder.append(" AND Employeeid = ?");
		        }
		        if (name != null && !name.isEmpty()) {
		            sqlBuilder.append(" AND Employeename LIKE ?");
		        }

		        // Tạo PreparedStatement
		        PreparedStatement pst = connection.prepareStatement(sqlBuilder.toString());

		        // Thiết lập các tham số cho PreparedStatement
		        int paramIndex = 1;
		        if (ma != null) {
		            pst.setInt(paramIndex++, ma);
		        }
		        if (name != null && !name.isEmpty()) {
		            pst.setString(paramIndex++, "%" + name + "%");
		        }

		        // Thực thi truy vấn
		        ResultSet rs = pst.executeQuery();

		        // Xử lý kết quả truy vấn
		        while (rs.next()) {
		            int Employeeid = rs.getInt("Employeeid");
		            String Employeename = rs.getString("Employeename");
		            String Gender = rs.getString("Gender");
		            String Position = rs.getString("Position");
		            String Date = rs.getString("Date");
		            String Address = rs.getString("Address");
		            String Email = rs.getString("Email");
		            String Phone = rs.getString("Phone");
		            double Salary = rs.getDouble("Salary");

		            ModelEmployeeManager model4 = new ModelEmployeeManager(Employeeid, Employeename, Gender, Position, Date, Address, Email, Phone, Salary);
		            ketQua.add(model4);
		        }

		        rs.close();
		        pst.close();
		        connection.close();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return ketQua;
		}

}
