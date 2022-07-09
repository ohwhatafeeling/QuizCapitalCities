import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	
	QuizQuestions questions = new QuizQuestions();
	String[] questionsList = questions.capitalCities.keySet().toArray(new String[0]);
	
	String questionText;
	String answerText;
	int correctQuestions = 0;
	int incorrectQuestions = 0;
	int counter = 0;
	
	Quiz() {
		this.setTitle("Capital City Quiz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		
		question = new JLabel();
		question.setBounds(20, 20, 460, 260);
		question.setText("Click start to begin");
		question.setFont(new Font(null, Font.PLAIN, 30));		
		question.setBackground(Color.yellow);
		question.setOpaque(true);
		
		response = new JTextField();
		response.setBounds(20, 320, 460, 60);
		response.setFont(new Font(null, Font.PLAIN, 20));
		
		submit = new JButton("Start");
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
			submit.setText("Submit");
			if (counter < questionsList.length) {
				if (response.getText().toLowerCase().equals(questions.capitalCities.get(questionsList[counter]).toLowerCase())) {
					correctQuestions++;
				} else {
					incorrectQuestions++;
				}
				question.setText("What is the capital of " + questionsList[counter] + "?");
				counter++;
			} else {
				questionPanel.setVisible(false);
				answer.setText("Finished\n" + "You got " + incorrectQuestions + " wrong");
				answerPanel.setVisible(true);
			}
			
		}
//		
		if (e.getSource() == restart) {
			counter = 0;
			correctQuestions = 0;
			incorrectQuestions = 0;
			question.setText("Click start to begin");
			submit.setText("Start");
			answerPanel.setVisible(false);
			questionPanel.setVisible(true);
		}
	}
	
}
