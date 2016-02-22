package database.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class PreparedStatementExample {
	
	private static Connection conn;
	private static PreparedStatement preStmt;
	private static ResultSet rs;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world!");
		
		try {
			// 1、注册驱动
			// 方式1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 方式2
			//Driver drv = new oracle.jdbc.driver.OracleDriver();
			//DriverManager.registerDriver(drv);
			//方式3
			//System.setProperty("jdbc.drivers", "oracle.jdbc.driver.OracleDriver");
			// 2、通过驱动管理器获得数据库连接
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:FM";
			String user = "dbtest";
			String password = "yuu";
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into emp values(?, ?, ?, ?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, 12);
			preStmt.setString(2, "zqx");
			preStmt.setDate(3, new java.sql.Date(new Date().getTime()));
			preStmt.setString(4, "zqx@163.com");
			int x = preStmt.executeUpdate();
			if(x == 1)
			{
				System.out.println("插入" + x + "条");
			}else{
				System.out.println("插入失败！");
			}
			
			/*
			 * preparedstatement查询测试
			String sql = "select id, name, registertime hiredate, email from emp where id = ? or name = ? order by id";
			// 获取PreparedStatement对象
			preStmt = conn.prepareStatement(sql);
			// 1:第一个？， 8：第一个问号的值
			preStmt.setInt(1, 8);
			// 2:第二个？，"xiaoyujiaxue"：第二个问号的值
			preStmt.setString(2, "xiaoyujiaxue");
			
			rs = preStmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			for(int i = 1; i <= colCount; i++)
			{
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			for(int i = 1; i <= colCount; i++)
			{
				System.out.print(rsmd.getColumnTypeName(i) + "\t");
			}
			System.out.println();
			while(rs.next())
			{
				for(int j = 1; j <= colCount; j++)
				{
					System.out.print(rs.getString(rsmd.getColumnName(j)) + "\t");
				}
				System.out.println();
			}
			*/
			
			
			
			
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			// 5、关闭资源
			try {
				preStmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
