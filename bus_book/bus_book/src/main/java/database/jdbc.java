package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    public static void insertss(String name,String gender,String from,String to,String date,String time,String bus_no,String ref_id,String phone_no) throws SQLException{
    
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String dbURL = "jdbc:derby:C:/Users/thund/BusDB";
        Connection connection=DriverManager.getConnection(dbURL,"BUS_TABLE","");
        String query="INSERT INTO BUS(NAME,GENDER,FROM_LOC,TO_LOC,DATE_DES,TIME_DES,BUS_NO,REF_ID,PHONE_NUMBER) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setString(1, name);
        stmt.setString(2, gender);
        stmt.setString(3, from);
        stmt.setString(4, to);
        stmt.setString(5, date);
        stmt.setString(6, time);
        stmt.setString(7, bus_no);
        stmt.setString(8, ref_id);
        stmt.setString(9, phone_no);
        int v=stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }  
        
    	

    }
    public static String[] display(String ref_id) {
    	String[] straw=new String[7];
    	  try {
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          String dbURL = "jdbc:derby:C:/Users/thund/BusDB";
          Connection connection=DriverManager.getConnection(dbURL,"BUS_TABLE","");
          ref_id="'"+ref_id+"'";
          String query="SELECT*FROM BUS WHERE REF_ID="+ref_id; 
         
          Statement stmt = connection.createStatement();
		  ResultSet rs=stmt.executeQuery(query);
		
		if(rs.next()) {
		straw[0]=rs.getString("NAME");
		straw[1]=rs.getString("DATE_DES");
		straw[2]=rs.getString("FROM_LOC");
		straw[3]=rs.getString("TO_LOC");
		straw[4]=rs.getString("TIME_DES");
		straw[5]=rs.getString("BUS_NO");
		straw[6]=rs.getString("REF_ID");
		return straw;
		}
	
    }catch(Exception e) {
    	e.printStackTrace();
    }
   return null;
}
    	public static int cancel(String ref) {
    		 try {
                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             String dbURL = "jdbc:derby:C:/Users/thund/BusDB";
             Connection connection=DriverManager.getConnection(dbURL,"BUS_TABLE","");
             ref="'"+ref+"'";
         	String query="DELETE FROM BUS WHERE REF_ID="+ref;
			PreparedStatement stmt=connection.prepareStatement(query);
			stmt.executeUpdate();
			return 1;
             
    		
    	}catch(Exception e) {
    		return 0;
    	}
    		 
}
}