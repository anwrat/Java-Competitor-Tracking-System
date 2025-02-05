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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginPage frame = new UserLoginPage();
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
	public UserLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(300, 23, 148, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(101, 131, 73, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Difficulty");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(101, 188, 73, 19);
		contentPane.add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setBounds(216, 121, 182, 31);
		contentPane.add(name);
		name.setColumns(10);
		
		JComboBox level = new JComboBox();
		level.setFont(new Font("Tahoma", Font.BOLD, 15));
		level.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Intermediate", "Advanced"}));
		level.setBounds(216, 182, 142, 31);
		contentPane.add(level);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnNewButton);
				currentFrame.setVisible(false); // Hide current frame
				Main main=new Main();
				main.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(23, 35, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Proceed");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Please fill the fields","Empty fields",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String username=name.getText();
					String userlevel=level.getSelectedItem().toString();
					UserLogin login=new UserLogin();
					UserDashboard ud=new UserDashboard();
					if(login.login(username, userlevel)) {
						JOptionPane.showMessageDialog(contentPane, "Login Successful");
						JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnNewButton);
						currentFrame.setVisible(false); // Hide current frame
						ud.setVisible(true);
					}
					else {
						UserRegister register = new UserRegister();
						register.signup(username, userlevel);
						JOptionPane.showMessageDialog(contentPane, "Registration Successful");
						JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnNewButton);
						currentFrame.setVisible(false); // Hide current frame
						ud.setVisible(true);
					}					
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(300, 284, 120, 31);
		contentPane.add(btnNewButton_1);
	}
}
