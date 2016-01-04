package com.amodi.data;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AmodiDialog {
	private JTextField txtmarke, txtfarbe, txttags, txtstil, txtart, txtform;
	private JTextField txtgname, txtlink, txtgstrasse, txtgplz, txtgort;
	private JTextField txtuname, txtemail, txtuplz, txtuort;
	private JComboBox<String> cbgeschlecht, cbrang;
	private JPasswordField upw;
	private JComponent[] artikel, angebot, geschaeft, user;

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

		// Geschaeft
		txtgname = new JTextField();
		txtlink = new JTextField("http://");
		txtgstrasse = new JTextField();
		txtgplz = new JTextField();
		txtgort = new JTextField();
		geschaeft = new JComponent[] { new JLabel("Geschaeftsname:"), txtgname, new JLabel("Link:"), txtlink,
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
				values = new String[] { null, (String) cbgeschlecht.getSelectedItem(), txtmarke.getText(),
						txtfarbe.getText(), txttags.getText(), txtstil.getText(), null, txtart.getText(),
						txtform.getText() };
				break;
			case "Angebot":
				components = angebot;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				values = null;
				break;
			case "Geschaeft":
				components = geschaeft;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				values = new String[] { txtgname.getText(), txtlink.getText(), txtgstrasse.getText(), txtgplz.getText(),
						txtgort.getText() };
				break;
			case "User":
				components = user;
				i = JOptionPane.showConfirmDialog(owner, components, title, JOptionPane.OK_CANCEL_OPTION, 0, icon);
				values = new String[] { txtuname.getText(), Integer.toString(new String(upw.getPassword()).hashCode()),
						txtemail.getText(),  txtuplz.getText(),txtuort.getText(), (String) cbrang.getSelectedItem() };
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
			boolean geschlecht = values[1] == "m‰nnlich" || values[1] == "weiblich" || values[1] == "unisex";
			boolean farbe = !((String) values[3]).matches("^\\s*$") && !((String) values[3]).matches(".*\\d.*");
			boolean tags = !((String) values[4]).matches("^\\s*$");
			boolean stil = !((String) values[5]).matches("^\\s*$") && !((String) values[5]).matches(".*\\d.*");
			boolean art = !((String) values[7]).matches("^\\s*$") && !((String) values[7]).matches(".*\\d.*");
			boolean form = !((String) values[8]).matches("^\\s*$") && !((String) values[8]).matches(".*\\d.*");
			return geschlecht && farbe && tags && stil && art && form;

		case "Angebot":
			return true;
		case "Geschaeft":
			boolean name = !((String) values[0]).matches(".*\\d.*") && !((String) values[0]).matches(".*\\d.*");
			boolean ort = !((String) values[2]).matches(".*\\d.*") && !((String) values[2]).matches(".*\\d.*");
			boolean plz;
			try {
				int p = Integer.parseInt((String) values[3]);
				plz = true;
			} catch (NumberFormatException e) {
				plz = false;
			}
			return name && ort && plz;
		case "User":
			boolean rang = values[5] == "admin" || values[5] == "user";
			boolean uort = !((String) values[4]).matches(".*\\d.*");
			boolean uplz;
			try {
				int p = Integer.parseInt((String) values[3]);
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

}
