package javafinalgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class UserDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserDashboard frame = new UserDashboard();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UserDashboard(String name,String level) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome "+name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(193, 30, 390, 49);
		contentPane.add(lblNewLabel);
		
		JButton playbutton = new JButton("Play Quiz");
		playbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "A total of 5 questions will be asked. If you leave in middle your progress won't be saved","Warning",JOptionPane.WARNING_MESSAGE);
				PlayGamePage pg=new PlayGamePage(name,level);
				pg.setVisible(true);
			}
		});
		playbutton.setBackground(new Color(0, 128, 0));
		playbutton.setFont(new Font("Source Code Pro", Font.BOLD, 30));
		playbutton.setBounds(257, 212, 249, 101);
		contentPane.add(playbutton);
		
		JButton btnShowLeaderboard = new JButton("Show leaderboard");
		btnShowLeaderboard.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShowLeaderboard.setBackground(new Color(255, 128, 64));
		btnShowLeaderboard.setBounds(271, 393, 202, 40);
		contentPane.add(btnShowLeaderboard);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(contentPane, "Are you sure?","Logout",JOptionPane.YES_NO_OPTION);
				if(response==JOptionPane.YES_OPTION) {
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnLogout);
					currentFrame.setVisible(false); // Hide current frame
					Main main=new Main();
					main.setVisible(true);					
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(611, 82, 119, 40);
		contentPane.add(btnLogout);
		
		JButton btnNewButton = new JButton("Your details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUserDetailsDialog(name,level);
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(33, 112, 154, 30);
		contentPane.add(btnNewButton);
	}
	
	private void showUserDetailsDialog(String name, String level) {
	    JDialog dialog = new JDialog(this, "Details for " + name, true);
	    dialog.setSize(600, 200); 
	    dialog.getContentPane().setLayout(new BorderLayout()); 

	    
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("ID");
	    model.addColumn("Name");
	    model.addColumn("Level");
	    model.addColumn("Sports");
	    model.addColumn("History");
	    model.addColumn("Java");

	    JTable table = new JTable(model);
	    JScrollPane detailTable = new JScrollPane(table); 

	    Competitor.showuserdetails(model, name, level);

	    dialog.getContentPane().add(detailTable, BorderLayout.CENTER);

	    dialog.setLocationRelativeTo(this);
	    dialog.setVisible(true);
	}

}
