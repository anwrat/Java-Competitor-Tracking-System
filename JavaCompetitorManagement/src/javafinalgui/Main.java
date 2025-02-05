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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Competitor Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(198, 32, 370, 78);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login/Register");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(260, 159, 204, 31);
		contentPane.add(btnNewButton);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnAdminLogin);
		        currentFrame.setVisible(false); // Hide current frame
				Admin a=new Admin();
				a.setVisible(true);
			}
		});
		btnAdminLogin.setBackground(new Color(255, 0, 0));
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdminLogin.setBounds(260, 237, 204, 31);
		contentPane.add(btnAdminLogin);
	}
}
