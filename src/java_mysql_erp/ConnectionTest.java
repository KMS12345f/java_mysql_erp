package java_mysql_erp;

import java.sql.Connection;

import java_mysql_erp.util.JdbcUtil;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = JdbcUtil.getConnection();
		System.out.println("con " + con);
	}

}
