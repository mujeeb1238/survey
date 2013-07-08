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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class CHOOSE_SINGLE_OTHER extends JPanel implements ActionListener {

	JLabel questionFiveLable;
	JLabel answerFiveLable;

	JCheckBox button1;
	JCheckBox button2;
	JCheckBox button3;
	JCheckBox button4;
	JTextField casteOtherText;
	JCheckBox button5;

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	int q_id;
	String q_text,a_type,typedText,typedText1;

	CHOOSE_SINGLE_OTHER() throws SQLException {
		this.setLayout(null);

		try {

			connection = new DriverCTion().getconnections();
			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_SINGLE_OTHER' AND question_id =5;");

			q_id = resultSet.getInt("question_id");
			q_text = resultSet.getString("question_text");
			a_type=resultSet.getString("answer_type");

			questionFiveLable = new JLabel(q_id + " " + q_text);
			questionFiveLable.setBounds(100, 50, 500, 20);
			this.add(questionFiveLable);

			answerFiveLable = new JLabel("ANS :");
			answerFiveLable.setBounds(100, 80, 40, 20);
			this.add(answerFiveLable);

			ButtonGroup bg = new ButtonGroup();

			resultSet = statement
					.executeQuery("SELECT * FROM answers WHERE question_id =5;");

			while (resultSet.next()) {

				int b = resultSet.getInt("choice_id");
				if (b == 1) {
					String str = resultSet.getString("choice_text");
					button1 = new JCheckBox(str);
					button1.setBounds(140, 80, 50, 20);
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
					bg.add(button1);
					this.add(button1);
					button1.addActionListener(this);
					button1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText = button1.getActionCommand();
								
							}

						}
					});
				} else if (b == 2) {
					String str = resultSet.getString("choice_text");
					button2 = new JCheckBox(str);
					button2.setBounds(210, 80, 70, 20);
					bg.add(button2);
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
					button2.addActionListener(this);
					button2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText = button2.getActionCommand();
							
							}

						}
					});
				} else if (b == 3) {
					String str = resultSet.getString("choice_text");
					button3 = new JCheckBox(str);
					button3.setBounds(140, 110, 70, 20);
					bg.add(button3);
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
					button3.addActionListener(this);
					button3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText = button3.getActionCommand();
							
							}

						}
					});
				} else if (b == 4) {
					String str = resultSet.getString("choice_text");
					button4 = new JCheckBox(str);
					button4.setBounds(210, 110, 80, 20);
					bg.add(button4);
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
					button4.addActionListener(this);
					button4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText = button4.getActionCommand();
								
							}

						}
					});
				} else if (b == 5) {
					String str = resultSet.getString("choice_text");
					button5 = new JCheckBox(str);
					button5.setBounds(80, 140, 70, 20);
					bg.add(button5);
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
					button5.addActionListener(this);
				}
			}

			casteOtherText = new JTextField(15);
			casteOtherText.setBounds(295, 110, 70, 20);
			this.add(casteOtherText);
			//casteOtherText.setEditable(false);
			casteOtherText.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					typedText1=casteOtherText.getText();
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

		if (e.getActionCommand().equalsIgnoreCase("Others")) {
			casteOtherText.setEditable(true);
			casteOtherText.requestFocus();
//			typedText1=casteOtherText.getText();
		} else {
			casteOtherText.setEditable(false);
			casteOtherText.setText("");
		}
		
		

	}
	
	public void paint(Graphics g){
		super.paint(g);
		button1.requestFocus();
		System.out.println("CHOOSE_SINGLE_OTHER");
	}

}

