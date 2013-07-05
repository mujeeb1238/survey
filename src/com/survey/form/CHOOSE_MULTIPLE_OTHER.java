package com.survey.form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CHOOSE_MULTIPLE_OTHER extends JPanel implements ActionListener {
	
	JLabel questionSevenLable;
	JLabel answerSevenLable;
	

	JCheckBox button1;
	JCheckBox button2;
	JCheckBox button3;
	JCheckBox button4;
	JCheckBox button5;
	JCheckBox button6;
	
	JTextField button1text,button2text,button3text,button4text,button5text,button6text;
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	int q_seq;
	String q_text,a_type,typedText,typedText1;


	CHOOSE_MULTIPLE_OTHER() throws SQLException {
			this.setLayout(null);
			try {
			

			connection = new DriverCTion().getconnections();
			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE_OTHER' AND question_seq =7;");

			
			
			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE_OTHER' AND question_seq =7;");

			q_seq = resultSet.getInt("question_seq");
			q_text = resultSet.getString("question_text");
			a_type=resultSet.getString("answer_type");
			
			questionSevenLable = new JLabel(q_seq + " " + q_text);
			questionSevenLable.setBounds(100, 50, 500, 20);
			this.add(questionSevenLable);

			answerSevenLable = new JLabel("ANS :");
			answerSevenLable.setBounds(100, 80, 40, 20);
			this.add(answerSevenLable);
			
			ButtonGroup bg = new ButtonGroup();
			
			resultSet = statement
					.executeQuery("SELECT * FROM answers WHERE question_id =7;");

			
			
			
			while (resultSet.next()) {
			
				int b = resultSet.getInt("choice_id");
				if (b == 1) {
					String str = resultSet.getString("choice_text");
					button1 = new JCheckBox(str);
					button1.setBounds(140, 80, 200, 20);
					bg.add(button1);
					this.add(button1);
					button1.addActionListener(this);
					button1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

					//			button1text = button1.getActionCommand();
								
							}

						}
					});
				} 

				
				else if (b == 2) {
					String str = resultSet.getString("choice_text");
					button2 = new JCheckBox(str);
					button2.setBounds(140, 110, 200, 20);
					bg.add(button2);
					this.add(button2);
					button2.addActionListener(this);
					button2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

						//		button2text = button2.getActionCommand();
							
							}

						}
					});
				} else if (b == 3) {
					String str = resultSet.getString("choice_text");
					button3 = new JCheckBox(str);
					button3.setBounds(140, 140, 200, 20);
					bg.add(button3);
					this.add(button3);
					button3.addActionListener(this);
					button3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

						//		button3text = button3.getActionCommand();
							
							}

						}
					});
				} else if (b == 4) {
					String str = resultSet.getString("choice_text");
					button4 = new JCheckBox(str);
					button4.setBounds(140, 170, 200, 20);
					bg.add(button4);
					this.add(button4);
					button4.addActionListener(this);
					button4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

						//		button4text = button4.getActionCommand();
								
							}

						}
					});
				} 
				else if (b == 5) {
					String str = resultSet.getString("choice_text");
					button5 = new JCheckBox(str);
					button5.setBounds(140, 200, 200, 20);
					bg.add(button5);
					this.add(button5);
					button5.addActionListener(this);
					button5.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

						//		button5text = button5.getActionCommand();
								
							}

						}
					});
				} 
			
			
			}
			
			button1text=new JTextField();
			button1text.setBounds(350, 80, 150, 20);
			this.add(button1text);
			
			
			} catch (Exception e) {
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
		
	
	@Override
	public void actionPerformed(ActionEvent e) {

	
		
		
		

	}

		}