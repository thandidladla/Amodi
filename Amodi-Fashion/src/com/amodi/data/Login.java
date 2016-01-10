package com.amodi.data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {
	
	private Controller ctrl;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel labelPassword;
	private JLabel lblAmodiFashion;
	private JButton btnSignUp;
	private AdminGUI admin;
	private AmodiDialog ad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login frame = new Login();
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		ctrl = new Controller();
		ad = new AmodiDialog();
		if(!ctrl.isConnected()){
			return;
		}
		WindowAdapter exitListener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Are you sure to close Application?",
						"Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == JOptionPane.YES_OPTION) {
					ctrl.disconnect();
					System.exit(0);
				}
			}
		};
		this.addWindowListener(exitListener);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Login");
		setOpacity(1.0f);
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
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/Angebot.png")));
		btnLogin.setBackground(new Color(240, 230, 140));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		btnLogin.setBounds(175, 216, 100, 28);
		this.getRootPane().setDefaultButton(btnLogin);
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
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.setForeground(new Color(0, 0, 0));
		btnSignUp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSignUp.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		btnSignUp.setIcon(new ImageIcon(Login.class.getResource("/com/amodi/res/User.png")));
		btnSignUp.setBackground(new Color(240, 230, 140));
		btnSignUp.setBounds(282, 216, 120, 28);
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] data = ad.showSignUpDialog(getRootPane(), "Sign up", new ImageIcon(Login.class.getResource("/com/amodi/res/signup.png")));
				if(data != null){
					ctrl.add(data, ctrl.USER);
					JOptionPane.showMessageDialog(getRootPane(), "Signed up successful! Please login.");
				}
			}
		});
		lblBackground.add(btnSignUp);
		this.setVisible(true);
	}
	
	private void actionPerformed_login(){
		String rang = checkCredentials();
		if(rang != null){
			if(rang.equals("admin")){
				this.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							admin = new AdminGUI(ctrl,ad);
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
				passwordField.setText("");

			}
		}else{
			JOptionPane.showMessageDialog(null, "Failed. Check your credentials and your connection to the internet.", "Error", JOptionPane.ERROR_MESSAGE);
			passwordField.setText("");		}
	}
	
	private String checkCredentials(){
		String username = txtUsername.getText();
		String password = new String( passwordField.getPassword());
		return ctrl.checkCredentials(username, password);
	}
}
