package database.jdbc.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbc.util.DBHandler;

public class ScrollResultSet {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHandler.OpenConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			String sql = "select id, name, email from emp order by id";
			rs = stmt.executeQuery(sql);
			// 跳到结果集第二十条
			rs.absolute(20);
			System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			// 相对当前位置向前跳5条
			rs.relative(-5);
			System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBHandler.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
