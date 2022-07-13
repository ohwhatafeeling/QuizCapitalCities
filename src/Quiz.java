import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {
	JPanel questionPanel;
	JPanel answerPanel;
	JLabel question;
	JLabel answer;
	JTextField response;
	JButton start;
	JButton submit;
	JButton restart;
	
	QuizQuestions questions = new QuizQuestions();
	String[] questionsList = questions.capitalCities.keySet().toArray(new String[0]);
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
		question.setBounds(20, 20, 460, 360);
		question.setText("Click start to begin");
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setFont(new Font(null, Font.PLAIN, 30));		
		question.setBackground(new Color(0x9bff4f));
		question.setOpaque(true);
		
		response = new JTextField();
		response.setBounds(20, 320, 460, 60);
		response.setFont(new Font(null, Font.PLAIN, 20));
		response.setVisible(false);
		
		start = new JButton("Start");
		start.setBounds(20, 400, 460, 60);
		start.setFont(new Font(null, Font.PLAIN, 20));
		start.setVisible(true);
		start.addActionListener(this);
		
		submit = new JButton("Submit");
		submit.setBounds(20, 400, 460, 60);
		submit.setFont(new Font(null, Font.PLAIN, 20));
		submit.setVisible(false);
		submit.addActionListener(this);

		questionPanel = new JPanel();
		questionPanel.setBounds(0, 0, 500, 500);
		questionPanel.setLayout(null);
		questionPanel.add(question);
		questionPanel.add(response);
		questionPanel.add(start);
		questionPanel.add(submit);
		questionPanel.setVisible(true);

		answer = new JLabel();
		answer.setBounds(20, 20, 460, 360);
		answer.setFont(new Font(null, Font.PLAIN, 30));
		answer.setHorizontalAlignment(JLabel.CENTER);
		answer.setBackground(new Color(0x58ecfc));
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
		if (e.getSource() == start) {
			start.setVisible(false);
			response.setVisible(true);
			submit.setVisible(true);
			question.setText("<html>What is the capital of " + questionsList[counter] + "?</html>");
			question.setBackground(new Color(0xffbc57));
			question.setBounds(20, 20, 460, 260);
			
		}
		
		if (e.getSource() == submit) {
			if (counter < questionsList.length) {
				if (response.getText().toLowerCase().equals(questions.capitalCities.get(questionsList[counter]).toLowerCase())) {
					correctQuestions++;
				} else {
					incorrectQuestions++;
				}
				counter++;
				if (counter == questionsList.length) {
					questionPanel.setVisible(false);
					answer.setText("<html>You scored " + getPercentage(correctQuestions, questionsList.length) + "%<br/>" + "You got " + incorrectQuestions + " wrong</html>");
					answerPanel.setVisible(true);
				} else {
					question.setText("<html>What is the capital of " + questionsList[counter] + "?</html>");
					response.setText("");
				}		
			}
		}
		
		if (e.getSource() == restart) {
			counter = 0;
			correctQuestions = 0;
			incorrectQuestions = 0;
			question.setBounds(20, 20, 460, 360);
			question.setBackground(new Color(0x9bff4f));
			question.setText("Click start to begin");
			submit.setVisible(false);
			response.setVisible(false);
			start.setVisible(true);
			answerPanel.setVisible(false);
			questionPanel.setVisible(true);
		}
	}
	
	public int getPercentage(int score, int totalQuestions) {
		return (score * 100) / totalQuestions;
	}
	
}
