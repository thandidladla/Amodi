package com.amodi.data;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTable tblArtikel;
	private JTable tblKleidungsart;
	private JTable tblGeschaeft;
	private JTable tblUser;
	private JTable tblAngebot;
	private Controller ctrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 AdminGUI frame = new  AdminGUI();
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
	public AdminGUI() {
		ctrl = new Controller();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 510);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelArtikel = new JPanel();
		tabbedPane.addTab("Artikel        ",
				new ImageIcon( AdminGUI.class.getResource("/com/amodi/res/Jumper Filled-25.png")), panelArtikel, null);
		panelArtikel.setLayout(null);

		JScrollPane scrollPaneArtikel = new JScrollPane();
		scrollPaneArtikel.setBounds(10, 5, 579, 427);
		scrollPaneArtikel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelArtikel.add(scrollPaneArtikel);

		tblArtikel = new JTable();
		tblArtikel.setModel(new DefaultTableModel(ctrl.loadData(Controller.ARTIKEL),
				Arrays.copyOfRange(Controller.ARTIKEL, 1, Controller.ARTIKEL.length)));
		scrollPaneArtikel.setViewportView(tblArtikel);

		JPanel panelKleidungsart = new JPanel();
		tabbedPane.addTab("Kleidungsart",
				new ImageIcon( AdminGUI.class.getResource("/com/amodi/res/Barber Scissors-24.png")), panelKleidungsart,
				null);
		panelKleidungsart.setLayout(null);

		JScrollPane scrollPaneKleidungsart = new JScrollPane();
		scrollPaneKleidungsart.setBounds(10, 5, 579, 427);
		scrollPaneKleidungsart.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelKleidungsart.add(scrollPaneKleidungsart);

		tblKleidungsart = new JTable();
		tblKleidungsart.setModel(new DefaultTableModel(ctrl.loadData(Controller.KLEIDUNGSART),
				Arrays.copyOfRange(Controller.KLEIDUNGSART, 1, Controller.KLEIDUNGSART.length)));
		scrollPaneKleidungsart.setViewportView(tblKleidungsart);

		JPanel panelAngebot = new JPanel();
		tabbedPane.addTab("Angebot    ",
				new ImageIcon( AdminGUI.class.getResource("/com/amodi/res/Price Tag USD-26.png")), panelAngebot, null);
		panelAngebot.setLayout(null);

		JScrollPane scrollPaneAngebot = new JScrollPane();
		scrollPaneAngebot.setBounds(10, 5, 579, 427);
		scrollPaneAngebot.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelAngebot.add(scrollPaneAngebot);

		tblAngebot = new JTable();
		tblAngebot.setModel(new DefaultTableModel(ctrl.loadData(Controller.ANGEBOT),
				Arrays.copyOfRange(Controller.ANGEBOT, 1, Controller.ANGEBOT.length)));
		tblAngebot.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {

				ctrl.edit(tblAngebot.getValueAt(e.getLastRow(), 0),
						tblAngebot.getValueAt(e.getLastRow(), e.getColumn()), e.getColumn(), Controller.ANGEBOT);
			}
		});

		scrollPaneAngebot.setViewportView(tblAngebot);

		JPanel panelGeschaeft = new JPanel();
		tabbedPane.addTab("Gesch\u00E4ft    ", new ImageIcon( AdminGUI.class.getResource("/com/amodi/res/Shop-26.png")),
				panelGeschaeft, null);
		panelGeschaeft.setLayout(null);

		JScrollPane scrollPaneGeschaeft = new JScrollPane();
		scrollPaneGeschaeft.setBounds(10, 5, 579, 431);
		scrollPaneGeschaeft.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelGeschaeft.add(scrollPaneGeschaeft);

		tblGeschaeft = new JTable();
		tblGeschaeft.setModel(new DefaultTableModel(ctrl.loadData(Controller.GESCHAEFT),
				Arrays.copyOfRange(Controller.GESCHAEFT, 1, Controller.GESCHAEFT.length)));
		scrollPaneGeschaeft.setViewportView(tblGeschaeft);

		JPanel panelUser = new JPanel();
		tabbedPane.addTab("User            ",
				new ImageIcon( AdminGUI.class.getResource("/com/amodi/res/Manager-26.png")), panelUser, null);
		panelUser.setLayout(null);

		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(10, 5, 579, 431);
		scrollPaneUser.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelUser.add(scrollPaneUser);

		tblUser = new JTable();
		tblUser.setModel(new DefaultTableModel(ctrl.loadData(Controller.USER),
				Arrays.copyOfRange(Controller.USER, 1, Controller.USER.length)));
		scrollPaneUser.setViewportView(tblUser);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
	}
	
	private void actionPerformed_Add(Object[] row,String[] relation){
		if(!ctrl.add(row,relation)){
			JOptionPane.showMessageDialog(this, "Error: Failed adding to the database.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
