package com.survey.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CHOOSE_MULTIPLE extends JPanel {

	JLabel questionThreeLable;
	JLabel answerThreeLable;
	JCheckBox button1;
	JCheckBox button2;
	JCheckBox button3;
	JCheckBox button4;
	JCheckBox button5;
	JCheckBox button6;
	JCheckBox button7;
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String q_text,a_type,typedText1,typedText2,typedText3,typedText4,typedText5,typedText6,typedText7;
	int q_seq;

	CHOOSE_MULTIPLE() throws Exception {

		this.setLayout(null);

		try {

			connection = new DriverCTion().getconnections();
			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_MULTIPLE' AND question_seq =3;");

			q_seq = resultSet.getInt("question_seq");
			q_text = resultSet.getString("question_text");
			a_type=resultSet.getString("answer_type");

			questionThreeLable = new JLabel(q_seq + " " + q_text);
			questionThreeLable.setBounds(100, 50, 500, 20);
			this.add(questionThreeLable);

			answerThreeLable = new JLabel("ANS :");
			answerThreeLable.setBounds(100, 80, 40, 20);
			this.add(answerThreeLable);

			resultSet = statement
					.executeQuery("SELECT * FROM answers WHERE question_id =3;");

			while (resultSet.next()) {

				int b = resultSet.getInt("choice_id");
				if (b == 1) {
					String str = resultSet.getString("choice_text");
					button1 = new JCheckBox(str);
					button1.setBounds(140, 80, 200, 20);
					this.add(button1);
					button1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText1 = button1.getActionCommand();
							
							}

						}
					});
				} else if (b == 2) {
					String str = resultSet.getString("choice_text");
					button2 = new JCheckBox(str);
					button2.setBounds(140, 100, 200, 20);
					this.add(button2);
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
					button3.setBounds(140, 120, 200, 20);
					this.add(button3);
					button3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText3 = button3.getActionCommand();
							
							}

						}
					});
				} else if (b == 4) {
					String str = resultSet.getString("choice_text");
					button4 = new JCheckBox(str);
					button4.setBounds(140, 140, 200, 20);
					this.add(button4);
					button4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText4 = button4.getActionCommand();
							
							}

						}
					});
				}
				else if (b == 5) {
					String str = resultSet.getString("choice_text");
					button5 = new JCheckBox(str);
					button5.setBounds(140, 160, 200, 20);
					this.add(button5);
					button5.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText5 = button5.getActionCommand();
							
							}

						}
					});
				}
				else if (b == 6) {
					String str = resultSet.getString("choice_text");
					button6 = new JCheckBox(str);
					button6.setBounds(140, 180, 200, 20);
					this.add(button6);
					button6.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText6 = button6.getActionCommand();
							
							}

						}
					});
				}
				else if (b == 7) {
					String str = resultSet.getString("choice_text");
					button7 = new JCheckBox(str);
					button7.setBounds(140, 200, 200, 20);
					this.add(button7);
					button7.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText7 = button7.getActionCommand();
								
							}

						}
					});
				}

			}

	
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

}
