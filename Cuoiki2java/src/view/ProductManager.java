package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.JDBC;
import controller.ControProductManager;
import dao.daoEmployeeManager;
import dao.daoProductManager;
import model.ModelClothes;
import model.ModelEmployeeManager;
import model.ModelHandBag;
import model.ModelShoe;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_clo_id, tf_clo_name, tf_clo_color, tf_clo_size, tf_clo_quan, tf_clo_price, tf_search_clo;
	private JTextField tf_shoe_id, tf_shoe_name, tf_shoe_color, tf_shoe_size, tf_shoe_quantity, tf_shoe_price,
			tf_search_shoe;
	private JTextField tf_hbag_id, tf_hbag_name, tf_hbag_color, tf_hbag_size, tf_hbag_quantity, tf_hbag_price,
			tf_search_hbag;
	private JComboBox comboBox;
	private JTable table;
	private DefaultTableModel dm;
	private JComboBox cb_type;
	private DefaultTableModel dmshoe;
	private JTable tableshoe;
	private JComboBox cb_hbtype;
	private DefaultTableModel dmhb;
	private JTable tablehb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManager frame = new ProductManager();
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
	public ProductManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1278, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ControProductManager C_product = new ControProductManager(this);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1264, 62);
		panel_2.setLayout(null);
		contentPane.add(panel_2);

		JButton btnClothesManager = new JButton("Clothes Manager");
		btnClothesManager.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClothesManager.setBounds(343, 13, 181, 32);
		panel_2.add(btnClothesManager);

		JButton btnNewButton_1_1 = new JButton("Shoe Manager");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(570, 13, 168, 32);
		panel_2.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("HandBag Manager");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_2.setBounds(796, 15, 221, 32);
		panel_2.add(btnNewButton_1_2);
		//
		JPanel panel_cr = new JPanel();
		panel_cr.setBounds(0, 62, 1265, 504);
		contentPane.add(panel_cr);
		panel_cr.setLayout(new CardLayout(0, 0));
		// manager clothes
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(1, 2, 367, 505);
		panel_3.setBackground(new Color(255, 255, 240));
		panel_cr.add(panel_3, "mycard1");

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_1.setBounds(1, 1, 367, 502);
		panel_3.add(panel_4_1);

		tf_clo_id = new JTextField();
		tf_clo_id.setColumns(10);
		tf_clo_id.setBounds(131, 39, 155, 19);
		panel_4_1.add(tf_clo_id);

		tf_clo_name = new JTextField();
		tf_clo_name.setColumns(10);
		tf_clo_name.setBounds(131, 82, 155, 19);
		panel_4_1.add(tf_clo_name);

		tf_clo_color = new JTextField();
		tf_clo_color.setColumns(10);
		tf_clo_color.setBounds(131, 165, 155, 19);
		panel_4_1.add(tf_clo_color);

		tf_clo_size = new JTextField();
		tf_clo_size.setColumns(10);
		tf_clo_size.setBounds(131, 203, 155, 19);
		panel_4_1.add(tf_clo_size);

		tf_clo_quan = new JTextField();
		tf_clo_quan.setColumns(10);
		tf_clo_quan.setBounds(131, 242, 155, 19);
		panel_4_1.add(tf_clo_quan);

		tf_clo_price = new JTextField();
		tf_clo_price.setColumns(10);
		tf_clo_price.setBounds(131, 291, 155, 19);
		panel_4_1.add(tf_clo_price);

		JLabel lb_cloid = new JLabel("Clothesid");
		lb_cloid.setBounds(27, 42, 62, 13);
		panel_4_1.add(lb_cloid);

		JLabel lb_cloname = new JLabel("Clothes name");
		lb_cloname.setBounds(27, 85, 94, 13);
		panel_4_1.add(lb_cloname);

		JLabel lb_clotype = new JLabel("Type of clothes");
		lb_clotype.setBounds(27, 128, 94, 13);
		panel_4_1.add(lb_clotype);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity");
		lblNewLabel_1_3.setBounds(27, 245, 68, 13);
		panel_4_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Size");
		lblNewLabel_1_4.setBounds(27, 206, 45, 13);
		panel_4_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Color");
		lblNewLabel_1_5.setBounds(27, 168, 45, 13);
		panel_4_1.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Price");
		lblNewLabel_1_6.setBounds(27, 294, 45, 13);
		panel_4_1.add(lblNewLabel_1_6);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 356, 347, 127);
		panel_4_1.add(panel_5);

		JButton bt_clo_add = new JButton("Add");
		bt_clo_add.setBounds(23, 18, 134, 34);
		bt_clo_add.setActionCommand("Addclothes");
		bt_clo_add.addActionListener(C_product);
		panel_5.setLayout(null);
		bt_clo_add.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(bt_clo_add);

		JButton bt_clo_reset = new JButton("Reset");
		bt_clo_reset.setBounds(23, 70, 134, 34);
		bt_clo_reset.setActionCommand("Resetclothes");
		bt_clo_reset.addActionListener(C_product);
		bt_clo_reset.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(bt_clo_reset);

		JButton bt_clo_repair = new JButton("Repair");
		bt_clo_repair.addActionListener(C_product);
		bt_clo_repair.setActionCommand("Repairclothes");
		bt_clo_repair.setBounds(185, 18, 134, 34);
		bt_clo_repair.setActionCommand("Repairclothes");
		bt_clo_repair.addActionListener(C_product);
		bt_clo_repair.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(bt_clo_repair);

		JButton bt_clo_delete = new JButton("Delete");
		bt_clo_delete.setBounds(185, 70, 134, 34);
		bt_clo_delete.setActionCommand("Deleteclothes");
		bt_clo_delete.addActionListener(C_product);
		bt_clo_delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(bt_clo_delete);
		String arclothes[] = { "Shirts", "T-shirts", "Sweaters", "Jackets", "Jeans", "Trousers", "Dresses", "Shorts",
				"Leggings", "Skirts" };
		comboBox = new JComboBox(arclothes);
		comboBox.setBounds(131, 124, 155, 21);
		panel_4_1.add(comboBox);

		JLabel lblClothesManager = new JLabel("Clothes Manager");
		lblClothesManager.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblClothesManager.setBounds(10, 10, 155, 19);
		panel_4_1.add(lblClothesManager);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(372, 1, 891, 502);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblSearch = new JLabel("Enter clothes ID");
		lblSearch.setBounds(30, 30, 266, 39);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_4.add(lblSearch);

		tf_search_clo = new JTextField();
		tf_search_clo.setBounds(330, 30, 250, 39);
		tf_search_clo.setColumns(10);
		panel_4.add(tf_search_clo);
		dm = new DefaultTableModel();
		dm.addColumn("Clothesid");
		dm.addColumn("Clothesname");
		dm.addColumn("Type");
		dm.addColumn("Color");
		dm.addColumn("Size");
		dm.addColumn("Quantity");
		dm.addColumn("Price");

		table = new JTable(dm);
		// Khai báo sự kiện lắng nghe cho bảng
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
					int Quantity = (int) dm.getValueAt(selectedRow, 5);
					double Price = (double) dm.getValueAt(selectedRow, 6);

					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_clo_id.setText(Clothesid);
					tf_clo_name.setText(Clothesname);
					comboBox.setSelectedItem(Type);
					tf_clo_color.setText(Color);
					tf_clo_size.setText(Size);
					tf_clo_quan.setText(String.valueOf(Quantity));
					tf_clo_price.setText(String.valueOf(Price));
				}
			}
		});
		JScrollPane js = new JScrollPane(table);
		js.setBounds(26, 99, 832, 358);
		panel_4.add(js);

		JButton btnNewButton_2_2_1 = new JButton("Search");
		btnNewButton_2_2_1.setActionCommand("Searchclothes");
		btnNewButton_2_2_1.addActionListener(C_product);

		btnNewButton_2_2_1.setBounds(600, 30, 134, 39);
		btnNewButton_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(btnNewButton_2_2_1);
		
		JButton btnNewButton_2_2_1_1 = new JButton("Clear Search");
		btnNewButton_2_2_1_1.addActionListener(e -> clearSearchClo());
		btnNewButton_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_2_1_1.setActionCommand("Searchclothes");
		btnNewButton_2_2_1_1.setBounds(750, 30, 134, 39);
		panel_4.add(btnNewButton_2_2_1_1);
		/// shoe
		JPanel panel_shoe = new JPanel();
		panel_cr.add(panel_shoe, "mycard2");

		panel_shoe.setBackground(new Color(255, 255, 240));
		panel_shoe.setBounds(1, 54, 1255, 496);
		panel_shoe.setLayout(null);
		// Main bottom left
		JPanel panel_shoel = new JPanel();
		panel_shoel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_shoel.setLayout(null);
		panel_shoel.setBounds(0, 0, 367, 502);
		panel_shoe.add(panel_shoel);

		tf_shoe_id = new JTextField();
		tf_shoe_id.setColumns(10);
		tf_shoe_id.setBounds(131, 39, 155, 19);
		panel_shoel.add(tf_shoe_id);

		tf_shoe_name = new JTextField();
		tf_shoe_name.setColumns(10);
		tf_shoe_name.setBounds(131, 82, 155, 19);
		panel_shoel.add(tf_shoe_name);

		tf_shoe_color = new JTextField();
		tf_shoe_color.setColumns(10);
		tf_shoe_color.setBounds(131, 165, 155, 19);
		panel_shoel.add(tf_shoe_color);

		tf_shoe_size = new JTextField();
		tf_shoe_size.setColumns(10);
		tf_shoe_size.setBounds(131, 203, 155, 19);
		panel_shoel.add(tf_shoe_size);

		tf_shoe_quantity = new JTextField();
		tf_shoe_quantity.setColumns(10);
		tf_shoe_quantity.setBounds(131, 242, 155, 19);
		panel_shoel.add(tf_shoe_quantity);

		tf_shoe_price = new JTextField();
		tf_shoe_price.setColumns(10);
		tf_shoe_price.setBounds(131, 291, 155, 19);
		panel_shoel.add(tf_shoe_price);

		JLabel lb_shoe_id = new JLabel("Shoeid");
		lb_shoe_id.setBounds(27, 42, 62, 13);
		panel_shoel.add(lb_shoe_id);

		JLabel lb_shoename = new JLabel("Shoe name");
		lb_shoename.setBounds(27, 85, 94, 13);
		panel_shoel.add(lb_shoename);

		JLabel lb_shoetype = new JLabel("Type of shoe");
		lb_shoetype.setBounds(27, 128, 94, 13);
		panel_shoel.add(lb_shoetype);
		String arshoe[] = { "Sneakers", "Running shoes", "Training shoes", "Oxfords", "Loafers", "Boots", "Sandals" };
		cb_type = new JComboBox(arshoe);
		cb_type.setBounds(131, 124, 155, 21);
		panel_shoel.add(cb_type);
		JLabel lb_shoe_qua = new JLabel("Quantity");
		lb_shoe_qua.setBounds(27, 245, 68, 13);
		panel_shoel.add(lb_shoe_qua);

		JLabel lb_shoesize = new JLabel("Size");
		lb_shoesize.setBounds(27, 206, 45, 13);
		panel_shoel.add(lb_shoesize);

		JLabel lb_shoecolor = new JLabel("Color");
		lb_shoecolor.setBounds(27, 168, 45, 13);
		panel_shoel.add(lb_shoecolor);

		JLabel lb_shoeprice = new JLabel("Price");
		lb_shoeprice.setBounds(27, 294, 45, 13);
		panel_shoel.add(lb_shoeprice);

		JPanel panel_shoefunction = new JPanel();
		panel_shoefunction.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_shoefunction.setBounds(10, 356, 347, 127);
		panel_shoel.add(panel_shoefunction);

		JButton bt_shoeadd = new JButton("Add");
		bt_shoeadd.setBounds(23, 18, 134, 34);
		bt_shoeadd.setActionCommand("Addshoe");
		bt_shoeadd.addActionListener(C_product);
		panel_shoefunction.setLayout(null);
		bt_shoeadd.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_shoefunction.add(bt_shoeadd);

		JButton bt_shoereset = new JButton("Reset");
		bt_shoereset.setBounds(23, 70, 134, 34);
		bt_shoereset.setActionCommand("Resetshoe");
		bt_shoereset.addActionListener(C_product);
		bt_shoereset.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_shoefunction.add(bt_shoereset);

		JButton bt_shoerepair = new JButton("Repair");
		bt_shoerepair.addActionListener(C_product);
		bt_shoerepair.setActionCommand("Repairshoe");
		bt_shoerepair.setBounds(185, 18, 134, 34);
		bt_shoerepair.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_shoefunction.add(bt_shoerepair);

		JButton bt_shoe_delete = new JButton("Delete");
		bt_shoe_delete.setBounds(185, 70, 134, 34);
		bt_shoe_delete.setActionCommand("Deleteshoe");
		bt_shoe_delete.addActionListener(C_product);

		bt_shoe_delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_shoefunction.add(bt_shoe_delete);

		JLabel lblShoeManager = new JLabel("Shoe Manager");
		lblShoeManager.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblShoeManager.setBounds(10, 10, 155, 19);
		panel_shoel.add(lblShoeManager);

		// Main bottom right
		JPanel panel_shoeta = new JPanel();
		panel_shoeta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_shoeta.setBounds(372, 0, 892, 502);
		panel_shoe.add(panel_shoeta);
		dmshoe = new DefaultTableModel();
		dmshoe.addColumn("Shoeid");
		dmshoe.addColumn("Shoename");
		dmshoe.addColumn("Type");
		dmshoe.addColumn("Color");
		dmshoe.addColumn("Size");
		dmshoe.addColumn("Quantity");
		dmshoe.addColumn("Price");

		tableshoe = new JTable(dmshoe);
		tableshoe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy chỉ số hàng được chọn
				int selectedRow = tableshoe.getSelectedRow();

				// Kiểm tra nếu người dùng đã chọn một hàng hợp lệ
				if (selectedRow != -1) {
					// Lấy dữ liệu từ hàng được chọn và hiển thị trên các trường nhập
					String Shoeid = (String) dmshoe.getValueAt(selectedRow, 0);
					String Shoename = (String) dmshoe.getValueAt(selectedRow, 1);
					String Type = (String) dmshoe.getValueAt(selectedRow, 2);
					String Color = (String) dmshoe.getValueAt(selectedRow, 3);
					String Size = (String) dmshoe.getValueAt(selectedRow, 4);
					int Quantity = (int) dmshoe.getValueAt(selectedRow, 5);
					double Price = (double) dmshoe.getValueAt(selectedRow, 6);

					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_shoe_id.setText(String.valueOf(Shoeid));
					tf_shoe_name.setText(Shoename);
					cb_type.setSelectedItem(Type);
					tf_shoe_color.setText(Color);
					tf_shoe_size.setText(Size);
					tf_shoe_quantity.setText(String.valueOf(Quantity));
					tf_shoe_price.setText(String.valueOf(Price));
				}
			}
		});
		panel_shoeta.setLayout(null);
		JScrollPane jsshoe = new JScrollPane(tableshoe);
		jsshoe.setBounds(26, 99, 832, 358);

		panel_shoeta.add(jsshoe);

		JLabel lblSearchshoe = new JLabel("Enter shoe ID");
		lblSearchshoe.setBounds(30, 27, 266, 39);
		lblSearchshoe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_shoeta.add(lblSearchshoe);

		tf_search_shoe = new JTextField();
		tf_search_shoe.setBounds(330, 29, 250, 39);
		tf_search_shoe.setColumns(10);
		panel_shoeta.add(tf_search_shoe);

		JButton bt_shoesearch = new JButton("Search");
		bt_shoesearch.setActionCommand("Searchshoe");
		bt_shoesearch.addActionListener(C_product);
		bt_shoesearch.setBounds(600, 30, 134, 39);
		bt_shoesearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_shoeta.add(bt_shoesearch);
		
		JButton bt_shoesearch_1 = new JButton("Clear Search");
		bt_shoesearch_1.addActionListener(e -> clearSearchShoe());
		bt_shoesearch_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_shoesearch_1.setActionCommand("Searchshoe");
		bt_shoesearch_1.setBounds(750, 27, 134, 39);
		panel_shoeta.add(bt_shoesearch_1);
		// handbag
		JPanel panel_handbag = new JPanel();
		panel_cr.add(panel_handbag, "mycard3");
		panel_handbag.setBackground(new Color(255, 255, 240));
		panel_handbag.setBounds(1, 54, 1255, 496);
		panel_handbag.setLayout(null);
		// Main bottom left
		JPanel panel_handbagl = new JPanel();
		panel_handbagl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_handbagl.setLayout(null);
		panel_handbagl.setBounds(0, 0, 367, 502);
		panel_handbag.add(panel_handbagl);

		tf_hbag_id = new JTextField();
		tf_hbag_id.setColumns(10);
		tf_hbag_id.setBounds(131, 39, 155, 19);
		panel_handbagl.add(tf_hbag_id);

		tf_hbag_name = new JTextField();
		tf_hbag_name.setColumns(10);
		tf_hbag_name.setBounds(131, 82, 155, 19);
		panel_handbagl.add(tf_hbag_name);

		tf_hbag_color = new JTextField();
		tf_hbag_color.setColumns(10);
		tf_hbag_color.setBounds(131, 165, 155, 19);
		panel_handbagl.add(tf_hbag_color);

		tf_hbag_size = new JTextField();
		tf_hbag_size.setColumns(10);
		tf_hbag_size.setBounds(131, 203, 155, 19);
		panel_handbagl.add(tf_hbag_size);

		tf_hbag_quantity = new JTextField();
		tf_hbag_quantity.setColumns(10);
		tf_hbag_quantity.setBounds(131, 242, 155, 19);
		panel_handbagl.add(tf_hbag_quantity);

		tf_hbag_price = new JTextField();
		tf_hbag_price.setColumns(10);
		tf_hbag_price.setBounds(131, 291, 155, 19);
		panel_handbagl.add(tf_hbag_price);

		JLabel lb_hb_id = new JLabel("HandBagid");
		lb_hb_id.setBounds(27, 42, 62, 13);
		panel_handbagl.add(lb_hb_id);

		JLabel lb_hbname = new JLabel("HandBag name");
		lb_hbname.setBounds(27, 85, 94, 13);
		panel_handbagl.add(lb_hbname);

		JLabel lb_hbtype = new JLabel("Type of HandBag");
		lb_hbtype.setBounds(27, 128, 94, 13);
		panel_handbagl.add(lb_hbtype);
		String arhandbag[] = { "Tote bag", "Bucket bag", "Hobo bag", "Messenger bag", "Shoulder bag", "Crossbody bag" };
		cb_hbtype = new JComboBox(arhandbag);

		cb_hbtype.setBounds(131, 124, 155, 21);
		panel_handbagl.add(cb_hbtype);
		JLabel lb_hb_qua = new JLabel("Quantity");
		lb_hb_qua.setBounds(27, 245, 68, 13);
		panel_handbagl.add(lb_hb_qua);

		JLabel lb_hbsize = new JLabel("Size");
		lb_hbsize.setBounds(27, 206, 45, 13);
		panel_handbagl.add(lb_hbsize);

		JLabel lb_hbcolor = new JLabel("Color");
		lb_hbcolor.setBounds(27, 168, 45, 13);
		panel_handbagl.add(lb_hbcolor);

		JLabel lb_hbprice = new JLabel("Price");
		lb_hbprice.setBounds(27, 294, 45, 13);
		panel_handbagl.add(lb_hbprice);

		JPanel panel_hbfunction = new JPanel();
		panel_hbfunction.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_hbfunction.setLayout(null);
		panel_hbfunction.setBounds(10, 356, 347, 127);
		panel_handbagl.add(panel_hbfunction);

		JButton bt_hbadd = new JButton("Add");
		bt_hbadd.setActionCommand("Addhandbag");
		;
		bt_hbadd.addActionListener(C_product);
		bt_hbadd.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_hbadd.setBounds(23, 18, 134, 34);
		panel_hbfunction.add(bt_hbadd);

		JButton bt_hbreset = new JButton("Reset");
		bt_hbreset.addActionListener(C_product);
		bt_hbreset.setActionCommand("Resethandbag");
		bt_hbreset.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_hbreset.setBounds(23, 70, 134, 34);
		panel_hbfunction.add(bt_hbreset);

		JButton bt_hbrepair = new JButton("Repair");
		bt_hbrepair.addActionListener(C_product);
		bt_hbrepair.setActionCommand("Repairhandbag");
		bt_hbrepair.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_hbrepair.setBounds(185, 18, 134, 34);
		panel_hbfunction.add(bt_hbrepair);

		JButton bt_hb_delete = new JButton("Delete");
		bt_hb_delete.addActionListener(C_product);
		bt_hb_delete.setActionCommand("Deletehandbag");
		bt_hb_delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_hb_delete.setBounds(185, 70, 134, 34);
		panel_hbfunction.add(bt_hb_delete);

		JLabel lblHandbagManager = new JLabel("HandBag Manager");
		lblHandbagManager.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblHandbagManager.setBounds(10, 10, 155, 19);
		panel_handbagl.add(lblHandbagManager);

		// Main bottom right
		JPanel panel_hbta = new JPanel();
		panel_hbta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_hbta.setBounds(372, 0, 892, 502);
		panel_handbag.add(panel_hbta);
		dmhb = new DefaultTableModel();
		dmhb.addColumn("HandBagid");
		dmhb.addColumn("HandBagname");
		dmhb.addColumn("Type");
		dmhb.addColumn("Color");
		dmhb.addColumn("Size");
		dmhb.addColumn("Quantity");
		dmhb.addColumn("Price");

		tablehb = new JTable(dmhb);
		tablehb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy chỉ số hàng được chọn
				int selectedRow = tablehb.getSelectedRow();

				// Kiểm tra nếu người dùng đã chọn một hàng hợp lệ
				if (selectedRow != -1) {
					// Lấy dữ liệu từ hàng được chọn và hiển thị trên các trường nhập
					String HandBagid = (String) dmhb.getValueAt(selectedRow, 0);
					String HandBagname = (String) dmhb.getValueAt(selectedRow, 1);
					String Type = (String) dmhb.getValueAt(selectedRow, 2);
					String Color = (String) dmhb.getValueAt(selectedRow, 3);
					String Size = (String) dmhb.getValueAt(selectedRow, 4);
					int Quantity = (int) dmhb.getValueAt(selectedRow, 5);
					double Price = (double) dmhb.getValueAt(selectedRow, 6);

					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_hbag_id.setText(String.valueOf(HandBagid));
					tf_hbag_name.setText(HandBagname);
					cb_hbtype.setSelectedItem(Type);
					tf_hbag_color.setText(Color);
					tf_hbag_size.setText(Size);
					tf_hbag_quantity.setText(String.valueOf(Quantity));
					tf_hbag_price.setText(String.valueOf(Price));
				}
			}
		});
		panel_hbta.setLayout(null);
		JScrollPane jshb = new JScrollPane(tablehb);
		jshb.setBounds(26, 99, 832, 358);
		panel_hbta.add(jshb);

		JLabel lblSearchhb = new JLabel("Enter  hand bag ID");
		lblSearchhb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSearchhb.setBounds(30, 27, 266, 39);
		panel_hbta.add(lblSearchhb);

		tf_search_hbag = new JTextField();
		tf_search_hbag.setColumns(10);
		tf_search_hbag.setBounds(330, 29, 250, 39);
		panel_hbta.add(tf_search_hbag);

		JButton bt_hbsearch = new JButton("Search");
		bt_hbsearch.setActionCommand("Searchhandbag");
		bt_hbsearch.addActionListener(C_product);
		bt_hbsearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_hbsearch.setBounds(600, 29, 134, 39);
		panel_hbta.add(bt_hbsearch);
		
		JButton bt_hbsearch_1 = new JButton("Clear Search");
		bt_hbsearch_1.addActionListener(e -> clearSearchHBag());
		bt_hbsearch_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_hbsearch_1.setActionCommand("Searchhandbag");
		bt_hbsearch_1.setBounds(750, 27, 134, 39);
		panel_hbta.add(bt_hbsearch_1);
		btnClothesManager.addActionListener(e -> {
			CardLayout cl = (CardLayout) (panel_cr.getLayout());
			cl.show(panel_cr, "mycard1"); // Thay "clothesManager" thành "mycard1"
        });
		btnNewButton_1_1.addActionListener(e -> {
			CardLayout cl = (CardLayout) (panel_cr.getLayout());
			cl.show(panel_cr, "mycard2"); // Thay "shoeManager" thành "mycard2"
        });
		btnNewButton_1_2.addActionListener(e -> {
			CardLayout cl = (CardLayout) (panel_cr.getLayout());
			cl.show(panel_cr, "mycard3"); 
        });
	
		load_data_clothes();
		load_data_shoe();
		load_data_handbag();
	}

	// thêm
	public void addclothes() {
		if (tf_clo_id.getText().isEmpty() || tf_clo_name.getText().isEmpty() || comboBox.getSelectedItem() == null
				|| tf_clo_color.getText().isEmpty() || tf_clo_size.getText().isEmpty()
				|| tf_clo_quan.getText().isEmpty() || tf_clo_price.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter complete information!");
			return;
		}
		String Clothesid = tf_clo_id.getText(); // Đổi sang kiểu String
		String Clothesname = tf_clo_name.getText();
		String Type = (String) comboBox.getSelectedItem();
		String Color = tf_clo_color.getText();
		String Size = tf_clo_size.getText();
		int Quantity = Integer.parseInt(tf_clo_quan.getText());
		double Price = Double.parseDouble(tf_clo_price.getText());
		ModelClothes modelclothes = new ModelClothes(Clothesid, Clothesname, Type, Color, Size, Quantity, Price);
		daoProductManager Dao2 = new daoProductManager();
		Dao2.add_data_clothes(modelclothes);
		DefaultTableModel tablemodel2t = (DefaultTableModel) table.getModel();
		tablemodel2t.addRow(new Object[] { Clothesid, Clothesname, Type, Color, Size, Quantity, Price });
		table.setModel(tablemodel2t);

		// làm mới lại phần nhập
		tf_clo_id.setText("");
		tf_clo_name.setText("");
		comboBox.setSelectedItem(null);
		tf_clo_color.setText("");
		tf_clo_size.setText("");
		tf_clo_quan.setText("");
		tf_clo_price.setText("");
	}

	public void addshoe() {
		if (tf_shoe_id.getText().isEmpty() || tf_shoe_name.getText().isEmpty() || cb_type.getSelectedItem() == null
				|| tf_shoe_color.getText().isEmpty() || tf_shoe_size.getText().isEmpty()
				|| tf_shoe_quantity.getText().isEmpty() || tf_shoe_price.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter complete information!");
			return;
		}
		String Shoeid = tf_shoe_id.getText();
		String Shoename = tf_shoe_name.getText();
		String Type = (String) cb_type.getSelectedItem();
		String Color = tf_shoe_color.getText();
		String Size = tf_shoe_size.getText();
		int Quantity = Integer.parseInt(tf_shoe_quantity.getText());
		double Price = Double.parseDouble(tf_shoe_price.getText());
		ModelShoe modelshoe = new ModelShoe(Shoeid, Shoename, Type, Color, Size, Quantity, Price);
		daoProductManager Dao2 = new daoProductManager();
		Dao2.add_data_shoe(modelshoe);
		DefaultTableModel ta = (DefaultTableModel) tableshoe.getModel();
		ta.addRow(new Object[] { Shoeid, Shoename, Type, Color, Size, Quantity, Price });
		tableshoe.setModel(ta);
		// làm mới lại phần nhập
		tf_shoe_id.setText("");
		tf_shoe_name.setText("");
		cb_type.setSelectedItem(null);
		tf_shoe_color.setText("");
		tf_shoe_size.setText("");
		tf_shoe_quantity.setText("");
		tf_shoe_price.setText("");
	}

	public void addhandbag() {
		if (tf_hbag_id.getText().isEmpty() || tf_hbag_name.getText().isEmpty() || cb_hbtype.getSelectedItem() == null
				|| tf_hbag_color.getText().isEmpty() || tf_hbag_size.getText().isEmpty()
				|| tf_hbag_quantity.getText().isEmpty() || tf_hbag_price.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter complete information!");
			return;
		}
		String HandBagid = tf_hbag_id.getText();
		String HandBagname = tf_hbag_name.getText();
		String Type = (String) cb_hbtype.getSelectedItem();
		String Color = tf_hbag_color.getText();
		String Size = tf_hbag_size.getText();
		int Quantity = Integer.parseInt(tf_hbag_quantity.getText());
		double Price = Double.parseDouble(tf_hbag_price.getText());
		ModelHandBag modelhbag = new ModelHandBag(HandBagid, HandBagname, Type, Color, Size, Quantity, Price);
		daoProductManager Dao2 = new daoProductManager();
		Dao2.add_data_handbag(modelhbag);
		DefaultTableModel ta_handbag = (DefaultTableModel) tablehb.getModel();
		ta_handbag.addRow(new Object[] { HandBagid, HandBagname, Type, Color, Size, Quantity, Price });
		tablehb.setModel(ta_handbag);
		// làm mới lại phần nhập
		tf_hbag_id.setText("");
		tf_hbag_name.setText("");
		cb_hbtype.setSelectedItem(null);
		tf_hbag_color.setText("");
		tf_hbag_size.setText("");
		tf_hbag_quantity.setText("");
		tf_hbag_price.setText("");
	}

	// xoá
		public void deleteclothes() {
			int selectRow = table.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "Please select a line to delete");
			}
			int[] selectedRows = table.getSelectedRows();
			daoProductManager Dao2 = new daoProductManager();
	
			List<Integer> rowDeXoa = new ArrayList<Integer>();
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				int selectedRow = table.convertRowIndexToModel(selectedRows[i]);
				rowDeXoa.add(selectedRow);
			}
			for (int row : rowDeXoa) {
				String Clothesid = table.getValueAt(row, 0).toString();
				String Clothesname = table.getValueAt(row, 1).toString();
				String Type = table.getValueAt(row, 2).toString();
				String Color = table.getValueAt(row, 3).toString();
				String Size = table.getValueAt(row, 4).toString();
				int Quantity = Integer.parseInt(table.getValueAt(row, 5).toString());
				double Price = Double.parseDouble(table.getValueAt(row, 6).toString());
	
				ModelClothes model = new ModelClothes(Clothesid, Clothesname, Type, Color, Size, Quantity, Price);
				Dao2.delete_data_clothes(model);
				dm.removeRow(row);
			}
			tf_clo_id.setText("");
			tf_clo_name.setText("");
			comboBox.setSelectedItem(null);
			tf_clo_color.setText("");
			tf_clo_size.setText("");
			tf_clo_quan.setText("");
			tf_clo_price.setText("");
		}

	public void deleteshoe() {
		int selectRow = tableshoe.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Please select a line to delete");
		}
		int[] selectedRows = tableshoe.getSelectedRows();
		daoProductManager Dao2 = new daoProductManager();

		List<Integer> rowDeXoa = new ArrayList<Integer>();
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int selectedRow = tableshoe.convertRowIndexToModel(selectedRows[i]);
			rowDeXoa.add(selectedRow);
		}
		for (int row : rowDeXoa) {
			String Shoeid = tableshoe.getValueAt(row, 0).toString();
			String Shoename = tableshoe.getValueAt(row, 1).toString();
			String Type = tableshoe.getValueAt(row, 2).toString();
			String Color = tableshoe.getValueAt(row, 3).toString();
			String Size = tableshoe.getValueAt(row, 4).toString();
			int Quantity = Integer.parseInt(tableshoe.getValueAt(row, 5).toString());
			double Price = Double.parseDouble(tableshoe.getValueAt(row, 6).toString());

			ModelShoe model = new ModelShoe(Shoeid, Shoename, Type, Color, Size, Quantity, Price);
			Dao2.delete_data_shoe(model);
			dmshoe.removeRow(row);
		}
		tf_shoe_id.setText("");
		tf_shoe_name.setText("");
		cb_type.setSelectedItem(null);
		tf_shoe_color.setText("");
		tf_shoe_size.setText("");
		tf_shoe_quantity.setText("");
		tf_shoe_price.setText("");
	}

	public void deletehandbag() {
		int selectRow = tablehb.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Please select a line to delete");
		}
		int[] selectedRows = tablehb.getSelectedRows();
		daoProductManager Dao2 = new daoProductManager();

		List<Integer> rowDeXoa = new ArrayList<Integer>();
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int selectedRow = tablehb.convertRowIndexToModel(selectedRows[i]);
			rowDeXoa.add(selectedRow);
		}
		for (int row : rowDeXoa) {
			String HandBagid = tablehb.getValueAt(row, 0).toString();
			String HandBagname = tablehb.getValueAt(row, 1).toString();
			String Type = tablehb.getValueAt(row, 2).toString();
			String Color = tablehb.getValueAt(row, 3).toString();
			String Size = tablehb.getValueAt(row, 4).toString();
			int Quantity = Integer.parseInt(tablehb.getValueAt(row, 5).toString());
			double Price = Double.parseDouble(tablehb.getValueAt(row, 6).toString());

			ModelHandBag model = new ModelHandBag(HandBagid, HandBagname, Type, Color, Size, Quantity, Price);
			Dao2.delete_data_handbag(model);
			dmhb.removeRow(row);
		}
		tf_hbag_id.setText("");
		tf_hbag_name.setText("");
		cb_hbtype.setSelectedItem(null);
		tf_hbag_color.setText("");
		tf_hbag_size.setText("");
		tf_hbag_quantity.setText("");
		tf_hbag_price.setText("");
	}
	// sửa

	public void updateclothes() {
		try {
			DefaultTableModel dm = (DefaultTableModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật.");
				return;
			}

			String Clothesid = dm.getValueAt(selectedRow, 0).toString(); 

			String newClothesname = tf_clo_name.getText();
			String newType = (String) comboBox.getSelectedItem();
			String newColor = tf_clo_color.getText();
			String newSize = tf_clo_size.getText();
			int newQuantity = Integer.parseInt(tf_clo_quan.getText());
			double newPrice = Double.parseDouble(tf_clo_price.getText());

			ModelClothes model = new ModelClothes(Clothesid, newClothesname, newType, newColor, newSize, newQuantity,
					newPrice);

			daoProductManager dao = new daoProductManager();
			dao.update_data_clothes(model);

			dm.setValueAt(newClothesname, selectedRow, 1);
			dm.setValueAt(newType, selectedRow, 2);
			dm.setValueAt(newColor, selectedRow, 3);
			dm.setValueAt(newSize, selectedRow, 4);
			dm.setValueAt(newQuantity, selectedRow, 5);
			dm.setValueAt(newPrice, selectedRow, 6);
			JOptionPane.showMessageDialog(this, "Clothes updated successfully!");
		} catch (NumberFormatException e) {
		}

		tf_clo_id.setText("");
		tf_clo_name.setText("");
		comboBox.setSelectedItem(null);
		tf_clo_color.setText("");
		tf_clo_size.setText("");
		tf_clo_quan.setText("");
		tf_clo_price.setText("");
	}

	public void updateshoe() {
		try {
			DefaultTableModel dmshoe = (DefaultTableModel) tableshoe.getModel();
			int selectedRow = tableshoe.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật.");
				return;
			}
			String Shoeid = dm.getValueAt(selectedRow, 0).toString(); 

			String Shoename = tf_shoe_name.getText();
			String Type = (String) cb_type.getSelectedItem();
			String Color = tf_shoe_color.getText();
			String Size = tf_shoe_size.getText();
			int Quantity = Integer.parseInt(tf_shoe_quantity.getText());
			double Price = Double.parseDouble(tf_shoe_price.getText());

			ModelShoe model = new ModelShoe(Shoeid, Shoename, Type, Color, Size, Quantity, Price);

			daoProductManager dao = new daoProductManager();
			dao.update_data_shoe(model);

			dm.setValueAt(Shoename, selectedRow, 1);
			dm.setValueAt(Type, selectedRow, 2);
			dm.setValueAt(Color, selectedRow, 3);
			dm.setValueAt(Size, selectedRow, 4);
			dm.setValueAt(Quantity, selectedRow, 5);
			dm.setValueAt(Price, selectedRow, 6);
			JOptionPane.showMessageDialog(this, "Clothes updated successfully!");
		} catch (NumberFormatException e) {
		}

		tf_shoe_id.setText("");
		tf_shoe_name.setText("");
		cb_type.setSelectedItem(null);
		tf_shoe_color.setText("");
		tf_shoe_size.setText("");
		tf_shoe_quantity.setText("");
		tf_shoe_price.setText("");
	}

	public void updatehandbag() {
		try {
			DefaultTableModel dmhb = (DefaultTableModel) tablehb.getModel();
			int selectedRow = tablehb.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật.");
				return;
			}
			String HandBagid = dm.getValueAt(selectedRow, 0).toString(); 

			String HandBagname = tf_hbag_name.getText();
			String Type = (String) cb_hbtype.getSelectedItem();
			String Color = tf_hbag_color.getText();
			String Size = tf_hbag_size.getText();
			int Quantity = Integer.parseInt(tf_hbag_quantity.getText());
			double Price = Double.parseDouble(tf_hbag_price.getText());

			ModelHandBag model = new ModelHandBag(HandBagid, HandBagname, Type, Color, Size, Quantity, Price);

			daoProductManager dao = new daoProductManager();
			dao.update_data_handbag(model);

			dm.setValueAt(HandBagname, selectedRow, 1);
			dm.setValueAt(Type, selectedRow, 2);
			dm.setValueAt(Color, selectedRow, 3);
			dm.setValueAt(Size, selectedRow, 4);
			dm.setValueAt(Quantity, selectedRow, 5);
			dm.setValueAt(Price, selectedRow, 6);
			JOptionPane.showMessageDialog(this, "Clothes updated successfully!");
		} catch (NumberFormatException e) {
		}

		tf_hbag_id.setText("");
		tf_hbag_name.setText("");
		cb_hbtype.setSelectedItem(null);
		tf_hbag_color.setText("");
		tf_hbag_size.setText("");
		tf_hbag_quantity.setText("");
		tf_hbag_price.setText("");
	}

