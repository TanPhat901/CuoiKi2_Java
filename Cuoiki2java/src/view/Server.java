package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import model.ModelClothes;
import model.ModelHandBag;
import model.ModelInvoice;
import model.ModelShoe;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Server extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ServerSocket serverSocket;
    private Invoice invoice;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private volatile boolean isRunning = true;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Server frame = new Server();
                    frame.setVisible(true);
                    frame.startServerInBackground();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Server() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1281, 664);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 255)));
        panel.setBounds(0, 1, 1267, 61);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Manager");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setBounds(27, 10, 133, 41);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("Product Manager");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.setBounds(373, 12, 174, 41);
        panel.add(btnNewButton);

        JButton btnEmployeeManagement = new JButton("Employee Manager");
        btnEmployeeManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnEmployeeManagement.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnEmployeeManagement.setBounds(579, 12, 196, 41);
        panel.add(btnEmployeeManagement);

        JButton btnOrderManagement = new JButton("Order Manager");
        btnOrderManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnOrderManagement.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnOrderManagement.setBounds(810, 12, 174, 41);
        panel.add(btnOrderManagement);

        JButton btnStatistical = new JButton("Statistical");
        btnStatistical.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnStatistical.setBounds(1018, 12, 174, 41);
        panel.add(btnStatistical);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 255)));
        panel_1.setBounds(1, 67, 1266, 560);
        contentPane.add(panel_1);
        panel_1.setLayout(new CardLayout(0, 0));
        ProductManager promanager = new ProductManager(); 
        panel_1.add(promanager.getContentPane(), "ProductManager"); 

        EmployeeManager employeemanager = new EmployeeManager();
        panel_1.add(employeemanager.getContentPane(), "EmployeeManager");
        Invoice invoice = new Invoice(); 
        this.invoice = invoice;
        panel_1.add(invoice.getContentPane(), "Invoice");

        Statistical statistical = new Statistical();
        panel_1.add(statistical.getContentPane(), "Statistical");

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cl = (CardLayout) panel_1.getLayout();
                cl.show(panel_1, "ProductManager"); 
            }
        });
        btnEmployeeManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cl = (CardLayout) panel_1.getLayout();
                cl.show(panel_1, "EmployeeManager");
            }
        });
        btnOrderManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cl = (CardLayout) panel_1.getLayout();
                cl.show(panel_1, "Invoice");
            }
        });
        btnStatistical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cl = (CardLayout) panel_1.getLayout();
                cl.show(panel_1, "Statistical");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stopServer();
                System.exit(0); 
            }
        });
    }

    public void startServerInBackground() {
        new Thread(this::startServer).start();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started...");
            while (isRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    executorService.submit(() -> handleClient(clientSocket));
                } catch (SocketException e) {
                    if (!isRunning) {
                        System.out.println("Server socket closed.");
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
            sendDataToClient(out);
            while (true) {
                Object receivedData = in.readObject();
                if (receivedData == null) {
                    // Kết thúc vòng lặp nếu không còn dữ liệu từ client
                    break;
                }
                if (receivedData instanceof ModelInvoice) {
                    ModelInvoice receivedInvoice = (ModelInvoice) receivedData;
                    saveInvoiceToDatabase(receivedInvoice); 
                    SwingUtilities.invokeLater(() -> {
                        invoice.updateTable(receivedInvoice);
                    });
                } else if (receivedData instanceof String) {
                    String message = (String) receivedData;
                    if (message.equals("UPDATE_REQUEST")) {
                        sendDataToClient(out);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendDataToClient(ObjectOutputStream out) {
        try {
            ProductManager productManager = new ProductManager();
            List<ModelClothes> clothesList = productManager.getProductData();
            List<ModelShoe> shoeList = productManager.getProductDatashoe();
            List<ModelHandBag> handbagList = productManager.getProductDatahandbag();
            out.writeObject(clothesList);
            out.writeObject(shoeList);
            out.writeObject(handbagList);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopServer() {
    	isRunning = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private void saveInvoiceToDatabase(ModelInvoice invoice) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managershop", "root", "123456")) {
            String query = "INSERT INTO invoice (Customer, Bookingdate, Productid, Productname, Type, Color, Size, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, invoice.getCustomer());
            statement.setString(2, invoice.getBookingdate());
            statement.setString(3, invoice.getProductid());
            statement.setString(4, invoice.getProductname());
            statement.setString(5, invoice.getType());
            statement.setString(6, invoice.getColor());
            statement.setString(7, invoice.getSize());
            statement.setInt(8, invoice.getQuantity());
            statement.setDouble(9, invoice.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
