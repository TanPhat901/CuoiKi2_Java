package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.ModelClothes;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.Box;

public class Clothes extends JFrame {

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
					Clothes frame = new Clothes();
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
	public Clothes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(281, 70, 1002, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(192, 192, 192));
		panel_table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_table.setBounds(46, 92, 894, 418);
		contentPane.add(panel_table);
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Clothesid");
		dm.addColumn("Clothesname");
		dm.addColumn("Type");
		dm.addColumn("Color");
		dm.addColumn("Size");
		dm.addColumn("Quantity");
		dm.addColumn("Price");

		table = new JTable(dm);
		panel_table.setLayout(null);
		JScrollPane js = new JScrollPane(table);
		js.setViewportBorder(new LineBorder(new Color(0, 51, 153), 1, true));

		js.setBounds(10, 10, 874, 398);
		panel_table.add(js);
		JLabel lblNewLabel = new JLabel("List of clothes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(46, 40, 237, 26);
		lblNewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblNewLabel.setForeground(Color.RED); // Đổi màu chữ khi di chuột qua
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblNewLabel.setForeground(Color.BLACK); // Khôi phục màu chữ khi di chuột ra khỏi nhãn
			}
		});
		contentPane.add(lblNewLabel);
	}

	public static void updateTable(List<ModelClothes> clothesList) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
		for (ModelClothes clothes : clothesList) {
			model.addRow(new Object[] { clothes.getClothesid(), clothes.getClothesname(), clothes.getType(),
					clothes.getColor(), clothes.getSize(), clothes.getQuantity(), clothes.getPrice() });
		}
	}

	public static void clearTablec() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trên bảng
	}
}
