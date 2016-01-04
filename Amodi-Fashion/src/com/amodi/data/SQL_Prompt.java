package com.amodi.data;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class SQL_Prompt {
	
	private  JFrame frame;
	private  final  JPanel contentPanel = new JPanel();
	private  JTextArea textArea;
	private  JRadioButton rdbtnQuery,rdbtnManipulation;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void showSQLPrompt(ActionListener al) {
		
		frame = new JFrame();
		frame.setTitle("SQL Prompt");
		frame.setBounds(100, 100, 513, 268);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				textArea = new JTextArea();
				textArea.setLineWrap(true);
				textArea.setForeground(Color.WHITE);
				textArea.setCaretColor(Color.WHITE);
				textArea.setBackground(Color.BLACK);
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton executeButton = new JButton("EXECUTE");
				
				executeButton.addActionListener(al);
				{
					rdbtnManipulation = new JRadioButton("Manipulation");
					rdbtnManipulation.setBackground(Color.BLACK);
					rdbtnManipulation.setForeground(Color.WHITE);
					rdbtnManipulation.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							rdbtnQuery.setSelected(false);
						}
					});
					buttonPane.add(rdbtnManipulation);
				}
				{
					rdbtnQuery = new JRadioButton("Query");
					rdbtnQuery.setSelected(true);
					rdbtnQuery.setForeground(Color.WHITE);
					rdbtnQuery.setBackground(Color.BLACK);
					rdbtnQuery.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							rdbtnManipulation.setSelected(false);
						}
					});
					buttonPane.add(rdbtnQuery);
				}
				buttonPane.add(executeButton);
			}
			{
				JButton cancelButton = new JButton("CANCEL");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				buttonPane.add(cancelButton);
				frame.dispose();
			}
		}
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public  String getCommand(){
		return textArea.getText();
	}
	
	public boolean isQuery(){
		return rdbtnQuery.isSelected();
	}
	
	public void showErrorMessage(String msg,int optiontype){
		JOptionPane.showMessageDialog(this.frame, msg, "Error", optiontype);
	}
}
