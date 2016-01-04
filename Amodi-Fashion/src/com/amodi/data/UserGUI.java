package com.amodi.data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private Controller ctrl = new Controller();
	private JLabel[] Labels  = new JLabel[10];
	private int Seite = 0;
	private JTextField txtAngebot;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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
		setBounds(100, 100, 806, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 789, 477);
		contentPane.add(tabbedPane);
		
		JPanel panel_offers = new JPanel();
		tabbedPane.addTab("Angebote", null, panel_offers, null);
		tabbedPane.setEnabledAt(0, true);
		
		panel_offers.setBackground(SystemColor.control);
		panel_offers.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		GridBagLayout gbl_panel_offers = new GridBagLayout();
		gbl_panel_offers.columnWidths = new int[] {5, 100, 5, 100, 5, 100, 5, 100, 5, 135, 30};
		gbl_panel_offers.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_offers.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_offers.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_offers.setLayout(gbl_panel_offers);
		
		JLabel lblAngebot_0 = new JLabel("A1");
		GridBagConstraints gbc_lblAngebot_0 = new GridBagConstraints();
		gbc_lblAngebot_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_0.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_0.gridx = 1;
		gbc_lblAngebot_0.gridy = 1;
		panel_offers.add(lblAngebot_0, gbc_lblAngebot_0);
		Labels[0]=lblAngebot_0;
		
		JLabel lblAngebot_1 = new JLabel("A2");
		GridBagConstraints gbc_lblAngebot_1 = new GridBagConstraints();
		gbc_lblAngebot_1.anchor = GridBagConstraints.NORTH;
		gbc_lblAngebot_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_1.gridx = 3;
		gbc_lblAngebot_1.gridy = 1;
		panel_offers.add(lblAngebot_1, gbc_lblAngebot_1);
		Labels[1]=lblAngebot_1;
		
		JLabel lblAngebot_2 = new JLabel("A3");
		GridBagConstraints gbc_lblAngebot_2 = new GridBagConstraints();
		gbc_lblAngebot_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_2.gridx = 5;
		gbc_lblAngebot_2.gridy = 1;
		panel_offers.add(lblAngebot_2, gbc_lblAngebot_2);
		Labels[2]=lblAngebot_2;
		
		JLabel lblAngebot_3 = new JLabel("A4");
		GridBagConstraints gbc_lblAngebot_3 = new GridBagConstraints();
		gbc_lblAngebot_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_3.gridx = 7;
		gbc_lblAngebot_3.gridy = 1;
		panel_offers.add(lblAngebot_3, gbc_lblAngebot_3);
		Labels[3]=lblAngebot_3;
		
		JLabel lblAngebot_4 = new JLabel("A5");
		GridBagConstraints gbc_lblAngebot_4 = new GridBagConstraints();
		gbc_lblAngebot_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_4.gridx = 9;
		gbc_lblAngebot_4.gridy = 1;
		panel_offers.add(lblAngebot_4, gbc_lblAngebot_4);
		Labels[4]=lblAngebot_4;
		
		JLabel lblAngebot_5 = new JLabel("A6");
		lblAngebot_5.setBackground(SystemColor.window);
		GridBagConstraints gbc_lblAngebot_5 = new GridBagConstraints();
		gbc_lblAngebot_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_5.gridx = 1;
		gbc_lblAngebot_5.gridy = 3;
		panel_offers.add(lblAngebot_5, gbc_lblAngebot_5);
		Labels[5]=lblAngebot_5;
		
		JLabel lblAngebot_6 = new JLabel("A7");
		GridBagConstraints gbc_lblAngebot_6 = new GridBagConstraints();
		gbc_lblAngebot_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_6.gridx = 3;
		gbc_lblAngebot_6.gridy = 3;
		panel_offers.add(lblAngebot_6, gbc_lblAngebot_6);
		Labels[6]=lblAngebot_6;
		
		JLabel lblAngebot_7 = new JLabel("A8");
		GridBagConstraints gbc_lblAngebot_7 = new GridBagConstraints();
		gbc_lblAngebot_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_7.gridx = 5;
		gbc_lblAngebot_7.gridy = 3;
		panel_offers.add(lblAngebot_7, gbc_lblAngebot_7);
		Labels[7]=lblAngebot_7;
		
		JLabel lblAngebot_8 = new JLabel("A9");
		GridBagConstraints gbc_lblAngebot_8 = new GridBagConstraints();
		gbc_lblAngebot_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_8.gridx = 7;
		gbc_lblAngebot_8.gridy = 3;
		panel_offers.add(lblAngebot_8, gbc_lblAngebot_8);
		Labels[8]=lblAngebot_8;
		
		JLabel lblAngebot_9 = new JLabel("A10");
		GridBagConstraints gbc_lblAngebot_9 = new GridBagConstraints();
		gbc_lblAngebot_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAngebot_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot_9.gridx = 9;
		gbc_lblAngebot_9.gridy = 3;
		panel_offers.add(lblAngebot_9, gbc_lblAngebot_9);
		Labels[9]=lblAngebot_9;
		
		JButton btnVorherige = new JButton("vorherige");
		GridBagConstraints gbc_btnVorherige = new GridBagConstraints();
		gbc_btnVorherige.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVorherige.insets = new Insets(0, 0, 5, 5);
		gbc_btnVorherige.gridx = 1;
		gbc_btnVorherige.gridy = 5;
		panel_offers.add(btnVorherige, gbc_btnVorherige);

		JButton btnNchste = new JButton("n\u00E4chste");
		btnNchste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seite++;
				anzeigen(Seite);
			}
		});
		GridBagConstraints gbc_btnNchste = new GridBagConstraints();
		gbc_btnNchste.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNchste.insets = new Insets(0, 0, 5, 5);
		gbc_btnNchste.gridx = 9;
		gbc_btnNchste.gridy = 5;
		panel_offers.add(btnNchste, gbc_btnNchste);
		
		JPanel panel_add = new JPanel();
		tabbedPane.addTab("Angebot eintragen", null, panel_add, null);
		GridBagLayout gbl_panel_add = new GridBagLayout();
		gbl_panel_add.columnWidths = new int[]{0, 0, 0, 20, 0};
		gbl_panel_add.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_add.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_add.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_add.setLayout(gbl_panel_add);
		
		JLabel lblAngebot = new JLabel("Angebot");
		GridBagConstraints gbc_lblAngebot = new GridBagConstraints();
		gbc_lblAngebot.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot.gridx = 1;
		gbc_lblAngebot.gridy = 1;
		panel_add.add(lblAngebot, gbc_lblAngebot);
		
		txtAngebot = new JTextField();
		GridBagConstraints gbc_txtAngebot = new GridBagConstraints();
		gbc_txtAngebot.anchor = GridBagConstraints.WEST;
		gbc_txtAngebot.insets = new Insets(0, 0, 5, 0);
		gbc_txtAngebot.gridx = 3;
		gbc_txtAngebot.gridy = 1;
		panel_add.add(txtAngebot, gbc_txtAngebot);
		txtAngebot.setColumns(10);
		
		JLabel lblArtikel = new JLabel("Artikel");
		GridBagConstraints gbc_lblArtikel = new GridBagConstraints();
		gbc_lblArtikel.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikel.gridx = 1;
		gbc_lblArtikel.gridy = 3;
		panel_add.add(lblArtikel, gbc_lblArtikel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		panel_add.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblGltigBis = new JLabel("G\u00FCltig bis:");
		GridBagConstraints gbc_lblGltigBis = new GridBagConstraints();
		gbc_lblGltigBis.insets = new Insets(0, 0, 5, 5);
		gbc_lblGltigBis.gridx = 1;
		gbc_lblGltigBis.gridy = 5;
		panel_add.add(lblGltigBis, gbc_lblGltigBis);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		panel_add.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPreis = new JLabel("Preis");
		GridBagConstraints gbc_lblPreis = new GridBagConstraints();
		gbc_lblPreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreis.gridx = 1;
		gbc_lblPreis.gridy = 7;
		panel_add.add(lblPreis, gbc_lblPreis);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 7;
		panel_add.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAngebotsart = new JLabel("Angebotsart");
		GridBagConstraints gbc_lblAngebotsart = new GridBagConstraints();
		gbc_lblAngebotsart.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebotsart.gridx = 1;
		gbc_lblAngebotsart.gridy = 9;
		panel_add.add(lblAngebotsart, gbc_lblAngebotsart);
		
		JLabel lblGeschaeft = new JLabel("Geschaeft");
		GridBagConstraints gbc_lblGeschaeft = new GridBagConstraints();
		gbc_lblGeschaeft.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeschaeft.gridx = 1;
		gbc_lblGeschaeft.gridy = 11;
		panel_add.add(lblGeschaeft, gbc_lblGeschaeft);
		
		JButton btnEintragen = new JButton("Eintragen");
		GridBagConstraints gbc_btnEintragen = new GridBagConstraints();
		gbc_btnEintragen.gridx = 3;
		gbc_btnEintragen.gridy = 13;
		panel_add.add(btnEintragen, gbc_btnEintragen);
		
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

