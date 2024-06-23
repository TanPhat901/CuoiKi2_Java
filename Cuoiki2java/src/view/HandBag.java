package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.ModelClothes;
import model.ModelHandBag;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class HandBag extends JFrame {

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
					HandBag frame = new HandBag();
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
	public HandBag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(192, 192, 192));
		panel_table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_table.setBounds(46, 92, 908, 418);
		contentPane.add(panel_table);
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("HandBagid");
		dm.addColumn("HandBagname");
		dm.addColumn("Type");
		dm.addColumn("Color");
		dm.addColumn("Size");
		dm.addColumn("Quantity");
		dm.addColumn("Price");
		
		
		table = new JTable(dm);
		panel_table.setLayout(null);
		JScrollPane js = new JScrollPane(table);
		js.setViewportBorder(new LineBorder(new Color(0, 0, 128)));
		
		js.setBounds(10, 10, 888, 398);
		panel_table.add(js);
		JLabel lblNewLabel = new JLabel("List of Hand Bag");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(60, 22, 290, 44);
		contentPane.add(lblNewLabel);
	}

	public static void updateTable(List<ModelHandBag> handbagList) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
		for (ModelHandBag handbag : handbagList) {
			model.addRow(new Object[] { handbag.getHandBagid(), handbag.getHandBagname(), handbag.getType(),
					handbag.getColor(), handbag.getSize(), handbag.getQuantity(), handbag.getPrice() });
		}
	}

	public static void clearTableh() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trên bảng
	}
}
