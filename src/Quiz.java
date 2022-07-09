import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quiz extends JFrame implements ActionListener {
	JPanel questionPanel;
	JPanel answerPanel;
	JLabel question;
	JLabel answer;
	JTextField response;
	JButton submit;
	JButton restart;
	QuizQuestions questions;
	String questionText;
	String answerText;
	
	Quiz() {
		this.setTitle("Capital City Quiz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		questions = new QuizQuestions();
		questionText = (String)questions.capitalCities.keySet().toArray()[0];
		answerText = questions.capitalCities.get(questionText);
		
		question = new JLabel();
		question.setBounds(20, 20, 460, 260);
		question.setText("What is the capital of " + questionText + "?");
		question.setFont(new Font(null, Font.PLAIN, 30));		
		question.setBackground(Color.yellow);
		question.setOpaque(true);
		
		response = new JTextField();
		response.setBounds(20, 320, 460, 60);
		response.setFont(new Font(null, Font.PLAIN, 20));
		
		submit = new JButton("Submit");
		submit.setBounds(20, 400, 460, 60);
		submit.setFont(new Font(null, Font.PLAIN, 20));
		submit.addActionListener(this);

		questionPanel = new JPanel();
		questionPanel.setBounds(0, 0, 500, 500);
		questionPanel.setLayout(null);
		questionPanel.add(question);
		questionPanel.add(response);
		questionPanel.add(submit);
		questionPanel.setVisible(true);

		answer = new JLabel();
		answer.setBounds(20, 20, 460, 360);
		answer.setFont(new Font(null, Font.PLAIN, 30));
		answer.setBackground(Color.blue);
		answer.setOpaque(true);
		
		restart = new JButton("Restart");
		restart.setBounds(20, 400, 460, 60);
		restart.setFont(new Font(null, Font.PLAIN, 20));
		restart.addActionListener(this);
		
		answerPanel = new JPanel();
		answerPanel.setBounds(0, 0, 500, 500);
		answerPanel.setLayout(null);
		answerPanel.add(answer);
		answerPanel.add(restart);
		answerPanel.setVisible(false);
		
		this.add(questionPanel);
		this.add(answerPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			questionPanel.setVisible(false);
			answerPanel.setVisible(true);
			if (response.getText().toLowerCase().equals(answerText.toLowerCase())) {
				answer.setText("Correct");
			} else {
				answer.setText("<html> The correct answer is " + answerText + "</html>");
			}
		}
		if (e.getSource() == restart) {
			answerPanel.setVisible(false);
			questionPanel.setVisible(true);
		}
	}

}
