package com.survey.form;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CHOOSE_SINGLE_TEXT  extends JPanel{
	
	JLabel questionSixLable;
	JLabel answerSixLable;

	 KLi l=new KLi();
	 
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;
	JRadioButton button4;
	JRadioButton button5;
	JRadioButton button6;
	
	JTextField button1text,button2text,button3text,button4text,button5text,button6text;
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	int q_seq;
	String q_text,a_type,typedText,typedText1;
	
	CHOOSE_SINGLE_TEXT(){
		this.setLayout(null);
		try {
		

		connection = new DriverCTion().getconnections();
		statement = connection.createStatement();

		resultSet = statement
				.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_SINGLE_TEXT' AND question_seq =6;");

		
		
		resultSet = statement
				.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_SINGLE_TEXT' AND question_seq =6;");

		q_seq = resultSet.getInt("question_seq");
		q_text = resultSet.getString("question_text");
		a_type=resultSet.getString("answer_type");
		
		questionSixLable = new JLabel(q_seq + " " + q_text);
		questionSixLable.setBounds(100, 50, 500, 20);
		this.add(questionSixLable);

		answerSixLable = new JLabel("ANS :");
		answerSixLable.setBounds(100, 80, 40, 20);
		this.add(answerSixLable);
		
		ButtonGroup bg = new ButtonGroup();
		
		resultSet = statement
				.executeQuery("SELECT * FROM answers WHERE question_id =6;");

		
		
		
		while (resultSet.next()) {
		
			int b = resultSet.getInt("choice_id");
			if (b == 1) {
				String str = resultSet.getString("choice_text");
				button1 = new JRadioButton(str);
				button1.setBounds(140, 80, 200, 20);
				bg.add(button1);
				this.add(button1);
		//		button1.addActionListener(this);
				button1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						typedText=button1.getActionCommand();
						button1text.setEditable(true);
						button2text.setEditable(false);
						button3text.setEditable(false);
						button4text.setEditable(false);
						button5text.setEditable(false);
//						typedText1=button1text.getText();
//						button1text.setText("");

					}
				});
			} 
			
			
			
			
			else if (b == 2) {
				String str = resultSet.getString("choice_text");
				button2 = new JRadioButton(str);
				button2.setBounds(140, 110, 200, 20);
				bg.add(button2);
				this.add(button2);
				//button2.addActionListener(this);
				button2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText=button2.getActionCommand();
						button1text.setEditable(false);
						button2text.setEditable(true);
						button3text.setEditable(false);
						button4text.setEditable(false);
						button5text.setEditable(false);
					//	typedText1=button2text.getText();
					//	button2text.setText("");

					}
				});
			} else if (b == 3) {
				String str = resultSet.getString("choice_text");
				button3 = new JRadioButton(str);
				button3.setBounds(140, 140, 200, 20);
				bg.add(button3);
				this.add(button3);
			//	button3.addActionListener(this);
				button3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText=button3.getActionCommand();
						button1text.setEditable(false);
						button2text.setEditable(false);
						button3text.setEditable(true);
						button4text.setEditable(false);
						button5text.setEditable(false);
						
					//	button3text.setText("");
					}
				});
			} else if (b == 4) {
				String str = resultSet.getString("choice_text");
				button4 = new JRadioButton(str);
				button4.setBounds(140, 170, 200, 20);
				bg.add(button4);
				this.add(button4);
			//	button4.addActionListener(this);
				button4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText=button4.getActionCommand();
						button1text.setEditable(false);
						button2text.setEditable(false);
						button3text.setEditable(false);
						button4text.setEditable(true);
						button5text.setEditable(false);
					//	typedText1=button4text.getText();
					//	button4text.setText("");

					}
				});
			} 
			else if (b == 5) {
				String str = resultSet.getString("choice_text");
				button5 = new JRadioButton(str);
				button5.setBounds(140, 200, 200, 20);
				bg.add(button5);
				this.add(button5);
			//	button5.addActionListener(this);
				button5.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
							typedText=button5.getActionCommand();
							button5text.setEditable(true);
							button4text.setEditable(false);
							button3text.setEditable(false);
							button2text.setEditable(false);
							button1text.setEditable(false);
					//		typedText1=button5text.getText();
				//			button5text.setText("");
					
						}

					
				});
			} 
		
		
		}
		
		button1text=new JTextField();
		button1text.setBounds(350, 80, 150, 20);
		this.add(button1text);
		button1text.setEditable(false);
		button2text=new JTextField();
		button2text.setBounds(350, 110, 150, 20);
		this.add(button2text);
		button2text.setEditable(false);
		button3text=new JTextField();
		button3text.setBounds(350, 140, 150, 20);
		this.add(button3text);
		button3text.setEditable(false);
		button4text=new JTextField();
		button4text.setBounds(350, 170, 150, 20);
		this.add(button4text);
		button4text.setEditable(false);
		button5text=new JTextField();
		button5text.setBounds(350, 200, 150, 20);
		this.add(button5text);
		button5text.setEditable(false);
		button1text.addKeyListener(l);
		button2text.addKeyListener(l);
		button3text.addKeyListener(l);
		button4text.addKeyListener(l);
		button5text.addKeyListener(l);
		
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
	public class KLi extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			JTextField field = (JTextField)e.getSource();
			typedText1 = field.getText();
			/*if(field == button1text){
				typedText1=button1text.getText();
			}
			else if(field == button2text){
				typedText1=button2text.getText();
			}
			else if(field == button3text){
				typedText1=button3text.getText();
			}
			else if(field == button4text){
				typedText1=button4text.getText();
			}
			else if(field == button5text){
				typedText1=button5text.getText();
			}
			
			System.out.println(typedText1);*/
			
		}
	}
	
	
	}

