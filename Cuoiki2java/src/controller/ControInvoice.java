package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Invoice;



public class ControInvoice implements ActionListener {
	private Invoice invoice;
	public ControInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button2 =e.getActionCommand();
		if(button2.equals("Order confirmation")) {
			this.invoice.addinvoiceconfirm();
		}
}
}
