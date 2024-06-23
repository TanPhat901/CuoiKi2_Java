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
import model.ModelHandBag;
import model.ModelShoe;

public class daoProductManager {
	// hien thi
	public List<ModelClothes> getAllClothes() {
		List<ModelClothes> clothes = new ArrayList<>();
		String sql = "SELECT * FROM clothes";

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String Clothesid = resultSet.getString("Clothesid");
				String Clothesname = resultSet.getString("Clothesname");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelClothes modelclothes = new ModelClothes(Clothesid, Clothesname, Type, Color, Size, Quantity,
						Price);
				clothes.add(modelclothes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clothes;
	}

	public List<ModelShoe> getAllShoe() {
		List<ModelShoe> shoe = new ArrayList<>();
		String sql = "SELECT * FROM shoe";

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String Shoeid = resultSet.getString("Shoeid");
				String Shoename = resultSet.getString("Shoename");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelShoe modelshoe = new ModelShoe(Shoeid, Shoename, Type, Color, Size, Quantity, Price);
				shoe.add(modelshoe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shoe;
	}

	public List<ModelHandBag> getAllHandBag() {
		List<ModelHandBag> handbag = new ArrayList<>();
		String sql = "SELECT * FROM handbag";

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String HandBagid = resultSet.getString("HandBagid");
				String HandBagname = resultSet.getString("HandBagname");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelHandBag modelhandbag = new ModelHandBag(HandBagid, HandBagname, Type, Color, Size, Quantity,
						Price);
				handbag.add(modelhandbag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return handbag;
	}

	// them
	public void add_data_clothes(ModelClothes modelclothes) {
	    String sql = "INSERT INTO clothes (Clothesid, Clothesname, Type, Color, Size, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, modelclothes.getClothesid());
	        preparedStatement.setString(2, modelclothes.getClothesname());
	        preparedStatement.setString(3, modelclothes.getType());
	        preparedStatement.setString(4, modelclothes.getColor());
	        preparedStatement.setString(5, modelclothes.getSize());
	        preparedStatement.setInt(6, modelclothes.getQuantity());
	        preparedStatement.setDouble(7, modelclothes.getPrice());
	        
	        preparedStatement.executeUpdate();
	        System.out.println("Data inserted successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void add_data_shoe(ModelShoe modelshoe) {
	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(
	                 "INSERT INTO shoe (Shoeid, Shoename, Type, Color, Size, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
	        preparedStatement.setString(1, modelshoe.getShoeid());
	        preparedStatement.setString(2, modelshoe.getShoename());
	        preparedStatement.setString(3, modelshoe.getType());
	        preparedStatement.setString(4, modelshoe.getColor());
	        preparedStatement.setString(5, modelshoe.getSize());
	        preparedStatement.setInt(6, modelshoe.getQuantity());
	        preparedStatement.setDouble(7, modelshoe.getPrice());
	        preparedStatement.executeUpdate();
	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
	}

	public void add_data_handbag(ModelHandBag modelhandbag) {
	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(
	                 "INSERT INTO handbag (HandBagid, HandBagname, Type, Color, Size, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
	        preparedStatement.setString(1, modelhandbag.getHandBagid());
	        preparedStatement.setString(2, modelhandbag.getHandBagname());
	        preparedStatement.setString(3, modelhandbag.getType());
	        preparedStatement.setString(4, modelhandbag.getColor());
	        preparedStatement.setString(5, modelhandbag.getSize());
	        preparedStatement.setInt(6, modelhandbag.getQuantity());
	        preparedStatement.setDouble(7, modelhandbag.getPrice());
	        preparedStatement.executeUpdate();
	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
	}

	// xoá
	public void delete_data_clothes(ModelClothes modelclothes_de) {
		String sql = "DELETE FROM clothes WHERE Clothesid = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, modelclothes_de.getClothesid());
			st.executeUpdate();
			st.close();
			System.out.println("The data has been deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete_data_shoe(ModelShoe modelshoe_de) {
		String sql = "DELETE FROM shoe WHERE Shoeid = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, modelshoe_de.getShoeid());
			st.executeUpdate();
			st.close();
			System.out.println("The data has been deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete_data_handbag(ModelHandBag modelhandbag_de) {
		String sql = "DELETE FROM handbag WHERE HandBagid = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, modelhandbag_de.getHandBagid());
			st.executeUpdate();
			st.close();
			System.out.println("The data has been deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/// sửa
	public boolean update_data_clothes(ModelClothes modelclothes) {
		String sql = "UPDATE clothes SET Clothesname=?, Type=?, Color=?, Size=?, Quantity=?, Price=? WHERE Clothesid=?";
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, modelclothes.getClothesname());
			preparedStatement.setString(2, modelclothes.getType());
			preparedStatement.setString(3, modelclothes.getColor());
			preparedStatement.setString(4, modelclothes.getSize());
			preparedStatement.setInt(5, modelclothes.getQuantity());
			preparedStatement.setDouble(6, modelclothes.getPrice());
			preparedStatement.setString(7, modelclothes.getClothesid());
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Data updated successfully");
			} else {
				System.out.println("No data found to update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update_data_shoe(ModelShoe modelshoe) {
		String sql = "UPDATE shoe SET Shoename=?, Type=?, Color=?, Size=?, Quantity=?, Price=? WHERE Shoeid=?";
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, modelshoe.getShoename());
			preparedStatement.setString(2, modelshoe.getType());
			preparedStatement.setString(3, modelshoe.getColor());
			preparedStatement.setString(4, modelshoe.getSize());
			preparedStatement.setInt(5, modelshoe.getQuantity());
			preparedStatement.setDouble(6, modelshoe.getPrice());
			preparedStatement.setString(7, modelshoe.getShoeid());
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Data updated successfully");
			} else {
				System.out.println("No data found to update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update_data_handbag(ModelHandBag mhandbag) {
		String sql = "UPDATE handbag SET HandBagname=?, Type=?, Color=?, Size=?, Quantity=?, Price=? WHERE HandBagid=?";
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, mhandbag.getHandBagname());
			preparedStatement.setString(2, mhandbag.getType());
			preparedStatement.setString(3, mhandbag.getColor());
			preparedStatement.setString(4, mhandbag.getSize());
			preparedStatement.setInt(5, mhandbag.getQuantity());
			preparedStatement.setDouble(6, mhandbag.getPrice());
			preparedStatement.setString(7, mhandbag.getHandBagid());
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Data updated successfully");
			} else {
				System.out.println("No data found to update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// reset
	public void reset_data_clothes(ModelClothes clothes) {
		String sql = "DELETE FROM clothes";
		Connection connection = null;
		PreparedStatement st = null;

		try {
			// Kết nối tới cơ sở dữ liệu
			connection = JDBC.getConnection();
			st = connection.prepareStatement(sql);

			// Thực thi câu lệnh DELETE
			st.executeUpdate();

			System.out.println("Data in clothes table reset successfully.");
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ
		} finally {
			// Đóng PreparedStatement và Connection
			try {
				if (st != null)
					st.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(); // Xử lý ngoại lệ khi đóng
			}
		}
	}

	public void reset_data_shoe(ModelShoe shoe) {
		String sql = "DELETE FROM shoe";
		Connection connection = null;
		PreparedStatement st = null;

		try {
			// Kết nối tới cơ sở dữ liệu
			connection = JDBC.getConnection();
			st = connection.prepareStatement(sql);

			// Thực thi câu lệnh DELETE
			st.executeUpdate();

			System.out.println("Data in clothes table reset successfully.");
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ
		} finally {
			// Đóng PreparedStatement và Connection
			try {
				if (st != null)
					st.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(); // Xử lý ngoại lệ khi đóng
			}
		}
	}

	public void reset_data_handbag(ModelHandBag handbag) {
		String sql = "DELETE FROM handbag";
		Connection connection = null;
		PreparedStatement st = null;

		try {

			connection = JDBC.getConnection();
			st = connection.prepareStatement(sql);
			st.executeUpdate();

			System.out.println("Data in clothes table reset successfully.");
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
	
			try {
				if (st != null)
					st.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(); // Xử lý ngoại lệ khi đóng
			}
		}
	}

	// tim kiem
	public ArrayList<ModelClothes> SearchClothes(String id) {
	    ArrayList<ModelClothes> result = new ArrayList<>();

	    try {
	        Connection connection = JDBC.getConnection();
	        String sql = "SELECT * FROM clothes WHERE Clothesid = ?";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, id); // Thiết lập giá trị cho tham số trong câu SQL
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            String clothesid = rs.getString("Clothesid");
	            String clothesname = rs.getString("Clothesname");
	            String type = rs.getString("Type");
	            String color = rs.getString("Color");
	            String size = rs.getString("Size");
	            int quantity = rs.getInt("Quantity");
	            double price = rs.getDouble("Price");
	            
	            ModelClothes model = new ModelClothes(clothesid, clothesname, type, color, size, quantity, price);
	            result.add(model);
	        }
	        
	        ps.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}

	public ArrayList<ModelShoe> SearchShoe(String id) {
	    ArrayList<ModelShoe> result = new ArrayList<>();

	    try {
	        Connection connection = JDBC.getConnection();
	        String sql = "SELECT * FROM shoe WHERE Shoeid = ?";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, id);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            String shoeid = rs.getString("Shoeid");
	            String shoename = rs.getString("Shoename");
	            String type = rs.getString("Type");
	            String color = rs.getString("Color");
	            String size = rs.getString("Size");
	            int quantity = rs.getInt("Quantity");
	            double price = rs.getDouble("Price");
	            
	            ModelShoe model = new ModelShoe(shoeid, shoename, type, color, size, quantity, price);
	            result.add(model);
	        }
	        
	        ps.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}

	public ArrayList<ModelHandBag> SearchHandBag(String id) {
	    ArrayList<ModelHandBag> result = new ArrayList<>();

	    try {
	        Connection connection = JDBC.getConnection();
	        String sql = "SELECT * FROM handbag WHERE HandBagid = ?";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, id); 
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            String handBagid = rs.getString("HandBagid");
	            String handBagname = rs.getString("HandBagname");
	            String type = rs.getString("Type");
	            String color = rs.getString("Color");
	            String size = rs.getString("Size");
	            int quantity = rs.getInt("Quantity");
	            double price = rs.getDouble("Price");
	            
	            ModelHandBag model = new ModelHandBag(handBagid, handBagname, type, color, size, quantity, price);
	            result.add(model);
	        }
	        
	        ps.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}

}
