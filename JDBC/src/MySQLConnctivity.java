import java.sql.*;
import java.util.Scanner;
public class MySQLConnctivity 
{
public static void main(String[] args) throws Exception 
{
	Scanner sc = new Scanner(System.in);
	System.out.print("Input id:");
	int id = sc.nextInt();
	
	Scanner sc2 = new Scanner(System.in);
	System.out.print("Enter sec:");
	String sec = sc2.nextLine();
	
	System.out.print("Enter Name:");
	String name = sc2.nextLine();
	
	System.out.print("Enter Addr:");
	
	String addr = sc2.nextLine();
	
//	//simple query for insertion
//	Class.forName("com.mysql.jdbc.Driver");
//	Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","HashimHassan");
//	Statement st = cn.createStatement();
//	int count = st.executeUpdate("insert into student values("+id+", '"+name+"', '"+sec+"', '"+addr+"')");
//	
	//OR
	
	
	//Query for preparedStatement
	String Query = "insert into student values(?,?,?,?)";

	Class.forName("com.mysql.jdbc.Driver");
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","username","Password");
	
	//preparedStetement instead of Statement & prepareStatement(query) instead of createStatement()
	PreparedStatement st = cn.prepareStatement(Query);
	//create preparedStatement as st.setInt(columnNumber, columnName)
	st.setInt(1, id); 
	st.setString(2, name);
	st.setString(3, sec);
	st.setString(4, addr);
	

	int count = st.executeUpdate(); //in case of perparedStatement don't write query inside st.executeUpdate()
	
	//int count = st.executeUpdate("insert into student values("+id+",'"+name+"','"+sec+"','"+addr+"')");
	System.out.println(count+" rows affected");
	
	//to fetch data from database
	ResultSet rs = st.executeQuery("select* from Student");
	 while(rs.next())
	 {
		 String userData = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4);
		 System.out.println(userData);
		
	 }
	 st.close();
	 cn.close();
}
}
