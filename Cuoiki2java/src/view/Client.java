package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.ModelClothes;
import model.ModelHandBag;
import model.ModelInvoice;
import model.ModelShoe;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static Socket socket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
	
	 private volatile boolean keepRunning = true; 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client frame = new Client();
                    frame.setVisible(true);
                    frame.startClientInBackground();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Client() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1281, 664);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_top = new JPanel();
        panel_top.setBackground(new Color(175, 238, 238));
        panel_top.setBounds(0, 0, 1267, 71);
        contentPane.add(panel_top);
        panel_top.setLayout(null);

        JLabel lblNewLabel = new JLabel("PRODUCT INFORMATION");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(34, 10,300, 51);
        panel_top.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 255, 255));
        panel_1.setBounds(0, 70, 281, 557);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnHome = new JButton("HOME");
        btnHome.setBorder(new LineBorder(Color.white, 2)); 
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome.setForeground(Color.white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome.setForeground(Color.BLACK); 
            }
        });
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnHome.setBackground(Color.CYAN);
        btnHome.setBounds(24, 32, 211, 41);
        panel_1.add(btnHome);

        JButton btnNewButton = new JButton("CLOTHES");
        btnNewButton.setBackground(new Color(0, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBorder(new LineBorder(Color.white, 2)); 
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewButton.setForeground(Color.white); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewButton.setForeground(Color.BLACK); 
            }
        });
        btnNewButton.setBounds(24, 97, 211, 41);
        panel_1.add(btnNewButton);

        JButton btnSearch = new JButton("PURCHASE");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearch.setForeground(Color.white); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearch.setForeground(Color.BLACK);
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnSearch.setBorder(new LineBorder(Color.white, 2)); 
        btnSearch.setBackground(Color.CYAN);
        btnSearch.setBounds(24, 301, 211, 41);
        panel_1.add(btnSearch);

        JButton btnHandBag = new JButton("HAND BAG");
        btnHandBag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHandBag.setForeground(Color.white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHandBag.setForeground(Color.BLACK); 
            }
        });
        btnHandBag.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnHandBag.setBackground(Color.CYAN);
        btnHandBag.setBounds(24, 164, 211, 41);
        btnHandBag.setBorder(new LineBorder(Color.white, 2));
        panel_1.add(btnHandBag);

        JButton btnShoe = new JButton("SHOE");
        btnShoe.setBorder(new LineBorder(Color.white, 2)); 
        btnShoe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnShoe.setForeground(Color.white); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnShoe.setForeground(Color.BLACK); 
            }
        });
        btnShoe.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnShoe.setBackground(Color.CYAN);
        btnShoe.setBounds(24, 233, 211, 41);
        panel_1.add(btnShoe);

        // cardlayout
        JPanel panel_cardclient = new JPanel();
        panel_cardclient.setLayout(new CardLayout());
        panel_cardclient.setBounds(281, 70, 1002, 557);

        Home home = new Home(); 
        panel_cardclient.add(home.getContentPane(), "Home"); 

        Clothes clothes = new Clothes();
        panel_cardclient.add(clothes.getContentPane(), "Clothes");
        HandBag handbag = new HandBag(); 
        panel_cardclient.add(handbag.getContentPane(), "HandBag");

        Shoe shoe = new Shoe(); 
        panel_cardclient.add(shoe.getContentPane(), "Shoe"); 

        Search search = new Search(); // Tạo instance của Search
        panel_cardclient.add(search.getContentPane(), "Search"); 
        btnHome.addActionListener(e -> {
        	CardLayout cl = (CardLayout) panel_cardclient.getLayout();
            cl.show(panel_cardclient, "Home"); 
		});
        btnNewButton.addActionListener(e -> {
        	CardLayout cl = (CardLayout) panel_cardclient.getLayout();
            cl.show(panel_cardclient, "Clothes");
        });
        btnHandBag.addActionListener(e -> {
        	CardLayout cl = (CardLayout) panel_cardclient.getLayout();
            cl.show(panel_cardclient, "HandBag");
        });
        btnShoe.addActionListener(e -> {
        	CardLayout cl = (CardLayout) panel_cardclient.getLayout();
            cl.show(panel_cardclient, "Shoe");
        });
        btnSearch.addActionListener(e -> {
        	 CardLayout cl = (CardLayout) panel_cardclient.getLayout();
             cl.show(panel_cardclient, "Search");
        });
        contentPane.add(panel_cardclient);
        initializeConnection();
        startUpdateThread();
    }

    private void startUpdateThread() {
        Thread updateThread = new Thread(() -> {
            while (keepRunning) {
                try {
                    sendUpdateRequestToServer(); 
                    Thread.sleep(20000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.start();
    }
    private void sendUpdateRequestToServer() {
        try {
            if (socket == null || socket.isClosed()) {
                initializeConnection(); 
            }
      
            out.writeObject("UPDATE_REQUEST");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error sending update request to server: " + e.getMessage());
        }
    }
    public static void initializeConnection() {
        try {
            socket = new Socket("localhost", 1234);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to connect to server. Please try again later.", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void startClientInBackground() {
        new Thread(this::receiveProductDataFromServer).start();
    }

    private void receiveProductDataFromServer() {
        try {
            while (keepRunning) {
    
                try {
                    List<ModelClothes> clothesList = (List<ModelClothes>) in.readObject();
                    List<ModelShoe> shoeList = (List<ModelShoe>) in.readObject();
                    List<ModelHandBag> handbagList = (List<ModelHandBag>) in.readObject();
                    updateUI(clothesList, shoeList, handbagList);
                } catch (SocketException e) {
                    System.out.println("Server has been shut down.");
                    handleServerShutdown();
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            handleServerShutdown();
        }
    }

    private void updateUI(List<ModelClothes> clothesList, List<ModelShoe> shoeList, List<ModelHandBag> handbagList) {
        Clothes.updateTable(clothesList);
        Shoe.updateTable(shoeList);
        HandBag.updateTable(handbagList);
        Search.updateTablecl(clothesList);
        Search.updateTablesh(shoeList);
        Search.updateTablehb(handbagList);
    }

    private void handleServerShutdown() {
        // Xóa dữ liệu trên client
        Clothes.clearTablec();
        Shoe.clearTables();
        HandBag.clearTableh();
        Search.clearTableclo();
        Search.clearTableshoe();
        Search.clearTablehbag();

        JOptionPane.showMessageDialog(this, "The server has been shut down. Data has been cleared.", "Server Shutdown", JOptionPane.WARNING_MESSAGE);
        // Đóng kết nối
        try {
        	keepRunning = false;
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendDataToServer(ModelInvoice dataclo) {
        try {
            if (socket == null || socket.isClosed()) {
                initializeConnection();
            }
            out.writeObject(dataclo);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error sending data to server: " + e.getMessage());
        }
    }

}
