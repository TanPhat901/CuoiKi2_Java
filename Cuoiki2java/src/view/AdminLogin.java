package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import Database.JDBC;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 307);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(32, 53, 428, 115);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(31, 16, 138, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 72, 138, 32);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(202, 16, 190, 32);
		textField.setColumns(10);
		panel.add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(202, 72, 190, 32);
		panel.add(passwordField);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(32, 202, 428, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton bt_login = new JButton("Login");
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_login.setFont(new Font("Tahoma", Font.BOLD, 20));
		bt_login.setBounds(122, 10, 174, 36);
		panel_1.add(bt_login);

		JLabel lblNewLabel_1 = new JLabel("Admin Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(32, 10, 200, 33);
		contentPane.add(lblNewLabel_1);
		bt_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminlogin();
			}
		});
	}

	public void adminlogin() {

		String User = textField.getText();
		String Password = new String(passwordField.getPassword());

		if (User.equals("")) {
			JOptionPane.showMessageDialog(this, "Account name cannot be blank");
			return;
		}
		if (Password.equals("")) {
			JOptionPane.showMessageDialog(this, "Password can not be blank");
			return;
		}
		if (checkaccount(User, Password)) {
			JOptionPane.showMessageDialog(this, "Logged in successfully");
			this.setVisible(false);
			Server view = new Server();
			view.setLocationRelativeTo(null);
			view.setVisible(true);
			view.startServerInBackground();
		} else {
			// Kiểm tra xem sai mật khẩu hay sai tên đăng nhập
			if (!checkusername(User)) {
				JOptionPane.showMessageDialog(this, "You entered the wrong login name");
			} else {
				JOptionPane.showMessageDialog(this, "You entered the wrong password");
			}
		}
	}

	public boolean checkaccount(String User, String Password) {
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM adminlogin WHERE User='" + User + "' AND Password='" + Password + "'";
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

	public boolean checkusername(String User) {
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM adminlogin WHERE User='" + User + "'";
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

}
