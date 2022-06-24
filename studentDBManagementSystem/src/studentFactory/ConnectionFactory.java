package studentFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
      
	private static Connection con = null;
	static {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	public static Connection getConnection() {
		return con;
	}
	public static void close() {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
      
}
