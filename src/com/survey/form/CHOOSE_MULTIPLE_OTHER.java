package com.survey.form;
import java.awt.Graphics;
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

public class CHOOSE_MULTIPLE_OTHER extends JPanel{
	
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
	int q_id;
	String q_text,a_type,typedText1,typedText2,typedText3,typedText4,typedText5,typedText6,typedText7;


	CHOOSE_MULTIPLE_OTHER() throws SQLException {
			this.setLayout(null);
			try {
			

			connection = new DriverCTion().getconnections();
			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE_OTHER' AND question_id =7;");

			
			
			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE_OTHER' AND question_id =7;");

			q_id = resultSet.getInt("question_id");
			q_text = resultSet.getString("question_text");
			a_type=resultSet.getString("answer_type");
			
			questionSevenLable = new JLabel(q_id + " " + q_text);
			questionSevenLable.setBounds(100, 50, 500, 20);
			this.add(questionSevenLable);

			answerSevenLable = new JLabel("ANS :");
			answerSevenLable.setBounds(100, 80, 40, 20);
			this.add(answerSevenLable);
		
			resultSet = statement
					.executeQuery("SELECT * FROM answers WHERE question_id =7;");

			
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

					button1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText1 = button1.getActionCommand();
								
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

					button2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText2 = button2.getActionCommand();
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

					button3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
								typedText3 = button3.getActionCommand();
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

					button4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
						
							typedText4 = button4.getActionCommand();
					
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

					button5.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							typedText5 = button5.getActionCommand();
							if(button5.isSelected()){
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
			
			
			}
			
			button1text=new JTextField();
			button1text.setBounds(350, 200, 150, 20);
			this.add(button1text);
			button1text.setEditable(false);
			button1text.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					typedText6=button1text.getText();

					if(e.getKeyCode() == KeyEvent.VK_ENTER){
						if(Home.nextButton.isEnabled()){
						Home.nextButton.doClick();
						}
					}
				}
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
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
	
	public void paint(Graphics g){
		super.paint(g);
		button1.requestFocus();System.out.println("hello wordl");
	}
		
		}