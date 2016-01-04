package com.amodi.data;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private Controller ctrl;
	private JLabel[] Labels  = new JLabel[10];
	private int Seite = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public UserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {5, 100, 5, 100, 5, 100, 5, 100, 5, 135, 30};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblArtikel_0 = new JLabel("Artikel1");
		GridBagConstraints gbc_lblArtikel_0 = new GridBagConstraints();
		gbc_lblArtikel_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_0.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_0.gridx = 1;
		gbc_lblArtikel_0.gridy = 1;
		contentPane.add(lblArtikel_0, gbc_lblArtikel_0);
		Labels[0]=lblArtikel_0;
		
		JLabel lblArtikel_1 = new JLabel("Artikel2");
		GridBagConstraints gbc_lblArtikel_1 = new GridBagConstraints();
		gbc_lblArtikel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblArtikel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_1.gridx = 3;
		gbc_lblArtikel_1.gridy = 1;
		contentPane.add(lblArtikel_1, gbc_lblArtikel_1);
		Labels[1]=lblArtikel_1;
		
		JLabel lblArtikel_2 = new JLabel("Artikel3");
		GridBagConstraints gbc_lblArtikel_2 = new GridBagConstraints();
		gbc_lblArtikel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_2.gridx = 5;
		gbc_lblArtikel_2.gridy = 1;
		contentPane.add(lblArtikel_2, gbc_lblArtikel_2);
		Labels[2]=lblArtikel_2;
		
		JLabel lblArtikel_3 = new JLabel("Artikel4");
		GridBagConstraints gbc_lblArtikel_3 = new GridBagConstraints();
		gbc_lblArtikel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_3.gridx = 7;
		gbc_lblArtikel_3.gridy = 1;
		contentPane.add(lblArtikel_3, gbc_lblArtikel_3);
		Labels[3]=lblArtikel_3;
		
		JLabel lblArtikel_4 = new JLabel("Artikel5");
		GridBagConstraints gbc_lblArtikel_4 = new GridBagConstraints();
		gbc_lblArtikel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblArtikel_4.gridx = 9;
		gbc_lblArtikel_4.gridy = 1;
		contentPane.add(lblArtikel_4, gbc_lblArtikel_4);
		Labels[4]=lblArtikel_4;
		
		JLabel lblArtikel_5 = new JLabel("Artikel6");
		GridBagConstraints gbc_lblArtikel_5 = new GridBagConstraints();
		gbc_lblArtikel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_5.gridx = 1;
		gbc_lblArtikel_5.gridy = 3;
		contentPane.add(lblArtikel_5, gbc_lblArtikel_5);
		Labels[5]=lblArtikel_5;
		
		JLabel lblArtikel_6 = new JLabel("Artikel7");
		GridBagConstraints gbc_lblArtikel_6 = new GridBagConstraints();
		gbc_lblArtikel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_6.gridx = 3;
		gbc_lblArtikel_6.gridy = 3;
		contentPane.add(lblArtikel_6, gbc_lblArtikel_6);
		Labels[6]=lblArtikel_6;
		
		JLabel lblArtikel_7 = new JLabel("Artikel8");
		GridBagConstraints gbc_lblArtikel_7 = new GridBagConstraints();
		gbc_lblArtikel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_7.gridx = 5;
		gbc_lblArtikel_7.gridy = 3;
		contentPane.add(lblArtikel_7, gbc_lblArtikel_7);
		Labels[7]=lblArtikel_7;
		
		JLabel lblArtikel_8 = new JLabel("Artikel9");
		GridBagConstraints gbc_lblArtikel_8 = new GridBagConstraints();
		gbc_lblArtikel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel_8.gridx = 7;
		gbc_lblArtikel_8.gridy = 3;
		contentPane.add(lblArtikel_8, gbc_lblArtikel_8);
		Labels[8]=lblArtikel_8;
		
		JLabel lblArtikel_9 = new JLabel("Artikel10");
		GridBagConstraints gbc_lblArtikel_9 = new GridBagConstraints();
		gbc_lblArtikel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArtikel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblArtikel_9.gridx = 9;
		gbc_lblArtikel_9.gridy = 3;
		contentPane.add(lblArtikel_9, gbc_lblArtikel_9);
		Labels[9]=lblArtikel_9;
		
		JButton btnVorherige = new JButton("vorherige");
		GridBagConstraints gbc_btnVorherige = new GridBagConstraints();
		gbc_btnVorherige.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVorherige.insets = new Insets(0, 0, 5, 5);
		gbc_btnVorherige.gridx = 1;
		gbc_btnVorherige.gridy = 5;
		contentPane.add(btnVorherige, gbc_btnVorherige);

		JButton btnNchste = new JButton("n\u00E4chste");
		btnNchste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seite++;
				anzeigen(Seite);
			}
		});
		GridBagConstraints gbc_btnNchste = new GridBagConstraints();
		gbc_btnNchste.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNchste.insets = new Insets(0, 0, 5, 0);
		gbc_btnNchste.gridx = 9;
		gbc_btnNchste.gridy = 5;
		contentPane.add(btnNchste, gbc_btnNchste);
		
		JButton btnAngebotMelden = new JButton("neues Angebot");
		GridBagConstraints gbc_btnAngebotMelden = new GridBagConstraints();
		gbc_btnAngebotMelden.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAngebotMelden.gridx = 9;
		gbc_btnAngebotMelden.gridy = 6;
		contentPane.add(btnAngebotMelden, gbc_btnAngebotMelden);
		
		anzeigen(0);
	}
	public void anzeigen(int pSeite)
	{
		pSeite = pSeite * 10;
		try
		{
			Object[][] data = ctrl.loadData(Controller.ANGEBOT);
			for(int i = 0; i < 10; i++)
				{	
					Labels[i].setText((String)data[pSeite+i][0]);
				}
		}
		catch(NullPointerException e)
		{
			System.out.print("leer");
		}
	}
}
