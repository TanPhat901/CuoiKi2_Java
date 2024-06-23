package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.ModelHandBag;
import model.ModelShoe;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;
import java.awt.Color;

public class Shoe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shoe frame = new Shoe();
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
	public Shoe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Shoeid");
		dm.addColumn("Shoename");
		dm.addColumn("Type");
		dm.addColumn("Color");
		dm.addColumn("Size");
		dm.addColumn("Quantity");
		dm.addColumn("Price");

		table = new JTable(dm);
		JScrollPane js = new JScrollPane(table);

		js.setBounds(60, 100, 876, 380);
		contentPane.add(js);
		JLabel lblNewLabel = new JLabel("List of shoe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(60, 40, 290, 26);
		contentPane.add(lblNewLabel);
	}

	public static void updateTable(List<ModelShoe> shoeList) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
		for (ModelShoe shoe : shoeList) {
			model.addRow(new Object[] { shoe.getShoeid(), shoe.getShoename(), shoe.getType(), shoe.getColor(),
					shoe.getSize(), shoe.getQuantity(), shoe.getPrice() });
		}
	}

	public static void clearTables() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trên bảng
	}
}
