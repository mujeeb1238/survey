package com.survey.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.survey.form.NUMERIC.KL;

public class TEXT extends JPanel {
	
	JLabel questionOneLable;
	JLabel answerOneLable;
	JTextField questionOneText;
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	int q_seq,a_id,q_id;
	String q_text;
	String typedText,a_type;

	TEXT() throws Exception {
		
		try {
			this.setLayout(null);
			connection=new DriverCTion().getconnections();
			statement=connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='TEXT' AND question_seq =1;");

				q_id=resultSet.getInt("question_id");
				q_seq=resultSet.getInt("question_seq");
				q_text = resultSet.getString("question_text");
				a_type=resultSet.getString("answer_type");
				
				resultSet = statement
						.executeQuery("SELECT * FROM answers;");


			questionOneLable = new JLabel(q_seq+" "+q_text);
			questionOneLable.setBounds(100, 50, 500, 20);
		//	questionOneLable.setFont(new Font("Vijaya", Font.HANGING_BASELINE, 16));
			this.add(questionOneLable);

			answerOneLable = new JLabel("ANS :");
			answerOneLable.setBounds(100, 80, 40, 20);
			this.add(answerOneLable);

			questionOneText = new JTextField();
			questionOneText.setBounds(150, 80, 100, 20);
			this.add(questionOneText);
			questionOneText.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
					String input = questionOneText.getText();
					Pattern p = Pattern.compile("[^0-9]");
					Matcher m = p.matcher(input);
					if (m.find()) {
						answerOneLable.setVisible(true);
						answerOneLable.setForeground(Color.red);

					} else {
						answerOneLable.setVisible(true);
						answerOneLable.setForeground(Color.black);
					}
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
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
	
	
}
