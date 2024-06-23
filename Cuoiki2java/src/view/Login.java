package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 307);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 0, 499, 270);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to the fashion shop");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(245, 245, 220));
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(100, 10, 306, 43);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(51, 255, 204));
		btnNewButton.setBounds(66, 161, 151, 43);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("User Login");
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(102, 255, 204));
		btnNewButton_1.setBounds(284, 161, 151, 43);
		panel.add(btnNewButton_1);

		JLabel lblPleaseSelectYour = new JLabel("Please select your access rights");
		lblPleaseSelectYour.setForeground(new Color(255, 255, 255));
		lblPleaseSelectYour.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPleaseSelectYour.setBackground(new Color(245, 245, 220));
		lblPleaseSelectYour.setBounds(124, 86, 282, 43);
		panel.add(lblPleaseSelectYour);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\img(DA)\\6000388 (1).jpg"));
		lblNewLabel_1.setBounds(0, 0, 499, 270);
		panel.add(lblNewLabel_1);
	
		btnNewButton.addActionListener(e -> {
			AdminLogin adminLoginFrame = new AdminLogin();
			adminLoginFrame.setVisible(true);
			dispose(); 
		});
		btnNewButton_1.addActionListener(e -> {
			UserLogin userLoginFrame = new UserLogin();
			userLoginFrame.setVisible(true);
			dispose(); 
		});
	}
}
