package com.amodi.data;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {
	
	private Controller ctrl;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel labelPassword;
	private JLabel lblAmodiFashion;
	private JButton btnRegister;
	private AdminGUI admin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		ctrl = new Controller();
		setTitle("Login");
		setOpacity(1.0f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(590, 334);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/login_background.jpg")));
		lblBackground.setBounds(0, 0, 585, 305);
		contentPane.add(lblBackground);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		txtUsername.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtUsername.setBounds(277, 125, 105, 20);
		txtUsername.setColumns(10);
		lblBackground.add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		passwordField.setBounds(277, 159, 106, 20);
		lblBackground.add(passwordField);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblUsername.setBounds(189, 126, 78, 14);
		lblBackground.add(lblUsername);
		
		labelPassword = new JLabel("Password:");
		labelPassword.setForeground(Color.BLACK);
		labelPassword.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		labelPassword.setBounds(190, 161, 78, 14);
		lblBackground.add(labelPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/Price Tag USD-26.png")));
		btnLogin.setBackground(new Color(240, 230, 140));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		btnLogin.setBounds(175, 216, 100, 28);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformed_login();
				
			}
		});
		lblBackground.add(btnLogin);
		
		lblAmodiFashion = new JLabel("Amodi Fashion");
		lblAmodiFashion.setForeground(Color.BLACK);
		lblAmodiFashion.setFont(new Font("Mistral", Font.BOLD, 50));
		lblAmodiFashion.setBounds(150, 35, 411, 64);
		lblBackground.add(lblAmodiFashion);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRegister.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		btnRegister.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/Manager-26.png")));
		btnRegister.setBackground(new Color(240, 230, 140));
		btnRegister.setBounds(282, 216, 120, 28);
		lblBackground.add(btnRegister);
	}
	
	private void actionPerformed_login(){
		String rang = checkCredentials();
		if(rang != null){
			if(rang.equals("admin")){
				this.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							admin = new AdminGUI(ctrl);
							admin.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}else if(rang.equals("user")){
				JOptionPane.showMessageDialog(null, "In work :-)");
			}else{
				JOptionPane.showMessageDialog(null, "Failed. Check your credentials and your connection to the internet.", "Error", JOptionPane.ERROR_MESSAGE);
				txtUsername.setText("");
				passwordField.setText("");

			}
		}else{
			JOptionPane.showMessageDialog(null, "Failed. Check your credentials and your connection to the internet.", "Error", JOptionPane.ERROR_MESSAGE);
			passwordField.setText("");
			txtUsername.setText("");
		}
	}
	
	private String checkCredentials(){
		String username = txtUsername.getText();
		String password = new String( passwordField.getPassword());
		return ctrl.checkCredentials(username, password);
	}
}
