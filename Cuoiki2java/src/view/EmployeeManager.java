package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControEmployeeManager;
import dao.daoEmployeeManager;
import dao.daoProductManager;
import model.ModelClothes;
import model.ModelEmployeeManager;
import model.ModelHandBag;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;

public class EmployeeManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_em_id;
	private JTextField tf_em_name;
	private JTextField tf_em_date;
	private JTextField tf_em_address;
	private JTextField tf_em_phone;
	private JTextField tf_em_email;
	private JTextField tf_em_salary;
	private AbstractButton rdbtnNewRadioButton;
	private JComboBox cb_position;
	private DefaultTableModel dm;
	private JTable table;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManager frame = new EmployeeManager();
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
	public EmployeeManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1266, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ControEmployeeManager controller = new ControEmployeeManager(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 1252, 523);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 322, 513);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Employeeid");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 28, 92, 23);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Employee name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(21, 61, 127, 23);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(21, 94, 92, 23);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Position");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(21, 127, 92, 23);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Date of birth");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(21, 160, 127, 23);
		panel_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Address");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(21, 193, 92, 23);
		panel_1.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Email");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(21, 259, 92, 23);
		panel_1.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("Phone number");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(21, 226, 127, 23);
		panel_1.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8 = new JLabel("Salary");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(21, 292, 92, 23);
		panel_1.add(lblNewLabel_1_8);

		tf_em_id = new JTextField();
		tf_em_id.setBounds(173, 30, 139, 23);
		panel_1.add(tf_em_id);
		tf_em_id.setColumns(10);

		tf_em_name = new JTextField();
		tf_em_name.setColumns(10);
		tf_em_name.setBounds(173, 61, 139, 23);
		panel_1.add(tf_em_name);

		tf_em_date = new JTextField();
		tf_em_date.setColumns(10);
		tf_em_date.setBounds(173, 164, 139, 23);
		panel_1.add(tf_em_date);

		tf_em_address = new JTextField();
		tf_em_address.setColumns(10);
		tf_em_address.setBounds(173, 197, 139, 23);
		panel_1.add(tf_em_address);

		tf_em_phone = new JTextField();
		tf_em_phone.setColumns(10);
		tf_em_phone.setBounds(173, 230, 139, 23);
		panel_1.add(tf_em_phone);

		tf_em_email = new JTextField();
		tf_em_email.setColumns(10);
		tf_em_email.setBounds(173, 263, 139, 23);
		panel_1.add(tf_em_email);

		tf_em_salary = new JTextField();
		tf_em_salary.setColumns(10);
		tf_em_salary.setBounds(173, 296, 139, 23);
		panel_1.add(tf_em_salary);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(21, 372, 277, 112);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.addActionListener(controller);
		btnAdd.setBounds(23, 22, 85, 21);
		panel_3.add(btnAdd);

		JButton btnRepair = new JButton("Repair");
		btnRepair.addActionListener(controller);
		btnRepair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRepair.setBounds(155, 22, 85, 21);
		panel_3.add(btnRepair);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(controller);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(23, 70, 85, 21);
		panel_3.add(btnDelete);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(controller);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(155, 70, 85, 21);
		panel_3.add(btnSearch);

		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(173, 97, 58, 21);
		panel_1.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(246, 97, 66, 21);
		panel_1.add(rdbtnNewRadioButton_1);

		cb_position = new JComboBox();
		cb_position.setModel(new DefaultComboBoxModel(new String[] { "Seller", "Manager", "Guard" }));
		cb_position.setBounds(173, 127, 139, 23);
		panel_1.add(cb_position);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(330, 52, 912, 461);
		panel.add(panel_2);
		dm = new DefaultTableModel();
		dm.addColumn("Employeeid");
		dm.addColumn("Employeename");
		dm.addColumn("Gender");
		dm.addColumn("Position");
		dm.addColumn("Date");
		dm.addColumn("Address");
		dm.addColumn("Email");
		dm.addColumn("Phone");
		dm.addColumn("Salary");
		table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy chỉ số hàng được chọn
				int selectedRow = table.getSelectedRow();
				// Kiểm tra nếu người dùng đã chọn một hàng hợp lệ
				if (selectedRow != -1) {
					// Lấy dữ liệu từ hàng được chọn và hiển thị trên các trường nhập
					int Employeeid = (int) dm.getValueAt(selectedRow, 0);
					String Employeename = (String) dm.getValueAt(selectedRow, 1);
					String Gender = (String) dm.getValueAt(selectedRow, 2);
					String Position = (String) dm.getValueAt(selectedRow, 3);
					String Date = (String) dm.getValueAt(selectedRow, 4);
					String Address = (String) dm.getValueAt(selectedRow, 5);
					String Email = (String) dm.getValueAt(selectedRow, 6);
					String Phone = (String) dm.getValueAt(selectedRow, 7);
					double Salary = (double) dm.getValueAt(selectedRow, 8);
					// Điền dữ liệu từ hàng đã chọn vào các trường nhập liệu
					tf_em_id.setText(String.valueOf(Employeeid));
					tf_em_name.setText(Employeename);
					// Assuming rdbtnNewRadioButton represents gender radio button
					if (Gender.equals("Male")) {
						rdbtnNewRadioButton.setSelected(true);
					} else {
						rdbtnNewRadioButton.setSelected(false);
					}
					cb_position.setSelectedItem(Position);
					tf_em_date.setText(Date);
					tf_em_address.setText(Address);
					tf_em_email.setText(Email);
					tf_em_phone.setText(Phone);
					tf_em_salary.setText(String.valueOf(Salary));
				}
			}
		});
		panel_2.setLayout(null);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(33, 43, 847, 391);
		panel_2.add(js);

		JLabel lblNewLabel_1_9 = new JLabel("Employee Manager");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_9.setBounds(358, 10, 275, 32);
		panel.add(lblNewLabel_1_9);
		loadEmployeeData();
	}

	public void loadEmployeeData() {
		try {
			daoEmployeeManager dao = new daoEmployeeManager();
			List<ModelEmployeeManager> employees = dao.getAllEmployees();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (ModelEmployeeManager employee : employees) {
				model.addRow(new Object[] { employee.getEmployeeid(), employee.getEmployeename(), employee.getGender(),
						employee.getPosition(), employee.getDate(), employee.getAddress(), employee.getEmail(),
						employee.getPhone(), employee.getSalary() });
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Failed to load employee data from database.");
		}
	}

	public void addEmployee() {
		if (tf_em_id.getText().isEmpty() || tf_em_name.getText().isEmpty()
				|| (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected())
				|| cb_position.getSelectedItem() == null || tf_em_date.getText().isEmpty()
				|| tf_em_address.getText().isEmpty() || tf_em_email.getText().isEmpty()
				|| tf_em_phone.getText().isEmpty() || tf_em_salary.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			return;
		}

		// Lấy dữ liệu từ các trường nhập liệu trên giao diện
		int Employeeid = Integer.parseInt(tf_em_id.getText());
		String Employeename = tf_em_name.getText();
		String Gender = rdbtnNewRadioButton.isSelected() ? "Male" : "Female";
		String Position = (String) cb_position.getSelectedItem();
		String Date = tf_em_date.getText();
		String Address = tf_em_address.getText();
		String Email = tf_em_email.getText();
		String Phone = tf_em_phone.getText();
		double Salary = Double.parseDouble(tf_em_salary.getText());
		// Tạo đối tượng ModelEmployeeManager từ dữ liệu thu thập được
		ModelEmployeeManager newEmployee = new ModelEmployeeManager(Employeeid, Employeename, Gender, Position, Date,
				Address, Email, Phone, Salary);

		// Gọi phương thức addEmployee của đối tượng DaoEmployeeManager để thêm nhân
		// viên vào cơ sở dữ liệu
		daoEmployeeManager dao = new daoEmployeeManager();
		dao.add_data_employee(newEmployee);

		// Cập nhật bảng hiển thị trên giao diện
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.addRow(
				new Object[] { Employeeid, Employeename, Gender, Position, Date, Address, Email, Phone, Salary });
		table.setModel(tableModel);

		// Làm mới các trường nhập liệu
		tf_em_id.setText("");
		tf_em_name.setText("");
		rdbtnNewRadioButton.setSelected(false);
		cb_position.setSelectedItem(null);
		tf_em_date.setText("");
		tf_em_address.setText("");
		tf_em_email.setText("");
		tf_em_phone.setText("");
		tf_em_salary.setText("");
	}

	public void deleteemployee() {
		int selectRow = table.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Please select a line to delete");
		}
		int[] selectedRows = table.getSelectedRows();
		daoEmployeeManager dao = new daoEmployeeManager();

		List<Integer> rowDeXoa = new ArrayList<Integer>();
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int selectedRow = table.convertRowIndexToModel(selectedRows[i]);
			rowDeXoa.add(selectedRow);
		}
		for (int row : rowDeXoa) {
			int Employeeid = Integer.parseInt(table.getValueAt(row, 0).toString());
			String Employeename = table.getValueAt(row, 1).toString();
			String Gender = table.getValueAt(row, 2).toString();
			String Position = table.getValueAt(row, 3).toString();
			String Date = table.getValueAt(row, 4).toString();
			String Address = table.getValueAt(row, 5).toString();
			String Email = table.getValueAt(row, 6).toString();
			String Phone = table.getValueAt(row, 7).toString();
			double Salary = Double.parseDouble(table.getValueAt(row, 8).toString());
			ModelEmployeeManager model = new ModelEmployeeManager(Employeeid, Employeename, Gender, Position, Date,
					Address, Email, Phone, Salary);
			dao.delete_data_employee(model);
			dm.removeRow(row);
		}
	}

	public void repairemployee() {
		try {
			DefaultTableModel dm = (DefaultTableModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "Please select a row to update.");
				return;
			}

			int Employeeid = (int) dm.getValueAt(selectedRow, 0);

			String Employeename = tf_em_name.getText();
			String Gender = rdbtnNewRadioButton.isSelected() ? "Male" : "Female";
			String Position = (String) cb_position.getSelectedItem();
			String Date = tf_em_date.getText();
			String Address = tf_em_address.getText();
			String Email = tf_em_email.getText();
			String Phone = tf_em_phone.getText();
			double Salary = Double.parseDouble(tf_em_salary.getText());

			ModelEmployeeManager model = new ModelEmployeeManager(Employeeid, Employeename, Gender, Position, Date,
					Address, Email, Phone, Salary);

			daoEmployeeManager dao = new daoEmployeeManager();
			dao.update_data_employee(model);

			// Update the table model with the new data
			dm.setValueAt(Employeename, selectedRow, 1);
			dm.setValueAt(Gender, selectedRow, 2);
			dm.setValueAt(Position, selectedRow, 3);
			dm.setValueAt(Date, selectedRow, 4);
			dm.setValueAt(Address, selectedRow, 5);
			dm.setValueAt(Email, selectedRow, 6);
			dm.setValueAt(Phone, selectedRow, 7);
			dm.setValueAt(Salary, selectedRow, 8);

			JOptionPane.showMessageDialog(this, "Employee updated successfully!");
		} catch (NumberFormatException e) {
			// Handle the case where salary or other numeric fields are not valid numbers
			JOptionPane.showMessageDialog(this, "Please enter a valid salary.");
		}

		// Reset input fields
		tf_em_id.setText("");
		tf_em_name.setText("");
		rdbtnNewRadioButton.setSelected(false);
		cb_position.setSelectedItem(null);
		tf_em_date.setText("");
		tf_em_address.setText("");
		tf_em_email.setText("");
		tf_em_phone.setText("");
		tf_em_salary.setText("");
	}

	public void searchemployee() {
		String employeeIdText = tf_em_id.getText().trim();
		String employeeName = tf_em_name.getText().trim(); // Giả sử có một trường văn bản cho tên

		// Kiểm tra xem cả hai trường đều rỗng
		if (employeeIdText.isEmpty() && employeeName.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Vui lòng nhập thông tin để tìm kiếm (mã nhân viên hoặc tên nhân viên).");
			return;
		}

		Integer Employeeid = null;
		if (!employeeIdText.isEmpty()) {
			try {
				Employeeid = Integer.parseInt(employeeIdText);
			} catch (NumberFormatException e) {
				// Xử lý trường hợp mã nhân viên không hợp lệ
				JOptionPane.showMessageDialog(null, "Mã nhân viên không hợp lệ");
				return;
			}
		}
		daoEmployeeManager dao = new daoEmployeeManager();
		ArrayList<ModelEmployeeManager> list = dao.SearchEmployee(Employeeid, employeeName);
		dm.setRowCount(0);
		for (ModelEmployeeManager model : list) {
			dm.addRow(new Object[] { model.getEmployeeid(), model.getEmployeename(), model.getGender(),
					model.getPosition(), model.getDate(), model.getAddress(), model.getEmail(), model.getPhone(),
					model.getSalary() });
		}
	}
}
