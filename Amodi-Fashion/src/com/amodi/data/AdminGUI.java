package com.amodi.data;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTabbedPane;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTable tblAngebot;
	private static Controller ctrl;
	private JTabbedPane tabbedPane;
	private JTable tblArtikel;
	private JTable tblGeschaeft;
	private JTable tblUser;

	// Array mit zugehörigen Relationen für Tab-Index
	private static final Object[] RELATIONS = { ctrl.ARTIKEL, ctrl.ANGEBOT, ctrl.GESCHAEFT, ctrl.USER };
	private JTable[] tables = new JTable[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
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
		setBounds(100, 100, 898, 509);

		// MENU-------------------------------------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
				JMenuItem mntmAdd = new JMenuItem("Add...");
				mntmAdd.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Object[] data = showAddDialog(tabbedPane.getSelectedIndex());
						if (data != null) {
							String[] relation = (String[]) RELATIONS[tabbedPane.getSelectedIndex()];
							ctrl.add(data, relation);
							refreshCurrentTable();
						}

					}
				});
				mnTools.add(mntmAdd);

		JMenuItem mntmRemove = new JMenuItem("Remove");
		mnTools.add(mntmRemove);
		mntmRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (actionPerformed_remove()) {
					refreshCurrentTable();
				} else {
					JOptionPane.showMessageDialog(null, "Failed Removing from the Server.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		JCheckBoxMenuItem mntmHidePassword = new JCheckBoxMenuItem("Hide Password");
		mntmHidePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setHiddenPassword(mntmHidePassword.isSelected());
			}
		});
		mnTools.add(mntmHidePassword);

		// HIGHEST PANES-----------------------------------------------
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// TABS-------------------------------------------------------
		// ARTIKEL
		JPanel panelArtikel = new JPanel();
		tabbedPane.addTab("Artikel        ",
				new ImageIcon(AdminGUI.class.getResource("/com/amodi/res/Jumper Filled-25.png")), panelArtikel, null);
		panelArtikel.setLayout(null);

		JScrollPane scrollPaneArtikel = new JScrollPane();
		scrollPaneArtikel.setBounds(10, 11, 743, 427);
		scrollPaneArtikel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelArtikel.add(scrollPaneArtikel);

		tblArtikel = new JTable();
		tables[0] = tblArtikel;
		tblArtikel.setModel(new DefaultTableModel(ctrl.loadData(Controller.ARTIKEL),
				Arrays.copyOfRange(Controller.ARTIKEL, 1, Controller.ARTIKEL.length)) {
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				} else {
					return true;
				}
			}
		});
		tblArtikel.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				ctrl.edit(tblArtikel.getValueAt(e.getLastRow(), 0),
						tblArtikel.getValueAt(e.getLastRow(), e.getColumn()), e.getColumn(), Controller.ARTIKEL);
			}
		});
		scrollPaneArtikel.setViewportView(tblArtikel);

		// ANGEBOT
		JPanel panelAngebot = new JPanel();
		tabbedPane.addTab("Angebot    ",
				new ImageIcon(AdminGUI.class.getResource("/com/amodi/res/Price Tag USD-26.png")), panelAngebot, null);
		panelAngebot.setLayout(null);

		JScrollPane scrollPaneAngebot = new JScrollPane();
		scrollPaneAngebot.setBounds(10, 5, 694, 427);
		scrollPaneAngebot.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelAngebot.add(scrollPaneAngebot);

		tblAngebot = new JTable();
		tables[1] = tblAngebot;
		tblAngebot.setModel(new DefaultTableModel(ctrl.loadData(Controller.ANGEBOT),
				Arrays.copyOfRange(Controller.ANGEBOT, 1, Controller.ANGEBOT.length)) {
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				} else {
					return true;
				}
			}
		});
		tblAngebot.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {

				ctrl.edit(tblAngebot.getValueAt(e.getLastRow(), 0),
						tblAngebot.getValueAt(e.getLastRow(), e.getColumn()), e.getColumn(), Controller.ANGEBOT);
			}
		});

		scrollPaneAngebot.setViewportView(tblAngebot);

		// GESCHAEFT
		JPanel panelGeschaeft = new JPanel();
		tabbedPane.addTab("Gesch\u00E4ft    ", new ImageIcon(AdminGUI.class.getResource("/com/amodi/res/Shop-26.png")),
				panelGeschaeft, null);
		panelGeschaeft.setLayout(null);

		JScrollPane scrollPaneGeschaeft = new JScrollPane();
		scrollPaneGeschaeft.setBounds(10, 5, 579, 431);
		scrollPaneGeschaeft.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelGeschaeft.add(scrollPaneGeschaeft);

		tblGeschaeft = new JTable();
		tables[2] = tblGeschaeft;
		tblGeschaeft.setModel(new DefaultTableModel(ctrl.loadData(Controller.GESCHAEFT),
				Arrays.copyOfRange(Controller.GESCHAEFT, 1, Controller.GESCHAEFT.length)) {
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				} else {
					return true;
				}
			}
		});
		tblGeschaeft.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				ctrl.edit(tblGeschaeft.getValueAt(e.getLastRow(), 0),
						tblGeschaeft.getValueAt(e.getLastRow(), e.getColumn()), e.getColumn(), Controller.GESCHAEFT);
			}
		});
		scrollPaneGeschaeft.setViewportView(tblGeschaeft);

		// USER
		JPanel panelUser = new JPanel();
		tabbedPane.addTab("User            ",
				new ImageIcon(AdminGUI.class.getResource("/com/amodi/res/Manager-26.png")), panelUser, null);
		panelUser.setLayout(null);

		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(10, 5, 579, 431);
		scrollPaneUser.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelUser.add(scrollPaneUser);

		tblUser = new JTable();
		tables[3] = tblUser;
		tblUser.setModel(new DefaultTableModel(ctrl.loadData(Controller.USER),
				Arrays.copyOfRange(Controller.USER, 1, Controller.USER.length)) {
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				} else {
					return true;
				}
			}
		});
		tblUser.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				ctrl.edit(tblUser.getValueAt(e.getLastRow(), 0), tblUser.getValueAt(e.getLastRow(), e.getColumn()),
						e.getColumn(), Controller.USER);
			}
		});
		scrollPaneUser.setViewportView(tblUser);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
	}

	protected void refreshCurrentTable() {
		String[] relation = (String[]) RELATIONS[tabbedPane.getSelectedIndex()];
		tables[tabbedPane.getSelectedIndex()].setModel(
				new DefaultTableModel(ctrl.loadData(relation), Arrays.copyOfRange(relation, 1, relation.length)));
		tables[tabbedPane.getSelectedIndex()].repaint();
	}

	private void actionPerformed_Add(Object[] row, String[] relation) {
		if (!ctrl.add(row, relation)) {
			JOptionPane.showMessageDialog(this, "Error: Failed adding to the database.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public Object[] showAddDialog(int tabIndex) {
		JComponent[] inputs;
		switch (tabIndex) {
		case 0:
			JTextField txtmarke = new JTextField();
			JTextField txtfarbe = new JTextField();
			JTextField txttags = new JTextField();
			JTextField txtstil = new JTextField();
			JTextField txtart = new JTextField();
			JTextField txtform = new JTextField();
			String[] cb_items = { "männlich", "weiblich" };
			JComboBox<String> cbgeschlecht = new JComboBox<String>(cb_items);
			inputs = new JComponent[] { new JLabel("Geschlecht:"), cbgeschlecht, new JLabel("Marke:"), txtmarke,
					new JLabel("Farbe:"), txtfarbe, new JLabel("Tags:"), txttags, new JLabel("Stil:"), txtstil,
					new JLabel("Kleidungsart:"), txtart, new JLabel("Kleidungsform:"), txtform };
			if (JOptionPane.showConfirmDialog(this, inputs, "New 'Artikel'",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				Object[] result = { null, (String) cbgeschlecht.getSelectedItem(), txtmarke.getText(),
						txtfarbe.getText(), txttags.getText(), txtstil.getText(), null, txtart.getText(),
						txtform.getText() };
				return result;
			} else {
				return null;
			}
		case 2:
			JTextField txtname = new JTextField();
			JTextField txtlink = new JTextField("http://");
			JTextField txtstrasse = new JTextField();
			JTextField txtplz = new JTextField();
			JTextField txtort = new JTextField();
			inputs = new JComponent[] { new JLabel("Geschaeftsname:"), txtname, new JLabel("Link:"), txtlink,
					new JLabel("Straße:"), txtstrasse, new JLabel("Postleihzahl:"), txtplz, new JLabel("Ort:"),
					txtort };
			if (JOptionPane.showConfirmDialog(this, inputs, "New 'Geschaeft'",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				Object[] result = { txtname.getText(), txtlink.getText(), txtstrasse.getText(), txtplz.getText(),
						txtort.getText() };
				return result;
			} else {
				return null;
			}
		case 3:
			JTextField txtuname = new JTextField();
			JPasswordField pw = new JPasswordField(12);
			JTextField txtemail = new JTextField();
			JTextField txtuplz = new JTextField();
			JTextField txtuort = new JTextField();
			inputs = new JComponent[] { new JLabel("Username:"), txtuname, new JLabel("Password:"), pw,
					new JLabel("Email:"), txtemail, new JLabel("Postleihzahl:"), txtuplz, new JLabel("Ort:"), txtuort };
			if (JOptionPane.showConfirmDialog(this, inputs, "New 'User'",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				Object[] result = { txtuname.getText(), new String(pw.getPassword()), txtemail.getText(),
						txtuplz.getText(), txtuort.getText() };
				return result;
			} else {
				return null;
			}
		default:
			return null;

		}

	}

	public boolean actionPerformed_remove() {
		JTable current = tables[tabbedPane.getSelectedIndex()];
		if (current.getSelectedRowCount() > 0) {
			if (JOptionPane.showConfirmDialog(this,
					"Do you really want to delete the chosen rows?") == JOptionPane.YES_OPTION) {
				for (int i : current.getSelectedRows()) {
					if (ctrl.remove(getRow(current, i), (String[]) RELATIONS[tabbedPane.getSelectedIndex()])) {
						continue;
					} else {
						return false;
					}
				}
				return true;
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Gets row from JTable by index.
	 * 
	 * @param table
	 *            - JTable to get row from
	 * @param index
	 *            - Index of row
	 * @return Object[] with row data, if JTable is not null and index is
	 *         between 0 and row count.
	 */
	private Object[] getRow(JTable table, int index) {
		if (table != null && index >= 0 && index <= table.getRowCount()) {
			Object[] row = new Object[table.getColumnCount()];
			for (int i = 0; i < table.getColumnCount(); i++) {
				row[i] = table.getValueAt(index, i);
			}
			return row;
		} else {
			return null;
		}
	}

	public void setHiddenPassword(boolean hidden) {
		if (hidden) {
			JPasswordField pwf = new JPasswordField();
			DefaultCellEditor editor = new DefaultCellEditor(pwf);
			tblUser.getColumnModel().getColumn(2).setCellEditor(editor);
			tblUser.repaint();
		} else {
			tblUser.getColumnModel().getColumn(2).setCellEditor(null);
			tblUser.repaint();
		}
	}
}
