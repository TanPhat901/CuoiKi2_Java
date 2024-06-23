package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.LineBorder;

import Database.JDBC;

import javax.swing.border.BevelBorder;

public class UserLogin extends JFrame {
	private JTextField addressField;
	private JTextField textField;
	private JTextField userText;
	private JPasswordField passwordText;
	private JTextField nameText;
	private JTextField emailText;
	private JTextField phoneText;
	private JTextField userTextre;
	private JPasswordField passwordTextre;
	private JPasswordField confirmPasswordText;
	private JTabbedPane tabbedPane;

	public UserLogin() {
		super("User Login and Registration Form");
		tabbedPane = new JTabbedPane();
		JPanel loginPanel = createLoginPanel(tabbedPane);
		JPanel registerPanel = createRegisterPanel();
		tabbedPane.addTab("Login", loginPanel);
		tabbedPane.addTab("Register", registerPanel);
		getContentPane().add(tabbedPane);
		setSize(665, 336);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private JPanel createLoginPanel(JTabbedPane tabbedPane) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBounds(41, 33, 553, 100);
		panel.add(panel_1);
		JLabel userLabel = new JLabel("Username:");
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		userLabel.setBounds(54, 10, 100, 34);
		userText = new JTextField();
		userText.setBounds(235, 10, 260, 34);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(54, 56, 100, 34);
		passwordText = new JPasswordField();
		passwordText.setBounds(235, 54, 260, 34);
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginButton.setBounds(225, 139, 171, 35);
		JLabel noAccountLabel = new JLabel("Don't have an account?");
		noAccountLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		noAccountLabel.setBounds(246, 184, 141, 21);
		JButton goToRegisterButton = new JButton("Register here");
		goToRegisterButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		goToRegisterButton.setBounds(187, 215, 246, 35);
		panel.setLayout(null);
		panel_1.setLayout(null);

		panel_1.add(userLabel);
		panel_1.add(userText);
		panel_1.add(passwordLabel);
		panel_1.add(passwordText);
		panel.add(loginButton);
		panel.add(noAccountLabel);
		panel.add(goToRegisterButton);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userlogin();
			}
		});

		goToRegisterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1); // Chuyển sang tab đăng ký
			}
		});

		return panel;
	}

	private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        nameLabel.setBounds(10, 26, 96, 36);
        nameText = new JTextField();
        nameText.setBounds(169, 26, 152, 36);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        emailLabel.setBounds(10, 86, 96, 36);
        emailText = new JTextField();
        emailText.setBounds(169, 86, 152, 36);
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        phoneLabel.setBounds(354, 86, 96, 36);
        phoneText = new JTextField();
        phoneText.setBounds(472, 86, 152, 36);
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        userLabel.setBounds(10, 134, 96, 36);
        userTextre = new JTextField();
        userTextre.setBounds(169, 149, 152, 36);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        passwordLabel.setBounds(354, 146, 96, 36);
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            userregister();
        });
        registerButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        registerButton.setBounds(440, 216, 167, 30);
        panel.setLayout(null);

        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(phoneLabel);
        panel.add(phoneText);
        panel.add(userLabel);
        panel.add(userTextre);
        panel.add(passwordLabel);
        passwordTextre = new JPasswordField();
        passwordTextre.setBounds(472, 149, 152, 36);
        panel.add(passwordTextre);
        panel.add(registerButton);
        
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        addressLabel.setBounds(354, 26, 96, 36);
        panel.add(addressLabel);
        
        addressField = new JTextField();
        addressField.setBounds(472, 26, 152, 36);
        panel.add(addressField);
        
        JLabel confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirmPassword.setBounds(10, 212, 145, 34);
        panel.add(confirmPassword);
        
        confirmPasswordText = new JPasswordField();
        confirmPasswordText.setBounds(165, 212, 156, 36);
        panel.add(confirmPasswordText);
		return panel;
	}
	
	private String md5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
	// đăng kí 
	public void userregister() {
	    String name = nameText.getText();
	    String email = emailText.getText();
	    String phone = phoneText.getText();
	    String username = userTextre.getText();
	    String address = addressField.getText();
	    String password = new String(passwordTextre.getPassword());
	    String confirmPassword = new String(confirmPasswordText.getPassword());

	    // Kiểm tra xác nhận mật khẩu
	    if (!password.equals(confirmPassword)) {
	        JOptionPane.showMessageDialog(this, "Passwords do not match");
	        return;
	    }

	    // Kiểm tra các trường thông tin có trống không
	    if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Please fill in all fields");
	        return;
	    }
	    String hashedPassword = md5Hash(password);
	    // Lưu thông tin người dùng vào cơ sở dữ liệu
	    if (saveUserToDatabase(name, email, phone, username, address, hashedPassword)) {
	        JOptionPane.showMessageDialog(this, "Registration successful");
	        // Sau khi đăng ký thành công, chuyển sang tab đăng nhập
	        tabbedPane.setSelectedIndex(0);
	    } else {
	        JOptionPane.showMessageDialog(this, "Registration failed. Please try again.");
	    }
	}

	
	private boolean saveUserToDatabase(String name, String email, String phone, String username, String address, String password) {
	    try {
	        Connection con = JDBC.getConnection();
	        Statement st = con.createStatement();
	        String sql = "INSERT INTO userlogin (Username, Password, FullName, Email, Phone, Address ) VALUES ('" + username + "', '" + password  + "', '" +name  + "', '" + email + "', '" + phone+ "', '" + address + "')";
	        int rowsAffected = st.executeUpdate(sql);
	        con.close();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
// đăng nhập
	public void userlogin() {

		String Username = userText.getText();
		String Password = new String(passwordText.getPassword());

		if (Username.equals("")) {
			JOptionPane.showMessageDialog(this, "Account name cannot be blank");
			return;
		}
		if (Password.equals("")) {
			JOptionPane.showMessageDialog(this, "Password can not be blank");
			return;
		}
		String hashedPassword = md5Hash(Password);
		if (checkaccount(Username, hashedPassword)) {
			JOptionPane.showMessageDialog(this, "Logged in successfully");
			this.setVisible(false);
			Client view = new Client();
			view.setLocationRelativeTo(null);
			view.setVisible(true);
			view.startClientInBackground();
		} else {
			// Kiểm tra xem sai mật khẩu hay sai tên đăng nhập
			if (!checkusername(Username)) {
				JOptionPane.showMessageDialog(this, "You entered the wrong login name");
			} else {
				JOptionPane.showMessageDialog(this, "You entered the wrong password");
			}
		}
	}

	public boolean checkaccount(String Username, String hashedPassword) {
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM userlogin WHERE Username='" + Username + "' AND Password='" + hashedPassword + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				con.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkusername(String Username) {
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM adminlogin WHERE Username='" + Username + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public static void main(String[] args) {
		// Tạo và hiển thị form
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new UserLogin().setVisible(true);
			}
		});
	}
}
