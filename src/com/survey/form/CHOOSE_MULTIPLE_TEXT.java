package com.survey.form;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CHOOSE_MULTIPLE_TEXT extends JPanel{

	JLabel questionEiLable;
	JLabel answerEiLable;

	 KLii ll=new KLii();
	 
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
	int q_id;
	String q_text,a_type,typedText,typedText1,typedText2,typedText3,typedText4,typedText5;
	String text1,text2,text3,text4,text5;
	
	CHOOSE_MULTIPLE_TEXT(){
		this.setLayout(null);
		try {
		

		connection = new DriverCTion().getconnections();
		statement = connection.createStatement();

		resultSet = statement
				.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE_TEXT' AND question_id =8;");

		
		
		resultSet = statement
				.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE_TEXT' AND question_id =8;");

		q_id = resultSet.getInt("question_id");
		q_text = resultSet.getString("question_text");
		a_type=resultSet.getString("answer_type");
		
		questionEiLable = new JLabel(q_id + " " + q_text);
		questionEiLable.setBounds(100, 50, 500, 20);
		this.add(questionEiLable);

		answerEiLable = new JLabel("ANS :");
		answerEiLable.setBounds(100, 80, 40, 20);
		this.add(answerEiLable);
		
		resultSet = statement
				.executeQuery("SELECT * FROM answers WHERE question_id =8;");

		
		
		
		while (resultSet.next()) {
		
			int b = resultSet.getInt("choice_id");
			if (b == 1) {
				String str = resultSet.getString("choice_text");
				button1 = new JCheckBox(str);
				button1.setBounds(140, 80, 200, 20);
				this.add(button1);
				button1.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
								if(Home.nextButton.isEnabled()){
								Home.nextButton.doClick();
								}
							}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
				});

		//		button1.addActionListener(this);
				button1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText1 = button1.getActionCommand();
						
						if(button1.isSelected()){
							button1text.setEditable(true);
							button1text.requestFocus();
						//	typedText5=button1text.getText();
						}else{
							button1text.setEditable(false);
							button1text.setText("");
						}

					}
				});
			} 
			
			
			
			
			else if (b == 2) {
				String str = resultSet.getString("choice_text");
				button2 = new JCheckBox(str);
				button2.setBounds(140, 110, 200, 20);
				this.add(button2);
				button2.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
								if(Home.nextButton.isEnabled()){
								Home.nextButton.doClick();
								}
							}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
				});

				//button2.addActionListener(this);
				button2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText2 = button2.getActionCommand();
						if(button2.isSelected()){
							button2text.setEditable(true);
							button2text.requestFocus();
						//	typedText5=button1text.getText();
						}else{
							button2text.setEditable(false);
							button2text.setText("");
						}

					}
				});
			} else if (b == 3) {
				String str = resultSet.getString("choice_text");
				button3 = new JCheckBox(str);
				button3.setBounds(140, 140, 200, 20);
				this.add(button3);
				button3.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
								if(Home.nextButton.isEnabled()){
								Home.nextButton.doClick();
								}
							}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
				});

			//	button3.addActionListener(this);
				button3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText3 = button3.getActionCommand();
						
						if(button3.isSelected()){
							button3text.setEditable(true);
							button3text.requestFocus();
						//	typedText5=button1text.getText();
						}else{
							button3text.setEditable(false);
							button3text.setText("");
						}
					}
				});
			} else if (b == 4) {
				String str = resultSet.getString("choice_text");
				button4 = new JCheckBox(str);
				button4.setBounds(140, 170, 200, 20);
				this.add(button4);
				button4.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
								if(Home.nextButton.isEnabled()){
								Home.nextButton.doClick();
								}
							}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
				});

			//	button4.addActionListener(this);
				button4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						typedText4 = button4.getActionCommand();
						if(button4.isSelected()){
							button4text.setEditable(true);
							button4text.requestFocus();
						//	typedText5=button1text.getText();
						}else{
							button4text.setEditable(false);
							button4text.setText("");
						}

					}
				});
			} 
			else if (b == 5) {
				String str = resultSet.getString("choice_text");
				button5 = new JCheckBox(str);
				button5.setBounds(140, 200, 200, 20);
				this.add(button5);
				button5.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
								if(Home.nextButton.isEnabled()){
								Home.nextButton.doClick();
								}
							}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
				});

			//	button5.addActionListener(this);
				button5.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						typedText5 = button5.getActionCommand();
						if(button5.isSelected()){
							button5text.setEditable(true);
							button5text.requestFocus();
						//	typedText5=button1text.getText();
						}else{
							button5text.setEditable(false);
							button5text.setText("");
						}
					
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
		button1text.addKeyListener(ll);
		button2text.addKeyListener(ll);
		button3text.addKeyListener(ll);
		button4text.addKeyListener(ll);
		button5text.addKeyListener(ll);
		
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
	public class KLii extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
		//	JTextField field = (JTextField)e.getSource();
			if(button1.isFocusable()){
				text1 = button1text.getText();
				System.out.println("exec1");
				}
			if(button2.isFocusable()){
				text2 = button2text.getText();
				System.out.println("exec2");
				}
			if(button3.isFocusable()){
				text3 = button3text.getText();
				System.out.println("exec3");
				}
			if(button4.isFocusable()){
				text4 = button4text.getText();
				System.out.println("exec4");
				}
			if(button5.isFocusable()){
				text5 = button5text.getText();
				System.out.println("exec5");
				}
//			text2 = field.getText();
//			text3 = field.getText();
//			text4 = field.getText();
//			text5 = field.getText();
		//	field.requestFocus();
			

			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				if(Home.nextButton.isEnabled()){
				Home.nextButton.doClick();
				}
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		button1.requestFocus();
		System.out.println("CHOOSE_MULTIPLE_TEXT");
	}
	
}
