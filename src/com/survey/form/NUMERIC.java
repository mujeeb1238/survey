package com.survey.form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NUMERIC extends JPanel {
	JLabel questionTwoLable;
	JLabel answerTwoLable;
	JTextField questionTwoText;
	KL keyListener = new KL();

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String q_text,a_type;
	int q_id;

	NUMERIC() throws Exception {

		this.setLayout(null);

		try {
			connection = new DriverCTion().getconnections();
			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='NUMERIC' AND question_id =2;");

			q_id=resultSet.getInt("question_id");
			
			q_text = resultSet.getString("question_text");
			a_type=resultSet.getString("answer_type");

			questionTwoLable = new JLabel(q_id + " " + q_text);
			questionTwoLable.setBounds(100, 50, 500, 20);
			this.add(questionTwoLable);

			answerTwoLable = new JLabel("ANS :");
			answerTwoLable.setBounds(100, 80, 40, 20);
			this.add(answerTwoLable);

			questionTwoText = new JTextField();
			questionTwoText.setBounds(150, 80, 100, 20);
			this.add(questionTwoText);
			questionTwoText.addKeyListener(keyListener);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public class KL extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			

			if(e.getKeyCode()==KeyEvent.VK_ENTER){//KeyEvent.VK_ENTER
				System.out.println(e.getKeyCode());
				if(Home.nextButton.isEnabled()){
					Home.nextButton.doClick();
				
				}
			}
			
			String input = questionTwoText.getText();
			Pattern p = Pattern.compile("[^0-9]");
			Matcher m = p.matcher(input);
			if (m.find()) {
				answerTwoLable.setVisible(true);
				answerTwoLable.setForeground(Color.red);
				questionTwoText.setText("");
				
			} else {
				answerTwoLable.setVisible(true);
				answerTwoLable.setForeground(Color.black);
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		this.questionTwoText.requestFocusInWindow();
		//this.questionTwoText.requestFocus();
		//this.questionTwoText.requestDefaultFocus();
		//this.questionTwoText.requestFocus(true);
	}
}
