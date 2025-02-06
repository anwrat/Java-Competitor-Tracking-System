package javafinalgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayGamePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel questionlabel;
    private JRadioButton o1, o2, o3, o4;
    private JButton submitbutton;
	
	private ArrayList<Integer> questionIDs; // Stores shuffled question IDs
    private int currentQuestionIndex = 0; // Keeps track of the current question
    private int currentQuestionID; // Stores the current Question ID

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PlayGamePage frame = new PlayGamePage();
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
	public PlayGamePage(String name,String level) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//This just disposes this quiz game not the user dashboard
		setBounds(100, 100, 754, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Quiz");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(250, 28, 262, 41);
		contentPane.add(lblNewLabel);
		
		questionlabel = new JLabel("New label");
		questionlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionlabel.setVerticalAlignment(SwingConstants.TOP);
		questionlabel.setBounds(35, 123, 654, 127);
		contentPane.add(questionlabel);
		
		o1 = new JRadioButton("New radio button");
		o1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		o1.setBounds(35, 306, 674, 23);
		contentPane.add(o1);
		
		o2 = new JRadioButton("New radio button");
		o2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		o2.setBounds(35, 358, 674, 23);
		contentPane.add(o2);
		
		o3 = new JRadioButton("New radio button");
		o3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		o3.setBounds(35, 407, 674, 23);
		contentPane.add(o3);
		
		o4 = new JRadioButton("New radio button");
		o4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		o4.setBounds(35, 456, 674, 23);
		contentPane.add(o4);
		
		//For creating only one choosable option
		ButtonGroup g=new ButtonGroup();
		g.add(o1);
		g.add(o2);
		g.add(o3);
		g.add(o4);
		
		questionIDs=QuizGame.getrandomfiveids(level);
		if (!questionIDs.isEmpty()) {
			loadQuestion(0);
		} else {
			JOptionPane.showMessageDialog(this, "No questions available for this level!", "Error", JOptionPane.ERROR_MESSAGE);
			dispose();
		}

		JButton submitbutton = new JButton("Submit");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = o1.isSelected() ? o1.getText() :
                    o2.isSelected() ? o2.getText() :
                    o3.isSelected() ? o3.getText() :
                    o4.isSelected() ? o4.getText() : null;
				if (buttonText == null) {
				    JOptionPane.showMessageDialog(contentPane, "Please select an answer before submitting!", "Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					if(QuizGame.checkans(questionIDs.get(currentQuestionIndex), buttonText)) {
						JOptionPane.showMessageDialog(contentPane, "Correct Answer!", "Correct", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Incorrect Answer", "Incorrect", JOptionPane.ERROR_MESSAGE);
					}
				    nextQuestion(); // Move to the next question
				}
			}
		});
		submitbutton.setBackground(new Color(0, 128, 0));
		submitbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		submitbutton.setBounds(282, 529, 129, 41);
		contentPane.add(submitbutton);
	}
	
    private void loadQuestion(int index) {
        if (index < questionIDs.size()) {
            currentQuestionIndex = index;
            currentQuestionID = questionIDs.get(index);

            ArrayList<String> options = QuizGame.getshuffledoptions(currentQuestionID);
            String questionText = Questions.getqn(currentQuestionID); 

            if (options != null && options.size() == 4) {
                questionlabel.setText(questionText);
                o1.setText(options.get(0));
                o2.setText(options.get(1));
                o3.setText(options.get(2));
                o4.setText(options.get(3));
            } else {
                JOptionPane.showMessageDialog(this, "Error loading question!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
	
    private void nextQuestion() {
        if (currentQuestionIndex + 1 < questionIDs.size()) {
            loadQuestion(currentQuestionIndex + 1);
        } else {
            JOptionPane.showMessageDialog(this, "Quiz Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the quiz window
        }
    }
}
