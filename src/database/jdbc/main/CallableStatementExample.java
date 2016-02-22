package database.jdbc.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import database.jdbc.util.DBHandler;

public class CallableStatementExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CallableStatement cstmt = null;
		CallableStatement cstmt2 = null;
		try {
			// 获得数据库连接
			Connection conn = DBHandler.getConnection("dbtest", "yuu");
			
			// 测试不带参数的存储过程
			String sql = "{call insert_record_into_student(?, ?, ?, ?)}";
			if(conn == null)
			{
				System.out.println("hello world!");
				return;
			}
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, 8);
			cstmt.setString(2, "tubaozi");
			cstmt.setInt(3, 34);
			cstmt.setString(4, "M");
			Boolean flag = cstmt.execute();
			System.out.println(!flag ? "OK" : "error");
			
			// 测试带参数的存储过程
			String sql2 = "{call count_studunt_samename(?, ?)}";
			cstmt2 = conn.prepareCall(sql2);
			cstmt2.setString(1, "tubaozi");
			cstmt2.registerOutParameter(2, Types.INTEGER); //注册输出参数
			cstmt2.execute();
			int totalCount = cstmt2.getInt(2); //获取输出参数
			System.out.println("总数：" + totalCount);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				cstmt2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBHandler.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
