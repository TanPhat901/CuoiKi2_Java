package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EmployeeManager;
public class ControEmployeeManager implements ActionListener{
	private EmployeeManager employeeManager;
	public ControEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button2 =e.getActionCommand();
		if(button2.equals("Add")) {
			this.employeeManager.addEmployee();
		}
		if(button2.equals("Delete")) {
			this.employeeManager.deleteemployee();
		}
		if(button2.equals("Repair")) {
			this.employeeManager.repairemployee();
		}
		if(button2.equals("Search")) {
			this.employeeManager.searchemployee();
		}
		
		
	}
	
}
