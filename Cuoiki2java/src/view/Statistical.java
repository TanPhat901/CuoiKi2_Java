package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.JDBC;
import model.ModelInvoiceConfirm;

public class Statistical extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblNewLabel_2;
	private JButton clearSearchButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistical frame = new Statistical();
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
	public Statistical() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1266, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Revenue statistics");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 27));
		lblNewLabel.setBounds(436, 10, 287, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search by date");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(44, 60, 162, 19);
		panel.add(lblNewLabel_1);
		
		clearSearchButton = new JButton("Clear Search");
		clearSearchButton.addActionListener(e -> clearSearchResults());
		clearSearchButton.setBounds(404, 89, 120, 25);
		panel.add(clearSearchButton);

		textField = new JTextField();
		textField.setBounds(44, 89, 162, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		 btnNewButton.addActionListener(e -> {
	            String date = textField.getText();
	            searchByDate(date);
	        });
		btnNewButton.setBounds(290, 89, 102, 25);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Invoiceid", "Bookingdate", "Intomoney"
			}
		));
		table.setBounds(0, 0, 1, 1);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 147, 1246, 296);
		panel.add(scrollPane);
		
		lblNewLabel_2 = new JLabel("Total revenue: 0 VND");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 484, 350, 43);
		panel.add(lblNewLabel_2);
		fetchInvoiceData() ;
		updateTable();
	
	}
	  private Vector<Vector<Object>> fetchInvoiceData() {
	        Vector<Vector<Object>> data = new Vector<>();

	        try (Connection connection = JDBC.getConnection();
	             Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT Invoiceid, Bookingdate, Price FROM invoiceconfirm")) {

	            while (rs.next()) {
	                Vector<Object> row = new Vector<>();
	                row.add(rs.getString("Invoiceid"));
	                row.add(rs.getString("Bookingdate"));
	                row.add(rs.getDouble("Price"));
	                data.add(row);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return data;
	    }

	    public void updateTable() {
	        Vector<Vector<Object>> data = fetchInvoiceData();
	        Vector<String> columnNames = new Vector<>();
	        columnNames.add("Invoiceid");
	        columnNames.add("Bookingdate");
	        columnNames.add("Price");
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        table.setModel(model);
	        calculateTotalRevenue();
	    }
	  
	    private void calculateTotalRevenue() {
	        DecimalFormat formatter = new DecimalFormat("###,###,###");
	        double totalRevenue = 0;
	        for (int i = 0; i < table.getRowCount(); i++) {
	            totalRevenue += Double.parseDouble(table.getValueAt(i, 2).toString());
	        }
	        lblNewLabel_2.setText("Total revenue: " + formatter.format(totalRevenue) + " VND");
	    }
	    private void searchByDate(String date) {
	        Vector<Vector<Object>> data = new Vector<>();
	        
	        try (Connection connection = JDBC.getConnection();
	             Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT Invoiceid, Bookingdate, Price FROM invoiceconfirm WHERE Bookingdate = '" + date + "'")) {
	        	
	        	while (rs.next()) {
	        		Vector<Object> row = new Vector<>();
	                row.add(rs.getString("Invoiceid"));
	                row.add(rs.getString("Bookingdate"));
	                row.add(rs.getDouble("Price"));
	                data.add(row);
	        	}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
	        for (Vector<Object> rowData : data) {
	            model.addRow(rowData);
	        }

	        calculateTotalRevenue();
	    }
	    private void clearSearchResults() {
	        textField.setText(""); 
	        fetchInvoiceData(); 
	        updateTable(); 
	    }
	    public void addRowToTable(ModelInvoiceConfirm invoice) {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        Object[] rowData = {
	            invoice.getInvoiceid(),
	            invoice.getBookingdate(),
	            invoice.getPrice()
	        };
	        model.addRow(rowData);
	        calculateTotalRevenue();
	    }


	
}