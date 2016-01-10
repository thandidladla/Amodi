package com.amodi.data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;

public class Login extends JFrame {
	
	private Controller ctrl;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel labelPassword;
	private JButton btnRegister;
	private AdminGUI admin;
	private UserGUI user;

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
		
		txtUsername = new JTextField();
		contentPane.add(txtUsername);
		txtUsername.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		txtUsername.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtUsername.setBounds(281, 108, 105, 20);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField);
		passwordField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		passwordField.setBounds(280, 142, 106, 20);
		
		labelPassword = new JLabel("Password:");
		contentPane.add(labelPassword);
		labelPassword.setForeground(Color.BLACK);
		labelPassword.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		labelPassword.setBounds(193, 145, 78, 14);
		
		lblUsername = new JLabel("Username:");
		contentPane.add(lblUsername);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblUsername.setBounds(194, 111, 78, 14);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/LoginButton1.png")));
		contentPane.add(btnLogin);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		btnLogin.setBounds(175, 182, 100, 28);
		this.getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformed_login();
				
			}
		});
		
		btnRegister = new JButton("");
		contentPane.add(btnRegister);
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		btnRegister.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/RegisterButton1.png")));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(283, 182, 120, 28);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/AmodiLogin.png")));
		lblBackground.setBounds(0, 0, 585, 305);
		contentPane.add(lblBackground);
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
				this.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							user = new UserGUI(ctrl);
							user.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
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
