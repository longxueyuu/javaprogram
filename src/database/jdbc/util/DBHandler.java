package database.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DBHandler {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	static{
		Properties prop = new Properties();
		try {
			// �������ļ��ж�ȡ�����ļ�
			prop.load(DBHandler.class.getClassLoader()
					.getResourceAsStream("database/jdbc/util/oracledatabase.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != prop)
		{
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		}
		
		// װ�ز�ע�����ݿ�����
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	public DBHandler() {
		
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection OpenConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * 
	 * @param connn
	 * @throws SQLException
	 */
	public static void closeConnection (Connection connn) throws SQLException
	{
		if(null != connn)
		{
			connn.close();
		}
	}
	
	
	/**
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection(String user, String password) throws ClassNotFoundException, SQLException
	{
		if(null == conn)
		{
			// 1��ע������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2��ͨ������������������ݿ�����
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:FM";
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
	
	/**
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static Statement getStatement(Connection conn) throws SQLException
	{
		if(null != conn)
		{
			stmt = conn.createStatement();
			return stmt;
		}
		return null;
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	public static void close() throws SQLException
	{
		if(null != stmt)
		{
			stmt.close();
		}
		if(null != conn)
		{
			conn.close();
		}
	}
}
