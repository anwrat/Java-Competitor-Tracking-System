package javafinalgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(257, 31, 198, 34);
		contentPane.add(lblNewLabel);
		
		JButton Logout = new JButton("LogOut");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(contentPane, "Are you sure?","Logout",JOptionPane.YES_NO_OPTION);
				if(response==JOptionPane.YES_OPTION) {
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Logout);
					currentFrame.setVisible(false); // Hide current frame
					Main main=new Main();
					main.setVisible(true);					
				}
			}
		});
		Logout.setBackground(new Color(255, 0, 0));
		Logout.setFont(new Font("Tahoma", Font.BOLD, 15));
		Logout.setBounds(589, 33, 107, 34);
		contentPane.add(Logout);
		
		JButton btnAddQuestions = new JButton("Add Questions");
		btnAddQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddQuestions.setBackground(new Color(0, 128, 0));
		btnAddQuestions.setBounds(52, 161, 156, 34);
		contentPane.add(btnAddQuestions);
		
		JButton btnDeleteQuestions = new JButton("Delete Questions");
		btnDeleteQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteQuestions.setBackground(new Color(0, 128, 0));
		btnDeleteQuestions.setBounds(267, 161, 188, 34);
		contentPane.add(btnDeleteQuestions);
		
		JButton btnUpdateQuestions = new JButton("Update Questions");
		btnUpdateQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateQuestions.setBackground(new Color(0, 128, 0));
		btnUpdateQuestions.setBounds(508, 161, 188, 34);
		contentPane.add(btnUpdateQuestions);
	}

}
