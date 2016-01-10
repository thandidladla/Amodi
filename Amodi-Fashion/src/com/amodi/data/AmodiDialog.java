package com.amodi.data;

import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit.CopyAction;

public class AmodiDialog {
	private JTextField txtmarke, txtfarbe, txttags, txtstil, txtart, txtform;
	private JTextField txtgname, txtlink, txtgstrasse, txtgplz, txtgort;
	private JTextField txtuname, txtemail, txtuplz, txtuort;
	private JTextField txtstatus, txtpreis, txtaart, txtstart, txtend;
	private JComboBox<String> cbgeschlecht, cbrang;
	private JPasswordField upw;
	private JComponent[] artikel, angebot, geschaeft, user;
	private JTable artikelTable, geschaeftTable;

	public AmodiDialog() {
		initialize();
	}

	private void initialize() {

		// Artikel
		txtmarke = new JTextField();
		txtfarbe = new JTextField();
		txttags = new JTextField();
		txtstil = new JTextField();
		txtart = new JTextField();
		txtform = new JTextField();
		String[] cb_items = { "m‰nnlich", "weiblich", "unisex" };
		cbgeschlecht = new JComboBox<String>(cb_items);
		artikel = new JComponent[] { new JLabel("Geschlecht:"), cbgeschlecht, new JLabel("Marke:"), txtmarke,
				new JLabel("Farbe:"), txtfarbe, new JLabel("Tags:"), txttags, new JLabel("Stil:"), txtstil,
				new JLabel("Kleidungsart:"), txtart, new JLabel("Kleidungsform:"), txtform };

		// Angebot
		txtstatus = new JTextField();
		txtpreis = new JTextField();
		txtaart = new JTextField();
		txtstart = new JTextField("yyy-mm-dd");
		txtend = new JTextField("yyy-mm-dd");
		angebot = new JComponent[] { new JLabel("Startdatum:"), txtstart, new JLabel("Enddatum:"), txtend,
				new JLabel("Status:"), txtstatus, new JLabel("Preis:"), txtpreis, new JLabel("Angebotsart:"), txtaart };

		// Geschaeft
		txtgname = new JTextField();
		txtlink = new JTextField("http://");
		txtgstrasse = new JTextField();
		txtgplz = new JTextField();
		txtgort = new JTextField();
		geschaeft = new JComponent[] { null, new JLabel("Geschaeftsname:"), txtgname, new JLabel("Link:"), txtlink,
				new JLabel("Straﬂe:"), txtgstrasse, new JLabel("Postleihzahl:"), txtgplz, new JLabel("Ort:"), txtgort };

		// User
		txtuname = new JTextField();
		upw = new JPasswordField(12);
		txtemail = new JTextField();
		txtuplz = new JTextField();
		txtuort = new JTextField();
		String[] cb2_items = { "user", "admin" };
		cbrang = new JComboBox<String>(cb2_items);
		user = new JComponent[] { new JLabel("Username:"), txtuname, new JLabel("Password:"), upw, new JLabel("Email:"),
				txtemail, new JLabel("Postleihzahl:"), txtuplz, new JLabel("Ort:"), txtuort, new JLabel("Rang:"),
				cbrang };
	}

	public Object[] showAmodiDialog(JFrame owner, String title, String relation, Icon icon) {
		int i = -100000;
		boolean b;
		JComponent[] components = null;
		String[] values = null;
		do {
			switch (relation) {
			case "Artikel":
				components = artikel;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				if (i != JOptionPane.OK_OPTION) {
					return null;
				}
				values = new String[] { null, (String) cbgeschlecht.getSelectedItem(), txtmarke.getText(),
						txtfarbe.getText(), txttags.getText(), txtstil.getText(), null, txtart.getText(),
						txtform.getText() };
				break;
			case "Angebot":
				components = angebot;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				if (i != JOptionPane.OK_OPTION) {
					return null;
				}
				Integer aid = showSelectionDialog(owner, this.artikelTable, "Artikel", icon);
				if (aid == -2) {
					return null;
				}
				Integer gid = showSelectionDialog(owner, this.geschaeftTable, "Gesch‰ft", icon);
				if (gid == -2) {
					return null;
				}
				values = new String[] {null, txtstart.getText(), txtend.getText(), txtstatus.getText(), txtpreis.getText(),
						txtaart.getText(), aid.toString(), gid.toString() };
				break;
			case "Geschaeft":
				components = geschaeft;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				if (i != JOptionPane.OK_OPTION) {
					return null;
				}
				values = new String[] { null, txtgname.getText(), txtlink.getText(), txtgstrasse.getText(),
						txtgplz.getText(), txtgort.getText() };
				break;
			case "User":
				components = user;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				if (i != JOptionPane.OK_OPTION) {
					return null;
				}
				values = new String[] { txtuname.getText(), Integer.toString(new String(upw.getPassword()).hashCode()),
						txtemail.getText(), txtuplz.getText(), txtuort.getText(), (String) cbrang.getSelectedItem() };
				break;
			}

			if (b = checkValues(values, relation) && i == JOptionPane.OK_OPTION) {
				blankDialog(relation);
				return values;
			} else if (i == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(owner, "Invalid data!");
			}

		} while (i == JOptionPane.OK_OPTION && !b);
		return null;
	}

