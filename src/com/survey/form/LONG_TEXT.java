package com.survey.form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LONG_TEXT extends JPanel{
	JLabel questionNineLable;
	JLabel answerNineLable;
	JTextArea questionNineText;
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	int q_id,a_id;
	String q_text;
	String typedText,a_type;

	LONG_TEXT() throws Exception {
		
		try {
			this.setLayout(null);
			connection=new DriverCTion().getconnections();
			statement=connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='LONG_TEXT' AND question_id =9;");

				q_id=resultSet.getInt("question_id");
				q_text = resultSet.getString("question_text");
				a_type=resultSet.getString("answer_type");
				
				resultSet = statement
						.executeQuery("SELECT * FROM answers;");


				questionNineLable = new JLabel(q_id+" "+q_text);
				questionNineLable.setBounds(100, 50, 500, 20);
		//	questionOneLable.setFont(new Font("Vijaya", Font.HANGING_BASELINE, 16));
			this.add(questionNineLable);

			answerNineLable = new JLabel("ANS :");
			answerNineLable.setBounds(100, 80, 40, 20);
			this.add(answerNineLable);

			questionNineText = new JTextArea(5,6);
		//	questionNineText.setBounds(150, 80, 200, 80);
			JScrollPane spane = new JScrollPane(questionNineText);
			spane.setBounds(150, 80, 200, 80);
			this.add(spane);
			questionNineText.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
					String input = questionNineText.getText();
					Pattern p = Pattern.compile("[^0-9]");
					Matcher m = p.matcher(input);
					if (m.find()) {
						answerNineLable.setVisible(true);
						answerNineLable.setForeground(Color.red);

					} else {
						answerNineLable.setVisible(true);
						answerNineLable.setForeground(Color.black);
					}
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

					if(e.getKeyCode() == KeyEvent.VK_TAB){
					Home.nextButton.requestFocus();
					}
					/*if(e.getKeyCode() == KeyEvent.VK_ENTER){
						if(Home.nextButton.isEnabled()){
						Home.nextButton.doClick();
						}
					}*/
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		
		} catch (Exception e) {
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
	
	public void paint(Graphics g){
		super.paint(g);
		questionNineText.requestFocus();
	}
	
}
