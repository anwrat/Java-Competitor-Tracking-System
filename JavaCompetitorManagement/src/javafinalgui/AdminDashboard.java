package javafinalgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

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
		btnAddQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddQuestionDialog();
			}
		});
		btnAddQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddQuestions.setBackground(new Color(0, 128, 0));
		btnAddQuestions.setBounds(52, 161, 156, 34);
		contentPane.add(btnAddQuestions);
		
		JButton btnDeleteQuestions = new JButton("Delete Questions");
		btnDeleteQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDeleteQuestionDialog();
			}
		});
		btnDeleteQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteQuestions.setBackground(new Color(0, 128, 0));
		btnDeleteQuestions.setBounds(52, 220, 188, 34);
		contentPane.add(btnDeleteQuestions);
		
		JButton btnUpdateQuestions = new JButton("Update Questions");
		btnUpdateQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateQuestions.setBackground(new Color(0, 128, 0));
		btnUpdateQuestions.setBounds(52, 272, 188, 34);
		contentPane.add(btnUpdateQuestions);
		
		JButton btnShowQuestions = new JButton("Show Questions");
		btnShowQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShowQuestions.setBackground(new Color(0, 128, 0));
		btnShowQuestions.setBounds(52, 326, 188, 34);
		contentPane.add(btnShowQuestions);
		
		JButton btnShowPlayerReports = new JButton("Show Player Reports");
		btnShowPlayerReports.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShowPlayerReports.setBackground(new Color(0, 128, 0));
		btnShowPlayerReports.setBounds(299, 220, 216, 34);
		contentPane.add(btnShowPlayerReports);
	}
	 // Method to Show Add Question Popup
    private void showAddQuestionDialog() {
        JDialog dialog = new JDialog(this, "Add Question", true);
        dialog.setSize(400, 350);
        dialog.getContentPane().setLayout(new GridLayout(8, 2, 5, 5)); //new GridLayout(rows, columns, hGap, vGap)

        JLabel lblLevel = new JLabel("Level:");
        String[] levels = {"Beginner", "Intermediate", "Advanced"};
        JComboBox<String> cmbLevel = new JComboBox<>(levels);

        JLabel lblCategory = new JLabel("Category:");
        String[] categories = {"Sports", "History", "Java"};
        JComboBox<String> category = new JComboBox<>(categories);

        JLabel lblQuestion = new JLabel("Question:");
        JTextField txtQuestion = new JTextField();
        JLabel lblOption1 = new JLabel("Option 1:");
        JTextField txtOption1 = new JTextField();
        JLabel lblOption2 = new JLabel("Option 2:");
        JTextField txtOption2 = new JTextField();
        JLabel lblOption3 = new JLabel("Option 3:");
        JTextField txtOption3 = new JTextField();
        JLabel lblRight = new JLabel("Right Option:");
        JTextField txtRight = new JTextField();

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String level = cmbLevel.getSelectedItem().toString();
                String question = txtQuestion.getText();
                String option1 = txtOption1.getText();
                String option2 = txtOption2.getText();
                String option3 = txtOption3.getText();
                String right = txtRight.getText();
                String cat=category.getSelectedItem().toString();
                if(Questions.addquestions(level, cat, question, option1, option2, option3, right)) {
                	JOptionPane.showMessageDialog(contentPane, "Added question to database","Success",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	JOptionPane.showMessageDialog(contentPane, "Some error occured. Please try again","Error",JOptionPane.ERROR_MESSAGE);
                }

                dialog.dispose();
            }
        });

        dialog.getContentPane().add(lblLevel);
        dialog.getContentPane().add(cmbLevel);
        dialog.getContentPane().add(lblCategory);
        dialog.getContentPane().add(category);
        dialog.getContentPane().add(lblQuestion);
        dialog.getContentPane().add(txtQuestion);
        dialog.getContentPane().add(lblOption1);
        dialog.getContentPane().add(txtOption1);
        dialog.getContentPane().add(lblOption2);
        dialog.getContentPane().add(txtOption2);
        dialog.getContentPane().add(lblOption3);
        dialog.getContentPane().add(txtOption3);
        dialog.getContentPane().add(lblRight);
        dialog.getContentPane().add(txtRight);
        dialog.getContentPane().add(btnSave);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    //Dialog for DeleteQuestion
    private void showDeleteQuestionDialog() {
    	JDialog dialog = new JDialog(this, "Delete Question", true);
    	dialog.setSize(300, 150);
    	dialog.getContentPane().setLayout(new GridLayout(2, 2, 2, 2)); //new GridLayout(rows, columns, hGap, vGap)
    	
    	JLabel lblID = new JLabel("Question ID:");
    	JTextField qnid = new JTextField();
    	
    	JButton btnDelete = new JButton("Delete");
    	btnDelete.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(qnid.getText().isEmpty()) {
    				JOptionPane.showMessageDialog(contentPane, "Please fill the fields","Empty fields",JOptionPane.ERROR_MESSAGE);
    			}
    			else {
    				int id=Integer.parseInt(qnid.getText());
    				if(Questions.searchbyID(id)) {
    					int response=JOptionPane.showConfirmDialog(contentPane, "Delete Question "+id+"?","Delete Question",JOptionPane.YES_NO_OPTION);
    					if(response==JOptionPane.YES_OPTION) {
    						Questions.deletequestions(id);
    						JOptionPane.showMessageDialog(contentPane, "Deleted question from database","Success",JOptionPane.INFORMATION_MESSAGE);    					
    					}
    				}
    				else {
    					JOptionPane.showMessageDialog(contentPane, "Question of ID "+id+" doesnot exist","Error",JOptionPane.ERROR_MESSAGE);
    				}    				
    			}
    			
    			dialog.dispose();
    		}
    	});
    	
    	dialog.getContentPane().add(lblID);
    	dialog.getContentPane().add(qnid);
    	dialog.getContentPane().add(btnDelete);
    	
    	dialog.setLocationRelativeTo(this);
    	dialog.setVisible(true);
    }
}
