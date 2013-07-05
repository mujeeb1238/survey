package com.survey.form;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame implements ActionListener{
	private JPanel contentPanel;
	private CardLayout cardLayout;
	private String card = "card";
	
	
	TEXT text;
	NUMERIC numeric;
	CHOOSE_MULTIPLE mchoose;
	CHOOSE_SINGLE schoose;
	CHOOSE_SINGLE_OTHER sochoose;
	CHOOSE_SINGLE_TEXT stchoose;
	CHOOSE_MULTIPLE_OTHER mochoose;
	
	JButton previousButton;
	JButton nextButton;
	
	Connection connection;
	Statement statement;
	ResultSet resultSet = null;
	
	int x=1;

	Home() throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 400);
		setLocationRelativeTo(null);
        setLayout(new BorderLayout());

		cardLayout = new CardLayout(0, 0);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(cardLayout);

		contentPanel.add("card0", text = new TEXT());
		contentPanel.add("card1", numeric = new NUMERIC());
		contentPanel.add("card2", mchoose = new CHOOSE_MULTIPLE());
		contentPanel.add("card3", schoose = new CHOOSE_SINGLE());
		contentPanel.add("card4", sochoose = new CHOOSE_SINGLE_OTHER());
		contentPanel.add("card5", stchoose = new CHOOSE_SINGLE_TEXT());
		contentPanel.add("card6", mochoose = new CHOOSE_MULTIPLE_OTHER());
		

		JPanel navigationPanel = new JPanel();
		navigationPanel.setLayout(new BorderLayout(25, 25));
		navigationPanel.setBackground(new Color(100, 100, 100));
		previousButton = new JButton("< PREVIOUS");
		previousButton.addActionListener(this);
		navigationPanel.add(previousButton, BorderLayout.WEST);

		nextButton = new JButton("NEXT >");
		nextButton.addActionListener(this);
		navigationPanel.add(nextButton ,BorderLayout.EAST);
		add(contentPanel);
		add(navigationPanel, BorderLayout.SOUTH);
		

	}
    int serialno=1;
	int count = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			
		if(serialno>=0 && serialno<20){
		if((e.getSource() == previousButton)&& serialno>1 &&serialno<20){
			serialno--;
			x--;
			cardLayout.previous(contentPanel);
			
			
		}
		if((e.getSource() == nextButton)&& serialno<20){
			
			serialno++;
			
			try {
				connection = new DriverCTion().getconnections();
				statement = connection.createStatement();

				String sql = "SELECT question_id FROM questions";
			
				resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()){
					
					int y =resultSet.getInt(1);
					
					if(y==x){
						
						switch (y) {
						case 1:
							if (text.a_type.equalsIgnoreCase("TEXT")) {
								

								String t = text.questionOneText.getText();
								int qi = text.q_id;
								String sql1 = "SELECT * FROM answers WHERE question_id="
										+ qi + ";";
								resultSet = statement.executeQuery(sql1);
								int i = resultSet.getInt("answer_id");
								statement
										.executeUpdate("INSERT INTO response (answer_text, answer_id, question_id) VALUES ('"
												+ t + "'," + i + "," + qi + ");");
								
								
							}
							break;
							
						case 2:
							
							if (numeric.a_type.equalsIgnoreCase("NUMERIC")) {

								String t = numeric.questionTwoText.getText();
								int qi = numeric.q_id;
								String sql2 = "SELECT * FROM answers WHERE question_id="
										+ qi + ";";
								resultSet = statement.executeQuery(sql2);
								int i = resultSet.getInt("answer_id");
								statement
										.executeUpdate("INSERT INTO response (answer_text, answer_id, question_id) VALUES ('"
												+ t + "'," + i + "," + qi + ");");
							}
							
							break;
							
							
						case 3:
							
							
							if (mchoose.a_type.equalsIgnoreCase("CHOOSE_MULTIPLE")) {

								if (mchoose.typedText1 != null) {
									String str1 = mchoose.typedText1;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
									
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}
								if (mchoose.typedText2 != null) {
									String str1 = mchoose.typedText2;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
								
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}
								if (mchoose.typedText3 != null) {
									String str1 = mchoose.typedText3;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
									
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}
								if (mchoose.typedText4 != null) {
									String str1 = mchoose.typedText4;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
								
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}
								if (mchoose.typedText5 != null) {
									String str1 = mchoose.typedText5;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
									
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}
								if (mchoose.typedText6 != null) {
									String str1 = mchoose.typedText6;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
								
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}
								if (mchoose.typedText7 != null) {
									String str1 = mchoose.typedText7;

									String sql1 = "SELECT * FROM answers WHERE choice_text='"
											+ str1 + "'";
								
									resultSet = statement.executeQuery(sql1);
									int i1 = 0, j1 = 0;
									while (resultSet.next()) {
										i1 = resultSet.getInt("answer_id");
										j1 = resultSet.getInt("question_id");
										resultSet.close();
									}
									statement
											.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
													+ str1 + "',"+ i1 + "," + j1 + ");");
								}

							}
							
							break;
							
							
						case 4:
							
							if (schoose.a_type.equalsIgnoreCase("CHOOSE_SINGLE")) {

								String str = schoose.typedText;
								String str1 = "SELECT * FROM answers WHERE choice_text='"
										+ str + "'";

							
								resultSet = statement.executeQuery(str1);
								int i = 0, j = 0;
								while (resultSet.next()) {
									i = resultSet.getInt("answer_id");
									j = resultSet.getInt("question_id");
									resultSet.close();
								}
							

								statement
										.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
												+ str+ "',"+ i + "," + j + ");");

							}
							
							
							break;

						case 5:
							
							if (sochoose.a_type.equalsIgnoreCase("CHOOSE_SINGLE_OTHER")) {

								String str = sochoose.typedText;
								String str1 = "SELECT * FROM answers WHERE choice_text='"
										+ str + "'";
								resultSet = statement.executeQuery(str1);
								int i = 0, j = 0;
								while (resultSet.next()) {
									i = resultSet.getInt("answer_id");
									j = resultSet.getInt("question_id");
									resultSet.close();
								}
							
								String ot="other";
								if(!str.equalsIgnoreCase(ot)){
									statement
									.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
											+ str+ "',"+ i + "," + j + ");");
									
								}else{
									String text=sochoose.typedText1;
									
									statement
									.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
											+text+ "',"+ i + "," + j + ");");
									
								}

							}
					//		JOptionPane.showMessageDialog(this, "Completed");
							break;
							
							
						case 6:
							
							if (stchoose.a_type.equalsIgnoreCase("CHOOSE_SINGLE_TEXT")) {

								String str = stchoose.typedText;
								String str1 = "SELECT * FROM answers WHERE choice_text='"
										+ str + "'";
								resultSet = statement.executeQuery(str1);
								int i = 0, j = 0;
								while (resultSet.next()) {
									i = resultSet.getInt("answer_id");
									j = resultSet.getInt("question_id");
									resultSet.close();
								}
							
									String text=stchoose.typedText1;
									
									System.out.println("At HOME :: "+text);
									
									statement
									.executeUpdate("INSERT INTO response (answer_text,answer_id, question_id) VALUES ('"
											+text+ "',"+ i + "," + j + ");");
									
								}
							
							break;
							
						case 7:
							
							
							
							break;
							
							
							
						default:
							JOptionPane.showMessageDialog(this, "Completed");
							
						}
	
						
					x++;	
					}
										
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {

				try {
					resultSet.close();
					statement.close();
					connection.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
			cardLayout.next(contentPanel);
			
			//cardLayout.show(contentPanel,card+""+count);
			//count++;
		
		}
		
		}
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Home home = new Home();
					home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
