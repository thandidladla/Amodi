package com.amodi.data;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddDialog {
	private JTextField txtmarke, txtfarbe, txttags, txtstil, txtart, txtform;
	private JTextField txtgname, txtlink, txtgstrasse, txtgplz, txtgort;
	private JTextField txtuname, txtemail, txtuplz, txtuort;
	private JComboBox<String> cbgeschlecht, cbrang;
	JPasswordField upw;
	private JComponent[] artikel, angebot, geschaeft, user;

	public AddDialog() {
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

	public Object[] showArtikelDialog(JFrame owner) {
		int i;
		boolean b;
		do {
			i = JOptionPane.showConfirmDialog(owner, artikel, "New 'Artikel'", JOptionPane.OK_CANCEL_OPTION, 0,
					new ImageIcon(AddDialog.class.getResource("/com/amodi/res/Jumper Filled-25.png")));
			String[] values = new String[]{(String)cbgeschlecht.getSelectedItem(),txtfarbe.getText(),txttags.getText(),txtstil.getText(),txtart.getText(),txtform.getText()};
			if (b = checkArtikel(values)) {
				blankArtikel();
				return new Object[] { null, (String) cbgeschlecht.getSelectedItem(), txtmarke.getText(),
						txtfarbe.getText(), txttags.getText(), txtstil.getText(), null, txtart.getText(),
						txtform.getText() };
			} else {
				JOptionPane.showMessageDialog(owner, "Invalid data!");
			}

		} while (i == JOptionPane.OK_OPTION && !b);
		return null;
	}

	public Object[] showAngebotDialog() {
		return null;
	}

	public Object[] showGeschaeftDialog(JFrame owner) {
		int i;
		boolean b;
		do {
			i = JOptionPane.showConfirmDialog(owner, geschaeft, "New 'Geschaeft'", JOptionPane.OK_CANCEL_OPTION, 0,
					new ImageIcon(AddDialog.class.getResource("/com/amodi/res/Manager-26.png")));
			if (b = checkGeschaeft()) {
				blankGeschaeft();
				return new Object[] { txtgname.getText(), txtlink.getText(), txtgstrasse.getText(), txtgplz.getText(),
						txtgort.getText() };
			} else {
				JOptionPane.showMessageDialog(owner, "Invalid data!");
			}

		} while (i == JOptionPane.OK_OPTION && !b);
		return null;
	}

	public Object[] showUserDialog(JFrame owner) {
		int i;
		boolean b;
		do {
			i = JOptionPane.showConfirmDialog(owner, user, "New 'User'", JOptionPane.OK_CANCEL_OPTION, 0,
					new ImageIcon(AddDialog.class.getResource("/com/amodi/res/Manager-26.png")));
			if (b = checkUser()) {
				blankUser();
				return new Object[] { txtuname.getText(), Integer.toString(new String(upw.getPassword()).hashCode()),
						txtemail.getText(), txtuplz.getText(), txtuort.getText(), (String) cbrang.getSelectedItem() };
			} else {
				JOptionPane.showMessageDialog(owner, "Invalid data!");
			}

		} while (i == JOptionPane.OK_OPTION && !b);
		return null;
	}

	public boolean checkArtikel(String[] values) {
		boolean geschlecht = values[0] == "m‰nnlich"
				|| values[0] == "weiblich" || values[0] == "unisex";
		boolean farbe = !values[1].matches(".*\\d.*") && !values[1].matches(".*\\d.*");
		boolean tags = !values[2].matches("^\\s*$");
		boolean stil = !values[3].matches("^\\s*$") && !values[3].matches(".*\\d.*");
		boolean art = !values[4].matches("^\\s*$") && !values[4].matches(".*\\d.*");
		boolean form = !values[4].matches("^\\s*$") && !values[4].matches(".*\\d.*");
		return geschlecht && farbe && tags && stil && art && form;
	}

	private boolean checkAngebot(String[] values) {
		return true;
	}

	private boolean checkGeschaeft(String[] values) {
		boolean name = !txtgname.getText().matches(".*\\d.*") && !txtgname.getText().matches(".*\\d.*");
		boolean ort = !txtgort.getText().matches(".*\\d.*") && !txtgort.getText().matches(".*\\d.*");
		boolean plz;
		try {
			int p = Integer.parseInt(txtgplz.getText());
			plz = true;
		} catch (NumberFormatException e) {
			plz = false;
		}
		return name && ort && plz;
	}

	private boolean checkUser(String[] values) {
		boolean rang = cbrang.getSelectedItem() == "admin" || cbrang.getSelectedItem() == "user";
		boolean ort = !txtuort.getText().matches(".*\\d.*") && !txtuort.getText().matches(".*\\d.*");
		boolean plz;
		try {
			int p = Integer.parseInt(txtuplz.getText());
			plz = true;
		} catch (NumberFormatException e) {
			plz = false;
		}
		return rang && ort && plz;
	}

	private void blankArtikel() {
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

	}

	private void blankGeschaeft() {
		txtgname = new JTextField();
		txtlink = new JTextField("http://");
		txtgstrasse = new JTextField();
		txtgplz = new JTextField();
		txtgort = new JTextField();
		geschaeft = new JComponent[] { new JLabel("Geschaeftsname:"), txtgname, new JLabel("Link:"), txtlink,
				new JLabel("Straﬂe:"), txtgstrasse, new JLabel("Postleihzahl:"), txtgplz, new JLabel("Ort:"), txtgort };
	}

	private void blankUser() {
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

	private void blankAngebot() {

	}
}
