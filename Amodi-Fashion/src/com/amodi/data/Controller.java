package com.amodi.data;
//test
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Controller {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement prep_statement = null;
	private ResultSet resultSet = null;
	private String url, username, password;

	public static final String[] KLEIDUNGSART = { "Kleidungsart",
			"KleidungsID", "Kleidungsart", "Form" };
	public static final String[] GESCHAEFT = { "Geschaeft", "GeschaeftsID",
			"Name", "Link", "Straße", "PLZ", "Ort" };
	public static final String[] USER = { "User", "Username", "Password",
			"E-Mail", "PLZ", "Ort" };
	public static final String[] ARTIKEL = { "Artikel", "ArtikelID",
			"Geschlecht", "Marke", "Farbe", "Tags", "Stil", "", "KleidungsID" };
	public static final String[] ANGEBOT = { "Angebot", "AngebotID",
			"Startdatum", "Ablaufdatum", "Status", "Preis", "Angebotsart",
			"ArtikelID", "GeschaeftsID" };

	public Controller() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/a9691386_Amodi", "mithras",
					"Pas413839");
			statement = connect.createStatement();
			System.out.println("established");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean edit(Object primkey_value, Object changed_value,
			int changed_index, String[] relation) {
		if (relation.equals(ARTIKEL) || relation.equals(KLEIDUNGSART)
				|| relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
				|| relation.equals(USER)) {
			String query = "";

			query = "UPDATE " + relation[0] + " SET " + relation[changed_index+1]
					+ "= '" + changed_value + "' ";

			query += "WHERE " + relation[1] + "='" + primkey_value + "';";
			try {
				statement.execute(query);
				return true;
			} catch (SQLException e) {
				System.out.println(e);
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean exists(Object[] row, String[] relation) {
		String query = "SELECT * FROM ";
		query += relation[0] + " WHERE " + relation[1] + "=" + "'"
				+ (String) row[0] + "';";
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			return false;
		}
		return resultSet == null;

	}

	public Object[][] loadData(String[] relation) {
		String query = "SELECT * FROM " + relation[0];
		try {
			resultSet = statement.executeQuery(query);
			resultSet.last();
			Object[][] data = new Object[resultSet.getRow()][relation.length - 1];
			resultSet.beforeFirst();
			for (int i = 0; resultSet.next(); i++) {
				for (int j = 1; j < relation.length; j++) {
					data[i][j - 1] = resultSet.getObject(j);
				}
			}
			return data;
		} catch (SQLException e) {
			// Exception Handling
			System.out.println(e);
			return null;
		}
	}

	public boolean add(Object[] row, String[] relation) {
		if (relation.equals(ARTIKEL) || relation.equals(KLEIDUNGSART)
				|| relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
				|| relation.equals(USER)) {
			String query1 = "", query2 = "";
			if (!exists(row, relation)) {
				for (int i = 0; i < relation.length; i++) {
					if (i == 0) {
						query1 = "INSERT INTO" + relation[i] + " (";
						query2 = "VALUES (";
					} else if (i != 1) {
						query1 += relation[i];
						query2 += "'" + (String) row[i-1] + "'";
						if (i != relation.length - 1) {
							query1 += ",";
							query2 += ",";
						} else {
							query1 += ")";
							query2 += ")";
						}
					}
				}
				try {
					statement.executeQuery(query1 + query2);
					return true;
				} catch (SQLException e) {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean remove(Vector<Object> row, String[] relation) {
		if (relation.equals(ARTIKEL) || relation.equals(KLEIDUNGSART)
				|| relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
				|| relation.equals(USER)) {
			String query = "DELETE FROM ";
			query += relation[0] + " WHERE " + relation[1] + "=" + "'"
					+ (String) row.get(0) + "'" + ";";
			try {
				statement.executeQuery(query);
				return true;
			} catch (SQLException e) {
				return false;
			}

		} else {
			return false;
		}
	}
}
