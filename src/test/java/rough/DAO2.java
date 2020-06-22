package rough;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DAO2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("mains");
		
	}
	
	
	
	public static void executeStoredProc(ArrayList<String> alist) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:HR/hr@192.168.1.6:1521/XEPDB1");
		
		CallableStatement calls = con.prepareCall("{call ADD_JOB_HISTORY(?,?,?,?,?)}");
		calls.setString(1,alist.get(0));
		calls.setString(2,alist.get(1));
		calls.setString(3,alist.get(2));
		calls.setString(4,alist.get(3));
		calls.setString(5,alist.get(4));
		calls.execute();
	}
	
	public static void executeQuery() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:HR/hr@192.168.1.6:1521/XEPDB1");
		//jdbc:oracle:thin:HR/hr@//myhost:5221/orcl -Correct URL for 
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select country_id, region_id from Countries");
		ResultSetMetaData md= rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList<LinkedHashMap<String, String>> row = new ArrayList();
		
		while (rs.next()) {
			LinkedHashMap hmap = new LinkedHashMap();
		    for (int i = 1; i <= columns; i++) {	 
		       hmap.put(md.getColumnName(i), rs.getObject(i));
		     }
		     row.add(hmap);
		  }
		System.out.println(row);
	}

}
