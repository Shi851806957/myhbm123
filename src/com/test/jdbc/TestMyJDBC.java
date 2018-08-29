package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestMyJDBC {

	@Test
	public void test1() throws ClassNotFoundException, SQLException {
		
		Connection conn = DbUtil.getDbInstance().getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from t_sys_user");
		
		while(rs.next()) {
			System.out.println(rs.getString("t_user_name"));
			System.out.println(rs.getString(3));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}
	
	@Test
	public void update() throws SQLException, ClassNotFoundException
	{
		
		Connection conn = DbUtil.getDbInstance().getConn();
		
		Statement stmt = conn.createStatement();
		int temp = stmt.executeUpdate("update t_sys_user u set u.t_user_name='��ķè��' where u.t_user_id='3a8f9a6b-b2ad-43ee-9a6a-181af4342aa7'");
		System.out.println("������"+temp+"����¼");
		
		//conn.commit();
		stmt.close();
		conn.close();
	}
	
	@Test
	public void test2()
	{
		DbUtil util1 = DbUtil.getDbInstance();
		DbUtil util2 = DbUtil.getDbInstance();
		
		if(util1==util2)
		{
			System.out.println("ͬһ��ʵ��");
		}else {
			System.out.println("��ͬ��ʵ��");
		}
	}
}
