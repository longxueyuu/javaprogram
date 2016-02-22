package database.jdbc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbc.util.DBHandler;

public class BatchExample {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBHandler.OpenConnection();
			// 设置事务不自动提交
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql1 = "insert into emp (id, name)" +
					"values (seq_emp.nextval, 'wangnima')";
			String sql2 = "insert into emp (id, name)" +
			"values (seq_emp.nextval, 'wangmitao')";
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			int[] result = stmt.executeBatch();
			conn.commit();
			for(int i : result)
			{
				System.out.println("result:" + i);
			}
			
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally{
			stmt.close();
			try {
				DBHandler.closeConnection(conn);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