	public boolean checkValues(Object[] values, String relation) {
		switch (relation) {
		case "Artikel":
			boolean geschlecht = values[1].equals("m‰nnlich") || values[1].equals("weiblich")
					|| values[1].equals("unisex");
			boolean farbe = !((String) values[3]).matches(".*\\s+.*") && !((String) values[3]).matches(".*\\d.*");
			boolean tags = !((String) values[4]).matches(".*\\s+.*");
			boolean stil = !((String) values[5]).matches(".*\\s+.*") && !((String) values[5]).matches(".*\\d.*");
			boolean art = !((String) values[7]).matches(".*\\s+.*") && !((String) values[7]).matches(".*\\d.*");
			boolean form = !((String) values[8]).matches(".*\\s+.*") && !((String) values[8]).matches(".*\\d.*");
			return geschlecht && farbe && tags && stil && art && form;

		case "Angebot":
			boolean dates = false;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try {
				sdf.parse(values[1].toString());
				sdf.parse(values[2].toString());
				dates = true;
			} catch (ParseException e) {
				return false;
			}
			boolean status = !((String) values[3]).matches(".*\\s+.*") && !((String) values[3]).matches(".*\\d.*");
			boolean preis = false;
			try {
				double p = Double.parseDouble(values[4].toString());
				preis = true;
			} catch (NumberFormatException e) {
				return false;
			}
			boolean ids = !values[6].toString().equals("-1") && !values[7].toString().equals("-1");
			return status && ids;
		case "Geschaeft":
			boolean name = !((String) values[1]).matches(".*\\d.*") && !((String) values[1]).matches(".*\\d.*");
			boolean ort = !((String) values[5]).matches(".*\\d.*") && !((String) values[5]).matches(".*\\d.*");
			boolean plz;
			try {
				int p = Integer.parseInt(values[4].toString());
				plz = true;
			} catch (NumberFormatException e) {
				plz = false;
			}
			return name && ort && plz;
		case "User":
			boolean rang = values[5].equals("admin") || values[5].equals("user");
			boolean uort = !((String) values[4]).matches(".*\\d.*");
			boolean uplz;
			try {
				int p = Integer.parseInt(values[3].toString());
				uplz = true;
			} catch (NumberFormatException e) {
				uplz = false;
			}
			return rang && uort && uplz;
		default:
			return false;
		}
	}

	private void blankDialog(String relation) {
		switch (relation) {
		case "Artikel":
			txtmarke = new JTextField();
			txtfarbe = new JTextField();
			txttags = new JTextField();
			txtstil = new JTextField();
			txtart = new JTextField();
			txtform = new JTextField();
			String[] cb_items = { "m‰nnlich", "weiblich", "unisex" };
			cbgeschlecht = new JComboBox<String>(cb_items);
			artikel = new JComponent[] { new JLabel("Geschlecht:"), cbgeschlecht, new JLabel("Marke:"), txtmarke,
					new JLabel("Farbe:"), txtfarbe, new JLabel("Tags:"), txttags, new JLabel("Stil:"), txtstil,
					new JLabel("Kleidungsart:"), txtart, new JLabel("Kleidungsform:"), txtform };
			break;
		case "Angebot":
			break;
		case "Geschaeft":
			txtgname = new JTextField();
			txtlink = new JTextField("http://");
			txtgstrasse = new JTextField();
			txtgplz = new JTextField();
			txtgort = new JTextField();
			geschaeft = new JComponent[] { new JLabel("Geschaeftsname:"), txtgname, new JLabel("Link:"), txtlink,
					new JLabel("Straﬂe:"), txtgstrasse, new JLabel("Postleihzahl:"), txtgplz, new JLabel("Ort:"),
					txtgort };
			break;
		case "User":
			txtuname = new JTextField();
			upw = new JPasswordField(12);
			txtemail = new JTextField();
			txtuplz = new JTextField();
			txtuort = new JTextField();
			String[] cb2_items = { "user", "admin" };
			cbrang = new JComboBox<String>(cb2_items);
			user = new JComponent[] { new JLabel("Username:"), txtuname, new JLabel("Password:"), upw,
					new JLabel("Email:"), txtemail, new JLabel("Postleihzahl:"), txtuplz, new JLabel("Ort:"), txtuort,
					new JLabel("Rang:"), cbrang };
			break;
		}

	}

	public void setArtikelTable(JTable table) {
		this.artikelTable = table;
	}

	public void setGeschaeftID(JTable table) {
		this.geschaeftTable = table;
	}

	public Integer showSelectionDialog(JFrame parent, JTable table, String name, Icon icon) {
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JComponent[] items = new JComponent[] { new JLabel("Select " + name + ":"), table };
		if (JOptionPane.showConfirmDialog(parent, items, name, JOptionPane.OK_CANCEL_OPTION, 0,
				icon) == JOptionPane.OK_OPTION) {
			int index = table.getSelectedRow();
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			if (index != -1) {
				return (int) table.getValueAt(index, 0);
			} else {
				return -1;
			}

		} else

		{
			return -2;
		}
	}

	public Object[] showSignUpDialog(JRootPane owner, String title, Icon icon) {
		JComponent[] components;
		int i;
		boolean b;
		do {
			components = Arrays.copyOfRange(user, 0, user.length - 2);
			i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
			if (i != JOptionPane.OK_OPTION) {
				return null;
			}
			String[] values = new String[] { txtuname.getText(),
					Integer.toString(new String(upw.getPassword()).hashCode()), txtemail.getText(), txtuplz.getText(),
					txtuort.getText(),"user" };
			if (b = checkValues(values, "User") && i == JOptionPane.OK_OPTION) {
				blankDialog("User");
				return values;
			} else if (i == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(owner, "Invalid data!");
			}

		} while (i == JOptionPane.OK_OPTION && !b);
		return null;
	}
	
	public File[] showPictureChooser(JRootPane owner){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Bilder", "gif","png","jpg");
		JFileChooser chooser = new JFileChooser("Choose pictures...");
		chooser.setMultiSelectionEnabled(true);
		chooser.setFileFilter(filter);
		if(chooser.showOpenDialog(owner)==JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFiles();
		}
		return null;
	}
}
