package com.survey.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CHOOSE_SINGLE extends JPanel {

	JLabel questionFourLable;
	JLabel answerFourLable;
	ButtonGroup button;
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	int q_seq;
	String q_text, typedText,a_type;

	CHOOSE_SINGLE() {
		this.setLayout(null);

		try {
			connection = new DriverCTion().getconnections();
			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT * FROM questions WHERE answer_type ='CHOOSE_SINGLE' AND question_seq =4;");

			q_seq = resultSet.getInt("question_seq");
			q_text = resultSet.getString("question_text");
			a_type=resultSet.getString("answer_type");

			questionFourLable = new JLabel(q_seq + " " + q_text);
			questionFourLable.setBounds(100, 50, 500, 20);
			this.add(questionFourLable);

			answerFourLable = new JLabel("ANS :");
			answerFourLable.setBounds(100, 80, 40, 20);
			this.add(answerFourLable);

			resultSet = statement
					.executeQuery("SELECT * FROM answers WHERE question_id =4;");

			button = new ButtonGroup();
			while (resultSet.next()) {

				int b = resultSet.getInt("choice_id");
				if (b == 1) {
					String str = resultSet.getString("choice_text");
					button1 = new JRadioButton(str);
					button1.setBounds(140, 80, 200, 20);
					button.add(button1);
					this.add(button1);
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
					button2 = new JRadioButton(str);
					button2.setBounds(140, 110, 80, 20);
					button.add(button2);
					this.add(button2);
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
					button3 = new JRadioButton(str);
					button3.setBounds(80, 140, 100, 20);
					button.add(button3);
					this.add(button3);

					button3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (AbstractButton.SELECTED_ICON_CHANGED_PROPERTY != null) {

								typedText = button3.getActionCommand();
						
							}

						}
					});
				}

			}

			
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

}
