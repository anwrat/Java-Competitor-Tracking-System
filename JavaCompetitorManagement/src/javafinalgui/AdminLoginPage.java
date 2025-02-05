package javafinalgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage frame = new AdminLoginPage();
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
	public AdminLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(282, 33, 147, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(90, 149, 92, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(90, 218, 92, 22);
		contentPane.add(lblNewLabel_1_1);
		
		Name = new JTextField();
		Name.setBounds(211, 149, 192, 24);
		contentPane.add(Name);
		Name.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(211, 218, 192, 24);
		contentPane.add(password);
		
		JButton Login = new JButton("LogIn");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=Name.getText();
				String pass = new String(password.getPassword());//getpassword returns char array so converting to String
				AdminLogin a=new AdminLogin();
				if(a.login(name, pass)) {
					JOptionPane.showMessageDialog(contentPane, "Login Successful","Success",JOptionPane.INFORMATION_MESSAGE);//contentPane parameters centers dialog box w.r.t the contentPane
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Login);
			        currentFrame.setVisible(false); // Hide current frame
			        AdminDashboard ad=new AdminDashboard();
			        ad.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Invalid Details","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Login.setFont(new Font("Tahoma", Font.BOLD, 15));
		Login.setBackground(new Color(0, 128, 0));
		Login.setBounds(266, 311, 89, 23);
		contentPane.add(Login);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(BackButton);
		        currentFrame.setVisible(false); // Hide current frame
		        Main main=new Main();
		        main.setVisible(true);
			}
		});
		BackButton.setBackground(new Color(255, 0, 0));
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		BackButton.setBounds(23, 33, 89, 23);
		contentPane.add(BackButton);
	}
}
