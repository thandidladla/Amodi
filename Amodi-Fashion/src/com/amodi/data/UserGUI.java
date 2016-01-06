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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComponent;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private Controller ctrl = new Controller();
	private JLabel[] Labels  = new JLabel[10];
	private int Seite = 0;
	private JTextField txtAngebot;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtmarke;
	private JTextField txtfarbe;
	private JTextField txttags;
	private JTextField txtstil;
	private JTextField txtart;
	private JTextField txtform;
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
		anzeigen(0);
		
		/*TAB ANGEBOT EINTRAGEN*/
		JPanel panel_addArt = new JPanel();
		tabbedPane.addTab("Artikel hinzuf\u00FCgen", null, panel_addArt, null);
		GridBagLayout gbl_panel_addArt = new GridBagLayout();
		gbl_panel_addArt.columnWidths = new int[]{30, 100, 30, 100, 30, 0, 0};
		gbl_panel_addArt.rowHeights = new int[]{30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gbl_panel_addArt.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_addArt.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_addArt.setLayout(gbl_panel_addArt);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht:");
		GridBagConstraints gbc_lblGeschlecht = new GridBagConstraints();
		gbc_lblGeschlecht.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeschlecht.gridx = 1;
		gbc_lblGeschlecht.gridy = 1;
		panel_addArt.add(lblGeschlecht, gbc_lblGeschlecht);
		
		String[] cb_items = { "männlich", "weiblich", "unisex" };
		JComboBox comboBox = new JComboBox(cb_items);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel_addArt.add(comboBox, gbc_comboBox);
		
		JLabel lblMarke = new JLabel("Marke:");
		GridBagConstraints gbc_lblMarke = new GridBagConstraints();
		gbc_lblMarke.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarke.gridx = 1;
		gbc_lblMarke.gridy = 3;
		panel_addArt.add(lblMarke, gbc_lblMarke);
		
		txtmarke = new JTextField();
		GridBagConstraints gbc_txtmarke = new GridBagConstraints();
		gbc_txtmarke.insets = new Insets(0, 0, 5, 5);
		gbc_txtmarke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmarke.gridx = 3;
		gbc_txtmarke.gridy = 3;
		panel_addArt.add(txtmarke, gbc_txtmarke);
		txtmarke.setColumns(10);
		
		JLabel lblFarbe = new JLabel("Farbe:");
		GridBagConstraints gbc_lblFarbe = new GridBagConstraints();
		gbc_lblFarbe.insets = new Insets(0, 0, 5, 5);
		gbc_lblFarbe.gridx = 1;
		gbc_lblFarbe.gridy = 5;
		panel_addArt.add(lblFarbe, gbc_lblFarbe);
		
		txtfarbe = new JTextField();
		GridBagConstraints gbc_txtfarbe = new GridBagConstraints();
		gbc_txtfarbe.insets = new Insets(0, 0, 5, 5);
		gbc_txtfarbe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfarbe.gridx = 3;
		gbc_txtfarbe.gridy = 5;
		panel_addArt.add(txtfarbe, gbc_txtfarbe);
		txtfarbe.setColumns(10);
		
		JLabel lblTags = new JLabel("Tags:");
		GridBagConstraints gbc_lblTags = new GridBagConstraints();
		gbc_lblTags.insets = new Insets(0, 0, 5, 5);
		gbc_lblTags.gridx = 1;
		gbc_lblTags.gridy = 7;
		panel_addArt.add(lblTags, gbc_lblTags);
		
		txttags = new JTextField();
		GridBagConstraints gbc_txttags = new GridBagConstraints();
		gbc_txttags.anchor = GridBagConstraints.NORTH;
		gbc_txttags.insets = new Insets(0, 0, 5, 5);
		gbc_txttags.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttags.gridx = 3;
		gbc_txttags.gridy = 7;
		panel_addArt.add(txttags, gbc_txttags);
		txttags.setColumns(10);
		
		JLabel lblStil = new JLabel("Stil:");
		GridBagConstraints gbc_lblStil = new GridBagConstraints();
		gbc_lblStil.insets = new Insets(0, 0, 5, 5);
		gbc_lblStil.gridx = 1;
		gbc_lblStil.gridy = 9;
		panel_addArt.add(lblStil, gbc_lblStil);
		
		txtstil = new JTextField();
		GridBagConstraints gbc_txtstil = new GridBagConstraints();
		gbc_txtstil.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtstil.anchor = GridBagConstraints.NORTH;
		gbc_txtstil.insets = new Insets(0, 0, 5, 5);
		gbc_txtstil.gridx = 3;
		gbc_txtstil.gridy = 9;
		panel_addArt.add(txtstil, gbc_txtstil);
		txtstil.setColumns(10);
		
		JLabel lblArt = new JLabel("Art:");
		GridBagConstraints gbc_lblArt = new GridBagConstraints();
		gbc_lblArt.insets = new Insets(0, 0, 5, 5);
		gbc_lblArt.gridx = 1;
		gbc_lblArt.gridy = 11;
		panel_addArt.add(lblArt, gbc_lblArt);
		
		txtart = new JTextField();
		GridBagConstraints gbc_txtart = new GridBagConstraints();
		gbc_txtart.anchor = GridBagConstraints.NORTH;
		gbc_txtart.insets = new Insets(0, 0, 5, 5);
		gbc_txtart.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtart.gridx = 3;
		gbc_txtart.gridy = 11;
		panel_addArt.add(txtart, gbc_txtart);
		txtart.setColumns(10);
		
		JLabel lblForm = new JLabel("Form:");
		GridBagConstraints gbc_lblForm = new GridBagConstraints();
		gbc_lblForm.insets = new Insets(0, 0, 0, 5);
		gbc_lblForm.gridx = 1;
		gbc_lblForm.gridy = 13;
		panel_addArt.add(lblForm, gbc_lblForm);
		
		txtform = new JTextField();
		GridBagConstraints gbc_txtform = new GridBagConstraints();
		gbc_txtform.insets = new Insets(0, 0, 0, 5);
		gbc_txtform.anchor = GridBagConstraints.NORTH;
		gbc_txtform.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtform.gridx = 3;
		gbc_txtform.gridy = 13;
		panel_addArt.add(txtform, gbc_txtform);
		txtform.setColumns(10);
		
		JButton btnArtikeladd = new JButton("hinzuf\u00FCgen");
		btnArtikeladd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] result = { null, (String) comboBox.getSelectedItem(), txtmarke.getText(),
						txtfarbe.getText(), txttags.getText(), txtstil.getText(), null, txtart.getText(),
						txtform.getText() };
				ctrl.add(result, Controller.ANGEBOT);
			}
		});
		GridBagConstraints gbc_btnArtikeladd = new GridBagConstraints();
		gbc_btnArtikeladd.gridx = 5;
		gbc_btnArtikeladd.gridy = 13;
		panel_addArt.add(btnArtikeladd, gbc_btnArtikeladd);
		
		JPanel panel_addAng = new JPanel();
		tabbedPane.addTab("Angebot eintragen", null, panel_addAng, null);


		
		
		
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

