package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import controller.ControInvoice;
import dao.daoEmployeeManager;
import dao.daoInvoice;
import dao.daoProductManager;
import model.ModelClothes;
import model.ModelEmployeeManager;
import model.ModelInvoice;
import model.ModelInvoiceConfirm;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Invoice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_invoi_id;
	private JTextField tf_product_id;
	private JTextField tf_color;
	private JTextField tf_size;
	private JTable table;
	private JTable table_1;
	private JTextField tf_type;
	private JTextField tf_quantity;
	private JTextField tf_price;
	private JTextField tf_bookingdate;
	private JTable table_2;
	private JTextField tf_Customer;
	private JTextField tf_product_name;
	private List<ModelInvoiceConfirm> invoiceConfirms;
	private DefaultTableModel modeliv;

	/**a
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
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
	public Invoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ControInvoice contro = new ControInvoice(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1266, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 38, 343, 512);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_invoi_id = new JLabel("InvoiceID");
		lb_invoi_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_invoi_id.setBounds(20, 105, 86, 29);
		panel_1.add(lb_invoi_id);
		
		JLabel lb_product_id = new JLabel("ProductID");
		lb_product_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_product_id.setBounds(20, 150, 86, 29);
		panel_1.add(lb_product_id);
		
		JLabel lb_type = new JLabel("Type");
		lb_type.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_type.setBounds(20, 240, 86, 29);
		panel_1.add(lb_type);
		
		JLabel lb_color = new JLabel("Color");
		lb_color.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_color.setBounds(20, 285, 86, 29);
		panel_1.add(lb_color);
		
		JLabel lb_size = new JLabel("Size");
		lb_size.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_size.setBounds(20, 330, 86, 29);
		panel_1.add(lb_size);
		
		tf_invoi_id = new JTextField();
		tf_invoi_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_invoi_id.setBounds(146, 105, 165, 29);
		panel_1.add(tf_invoi_id);
		tf_invoi_id.setColumns(10);
		
		tf_product_id = new JTextField();
		tf_product_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_product_id.setColumns(10);
		tf_product_id.setBounds(146, 150, 165, 29);
		panel_1.add(tf_product_id);
		
		tf_color = new JTextField();
		tf_color.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_color.setColumns(10);
		tf_color.setBounds(146, 285, 165, 29);
		panel_1.add(tf_color);
		
		tf_size = new JTextField();
		tf_size.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_size.setColumns(10);
		tf_size.setBounds(146, 330, 165, 29);
		panel_1.add(tf_size);
		JButton bt_confirm = new JButton("Order confirmation");
		bt_confirm.addActionListener(contro);
		
		bt_confirm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt_confirm.setBounds(146, 460, 187, 42);
		panel_1.add(bt_confirm);
		
		tf_type = new JTextField();
		tf_type.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_type.setColumns(10);
		tf_type.setBounds(146, 240, 165, 29);
		panel_1.add(tf_type);
		
		JLabel lb_quantity = new JLabel("Quantity");
		lb_quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_quantity.setBounds(22, 375, 114, 29);
		panel_1.add(lb_quantity);
		
		JLabel lb_price = new JLabel("Price");
		lb_price.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_price.setBounds(20, 420, 86, 29);
		panel_1.add(lb_price);
		
		tf_quantity = new JTextField();
		tf_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_quantity.setColumns(10);
		tf_quantity.setBounds(146, 375, 165, 29);
		panel_1.add(tf_quantity);
		
		tf_price = new JTextField();
		tf_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_price.setColumns(10);
		tf_price.setBounds(146, 420, 165, 29);
		panel_1.add(tf_price);
		
		JLabel lb_bookingdate = new JLabel("Bookingdate");
		lb_bookingdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_bookingdate.setBounds(20, 60, 114, 29);
		panel_1.add(lb_bookingdate);
		
		tf_bookingdate = new JTextField();
		tf_bookingdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_bookingdate.setColumns(10);
		tf_bookingdate.setBounds(146, 60, 165, 29);
		panel_1.add(tf_bookingdate);
		
		tf_Customer = new JTextField();
		tf_Customer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Customer.setColumns(10);
		tf_Customer.setBounds(146, 15, 165, 29);
		panel_1.add(tf_Customer);
		
		JLabel lb_Customer = new JLabel("Customer");
		lb_Customer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_Customer.setBounds(22, 15, 114, 29);
		panel_1.add(lb_Customer);
		
		JLabel lb_product_id_1 = new JLabel("Product Name");
		lb_product_id_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_product_id_1.setBounds(20, 195, 114, 29);
		panel_1.add(lb_product_id_1);
		
		tf_product_name = new JTextField();
		tf_product_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_product_name.setColumns(10);
		tf_product_name.setBounds(146, 195, 165, 29);
		panel_1.add(tf_product_name);
		
		JLabel lblNewLabel_1 = new JLabel("Invoice");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 27));
		lblNewLabel_1.setBounds(468, 7, 142, 34);
		panel.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Customer", "Bookingdate", "Productid", "Productname", "Type", "Color", "Size", "Quantity", "Price"
			}
		));
		table_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Lấy chỉ số hàng được chọn
		        int row = table_1.getSelectedRow();
		        // Lấy dữ liệu từ bảng tại hàng đã chọn
		        String customer = table_1.getValueAt(row, 1).toString();
		        String bookingDate = table_1.getValueAt(row, 2).toString();
		        String productId = table_1.getValueAt(row, 3).toString();
		        String productName = table_1.getValueAt(row, 4).toString();
		        String type = table_1.getValueAt(row, 5).toString();
		        String color = table_1.getValueAt(row, 6).toString();
		        String size = table_1.getValueAt(row, 7).toString();
		        String quantity = table_1.getValueAt(row, 8).toString();
		        String price = table_1.getValueAt(row, 9).toString();
		        // Đưa dữ liệu vào các trường nhập tương ứng
		        tf_Customer.setText(customer);
		        tf_bookingdate.setText(bookingDate);
		        tf_product_id.setText(productId);
		        tf_product_name.setText(productName);
		        tf_type.setText(type);
		        tf_color.setText(color);
		        tf_size.setText(size);
		        tf_quantity.setText(quantity);
		        tf_price.setText(price);
		    }
		});

		table_1.setBounds(0, 0, 1, 1);
		panel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(363, 86, 893, 200);
		panel.add(scrollPane);
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Invoiceid", "Customer", "Bookingdate", "Productid", "Productname", "Type", "Color", "Size", "Quantity", "Price"
			}
		));
		JScrollPane scrollPane_1 = new JScrollPane(table_2);
		scrollPane_1.setBounds(363, 340, 893, 200);
		panel.add(scrollPane_1);
		
		JLabel lblConfirmed = new JLabel("Confirmed");
		lblConfirmed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblConfirmed.setBounds(363, 307, 200, 25);
		panel.add(lblConfirmed);
		
		JLabel lblWaitForConfirmation = new JLabel("Wait for confirmation");
		lblWaitForConfirmation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblWaitForConfirmation.setBounds(363, 51, 200, 25);
		panel.add(lblWaitForConfirmation);
		load_data_invoiceconfirm();
		load_data();
	}
	public void updateTable(ModelInvoice receivedInvoice) {
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.addRow(new Object[]{
            // Sắp xếp dữ liệu để phù hợp với cột trong bảng
            model.getRowCount() + 1,
            receivedInvoice.getCustomer(),
            receivedInvoice.getBookingdate(),
            receivedInvoice.getProductid(),
            receivedInvoice.getProductname(),
            receivedInvoice.getType(),
            receivedInvoice.getColor(),
            receivedInvoice.getSize(),
            receivedInvoice.getQuantity(),
            receivedInvoice.getPrice()
        });
    }
	public void load_data() {
	    try {
	        daoInvoice dao = new daoInvoice();
	        List<ModelInvoice> invoices = dao.getAllInvoicewait(); // Đổi tên biến thành `invoices`
	        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng trước khi tải dữ liệu mới
	        int rowCount = 1; // Số dòng trong bảng

	        for (ModelInvoice invoice : invoices) {
	            // Thêm dòng mới vào bảng
	            model.addRow(new Object[]{
	                rowCount++, // Số thứ tự
	                invoice.getCustomer(),
	                invoice.getBookingdate(),
	                invoice.getProductid(),
	                invoice.getProductname(),
	                invoice.getType(),
	                invoice.getColor(),
	                invoice.getSize(),
	                invoice.getQuantity(),
	                invoice.getPrice()
	            });
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Failed to load invoice data from database.");
	    }
	}
	
	public void addinvoiceconfirm() {
		if (tf_Customer.getText().isEmpty() || tf_bookingdate.getText().isEmpty()
				|| tf_invoi_id.getText().isEmpty() ||tf_product_id.getText().isEmpty()
				||tf_product_name.getText().isEmpty()  || tf_type.getText().isEmpty()
				|| tf_color.getText().isEmpty() || tf_size.getText().isEmpty()
				|| tf_quantity.getText().isEmpty() || tf_price.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			return;
		}

		// Lấy dữ liệu từ các trường nhập liệu trên giao diện
		String Customer = tf_Customer.getText();
		String Bookingdate = tf_bookingdate.getText();
		String Invoiceid = tf_invoi_id.getText();
		String Productid = tf_product_id.getText();
		String Productname = tf_product_name.getText();
		String Type =tf_type.getText();
		String Color = tf_color.getText();
		String Size = tf_size.getText();
		int Quantity = Integer.parseInt(tf_quantity.getText());
		double Price = Double.parseDouble(tf_price.getText());
		// Tạo đối tượng ModelEmployeeManager từ dữ liệu thu thập được
		ModelInvoiceConfirm invoiceconfirm = new  ModelInvoiceConfirm(Customer, Bookingdate, Invoiceid, Productid, Productname, Type, Color, Size, Quantity, Price);

		daoInvoice dao = new daoInvoice();
		dao.add_invoiceconfirm(invoiceconfirm);
		
		// Cập nhật bảng hiển thị trên giao diện
		DefaultTableModel model = (DefaultTableModel) table_2.getModel();	
		Object[] row = {Invoiceid, Customer, Bookingdate, Productid, Productname, Type, Color, Size, Quantity, Price};
	    model.addRow(row);
	    DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
	    int selectedRow = table_1.getSelectedRow();
	    if (selectedRow != -1) { // Kiểm tra hàng được chọn
		    // Lấy dữ liệu từ hàng được chọn trên giao diện
		    String customer = model1.getValueAt(selectedRow, 1).toString(); // Lấy Customer từ hàng được chọn
		    daoInvoice dao2 = new daoInvoice();
		    dao2.deleteInvoiceWaitConfirm(customer); // Truyền Customer vào phương thức để xóa dữ liệu

		    model1.removeRow(selectedRow); // Xóa hàng được chọn từ bảng "Wait for confirmation"
		}
		// Làm mới các trường nhập liệu
		tf_Customer.setText("");
		tf_bookingdate.setText("");	
		tf_invoi_id.setText("");
		tf_product_id.setText("");
		tf_product_id.setText("");
		tf_product_name.setText("");
		tf_type.setText("");
		tf_color.setText("");
		tf_size.setText("");
		tf_quantity.setText("");
		tf_price.setText("");
		
	} 
	public void load_data_invoiceconfirm() {
		try {
			daoInvoice dao = new daoInvoice();
			List<ModelInvoiceConfirm> invoiceconfirm = dao.getAllInvoiceConfirm();
			DefaultTableModel model = (DefaultTableModel) table_2.getModel();
			for (ModelInvoiceConfirm modelinvoice : invoiceconfirm) {
				model.addRow(new Object[] { modelinvoice.getInvoiceid(),modelinvoice.getCustomer(), modelinvoice.getBookingdate(),
						modelinvoice.getProductid(),modelinvoice.getProductname(),
						modelinvoice.getType(), modelinvoice.getColor(), modelinvoice.getSize(),
						modelinvoice.getQuantity(), modelinvoice.getPrice(),

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load clothes data from database.");
		}
	}
}