package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.ModelClothes;
import model.ModelHandBag;
import model.ModelInvoice;
import model.ModelShoe;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JComboBox;

public class Search extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JTable table;
	private JPanel contentPane;
	private JTextField tf_searchclo;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField tf_clo_id;
	private JTextField tf_clo_name;
	private JTextField tf_clo_color;
	private JTextField tf_clo_size;
	private JTextField tf_clo_quantity;
	private JTextField tf_clo_price;
	private JTextField tf_clo_customer;
	private static JTable table3;
	private static JTable table2;
	private JTextField tf_clo_booking;
	private JTextField tf_hbag_id;
	private JTextField tf_hbag_name;
	private JTextField tf_hbag_color;
	private JTextField tf_hbag_size;
	private JTextField tf_hbag_quantity;
	private JTextField tf_hbag_price;
	private JTextField tf_hbag_customer;
	private JTextField tf_hbag_booking;
	private JTextField tf_shoe_id;
	private JTextField tf_shoe_name;
	private JTextField tf_shoe_color;
	private JTextField tf_shoe_size;
	private JTextField tf_shoe_quantity;
	private JTextField tf_shoe_price;
	private JTextField tf_shoe_customer;
	private JTextField tf_shoe_booking;
	private JComboBox cb_clothes;
	private JComboBox cb_shoe;
	private JComboBox cb_handbag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(-15, 0, 1003, 61);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Search for clothes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(338, 10, 194, 42);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search for shoes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(563, 10, 194, 42);
		panel.add(btnNewButton_1);

		JButton btnSearchForHand = new JButton("Search for hand bag");
		btnSearchForHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchForHand.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchForHand.setBounds(784, 10, 194, 42);
		panel.add(btnSearchForHand);

		JLabel lblNewLabel = new JLabel("Search product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(38, 13, 167, 33);
		panel.add(lblNewLabel);
		// tim kiem quan ao
		JPanel panel_card = new JPanel();
		panel_card.setLayout(new CardLayout());
		panel_card.setBounds(-5, 64, 993, 493);
		contentPane.add(panel_card);

/// panel 1 

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBorder(new LineBorder(new Color(65, 105, 225)));
		panel_1.setBounds(244, 0, 744, 557);
		panel_1.setLayout(null);
		panel_card.add(panel_1, "mycard1");

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(5, 0, 306, 493);
		panel_4.setLayout(null);
		panel_1.add(panel_4);

		tf_clo_customer = new JTextField();
		tf_clo_customer.setBounds(131, 15, 155, 25);
		tf_clo_customer.setColumns(10);
		panel_4.add(tf_clo_customer);

		tf_clo_booking = new JTextField();
		tf_clo_booking.setColumns(10);
		tf_clo_booking.setBounds(131, 57, 155, 25);
		panel_4.add(tf_clo_booking);

		tf_clo_id = new JTextField();
		tf_clo_id.setBounds(131, 99, 155, 25);
		tf_clo_id.setColumns(10);
		panel_4.add(tf_clo_id);

		tf_clo_name = new JTextField();
		tf_clo_name.setBounds(131, 141, 155, 25);
		tf_clo_name.setColumns(10);
		panel_4.add(tf_clo_name);

		String arclothes[] = { "Shirts", "T-shirts", "Sweaters", "Jackets", "Jeans", "Trousers", "Dresses", "Shorts",
				"Leggings", "Skirts" };
		cb_clothes = new JComboBox(arclothes);
		cb_clothes.setBounds(131, 183, 155, 25);
		panel_4.add(cb_clothes);

		tf_clo_color = new JTextField();
		tf_clo_color.setBounds(131, 225, 155, 25);
		tf_clo_color.setColumns(10);
		panel_4.add(tf_clo_color);

		tf_clo_size = new JTextField();
		tf_clo_size.setBounds(131, 272, 155, 25);
		tf_clo_size.setColumns(10);
		panel_4.add(tf_clo_size);

		tf_clo_quantity = new JTextField();
		tf_clo_quantity.setBounds(131, 317, 155, 25);
		tf_clo_quantity.setColumns(10);
		panel_4.add(tf_clo_quantity);

		tf_clo_price = new JTextField();
		tf_clo_price.setBounds(131, 362, 155, 25);
		tf_clo_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_clo_price.setColumns(10);
		panel_4.add(tf_clo_price);

		JLabel lblNewLabel_1_9 = new JLabel("Customer name");
		lblNewLabel_1_9.setBounds(10, 15, 120, 25);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_9);

		JLabel lblNewLabel_1_7 = new JLabel("Bookingdate");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(10, 57, 120, 25);
		panel_4.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1 = new JLabel("Clothesid");
		lblNewLabel_1.setBounds(10, 99, 120, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Clothes name");
		lblNewLabel_1_1.setBounds(10, 141, 120, 25);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Type of clothes");
		lblNewLabel_1_2.setBounds(10, 183, 120, 25);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity");
		lblNewLabel_1_3.setBounds(10, 315, 68, 25);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Size");
		lblNewLabel_1_4.setBounds(10, 270, 120, 25);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Color");
		lblNewLabel_1_5.setBounds(10, 225, 120, 25);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Price");
		lblNewLabel_1_6.setBounds(10, 362, 120, 25);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_1_6);

		// panel 5 mua
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(27, 397, 252, 51);
		panel_5.setLayout(null);
		panel_4.add(panel_5);

		JButton btnNewButton_2 = new JButton("Buy");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(51, 10, 144, 26);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu từ trường nhập cho quần áo
				String Customer = tf_clo_customer.getText();
				String Bookingdate = tf_clo_booking.getText();
				String Productid = tf_clo_id.getText();
				String Productname = tf_clo_name.getText();
				String Type = (String) cb_clothes.getSelectedItem();
				String Color = tf_clo_color.getText();
				String Size = tf_clo_size.getText();
				int Quantity = Integer.parseInt(tf_clo_quantity.getText());
				double Price = Double.parseDouble(tf_clo_price.getText());
				ModelInvoice dataclo = new ModelInvoice(Customer, Bookingdate, Productid, Productname, Type, Color,
						Size, Quantity, Price);
				
				Client.sendDataToServer(dataclo);
				System.out.println("Sending data to server: " + dataclo.toString());
				tf_clo_customer.setText("");
				tf_clo_booking.setText("");
				tf_clo_id.setText("");
				tf_clo_name.setText("");
				tf_clo_color.setText("");
				tf_clo_size.setText("");
				tf_clo_quantity.setText("");
				tf_clo_price.setText("");
			}
		});
		panel_5.add(btnNewButton_2);

		tf_searchclo = new JTextField();
		tf_searchclo.setBounds(620, 30, 200, 39);
		tf_searchclo.setColumns(10);
		panel_1.add(tf_searchclo);

		JLabel lblSearch = new JLabel("Enter the name of the clothes");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSearch.setBounds(332, 28, 266, 39);
		panel_1.add(lblSearch);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.setBounds(846, 27, 122, 42);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.getSelectionModel().clearSelection();
				String searchValue = tf_searchclo.getText().trim().toLowerCase();
				List<Integer> matchedRows = new ArrayList<>();

				// Lọc và hiển thị các hàng trong bảng dựa trên tên sản phẩm
				for (int row = 0; row < table.getRowCount(); row++) {
					String Clothesname = ((String) table.getValueAt(row, 1)).toLowerCase();
					// So sánh phần đầu của tên sản phẩm với chuỗi tìm kiếm
					if (Clothesname.startsWith(searchValue)) {
						matchedRows.add(row);
					}
				}
				if (matchedRows.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No products found to start with: " + searchValue);
				} else {
					for (Integer rowIndex : matchedRows) {
						table.getSelectionModel().addSelectionInterval(rowIndex, rowIndex);
						table.scrollRectToVisible(new Rectangle(table.getCellRect(rowIndex, 0, true)));
					}
				}
			}
		});
		panel_1.add(btnSearch);

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Clothesid");
		dm.addColumn("Clothesname");
		dm.addColumn("Type");
		dm.addColumn("Color sắc");
		dm.addColumn("Size");
		dm.addColumn("Quantity");
		dm.addColumn("Price");
		table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy chỉ số hàng được chọn
				int selectedRow = table.getSelectedRow();

				// Kiểm tra nếu người dùng đã chọn một hàng hợp lệ
				if (selectedRow != -1) {
					// Lấy dữ liệu từ hàng được chọn và hiển thị trên các trường nhập
					String Clothesid = (String) dm.getValueAt(selectedRow, 0);
					String Clothesname = (String) dm.getValueAt(selectedRow, 1);
					String Type = (String) dm.getValueAt(selectedRow, 2);
					String Color = (String) dm.getValueAt(selectedRow, 3);
					String Size = (String) dm.getValueAt(selectedRow, 4);

					double Price = (double) dm.getValueAt(selectedRow, 6);

					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_clo_id.setText(String.valueOf(Clothesid));
					tf_clo_name.setText(Clothesname);
					cb_clothes.setSelectedItem(Type);
					tf_clo_color.setText(Color);
					tf_clo_size.setText(Size);

					System.out.println(tf_clo_size.getText());

					tf_clo_price.setText(String.valueOf(Price));
					tf_clo_quantity.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int quantity = Integer.parseInt(tf_clo_quantity.getText());
							int selectedRow = table.getSelectedRow();
							if (selectedRow != -1) {
								double price = (double) table.getValueAt(selectedRow, 6);
								double totalPrice = quantity * price;
								tf_clo_price.setText(String.valueOf(totalPrice));
							}
						}
					});

				}
			}

		});

		JScrollPane js = new JScrollPane(table);
		js.setBounds(325, 100, 655, 338);
		panel_1.add(js);

		// tim kiem giay
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setBorder(new LineBorder(new Color(65, 105, 225)));
		panel_2.setBounds(244, 0, 744, 520);
		panel_2.setLayout(null);
		panel_card.add(panel_2, "mycard2");

		JPanel panel_4_ = new JPanel();
		panel_4_.setLayout(null);
		panel_4_.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_.setBounds(5, 0, 306, 493);
		panel_2.add(panel_4_);

		tf_shoe_customer = new JTextField();
		tf_shoe_customer.setColumns(10);
		tf_shoe_customer.setBounds(131, 15, 155, 25);
		panel_4_.add(tf_shoe_customer);

		tf_shoe_booking = new JTextField();
		tf_shoe_booking.setColumns(10);
		tf_shoe_booking.setBounds(131, 57, 155, 25);
		panel_4_.add(tf_shoe_booking);

		tf_shoe_id = new JTextField();
		tf_shoe_id.setColumns(10);
		tf_shoe_id.setBounds(131, 99, 155, 25);
		panel_4_.add(tf_shoe_id);

		tf_shoe_name = new JTextField();
		tf_shoe_name.setColumns(10);
		tf_shoe_name.setBounds(131, 141, 155, 25);
		panel_4_.add(tf_shoe_name);

		String arshoe[] = { "Sneakers", "Running shoes", "Training shoes", "Oxfords", "Loafers", "Boots", "Sandals" };
		cb_shoe = new JComboBox(arshoe);
		cb_shoe.setBounds(131, 183, 155, 25);
		panel_4_.add(cb_shoe);

		tf_shoe_color = new JTextField();
		tf_shoe_color.setColumns(10);
		tf_shoe_color.setBounds(131, 225, 155, 25);
		panel_4_.add(tf_shoe_color);

		tf_shoe_size = new JTextField();
		tf_shoe_size.setColumns(10);
		tf_shoe_size.setBounds(131, 272, 155, 25);
		panel_4_.add(tf_shoe_size);

		tf_shoe_quantity = new JTextField();
		tf_shoe_quantity.setColumns(10);
		tf_shoe_quantity.setBounds(131, 317, 155, 25);
		panel_4_.add(tf_shoe_quantity);

		tf_shoe_price = new JTextField();
		tf_shoe_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_shoe_price.setColumns(10);
		tf_shoe_price.setBounds(131, 362, 155, 25);
		panel_4_.add(tf_shoe_price);

		JLabel lblNewLabel_1_9_2_1 = new JLabel("Customer name");
		lblNewLabel_1_9_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_9_2_1.setBounds(10, 15, 120, 25);
		panel_4_.add(lblNewLabel_1_9_2_1);

		JLabel lblNewLabel_1_7_1_1 = new JLabel("Bookingdate");
		lblNewLabel_1_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7_1_1.setBounds(10, 57, 120, 25);
		panel_4_.add(lblNewLabel_1_7_1_1);

		JLabel lblNewLabel_1_10_1 = new JLabel("Shoeid");
		lblNewLabel_1_10_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_10_1.setBounds(10, 99, 120, 25);
		panel_4_.add(lblNewLabel_1_10_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Shoename");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 141, 120, 25);
		panel_4_.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Type of clothes");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 183, 120, 25);
		panel_4_.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Quantity");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(10, 315, 68, 25);
		panel_4_.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("Size");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_1_1.setBounds(10, 270, 120, 25);
		panel_4_.add(lblNewLabel_1_4_1_1);

		JLabel lblNewLabel_1_5_1_1 = new JLabel("Color");
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5_1_1.setBounds(10, 225, 120, 25);
		panel_4_.add(lblNewLabel_1_5_1_1);

		JLabel lblNewLabel_1_6_1_1 = new JLabel("Price");
		lblNewLabel_1_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6_1_1.setBounds(10, 362, 120, 25);
		panel_4_.add(lblNewLabel_1_6_1_1);

		// buy

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5_1_1.setBounds(27, 397, 252, 51);
		panel_4_.add(panel_5_1_1);

		JButton btnNewButton_2_1_1 = new JButton("Buy");
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1_1.setBounds(51, 10, 144, 26);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu từ trường nhập cho quần áo
				String Customer = tf_shoe_customer.getText();
				String Bookingdate = tf_shoe_booking.getText();
				String Productid = tf_shoe_id.getText();
				String Productname = tf_shoe_name.getText();
				String Type = (String) cb_shoe.getSelectedItem();
				String Color = tf_shoe_color.getText();
				String Size = tf_shoe_size.getText();
				int Quantity = Integer.parseInt(tf_shoe_quantity.getText());
				double Price = Double.parseDouble(tf_shoe_price.getText());

				ModelInvoice dataclo = new ModelInvoice(Customer, Bookingdate, Productid, Productname, Type, Color,
						Size, Quantity, Price);
			
				Client.sendDataToServer(dataclo);

				System.out.println("Sending data to server: " + dataclo.toString());
				// Sau khi gửi dữ liệu, làm sạch các trường nhập hoặc thực hiện hành động khác
				tf_shoe_customer.setText("");
				tf_shoe_booking.setText("");
				tf_shoe_id.setText("");
				tf_shoe_name.setText("");
				tf_shoe_color.setText("");
				tf_shoe_size.setText("");
				tf_shoe_quantity.setText("");
				tf_shoe_price.setText("");
			}
		});
		panel_5_1_1.add(btnNewButton_2_1_1);
		//
		textField2 = new JTextField();
		textField2.setBounds(605, 34, 200, 39);
		textField2.setColumns(10);
		panel_2.add(textField2);

		JLabel lblSearch2 = new JLabel("Enter the name of the shoe");
		lblSearch2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSearch2.setBounds(349, 34, 224, 39);
		panel_2.add(lblSearch2);

		JButton btnSearch2 = new JButton("Search");
		btnSearch2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch2.setBounds(833, 29, 122, 42);
		btnSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table2.getSelectionModel().clearSelection();
				String searchValue = textField2.getText().trim().toLowerCase();
				List<Integer> matchedRows = new ArrayList<>();

				// Lọc và hiển thị các hàng trong bảng dựa trên tên sản phẩm
				for (int row = 0; row < table2.getRowCount(); row++) {
					String Clothesname = ((String) table2.getValueAt(row, 1)).toLowerCase();
					// So sánh phần đầu của tên sản phẩm với chuỗi tìm kiếm
					if (Clothesname.startsWith(searchValue)) {
						matchedRows.add(row);
					}
				}
				if (matchedRows.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No products found to start with: " + searchValue);
				} else {
					for (Integer rowIndex : matchedRows) {
						table2.getSelectionModel().addSelectionInterval(rowIndex, rowIndex);
						table2.scrollRectToVisible(new Rectangle(table2.getCellRect(rowIndex, 0, true)));
					}
				}
			}
		});
		panel_2.add(btnSearch2);

		DefaultTableModel dm2 = new DefaultTableModel();
		dm2.addColumn("Shoeid");
		dm2.addColumn("Shoename");
		dm2.addColumn("Type");
		dm2.addColumn("Color");
		dm2.addColumn("Size");
		dm2.addColumn("Quantity");
		dm2.addColumn("Price");
		table2 = new JTable(dm2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy chỉ số hàng được chọn
				int selectedRow = table2.getSelectedRow();
				if (selectedRow != -1) {
					// Lấy dữ liệu từ hàng được chọn và hiển thị trên các trường nhập
					String Shoeid = (String) dm2.getValueAt(selectedRow, 0);
					String Shoename = (String) dm2.getValueAt(selectedRow, 1);
					String Type = (String) dm2.getValueAt(selectedRow, 2);
					String Color = (String) dm2.getValueAt(selectedRow, 3);
					String Size = (String) dm2.getValueAt(selectedRow, 4);
					double Price = (double) dm2.getValueAt(selectedRow, 6);

					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_shoe_id.setText(String.valueOf(Shoeid));
					tf_shoe_name.setText(Shoename);
					cb_shoe.setSelectedItem(Type);
					tf_shoe_color.setText(Color);
					tf_shoe_size.setText(Size);
					tf_shoe_price.setText(String.valueOf(Price));
					tf_shoe_quantity.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int quantity = Integer.parseInt(tf_shoe_quantity.getText());
							int selectedRow = table2.getSelectedRow();
							if (selectedRow != -1) {
								double price = (double) table2.getValueAt(selectedRow, 6);
								double totalPrice = quantity * price;
								tf_shoe_price.setText(String.valueOf(totalPrice));
							}
						}
					});
				}
			}
		});
		JScrollPane js2 = new JScrollPane(table2);
		js2.setBounds(325, 100, 655, 338);
		panel_2.add(js2);

		// tim kiem tui xach
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_3.setBorder(new LineBorder(new Color(65, 105, 225)));
		panel_3.setBounds(244, 0, 744, 520);
		panel_3.setLayout(null);
		panel_card.add(panel_3, "mycard3");

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_1.setBounds(5, 0, 306, 493);
		panel_3.add(panel_4_1);

		tf_hbag_customer = new JTextField();
		tf_hbag_customer.setColumns(10);
		tf_hbag_customer.setBounds(131, 15, 155, 25);
		panel_4_1.add(tf_hbag_customer);

		tf_hbag_booking = new JTextField();
		tf_hbag_booking.setColumns(10);
		tf_hbag_booking.setBounds(131, 57, 155, 25);
		panel_4_1.add(tf_hbag_booking);

		tf_hbag_id = new JTextField();
		tf_hbag_id.setColumns(10);
		tf_hbag_id.setBounds(131, 99, 155, 25);
		panel_4_1.add(tf_hbag_id);

		tf_hbag_name = new JTextField();
		tf_hbag_name.setColumns(10);
		tf_hbag_name.setBounds(131, 141, 155, 25);
		panel_4_1.add(tf_hbag_name);

		String arhandbag[] = { "Tote bag", "Bucket bag", "Hobo bag", "Messenger bag", "Shoulder bag", "Crossbody bag" };
		cb_handbag = new JComboBox(arhandbag);
		cb_handbag.setBounds(131, 183, 155, 25);
		panel_4_1.add(cb_handbag);

		tf_hbag_color = new JTextField();
		tf_hbag_color.setColumns(10);
		tf_hbag_color.setBounds(131, 225, 155, 25);
		panel_4_1.add(tf_hbag_color);

		tf_hbag_size = new JTextField();
		tf_hbag_size.setColumns(10);
		tf_hbag_size.setBounds(131, 272, 155, 25);
		panel_4_1.add(tf_hbag_size);

		tf_hbag_quantity = new JTextField();
		tf_hbag_quantity.setColumns(10);
		tf_hbag_quantity.setBounds(131, 317, 155, 25);
		panel_4_1.add(tf_hbag_quantity);

		tf_hbag_price = new JTextField();
		tf_hbag_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_hbag_price.setColumns(10);
		tf_hbag_price.setBounds(131, 362, 155, 25);
		panel_4_1.add(tf_hbag_price);

		JLabel lblNewLabel_1_9_2 = new JLabel("Customer name");
		lblNewLabel_1_9_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_9_2.setBounds(10, 15, 120, 25);
		panel_4_1.add(lblNewLabel_1_9_2);

		JLabel lblNewLabel_1_7_1 = new JLabel("Bookingdate");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7_1.setBounds(10, 57, 120, 25);
		panel_4_1.add(lblNewLabel_1_7_1);

		JLabel lblNewLabel_1_10 = new JLabel("HandBagid");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_10.setBounds(10, 99, 120, 25);
		panel_4_1.add(lblNewLabel_1_10);

		JLabel lblNewLabel_1_1_1 = new JLabel("HandBagname");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 141, 120, 25);
		panel_4_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Type of clothes");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(10, 183, 120, 25);
		panel_4_1.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("Quantity");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(10, 315, 68, 25);
		panel_4_1.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_4_1 = new JLabel("Size");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBounds(10, 270, 120, 25);
		panel_4_1.add(lblNewLabel_1_4_1);

		JLabel lblNewLabel_1_5_1 = new JLabel("Color");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBounds(10, 225, 120, 25);
		panel_4_1.add(lblNewLabel_1_5_1);

		JLabel lblNewLabel_1_6_1 = new JLabel("Price");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6_1.setBounds(10, 362, 120, 25);
		panel_4_1.add(lblNewLabel_1_6_1);
		// buy
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5_1.setBounds(27, 397, 252, 51);
		panel_4_1.add(panel_5_1);

		JButton btnNewButton_2_1 = new JButton("Buy");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(51, 10, 144, 26);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
		        // Lấy dữ liệu từ trường nhập cho quần áo
		        String Customer = tf_hbag_customer.getText();
		        String Bookingdate = tf_hbag_booking.getText();
		        String Productid = tf_hbag_id.getText();
		        String Productname = tf_hbag_name.getText();
		        String Type = (String) cb_handbag.getSelectedItem();
		        String Color = tf_hbag_color.getText();
		        String Size = tf_hbag_size.getText();
		        int Quantity = Integer.parseInt(tf_hbag_quantity.getText());
		        double Price = Double.parseDouble(tf_hbag_price.getText());

		        ModelInvoice dataclo = new ModelInvoice( Customer, Bookingdate, Productid, Productname, Type, Color, Size, Quantity, Price);
		      
		        Client.sendDataToServer(dataclo);
		     
		        System.out.println("Sending data to server: " + dataclo.toString());
		        // Sau khi gửi dữ liệu, làm sạch các trường nhập hoặc thực hiện hành động khác
		        tf_hbag_customer.setText("");
		        tf_hbag_booking.setText("");
		        tf_hbag_id.setText("");
		        tf_hbag_name.setText("");
		        tf_hbag_color.setText("");
		        tf_hbag_size.setText("");
		        tf_hbag_quantity.setText("");
		        tf_hbag_price.setText("");
		    }
		});

		panel_5_1.add(btnNewButton_2_1);
		// search
		textField3 = new JTextField();
		textField3.setBounds(626, 31, 200, 43);
		textField3.setColumns(10);
		panel_3.add(textField3);

		JLabel lblSearch3 = new JLabel("Enter the name of the hand bag");
		lblSearch3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSearch3.setBounds(335, 31, 265, 39);
		panel_3.add(lblSearch3);

		JButton btnSearch3 = new JButton("Search");
		btnSearch3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch3.setBounds(859, 31, 122, 42);
		btnSearch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table3.getSelectionModel().clearSelection();
				String searchValue = textField3.getText().trim().toLowerCase();
				List<Integer> matchedRows = new ArrayList<>();

				// Lọc và hiển thị các hàng trong bảng dựa trên tên sản phẩm
				for (int row = 0; row < table3.getRowCount(); row++) {
					String Clothesname = ((String) table3.getValueAt(row, 1)).toLowerCase();
					// So sánh phần đầu của tên sản phẩm với chuỗi tìm kiếm
					if (Clothesname.startsWith(searchValue)) {
						matchedRows.add(row);
					}
				}
				if (matchedRows.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No products found to start with: " + searchValue);
				} else {
					for (Integer rowIndex : matchedRows) {
						table3.getSelectionModel().addSelectionInterval(rowIndex, rowIndex);
						table3.scrollRectToVisible(new Rectangle(table2.getCellRect(rowIndex, 0, true)));
					}
				}
			}
		});
		panel_3.add(btnSearch3);

		DefaultTableModel dm3 = new DefaultTableModel();
		dm3.addColumn("HandBagid");
		dm3.addColumn("HandBagname");
		dm3.addColumn("Type");
		dm3.addColumn("Color");
		dm3.addColumn("Size");
		dm3.addColumn("Quantity");
		dm3.addColumn("Price");

		table3 = new JTable(dm3);
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy chỉ số hàng được chọn
				int selectedRow = table3.getSelectedRow();

				// Kiểm tra nếu người dùng đã chọn một hàng hợp lệ
				if (selectedRow != -1) {
					// Lấy dữ liệu từ hàng được chọn và hiển thị trên các trường nhập
					String HandBagid = (String) dm3.getValueAt(selectedRow, 0);
					String HandBagname = (String) dm3.getValueAt(selectedRow, 1);
					String Type = (String) dm3.getValueAt(selectedRow, 2);
					String Color = (String) dm3.getValueAt(selectedRow, 3);
					String Size = (String) dm3.getValueAt(selectedRow, 4);
					double Price = (double) dm3.getValueAt(selectedRow, 6);

					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_hbag_id.setText(String.valueOf(HandBagid));
					tf_hbag_name.setText(HandBagname);
					cb_handbag.setSelectedItem(Type);
					tf_hbag_color.setText(Color);
					tf_hbag_size.setText(Size);
					tf_hbag_price.setText(String.valueOf(Price));
					tf_hbag_quantity.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int quantity = Integer.parseInt(tf_hbag_quantity.getText());
							int selectedRow = table3.getSelectedRow();
							if (selectedRow != -1) {
								double price = (double) table3.getValueAt(selectedRow, 6);
								double totalPrice = quantity * price;
								tf_hbag_price.setText(String.valueOf(totalPrice));
							}
						}
					});
				}
			}
		});
		JScrollPane js3 = new JScrollPane(table3);
		js3.setBounds(325, 100, 655, 338);
		panel_3.add(js3);
		btnNewButton.addActionListener(e -> {
			CardLayout cl = (CardLayout) panel_card.getLayout();
			cl.show(panel_card, "mycard1");
        });
		btnNewButton_1.addActionListener(e -> {
			CardLayout cl = (CardLayout) panel_card.getLayout();
			cl.show(panel_card, "mycard2");
        });
		btnSearchForHand.addActionListener(e -> {
			CardLayout cl = (CardLayout) panel_card.getLayout();
			cl.show(panel_card, "mycard3");
        });
	}

	public static void updateTablecl(List<ModelClothes> clothesList) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
		for (ModelClothes clothes : clothesList) {
			model.addRow(new Object[] { clothes.getClothesid(), clothes.getClothesname(), clothes.getType(),
					clothes.getColor(), clothes.getSize(), clothes.getQuantity(), clothes.getPrice() });
		}
	}

	public static void updateTablesh(List<ModelShoe> shoeList) {
		DefaultTableModel model = (DefaultTableModel) table2.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
		for (ModelShoe shoe : shoeList) {
			model.addRow(new Object[] { shoe.getShoeid(), shoe.getShoename(), shoe.getType(), shoe.getColor(),
					shoe.getSize(), shoe.getQuantity(), shoe.getPrice() });
		}
	}

	public static void updateTablehb(List<ModelHandBag> handbagList) {
		DefaultTableModel model = (DefaultTableModel) table3.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
		for (ModelHandBag handbag : handbagList) {
			model.addRow(new Object[] { handbag.getHandBagid(), handbag.getHandBagname(), handbag.getType(),
					handbag.getColor(), handbag.getSize(), handbag.getQuantity(), handbag.getPrice() });
		}
	}

	public static void clearTableclo() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trên bảng
	}

	public static void clearTableshoe() {
		DefaultTableModel model = (DefaultTableModel) table2.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trên bảng
	}

	public static void clearTablehbag() {
		DefaultTableModel model = (DefaultTableModel) table3.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trên bảng
	}
}
