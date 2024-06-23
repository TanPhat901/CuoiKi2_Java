package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.ProductManager;

public class ControProductManager implements ActionListener {
	private ProductManager productManager;
	public ControProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button2 =e.getActionCommand();
		if(button2.equals("Addclothes")) {
			this.productManager.addclothes();
		}
		if(button2.equals("Addshoe")) {
			this.productManager.addshoe();
		}
		if(button2.equals("Addhandbag")) {
			this.productManager.addhandbag();
		}
		if(button2.equals("Deleteclothes")) {
			this.productManager.deleteclothes();
		}
		if(button2.equals("Deleteshoe")) {
			this.productManager.deleteshoe();
		}
		if(button2.equals("Deletehandbag")) {
			this.productManager.deletehandbag();
		}
		if(button2.equals("Repairclothes")) {
			this.productManager.updateclothes();
		}
		if(button2.equals("Repairshoe")) {
			this.productManager.updateshoe();
		}
		if(button2.equals("Repairhandbag")) {
			this.productManager.updatehandbag();
		}
		if(button2.equals("Resetclothes")) {
			this.productManager.resetclothes();
		}
		if(button2.equals("Resetshoe")) {
			this.productManager.resetshoe();
		}
		if(button2.equals("Resethandbag")) {
			this.productManager.resethandbag();
		}
		if(button2.equals("Searchclothes")) {
			this.productManager.searchclothes();
		}
		if(button2.equals("Searchshoe")) {
			this.productManager.searchshoe();
		}
		if(button2.equals("Searchhandbag")) {
			this.productManager.searchhandbag();
		}
	}
	
}