// reset
	public void resetclothes() {
		// Tạo một hộp thoại xác nhận
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa dữ liệu không?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		// Kiểm tra kết quả của hộp thoại xác nhận
		if (dialogResult == JOptionPane.YES_OPTION) {
			DefaultTableModel dm = (DefaultTableModel) table.getModel();
			dm.setRowCount(0);
			// Nếu người dùng chọn "Yes", đặt lại giá trị của các thành phần giao diện người
			// dùng
			tf_clo_id.setText("");
			tf_clo_name.setText("");
			tf_clo_color.setText("");
			tf_clo_size.setText("");
			tf_clo_quan.setText("");
			tf_clo_price.setText("");
			comboBox.setSelectedIndex(0);

			// Gọi phương thức reset_data_clothes để xóa dữ liệu trong cơ sở dữ liệu
			daoProductManager dao = new daoProductManager();
			dao.reset_data_clothes(null);
		}
	}

	public void resetshoe() {
		// Tạo một hộp thoại xác nhận
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa dữ liệu không?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		// Kiểm tra kết quả của hộp thoại xác nhận
		if (dialogResult == JOptionPane.YES_OPTION) {
			DefaultTableModel dmshoe = (DefaultTableModel) tableshoe.getModel();
			dmshoe.setRowCount(0);
			// Nếu người dùng chọn "Yes", đặt lại giá trị của các thành phần giao diện người
			// dùng
			tf_shoe_id.setText("");
			tf_shoe_name.setText("");
			tf_shoe_color.setText("");
			tf_shoe_size.setText("");
			tf_shoe_quantity.setText("");
			tf_shoe_price.setText("");
			cb_type.setSelectedIndex(0);

			// Gọi phương thức reset_data_clothes để xóa dữ liệu trong cơ sở dữ liệu
			daoProductManager dao = new daoProductManager();
			dao.reset_data_shoe(null);
		}
	}

	public void resethandbag() {
		// Tạo một hộp thoại xác nhận
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa dữ liệu không?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		// Kiểm tra kết quả của hộp thoại xác nhận
		if (dialogResult == JOptionPane.YES_OPTION) {
			DefaultTableModel dmhb = (DefaultTableModel) tablehb.getModel();
			dmhb.setRowCount(0);
		
			tf_hbag_id.setText("");
			tf_hbag_name.setText("");
			tf_hbag_color.setText("");
			tf_hbag_size.setText("");
			tf_hbag_quantity.setText("");
			tf_hbag_price.setText("");
			cb_hbtype.setSelectedIndex(0);
			daoProductManager dao = new daoProductManager();
			dao.reset_data_handbag(null);
		}
	}

	// load
	public void load_data_clothes() {
		try {
			daoProductManager dao = new daoProductManager();
			List<ModelClothes> clothes = dao.getAllClothes();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (ModelClothes modelclothes : clothes) {
				model.addRow(new Object[] { modelclothes.getClothesid(), modelclothes.getClothesname(),
						modelclothes.getType(), modelclothes.getColor(), modelclothes.getSize(),
						modelclothes.getQuantity(), modelclothes.getPrice(),

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load clothes data from database.");
		}
	}

	public void load_data_shoe() {
		try {
			daoProductManager dao = new daoProductManager();
			List<ModelShoe> shoe = dao.getAllShoe();
			DefaultTableModel model = (DefaultTableModel) tableshoe.getModel();
			for (ModelShoe modelshoe : shoe) {
				model.addRow(new Object[] { modelshoe.getShoeid(), modelshoe.getShoename(), modelshoe.getType(),
						modelshoe.getColor(), modelshoe.getSize(), modelshoe.getQuantity(), modelshoe.getPrice(),

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load clothes data from database.");
		}
	}

	public void load_data_handbag() {
		try {
			daoProductManager dao = new daoProductManager();
			List<ModelHandBag> handbag = dao.getAllHandBag();
			DefaultTableModel model = (DefaultTableModel) tablehb.getModel();
			for (ModelHandBag modelhandbag : handbag) {
				model.addRow(new Object[] { modelhandbag.getHandBagid(), modelhandbag.getHandBagname(),
						modelhandbag.getType(), modelhandbag.getColor(), modelhandbag.getSize(),
						modelhandbag.getQuantity(), modelhandbag.getPrice(),

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load clothes data from database.");
		}
	}

	public void searchclothes() {
	    String clothesId = tf_search_clo.getText().trim(); 
	    if (clothesId.isEmpty()) {	  
	        JOptionPane.showMessageDialog(null, "Please enter a clothes ID to search.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    daoProductManager dao = new daoProductManager();
	    ArrayList<ModelClothes> list = dao.SearchClothes(clothesId);
	    if (list.isEmpty()) {	 
	        JOptionPane.showMessageDialog(null, "No clothes found with ID: " + clothesId, "Information", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        dm.setRowCount(0);
	        for (ModelClothes model : list) {
	            dm.addRow(new Object[] { model.getClothesid(), model.getClothesname(), model.getType(), model.getColor(),
	                model.getSize(), model.getQuantity(), model.getPrice() });
	        }
	    }
	}
	public void searchshoe() {
	    String shoeId = tf_search_shoe.getText().trim();
	    if (shoeId.isEmpty()) {
	    	 JOptionPane.showMessageDialog(null, "Please enter a shoe ID to search.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    daoProductManager dao = new daoProductManager();
	    ArrayList<ModelShoe> list = dao.SearchShoe(shoeId);

	    if (list.isEmpty()) {
	    	 JOptionPane.showMessageDialog(null, "No shoe found with ID: " + shoeId, "Information", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        dmshoe.setRowCount(0);
	        for (ModelShoe model : list) {
	            dmshoe.addRow(new Object[] { model.getShoeid(), model.getShoename(), model.getType(), model.getColor(),
	                model.getSize(), model.getQuantity(), model.getPrice() });
	        }
	    }
	}

	public void searchhandbag() {
	    String handBagId = tf_search_hbag.getText().trim();

	    if (handBagId.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please enter a handbag ID to search.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    daoProductManager dao = new daoProductManager();
	    ArrayList<ModelHandBag> list = dao.SearchHandBag(handBagId);

	    if (list.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No handbag found with ID: " + handBagId, "Information", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        dmhb.setRowCount(0);
	        for (ModelHandBag model : list) {
	            dmhb.addRow(new Object[] { model.getHandBagid(), model.getHandBagname(), model.getType(), model.getColor(),
	                model.getSize(), model.getQuantity(), model.getPrice() });
	        }
	    }
	}


	public List<ModelClothes> getProductData() {
		List<ModelClothes> clothesList = new ArrayList<>();

		try {
			Connection connection = JDBC.getConnection();
			String sql = "SELECT * FROM clothes";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				 String Clothesid = resultSet.getString("Clothesid");
				String Clothesname = resultSet.getString("Clothesname");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelClothes clothes = new ModelClothes(Clothesid, Clothesname, Type, Color, Size, Quantity, Price);
				clothesList.add(clothes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("llxi");
		}
		return clothesList;
	}

	public List<ModelShoe> getProductDatashoe() {
		List<ModelShoe> shoeList = new ArrayList<>();

		try {
			Connection connection = JDBC.getConnection();
			String sql = "SELECT * FROM shoe";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String Shoeid = resultSet.getString("Shoeid");
				String Shoename = resultSet.getString("Shoename");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelShoe shoe = new ModelShoe(Shoeid, Shoename, Type, Color, Size, Quantity, Price);
				shoeList.add(shoe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("llxi");
		}
		return shoeList;
	}

	public List<ModelHandBag> getProductDatahandbag() {
		List<ModelHandBag> handbagList = new ArrayList<>();

		try {
			Connection connection = JDBC.getConnection();
			String sql = "SELECT * FROM handbag";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String HandBagid = resultSet.getString("HandBagid");
				String HandBagname = resultSet.getString("HandBagname");
				String Type = resultSet.getString("Type");
				String Color = resultSet.getString("Color");
				String Size = resultSet.getString("Size");
				int Quantity = resultSet.getInt("Quantity");
				double Price = resultSet.getDouble("Price");

				ModelHandBag handbag = new ModelHandBag(HandBagid, HandBagname, Type, Color, Size, Quantity, Price);
				handbagList.add(handbag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("llxi");
		}
		return handbagList;
	}
	private void clearSearchClo() {
		tf_search_clo.setText(""); 
		load_data_clothes(); 
    }
	private void clearSearchShoe() {
		tf_search_clo.setText(""); 
		load_data_clothes(); 
    }
	private void clearSearchHBag() {
		tf_search_clo.setText(""); 
		load_data_clothes(); 
    }
}
