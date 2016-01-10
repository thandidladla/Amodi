package com.amodi.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSetMetaData;

public class Controller {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private String url, username, password;
	boolean connected;

	// String constants with information of the relations <Name of
	// Relation>,<attribute1>,<attribute2>...
	// public static final String[] KLEIDUNGSART = { "Kleidungsart",
	// "KleidungsID", "Kleidungsart", "Form" };
	public final String[] GESCHAEFT;
	public final String[] USER;
	public final String[] ARTIKEL;
	public final String[] ANGEBOT;

	public Controller() {
		if(connect()){
			GESCHAEFT = getRelation("Geschaeft");
			USER = getRelation("User");
			ARTIKEL = getRelation("Artikel");
			ANGEBOT = getRelation("Angebot");
		}else{
			GESCHAEFT = null;
			USER = null;
			ARTIKEL = null;
			ANGEBOT = null;
		}
	}

	/**
	 * Commits new changes made in a relation.
	 * 
	 * @param primkey_value
	 *            - The primary key of the involved dataset
	 * @param changed_value
	 *            - The attribute of the dataset, which changed
	 * @param changed_index
	 *            - The index of the attribute which changed
	 * @param relation
	 *            - The relation of the dataset
	 * @return true, if the change was commited successfully
	 */
	public boolean edit(Object primkey_value, Object changed_value, int changed_index, String[] relation) {
		if (relation.equals(ARTIKEL) || relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
				|| relation.equals(USER)) {
			String query = "";

			query = "UPDATE " + relation[0] + " SET " + relation[changed_index + 1] + "= '" + changed_value + "' ";

			query += "WHERE " + relation[1] + "='" + primkey_value + "';";
			try {
				return !statement.execute(query);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if the given row is a dataset in the relation.
	 * 
	 * @param row
	 *            - The dataset to check
	 * @param relation
	 *            - The relation of the dataset
	 * @return
	 */
	public boolean exists(Object[] row, String[] relation) {
		String query = "SELECT * FROM ";
		query += relation[0] + " WHERE " + relation[1] + "=" + "'" + (String) row[0] + "';";
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			return false;
		}
		return resultSet == null;

	}

	/**
	 * Loads all datasets of the relation.
	 * 
	 * @param relation
	 *            - Relation to load
	 * @return Object[][] with relation-data if successful
	 * @return null if loading fails
	 */
	public Object[][] loadData(String[] relation) {
		String query = "SELECT * FROM " + relation[0];
		try {
			return executeQuery(query);
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Adds a dataset to the given relation.
	 * 
	 * @param row
	 *            - Dataset to add
	 * @param relation
	 *            - Involved relation.
	 * @return true if adding was successful
	 */
	public boolean add(Object[] row, String[] relation) {
		if (relation.equals(ARTIKEL) || relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
				|| relation.equals(USER)) {
			String query1 = "", query2 = "";
			if (!exists(row, relation)) {
				for (int i = 0; i < relation.length; i++) {
					if (i == 0) {
						query1 = "INSERT INTO " + relation[i] + " (";
						query2 = "VALUES (";
					} else if (i != 1 || (i == 1 && (relation == USER))) {
						query1 += relation[i];
						query2 += "'" + (String) row[i - 1] + "'";
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
					statement.execute(query1 + query2);
					return true;
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);;
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Removes given dataset from relation.
	 * 
	 * @param row
	 *            - dataset to remove
	 * @param relation
	 *            - Involved relation
	 * @return true if removing was successful
	 */
	public boolean remove(Object[] row, String[] relation) {
		if (relation.equals(ARTIKEL) || relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
				|| relation.equals(USER)) {
			String query = "DELETE FROM ";
			query += relation[0] + " WHERE " + relation[1] + "=" + "'" + row[0] + "'" + ";";
			try {
				statement.execute(query);
				return true;
			} catch (SQLException e) {
				System.out.print(e);
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Search method for Strings gives the row(s) where the searched String is
	 * in as result.
	 * 
	 * @param searchedObj
	 *            - String that is searched
	 * @param relation
	 *            - The relation where the object is searched
	 * @return null if nothing found else it gives all rows where the given
	 *         String is in.
	 */

//	public Object[][] search(String searchedObj, String[] relation) {
//		if (relation.equals(ARTIKEL) || relation.equals(GESCHAEFT) || relation.equals(ANGEBOT)
//				|| relation.equals(USER)) {
//			int i = 0;
//			boolean end = false;
//			String query = "";
//			int columns = relation.length;
//			do {
//				if (i < columns) {
//					query = "SELECT * FROM " + relation[0] + " WHERE " + relation[i] + "=" + "'" + searchedObj + "'"
//							+ ";";
//					i++;
//				} else
//					end = true;
//			} while (executeQuery(query) == null && end == false);
//			return executeQuery(query);
//		} else {
//			return null;
//		}
//	}

	/**
	 * Wrapper of execute Query to get a Object[][] as result.
	 * 
	 * @param sql
	 *            - Query to execute
	 * @return Object[][] with results
	 * @return null if query fails or no data was founded
	 */
	public Object[][] executeQuery(String sql) throws SQLException {
			resultSet = statement.executeQuery(sql);
			if (resultSet == null) {
				return null;
			} else {
				Object[][] result;

				resultSet.last();
				int rows = resultSet.getRow();
				int columns = getLastMetaData().getColumnCount();
				resultSet.beforeFirst();
				result = new Object[rows][columns];

				for (int i = 0; resultSet.next(); i++) {
					for (int j = 1; j <= columns; j++) {
						result[i][j - 1] = resultSet.getObject(j);
					}
				}
				return result;
			}
	}

	public boolean manipulate(String sql) throws SQLException {
		return !statement.execute(sql);
	}

	/**
	 * Connects with the database
	 * 
	 * @return true if connection was established
	 */
	public boolean connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com/sql4102535", "sql4102535",
					"pzLF3mtPK6");
			statement = connect.createStatement();
			JOptionPane.showMessageDialog(null, "Connection established!", "Information", JOptionPane.INFORMATION_MESSAGE);
			connected = true;
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, check your Internet connection.", "Connection failed", JOptionPane.ERROR_MESSAGE);
			connected = false;
			return false;
		}
	}
	
	public boolean disconnect()
	{
		if(isConnected()){
			try {
				connect.close();
				return true;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}return false;
	}
	public String checkCredentials(String username, String password) {
		if (connected) {
			try {
				resultSet = statement
						.executeQuery("SELECT Password,Rang FROM User WHERE Username = '" + username + "';");
				resultSet.next();
				if (resultSet.getInt(1) == password.hashCode()) {
					return resultSet.getString(2);
				} else {
					return null;
				}
			} catch (SQLException e) {
				return null;
			}

		} else {
			return null;
		}
	}

	public boolean isConnected() {
		return connected;
	}

	public Statement getStatement() {
		return statement;
	}

	public ResultSet gesResultSet() {
		return resultSet;
	}
	
	public ResultSetMetaData getLastMetaData(){
		try {
			return resultSet.getMetaData();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ResultSet getLastResult(){
		return resultSet;
	}
	
	public String[] getRelation(String name){
		try {
			resultSet = statement.executeQuery("SELECT * FROM "+name);
			ResultSetMetaData meta = resultSet.getMetaData();
			String[] relation = new String[meta.getColumnCount()+1];
			relation[0] = name;
			for(int i = 1;i <= meta.getColumnCount();i++){
				relation[i] = meta.getColumnName(i);
			}
			return relation;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
}
